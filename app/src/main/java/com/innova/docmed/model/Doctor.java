package com.innova.docmed.model;

public class Doctor {
    private String name;
    private String adress;
    private String tel;
    private String email;
    private String specialization;

    public Doctor(){
        //needed for firebase
    }

    public Doctor(String name, String adress, String tel, String email, String specialite) {
        this.name = name;
        this.adress = adress;
        this.tel = tel;
        this.email = email;
        this.specialization = specialite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
