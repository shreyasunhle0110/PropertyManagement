package com.Bank_Property_Evaluation.PropertyManagement;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bank_Property_Evaluation.PropertyManagement.Repository.MainBorrowerRepository;
import com.Bank_Property_Evaluation.PropertyManagement.Repository.PropertyRepository;
import com.Bank_Property_Evaluation.PropertyManagement.entity.MainBorrower;
import com.Bank_Property_Evaluation.PropertyManagement.entity.Property;

@CrossOrigin
@RestController
@RequestMapping("/api/rowdata")
public class Controller {
	private static final Logger logger = LoggerFactory.getLogger(JobWorkers.class);

	@Autowired
	private PropertyRepository propertyRepository;

	@Autowired
	private MainBorrowerRepository mainBorrowerRepository;

	@GetMapping
	public List<RowDataDto> getRowData() {
		try {
			logger.info("Fetching row data...");

			List<Property> properties = propertyRepository.findAll();
			List<RowDataDto> rowDataList = new ArrayList<>();
			for (Property property : properties) {
				MainBorrower mainBorrower = mainBorrowerRepository.findById(property.getId()).orElse(null);
				if (mainBorrower != null) {
					LocalDate receivedOn = property.getCreatedDateTime().toLocalDate();
					LocalDate createdOn = property.getCreatedDateTime().toLocalDate();
					LocalDate modifiedOn = property.getCreatedDateTime().toLocalDate();
					RowDataDto rowDataDto = new RowDataDto(property.getReferenceNumber(), property.getFosReference(),
							receivedOn, mainBorrower.getCustomerName(), createdOn, modifiedOn);
					rowDataList.add(rowDataDto);
				}
			}

			logger.info("Row data fetched successfully");
			return rowDataList;
		} catch (Exception e) {
			logger.error("Failed to fetch row data", e);
			return null;
		}
	}

	static class RowDataDto {
		private String referenceNumber;
		private String fosReference;
		private LocalDate receivedOn;
		private String customerName;
		private LocalDate createdOn;
		private LocalDate modifiedOn;

		public RowDataDto(String referenceNumber, String fosReference, LocalDate receivedOn, String customerName,
				LocalDate createdOn, LocalDate modifiedOn) {
			this.referenceNumber = referenceNumber;
			this.fosReference = fosReference;
			this.receivedOn = receivedOn;
			this.customerName = customerName;
			this.createdOn = createdOn;
			this.modifiedOn = modifiedOn;
		}

		public String getReferenceNumber() {
			return referenceNumber;
		}

		public void setReferenceNumber(String referenceNumber) {
			this.referenceNumber = referenceNumber;
		}

		public String getFosReference() {
			return fosReference;
		}

		public void setFosReference(String fosReference) {
			this.fosReference = fosReference;
		}

		public LocalDate getReceivedOn() {
			return receivedOn;
		}

		public void setReceivedOn(LocalDate receivedOn) {
			this.receivedOn = receivedOn;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public LocalDate getCreatedOn() {
			return createdOn;
		}

		public void setCreatedOn(LocalDate createdOn) {
			this.createdOn = createdOn;
		}

		public LocalDate getModifiedOn() {
			return modifiedOn;
		}

		public void setModifiedOn(LocalDate modifiedOn) {
			this.modifiedOn = modifiedOn;
		}

	}
}
