package com.innova.docmed.model;

public class Pharmacist {
    private String name;
    private String adresse;
    private String tel;
    private String email;

    public Pharmacist() {
    }

    public Pharmacist(String name, String adresse, String tel, String email) {
        this.name = name;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
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
}
