package com.azhar.e_parishad_b.RecyclerView.SideMenue;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.e_parishad_b.Activity.Business.BusinessDetailActivity;
import com.azhar.e_parishad_b.Activity.ElectricityActivity;
import com.azhar.e_parishad_b.Activity.HeadActivity;
import com.azhar.e_parishad_b.Activity.HoldingAddActivity;
import com.azhar.e_parishad_b.Activity.HoldingNoActivity;
import com.azhar.e_parishad_b.Activity.HouseTypeActivity;
import com.azhar.e_parishad_b.Activity.LandActivity;
import com.azhar.e_parishad_b.Activity.Loan.LoanActivity;
import com.azhar.e_parishad_b.Activity.Members.MembersActivity;
import com.azhar.e_parishad_b.Activity.SanitationActivity;
import com.azhar.e_parishad_b.Activity.WaterActivity;
import com.azhar.e_parishad_b.Activity.ReligionActivity;
import com.azhar.e_parishad_b.R;


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    String [] title;

    int row_index = -1;
    private int lastPosition = -1;

    public MyAdapter(Context context, String[] title) {
        this.context = context;
        this.title = title;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textView.setText(title[position]);

        holder.childLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                row_index=position;
                notifyDataSetChanged();


                if (position == 0){
                    Intent intent = new Intent(context, HoldingNoActivity.class);
                    context.startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(context, HoldingAddActivity.class);
                    context.startActivity(intent);
                }else if (position == 2){
                    Intent intent = new Intent(context, HeadActivity.class);
                    context.startActivity(intent);
                }else if (position == 3){
                    Intent intent = new Intent(context, MembersActivity.class);
                    context.startActivity(intent);
                }else if (position == 4){
                    Intent intent = new Intent(context, ReligionActivity.class);
                    context.startActivity(intent);
                }else if (position == 5){
                    Intent intent = new Intent(context, LandActivity.class);
                    context.startActivity(intent);
                }else if (position == 6){
                    Intent intent = new Intent(context, HouseTypeActivity.class);
                    context.startActivity(intent);
                }else if (position == 7){
                    Intent intent = new Intent(context, WaterActivity.class);
                    context.startActivity(intent);
                }else if (position == 8){
                    Intent intent = new Intent(context, SanitationActivity.class);
                    context.startActivity(intent);
                }else if (position == 9){
                    Intent intent = new Intent(context, ElectricityActivity.class);
                    context.startActivity(intent);
                }else if (position == 10){
                    Intent intent = new Intent(context, BusinessDetailActivity.class);
                    context.startActivity(intent);
                }else if (position == 11) {
                    Intent intent = new Intent(context, LoanActivity.class);
                    context.startActivity(intent);
                }
            }
        });

        if (row_index==position) {
            holder.childLayout.setBackgroundColor(Color.BLUE);
        } else {
            holder.childLayout.setBackgroundColor(Color.parseColor("#dddddd"));
        }
    }


    @Override
    public int getItemCount() {
        return title.length;
    }
}

