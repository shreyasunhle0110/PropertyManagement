package com.Bank_Property_Evaluation.PropertyManagement;

import java.util.List;

public class propertyDataRequest {
	
	private Borrower mainBorrower;
    private List<Borrower> jointBorrowers;
    private String initiatorName;
    private String businessUnit;
    private String contactNumber;
    private String facilityType;
    private String facilityCategory;
    private String facilityPurpose;
    private String facilityTerms;
    private String ccy;
    private int amount;
    private boolean isHousingLoan;
    private String fosReference;
    private String typeOfEvaluation;
    
	@Override
	public String toString() {
		return "propertyDataRequest [mainBorrower=" + mainBorrower + ", jointBorrowers=" + jointBorrowers
				+ ", initiatorName=" + initiatorName + ", businessUnit=" + businessUnit + ", contactNumber="
				+ contactNumber + ", facilityType=" + facilityType + ", facilityCategory=" + facilityCategory
				+ ", facilityPurpose=" + facilityPurpose + ", facilityTerms=" + facilityTerms + ", ccy=" + ccy
				+ ", amount=" + amount + ", isHousingLoan=" + isHousingLoan + ", fosReference=" + fosReference
				+ ", typeOfEvaluation=" + typeOfEvaluation + "]";
	}
	public Borrower getMainBorrower() {
		return mainBorrower;
	}
	public void setMainBorrower(Borrower mainBorrower) {
		this.mainBorrower = mainBorrower;
	}
	public List<Borrower> getJointBorrowers() {
		return jointBorrowers;
	}
	public void setJointBorrowers(List<Borrower> jointBorrowers) {
		this.jointBorrowers = jointBorrowers;
	}
	public String getInitiatorName() {
		return initiatorName;
	}
	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	public String getFacilityCategory() {
		return facilityCategory;
	}
	public void setFacilityCategory(String facilityCategory) {
		this.facilityCategory = facilityCategory;
	}
	public String getFacilityPurpose() {
		return facilityPurpose;
	}
	public void setFacilityPurpose(String facilityPurpose) {
		this.facilityPurpose = facilityPurpose;
	}
	public String getFacilityTerms() {
		return facilityTerms;
	}
	public void setFacilityTerms(String facilityTerms) {
		this.facilityTerms = facilityTerms;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public boolean isHousingLoan() {
		return isHousingLoan;
	}
	public void setHousingLoan(boolean isHousingLoan) {
		this.isHousingLoan = isHousingLoan;
	}
	public String getFosReference() {
		return fosReference;
	}
	public void setFosReference(String fosReference) {
		this.fosReference = fosReference;
	}
	public String getTypeOfEvaluation() {
		return typeOfEvaluation;
	}
	public void setTypeOfEvaluation(String typeOfEvaluation) {
		this.typeOfEvaluation = typeOfEvaluation;
	}
    

}
