package com.example.rajeev.getandpostusingratrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetUsingActivity extends AppCompatActivity {
    List<PatientModel> patientlst;
    ListView listView;
    FetchAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_using);
        listView=(ListView)findViewById(R.id.listview);
        patientlst=new ArrayList<>();
        loaddata();
    }

    private void loaddata() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Service.BASE1_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final Service api = retrofit.create(Service.class);
        Call<Patientlist>  call=api.getstatus();
        call.enqueue(new Callback<Patientlist>() {
            @Override
            public void onResponse(Call<Patientlist> call, Response<Patientlist> response) {
                if (response.isSuccessful()){
                    patientlst=response.body().getPatientArrayList();
                    adapter=new FetchAdapter(GetUsingActivity.this,R.layout.patientlist,patientlst);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Patientlist> call, Throwable t) {

            }
        });

    }
}
