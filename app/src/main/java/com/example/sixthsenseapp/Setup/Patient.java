package com.example.sixthsenseapp.Setup;

public class Patient {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String phoneNumber;
    private String dateOfBirth;
    private String gpName;
    private String gpNumber;
    private String emergencyContactName;
    private String emergencyContactNumber;
    private String primaryTreatmentMethod;
    private String secondaryTreatmentMethod;
    private String highBloodSugarTreatment;
    private String dbUserID;
    private float bloodSugarHighLimit;
    private float bloodSugarLowLimit;
    private int interventionWaitTime;

    public Patient(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public String getGpNumber() {
        return gpNumber;
    }

    public void setGpNumber(String gpNumber) {
        this.gpNumber = gpNumber;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getPrimaryTreatmentMethod() {
        return primaryTreatmentMethod;
    }

    public void setPrimaryTreatmentMethod(String primaryTreatmentMethod) {
        this.primaryTreatmentMethod = primaryTreatmentMethod;
    }

    public String getSecondaryTreatmentMethod() {
        return secondaryTreatmentMethod;
    }

    public void setSecondaryTreatmentMethod(String secondaryTreatmentMethod) {
        this.secondaryTreatmentMethod = secondaryTreatmentMethod;
    }

    public String getHighBloodSugarTreatment() {
        return highBloodSugarTreatment;
    }

    public void setHighBloodSugarTreatment(String highBloodSugarTreatment) {
        this.highBloodSugarTreatment = highBloodSugarTreatment;
    }

    public float getBloodSugarHighLimit() {
        return bloodSugarHighLimit;
    }

    public void setBloodSugarHighLimit(float bloodSugarHighLimit) {
        this.bloodSugarHighLimit = bloodSugarHighLimit;
    }

    public float getBloodSugarLowLimit() {
        return bloodSugarLowLimit;
    }

    public void setBloodSugarLowLimit(float bloodSugarLowLimit) {
        this.bloodSugarLowLimit = bloodSugarLowLimit;
    }

    public int getInterventionWaitTime() {
        return interventionWaitTime;
    }

    public void setInterventionWaitTime(int interventionWaitTime) {
        this.interventionWaitTime = interventionWaitTime;
    }

    public void setDbUserID(String dbUserID) {
        this.dbUserID = dbUserID;
    }

    public String getDbUserID() {
        return dbUserID;
    }
}
