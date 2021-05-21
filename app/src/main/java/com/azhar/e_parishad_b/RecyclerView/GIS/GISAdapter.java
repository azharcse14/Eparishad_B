package com.azhar.e_parishad_b.RecyclerView.GIS;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.e_parishad_b.Activity.GIScollectionActivity;
import com.azhar.e_parishad_b.Activity.GisActivity;
import com.azhar.e_parishad_b.Activity.MainActivity;
import com.azhar.e_parishad_b.Database.Entity.GISEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.Networking.EPNET.DataObject.GisObject;
import com.azhar.e_parishad_b.Networking.EPNET.DataObject.MemberObject;
import com.azhar.e_parishad_b.Networking.EPNET.GisRetroInterface;
import com.azhar.e_parishad_b.Networking.EPNET.RFInterfece;
import com.azhar.e_parishad_b.Networking.EPNET.Response.ResponseObject;
import com.azhar.e_parishad_b.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GISAdapter extends RecyclerView.Adapter<GISViewHolder> {

    Context context;
    ArrayList<GISEntity> dataSet;

    View successfulLayout, errorLayout;
    GisObject gisObject;
    ArrayList<GisObject> gisObjectArrayList = new ArrayList<>();

    public GISAdapter(Context context, ArrayList<GISEntity> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public GISViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gis_child_layout, parent, false);

        successfulLayout = LayoutInflater.from(context).inflate(R.layout.successful_toast_layout, parent, false);
        errorLayout = LayoutInflater.from(context).inflate(R.layout.error_toast_layout, parent, false);

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
        TextView editReplaceTv = holder.editReplace;
        TextView done = holder.done;
        Button send = holder.send;

        editTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String surveyId = dataSet.get(position).surveyId;
                String khanahead = dataSet.get(position).khanahead;
                String holdingnumber = dataSet.get(position).holdingnumber;
                String village = dataSet.get(position).village;
                String latitude = dataSet.get(position).latitude;
                String longitude = dataSet.get(position).longitude;
                String isDraft = dataSet.get(position).isSync;

                Intent intent = new Intent(context, GIScollectionActivity.class);
                intent.putExtra("surveyId", surveyId);
                intent.putExtra("khanahead", khanahead);
                intent.putExtra("holdingnumber", holdingnumber);
                intent.putExtra("village", village);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                intent.putExtra("isDraft", isDraft);
                context.startActivity(intent);
            }
        });

        if (dataSet.get(position).isSync.equals("0")) {
            send.setVisibility(View.VISIBLE);
            done.setVisibility(View.GONE);

            editTv.setVisibility(View.VISIBLE);
            editReplaceTv.setVisibility(View.GONE);

            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String surveyId = dataSet.get(position).surveyId;
                    String latitude = dataSet.get(position).latitude;
                    String longitude = dataSet.get(position).longitude;

                    System.out.println("surveyId: " + surveyId);
                    System.out.println("latitude: " + latitude);
                    System.out.println("longitude: " + longitude);

                    gisObject = new GisObject(surveyId, latitude, longitude);
                    gisObjectArrayList.add(gisObject);

                    System.out.println(gisObjectArrayList);
//                System.out.println("gisObject: "+gisObject);

                    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://103.147.182.110:5030/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    GisRetroInterface gisRetroInterface = retrofit.create(GisRetroInterface.class);

                    Call<ResponseObject> call = gisRetroInterface.PostData(gisObject);


                    call.enqueue(new Callback<ResponseObject>() {
                        @Override
                        public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {

                            Toast.makeText(context, "Successful", Toast.LENGTH_LONG).show();

                            //Creating the Toast object
                            Toast toast = new Toast(context);
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                            toast.setView(successfulLayout);//setting the view of custom toast layout
                            toast.show();

                            Repository repository = new Repository(context);
                            repository.UpdateSync(dataSet.get(position).surveyId);

                            Intent intent = new Intent(context, GisActivity.class);
                            context.startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<ResponseObject> call, Throwable t) {
//                        Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
                            //Creating the Toast object
                            Toast toast = new Toast(context);
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                            toast.setView(errorLayout);//setting the view of custom toast layout
                            toast.show();

                        }
                    });

                }

            });

        }else {
            send.setVisibility(View.GONE);
            done.setVisibility(View.VISIBLE);

            editTv.setVisibility(View.GONE);
            editReplaceTv.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
