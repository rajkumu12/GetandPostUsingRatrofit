package com.example.rajeev.getandpostusingratrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;

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
    ShimmerFrameLayout shimmerFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_using);
        shimmerFrameLayout=findViewById(R.id.shimmer_view_container);
        listView=(ListView)findViewById(R.id.listview);
        patientlst=new ArrayList<>();
        loaddata();
    }

    private void loaddata() {
        shimmerFrameLayout.startShimmerAnimation();
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
                shimmerFrameLayout.stopShimmerAnimation();
                shimmerFrameLayout.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Patientlist> call, Throwable t) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmerAnimation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        shimmerFrameLayout.stopShimmerAnimation();
    }
}
