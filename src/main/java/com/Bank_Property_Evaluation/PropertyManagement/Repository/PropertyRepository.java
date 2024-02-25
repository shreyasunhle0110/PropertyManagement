package com.Bank_Property_Evaluation.PropertyManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bank_Property_Evaluation.PropertyManagement.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
	
	Property findFirstByOrderByIdDesc();
}

