package com.innova.docmed.model;

public class Patient {
    private String name;
    private String adresse;
    private String tel;
    private String email;
    private String birthdate;
    private String situation;


    public Patient(){
        //needed for firebase
    }

    public Patient(String name, String adresse, String tel, String email, String birthdate, String situation) {
        this.name = name;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.birthdate = birthdate;
        this.situation = situation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}
