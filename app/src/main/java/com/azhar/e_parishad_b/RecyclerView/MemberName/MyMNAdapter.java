package com.azhar.e_parishad_b.RecyclerView.MemberName;


import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.e_parishad_b.Database.Entity.Member.MemberTempEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.Database.Entity.Member.MNEntity;
import com.azhar.e_parishad_b.R;

import java.util.ArrayList;

public class MyMNAdapter extends RecyclerView.Adapter<MyMNViewHolder> {
    Context context;
    ArrayList<MemberTempEntity> dataSet;

    public MyMNAdapter(Context context, ArrayList<MemberTempEntity> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }


    @NonNull
    @Override
    public MyMNViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.member_name_child_layout, parent, false);

        MyMNViewHolder myMNViewHolder = new MyMNViewHolder(view);

        return myMNViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyMNViewHolder holder, int position) {

        TextView tv_sName = holder.memberNameTv;
        tv_sName.setText(dataSet.get(position).name+"");
        ImageView deleteIcon = holder.deleteIconIB;

        deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MNEntity mnEntity = new MNEntity(dataSet.get(position).id,
                        dataSet.get(position).name,
                        dataSet.get(position).member_id,
                        dataSet.get(position).bloodgroup,
                        dataSet.get(position).fathername,
                        dataSet.get(position).mothername,
                        dataSet.get(position).gender,
                        dataSet.get(position).isHead,
                        dataSet.get(position).relationship,
                        dataSet.get(position).bdaydate,
                        dataSet.get(position).bdaymonth,
                        dataSet.get(position).bdayyear,
                        dataSet.get(position).age,
                        dataSet.get(position).birthcertificateno,
                        dataSet.get(position).birthcertificateimage,
                        dataSet.get(position).nationality,
                        dataSet.get(position).nid,
                        dataSet.get(position).nidimage,
                        dataSet.get(position).membervaccine,
                        dataSet.get(position).disability,
                        dataSet.get(position).ismothervaccination,
                        dataSet.get(position).nearesthospital,
                        dataSet.get(position).maternitynutritionconsultancy,
                        dataSet.get(position).consultingwith,
                        dataSet.get(position).iseligiblecouple,
                        dataSet.get(position).anyfamilyplaning,
                        dataSet.get(position).socialsafetynet,
                        dataSet.get(position).socialsafetynetcardinfo,
                        dataSet.get(position).socialsafetynetcardphoto,
                        dataSet.get(position).isTinAvaiable,
                        dataSet.get(position).tinNumber,
                        dataSet.get(position).tinimage,
                        dataSet.get(position).passportno,
                        dataSet.get(position).passportimage,
                        dataSet.get(position).isDrivingLicenceAvailable,
                        dataSet.get(position).drivingLicenceNumber,
                        dataSet.get(position).dirivinglicenseimage,
                        dataSet.get(position).higheshtEducation,
                        dataSet.get(position).doyoustudynow,
                        dataSet.get(position).whichLevel,
                        dataSet.get(position).educationinstitution,
                        dataSet.get(position).educationFinishingWant,
                        dataSet.get(position).training,
                        dataSet.get(position).primaryprofession,
                        dataSet.get(position).secondaryprofession,
                        dataSet.get(position).ifunemployednow,
                        dataSet.get(position).rickformofownership,
                        dataSet.get(position).ricksourcesoffinance,
                        dataSet.get(position).ricknooftransport,
                        dataSet.get(position).maritialstatus,
                        dataSet.get(position).spousename,
                        dataSet.get(position).marriageRegNo,
                        dataSet.get(position).marriageRegDate,
                        dataSet.get(position).divorceRegNo,
                        dataSet.get(position).divorceRegDate,
                        dataSet.get(position).incomefromMainOccuption,
                        dataSet.get(position).incomefromSecondOccuption,
                        dataSet.get(position).additionalincome,
                        dataSet.get(position).mobaileNumber,
                        dataSet.get(position).email,
                        dataSet.get(position).accountNo,
                        dataSet.get(position).mobaileNo,
                        dataSet.get(position).bankName,
                        dataSet.get(position).branchName,
                        dataSet.get(position).ismemberlivehere,
                        dataSet.get(position).mlivingAddress,
                        dataSet.get(position).memberimage,
                        dataSet.get(position).kinnumber
                        );

                generate_delete_dialog(mnEntity);
                notifyDataSetChanged();
                dataSet.remove(position);
            }
        });




    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void generate_delete_dialog(MNEntity mnEntity){
        final MNEntity mnEntity_about_to_delete = mnEntity;
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("Warning");
        builder.setIcon(android.R.drawable.ic_delete);
        builder.setMessage("Are you sure to delete?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Repository repository = new Repository(context);
                repository.DeleteTaskMNEntity(mnEntity_about_to_delete);
                Toast.makeText(context, "Values Deleted", Toast.LENGTH_LONG).show();
//                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }



}

