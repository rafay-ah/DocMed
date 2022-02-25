package com.innova.docmed.model;

public class MedicalDetails {
    String weight;
    String height;
    String bloodGroup;

    public MedicalDetails() {
    }

    public MedicalDetails(String weight, String height, String bloodGroup) {
        this.weight = weight;
        this.height = height;
        this.bloodGroup = bloodGroup;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
