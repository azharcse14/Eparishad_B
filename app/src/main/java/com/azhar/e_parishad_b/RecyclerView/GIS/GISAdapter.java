package com.azhar.e_parishad_b.RecyclerView.GIS;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.e_parishad_b.Activity.GIScollectionActivity;
import com.azhar.e_parishad_b.Database.Entity.GISEntity;
import com.azhar.e_parishad_b.R;

import java.util.ArrayList;

public class GISAdapter extends RecyclerView.Adapter<GISViewHolder> {

    Context context;
    ArrayList<GISEntity> dataSet;

    public GISAdapter(Context context, ArrayList<GISEntity> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public GISViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gis_child_layout, parent, false);

        GISViewHolder gisViewHolder = new GISViewHolder(view);

        return gisViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GISViewHolder holder, int position) {

        TextView snTv = holder.sn;
        snTv.setText(dataSet.get(position).id + "");

        TextView surveyIDTv = holder.survey_id;
        surveyIDTv.setText(dataSet.get(position).surveyId + "");

        TextView khanaHeadTv = holder.khana_head;
        khanaHeadTv.setText(dataSet.get(position).khanahead + "");

        TextView holdingNoTv = holder.holding_no;
        holdingNoTv.setText(dataSet.get(position).holdingnumber + "");

        TextView villageTv = holder.village;
        villageTv.setText(dataSet.get(position).village + "");

        TextView latitudeTv = holder.latitude;
        latitudeTv.setText(dataSet.get(position).latitude + "");

        TextView longitudeTv = holder.longitude;
        longitudeTv.setText(dataSet.get(position).longitude + "");

        TextView editTv = holder.edit;
        TextView sendTv = holder.send;

        editTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String surveyId = dataSet.get(position).surveyId;
                String khanahead = dataSet.get(position).khanahead;
                String holdingnumber = dataSet.get(position).holdingnumber;
                String village = dataSet.get(position).village;
                String latitude = dataSet.get(position).latitude;
                String longitude = dataSet.get(position).longitude;
                String isDraft = dataSet.get(position).isDraft;

                Intent intent = new Intent(context, GIScollectionActivity.class);
                intent.putExtra("surveyId", surveyId);
                intent.putExtra("khanahead", khanahead);
                intent.putExtra("holdingnumber", holdingnumber);
                intent.putExtra("village",village);
                intent.putExtra("latitude",latitude);
                intent.putExtra("longitude",longitude);
                intent.putExtra("isDraft",isDraft);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
