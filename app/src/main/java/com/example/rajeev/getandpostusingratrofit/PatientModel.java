package com.example.rajeev.getandpostusingratrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by RAJEEV on 31-Jul-18.
 */

public class PatientModel {
    @SerializedName("Id")
    @Expose
    private String  id;
    @SerializedName("BloodGroup")
    @Expose
    private String bloodgroup;
    @SerializedName("Address")
    @Expose
    private String adress;
    @SerializedName("City")
    @Expose
    private  String city;
    @SerializedName("PatientName")
    @Expose
    private String name;
    @SerializedName("ContactNumber")
    @Expose
    private String contact;
    @SerializedName("Time")
    @Expose
    private String time;
    @SerializedName("DonatedBy")
    @Expose
    private  String donar;

    public PatientModel(String id, String bloodgroup, String adress, String city, String name, String contact, String time, String donar) {
        this.id = id;
        this.bloodgroup = bloodgroup;
        this.adress = adress;
        this.city = city;
        this.name = name;
        this.contact = contact;
        this.time = time;
        this.donar = donar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDonar() {
        return donar;
    }

    public void setDonar(String donar) {
        this.donar = donar;
    }
}
