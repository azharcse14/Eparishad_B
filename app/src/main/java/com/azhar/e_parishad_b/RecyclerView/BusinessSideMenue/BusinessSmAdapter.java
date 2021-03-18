package com.azhar.e_parishad_b.RecyclerView.BusinessSideMenue;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.e_parishad_b.Activity.Business.BusinessDetailActivity;
import com.azhar.e_parishad_b.Activity.Business.FarmingDetailsActivity;
import com.azhar.e_parishad_b.Activity.Business.FisheriseDetailsActivity;
import com.azhar.e_parishad_b.Activity.Business.IndustryDetailsActivity;
import com.azhar.e_parishad_b.Activity.Business.InterestOfSecurityActivity;
import com.azhar.e_parishad_b.Activity.Business.LiveStockDetailActivity;
import com.azhar.e_parishad_b.Activity.Business.RiceMillActivity;
import com.azhar.e_parishad_b.Activity.Business.VehicalBusinessActivity;
import com.azhar.e_parishad_b.Activity.ElectricityActivity;
import com.azhar.e_parishad_b.Activity.HeadActivity;
import com.azhar.e_parishad_b.Activity.HouseTypeActivity;
import com.azhar.e_parishad_b.Activity.LandActivity;
import com.azhar.e_parishad_b.Activity.Loan.LoanActivity;
import com.azhar.e_parishad_b.Activity.Members.MembersActivity;
import com.azhar.e_parishad_b.Activity.ReligionActivity;
import com.azhar.e_parishad_b.Activity.SanitationActivity;
import com.azhar.e_parishad_b.Activity.WaterActivity;
import com.azhar.e_parishad_b.R;


public class BusinessSmAdapter extends RecyclerView.Adapter<BusinessSmViewHolder> {

    Context context;
    String [] business;

    int row_index = -1;
    private int lastPosition = -1;

    public BusinessSmAdapter(Context context, String[] business) {
        this.context = context;
        this.business = business;
    }

    @NonNull
    @Override
    public BusinessSmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_layout, parent, false);
        BusinessSmViewHolder viewHolder = new BusinessSmViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BusinessSmViewHolder holder, int position) {

        holder.textView.setText(business[position]);

        holder.childLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                row_index=position;
                notifyDataSetChanged();


                if (position == 0){
                    Intent intent = new Intent(context, BusinessDetailActivity.class);
                    context.startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(context, IndustryDetailsActivity.class);
                    context.startActivity(intent);
                }else if (position == 2){
                    Intent intent = new Intent(context, RiceMillActivity.class);
                    context.startActivity(intent);
                }else if (position == 3){
                    Intent intent = new Intent(context, VehicalBusinessActivity.class);
                    context.startActivity(intent);
                }else if (position == 4){
                    Intent intent = new Intent(context, InterestOfSecurityActivity.class);
                    context.startActivity(intent);
                }else if (position == 5){
                    Intent intent = new Intent(context, FarmingDetailsActivity.class);
                    context.startActivity(intent);
                }else if (position == 6){
                    Intent intent = new Intent(context, LiveStockDetailActivity.class);
                    context.startActivity(intent);
                }else if (position == 7){
                    Intent intent = new Intent(context, FisheriseDetailsActivity.class);
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
        return business.length;
    }
}

