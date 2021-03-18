package com.azhar.e_parishad_b.RecyclerView.MemberSideMenue;


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
import com.azhar.e_parishad_b.Activity.Members.BankDetailActivity;
import com.azhar.e_parishad_b.Activity.Members.DisabilityActivity;
import com.azhar.e_parishad_b.Activity.Members.DrivingLicenceActivity;
import com.azhar.e_parishad_b.Activity.Members.EducationActivity;
import com.azhar.e_parishad_b.Activity.Members.EducationDetailsActivity;
import com.azhar.e_parishad_b.Activity.Members.FamillyPlaningActivity;
import com.azhar.e_parishad_b.Activity.Members.IncomeDetailActivity;
import com.azhar.e_parishad_b.Activity.Members.MaritalStatusDetailActivity;
import com.azhar.e_parishad_b.Activity.Members.MemberFirstBFMGActivity;
import com.azhar.e_parishad_b.Activity.Members.MemberLiveActivity;
import com.azhar.e_parishad_b.Activity.Members.MemberNationalityActivity;
import com.azhar.e_parishad_b.Activity.Members.MemberRelationWithKhanaHeadActivity;
import com.azhar.e_parishad_b.Activity.Members.MemberVaccinationInformationActivity;
import com.azhar.e_parishad_b.Activity.Members.Member_Details_One_Activity;
import com.azhar.e_parishad_b.Activity.Members.MembersActivity;
import com.azhar.e_parishad_b.Activity.Members.MotherHealthCareInformationActivity;
import com.azhar.e_parishad_b.Activity.Members.PassportActivity;
import com.azhar.e_parishad_b.Activity.Members.PersonalStatusDetailActivity;
import com.azhar.e_parishad_b.Activity.Members.ProfessionActivity;
import com.azhar.e_parishad_b.Activity.Members.SocialSaftyNetActivity;
import com.azhar.e_parishad_b.Activity.Members.TINinformationActivity;
import com.azhar.e_parishad_b.Activity.Members.TrainingActivity;
import com.azhar.e_parishad_b.Activity.ReligionActivity;
import com.azhar.e_parishad_b.Activity.SanitationActivity;
import com.azhar.e_parishad_b.Activity.WaterActivity;
import com.azhar.e_parishad_b.R;


public class MSMAdapter extends RecyclerView.Adapter<MSMViewHolder> {

    Context context;
    String [] msm;

    int row_index = -1;
    private int lastPosition = -1;

    public MSMAdapter(Context context, String[] msm) {
        this.context = context;
        this.msm = msm;
    }

    @NonNull
    @Override
    public MSMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_layout, parent, false);
        MSMViewHolder viewHolder = new MSMViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MSMViewHolder holder, int position) {

        holder.textView.setText(msm[position]);

        holder.childLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                row_index=position;
                notifyDataSetChanged();


                if (position == 0){
                    Intent intent = new Intent(context, MemberFirstBFMGActivity.class);
                    context.startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(context, MemberRelationWithKhanaHeadActivity.class);
                    context.startActivity(intent);
                }else if (position == 2){
                    Intent intent = new Intent(context, Member_Details_One_Activity.class);
                    context.startActivity(intent);
                }else if (position == 3){
                    Intent intent = new Intent(context, MemberNationalityActivity.class);
                    context.startActivity(intent);
                }else if (position == 4){
                    Intent intent = new Intent(context, MemberVaccinationInformationActivity.class);
                    context.startActivity(intent);
                }else if (position == 5){
                    Intent intent = new Intent(context, DisabilityActivity.class);
                    context.startActivity(intent);
                }else if (position == 6){
                    Intent intent = new Intent(context, MotherHealthCareInformationActivity.class);
                    context.startActivity(intent);
                }else if (position == 7){
                    Intent intent = new Intent(context, FamillyPlaningActivity.class);
                    context.startActivity(intent);
                }else if (position == 8){
                    Intent intent = new Intent(context, SocialSaftyNetActivity.class);
                    context.startActivity(intent);
                }else if (position == 9){
                    Intent intent = new Intent(context, TINinformationActivity.class);
                    context.startActivity(intent);
                }else if (position == 10){
                    Intent intent = new Intent(context, PassportActivity.class);
                    context.startActivity(intent);
                }else if (position == 11) {
                    Intent intent = new Intent(context, DrivingLicenceActivity.class);
                    context.startActivity(intent);
                }else if (position == 12) {
                    Intent intent = new Intent(context, EducationActivity.class);
                    context.startActivity(intent);
                }else if (position == 13) {
                    Intent intent = new Intent(context, EducationDetailsActivity.class);
                    context.startActivity(intent);
                }else if (position == 14) {
                    Intent intent = new Intent(context, TrainingActivity.class);
                    context.startActivity(intent);
                }else if (position == 15) {
                    Intent intent = new Intent(context, ProfessionActivity.class);
                    context.startActivity(intent);
                }else if (position == 16) {
                    Intent intent = new Intent(context, MaritalStatusDetailActivity.class);
                    context.startActivity(intent);
                }else if (position == 17) {
                    Intent intent = new Intent(context, PersonalStatusDetailActivity.class);
                    context.startActivity(intent);
                }else if (position == 18) {
                    Intent intent = new Intent(context, IncomeDetailActivity.class);
                    context.startActivity(intent);
                }else if (position == 19) {
                    Intent intent = new Intent(context, BankDetailActivity.class);
                    context.startActivity(intent);
                }else if (position == 20) {
                    Intent intent = new Intent(context, MemberLiveActivity.class);
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
        return msm.length;
    }
}

