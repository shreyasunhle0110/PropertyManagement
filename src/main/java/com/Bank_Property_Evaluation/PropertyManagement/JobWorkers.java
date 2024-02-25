package com.Bank_Property_Evaluation.PropertyManagement;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Bank_Property_Evaluation.PropertyManagement.Repository.JointBorrowerRepository;
import com.Bank_Property_Evaluation.PropertyManagement.Repository.MainBorrowerRepository;
import com.Bank_Property_Evaluation.PropertyManagement.Repository.PropertyRepository;
import com.Bank_Property_Evaluation.PropertyManagement.entity.JointBorrower;
import com.Bank_Property_Evaluation.PropertyManagement.entity.MainBorrower;
import com.Bank_Property_Evaluation.PropertyManagement.entity.Property;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class JobWorkers {
	private static final Logger logger = LoggerFactory.getLogger(JobWorkers.class);

	@Autowired
	ZeebeClient zeebe;
	@Autowired
	ObjectMapper mapper;
	@Autowired
	PropertyRepository propertyRepo;
	@Autowired
	private MainBorrowerRepository mainBorrowerRepository;
	@Autowired
	private JointBorrowerRepository jointBorrowerRepository;

	private static int sequence = 1;

	public String generateReferenceNumber() {
		Property lastProperty = propertyRepo.findFirstByOrderByIdDesc();
		if (lastProperty != null) {
			String lastReferenceNumber = lastProperty.getReferenceNumber();
			int lastSequence = Integer.parseInt(lastReferenceNumber.substring(10));
			sequence = lastSequence + 1;
		}

		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		return "PV" + formattedDate + String.format("%04d", sequence);
	}

	@JobWorker
	public void savePropertyDetails(final JobClient client, final ActivatedJob job) {
		try {
			logger.info("Saving property details...");

			propertyDataRequest req1 = mapper.convertValue(job.getVariable("propertyData"), propertyDataRequest.class);
			Property property = mapper.convertValue(req1, Property.class);
			property.setReferenceNumber(generateReferenceNumber());
			Property savedProperty = propertyRepo.save(property);

			MainBorrower mainBorrower = mapper.convertValue(job.getVariable("mainBorrower"), MainBorrower.class);
			MainBorrower savedMainBorrower = mainBorrowerRepository.save(mainBorrower);

			List<JointBorrower> jointBorrowers = mapper.convertValue(job.getVariable("jointBorrowers"),
					new TypeReference<List<JointBorrower>>() {
					});
			if (jointBorrowers != null) {
				for (JointBorrower jointBorrower : jointBorrowers) {
					jointBorrower.setProperty(savedProperty);
					jointBorrowerRepository.save(jointBorrower);
				}
			}

			zeebe.newSetVariablesCommand(job.getElementInstanceKey()).variables(Map.of("savedProperty", savedProperty))
					.send();

			logger.info("Property details saved successfully: {}", savedProperty.toString());
		} catch (Exception e) {
			logger.error("Failed to save property details", e);
		}
	}
}
