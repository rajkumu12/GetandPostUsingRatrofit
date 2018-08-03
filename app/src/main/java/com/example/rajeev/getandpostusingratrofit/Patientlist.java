package com.example.rajeev.getandpostusingratrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by RAJEEV on 03-Aug-18.
 */

public class Patientlist {
    @SerializedName("patients")
    private ArrayList<PatientModel> patient=new ArrayList<>();

    public ArrayList<PatientModel> getPatientArrayList() {
        return patient;
    }

    public void setPatient(ArrayList<PatientModel> patient) {
        this.patient = patient;
    }
}

