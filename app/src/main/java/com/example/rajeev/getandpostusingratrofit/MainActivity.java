package com.example.rajeev.getandpostusingratrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.Response;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText n1,b1,a1,c1,d1,t1,cn1;
    Button post,get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        n1=(EditText)findViewById(R.id.pname);
        b1=(EditText)findViewById(R.id.bloodg);
        a1=(EditText)findViewById(R.id.addrees1);
        c1=(EditText)findViewById(R.id.city1);
        d1=(EditText)findViewById(R.id.donar1);
        t1=(EditText)findViewById(R.id.time1);
        cn1=(EditText)findViewById(R.id.contact1);

        post=(Button)findViewById(R.id.post);
        get=(Button)findViewById(R.id.get);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click();
            }
        });
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,GetUsingActivity.class));
            }
        });
    }

    private void click() {
        String name = n1.getText().toString().toLowerCase();
        String bldgr = b1.getText().toString().toLowerCase().trim();
        String city = c1.getText().toString().toLowerCase().trim();
        String contactno = cn1.getText().toString().toLowerCase().trim();
        String adress = a1.getText().toString().toLowerCase().trim();
        String time = t1.getText().toString().toLowerCase().trim();
        String donar = d1.getText().toString().toLowerCase().trim();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ramgopalabs.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final Service service = retrofit.create(Service.class);
        retrofit2.Call<Result> call = service.addPerson(bldgr, adress, city, contactno, name, time, donar);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(retrofit2.Call<Result> call, retrofit2.Response<Result> response) {
                Toast.makeText(MainActivity.this, response.body().result, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(retrofit2.Call<Result> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
