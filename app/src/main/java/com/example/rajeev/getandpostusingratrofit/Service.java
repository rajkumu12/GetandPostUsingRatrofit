package com.example.rajeev.getandpostusingratrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by RAJEEV on 01-Aug-18.
 */

public interface Service {
    String BASE1_URL = "http://ramgopalabs.000webhostapp.com/";
    @GET("v1/EmergencyRequirement.php/?op=getPatient")
    Call<Patientlist> getstatus();
    @FormUrlEncoded
    @POST("v1/EmergencyRequirement.php/?op=addPatient")
    Call<Result> addPerson(@Field("BloodGroup") String bloodgroup,
    @Field("Address") String Address,
    @Field("City") String city,@Field("ContactNumber") String contactnumber,@Field("PatientName") String name
    ,@Field("Time") String Time,
                           @Field("DonatedBy") String donar);
}
