package com.example.rajeev.getandpostusingratrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by RAJEEV on 31-Jul-18.
 */

public class FetchAdapter extends ArrayAdapter{
    Context context;
    LayoutInflater inflater;
    int resource;
    List<PatientModel>list;
    public FetchAdapter(@NonNull Context context, int resource,List<PatientModel>list) {
        super(context, resource,list);

        this.context = context;
        this.resource = resource;
        this.list = list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){

            convertView = inflater.inflate(resource,null);

            holder = new ViewHolder();
            holder.id = (TextView)convertView.findViewById(R.id.ids);
            holder.bloodgroup=(TextView)convertView.findViewById(R.id.blg);
            holder.address=(TextView)convertView.findViewById(R.id.address);
            holder.city=(TextView)convertView.findViewById(R.id.city);
            holder.name=(TextView)convertView.findViewById(R.id.name);
            holder.contact=(TextView)convertView.findViewById(R.id.contact);
            holder.time=(TextView)convertView.findViewById(R.id.time);
            holder.donar=(TextView)convertView.findViewById(R.id.donar);

            convertView.setTag(holder);


        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        PatientModel model = list.get(position);
        holder.id.setText("Id: "+model.getId());
        holder.name.setText("Patient Name: "+model.getName());
        holder.bloodgroup.setText("blood group: "+model.getBloodgroup());
        holder.address.setText("Address: "+model.getAdress());
        holder.city.setText("City: "+model.getCity());
        holder.contact.setText("Contact: "+model.getContact());
        holder.time.setText("Time: "+model.getTime());
        holder.donar.setText("Donar Name: "+model.getDonar());

        return convertView;
    }

    static class ViewHolder{
        TextView id,name,bloodgroup,city,contact,address,time,donar;
    }
}

