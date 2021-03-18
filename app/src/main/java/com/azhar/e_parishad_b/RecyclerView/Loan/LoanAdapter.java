package com.azhar.e_parishad_b.RecyclerView.Loan;

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

import com.azhar.e_parishad_b.Database.Entity.Loan.LoanTempEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.Database.Entity.Loan.LoanEntity;
import com.azhar.e_parishad_b.R;

import java.util.ArrayList;

public class LoanAdapter extends RecyclerView.Adapter<LoanViewHolder> {

    Context context;
    ArrayList<LoanTempEntity> dataSet;

    public LoanAdapter(Context context, ArrayList<LoanTempEntity> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public LoanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.loan_child_layout, parent, false);

        LoanViewHolder loanViewHolder = new LoanViewHolder(view);

        return loanViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LoanViewHolder holder, int position) {

        TextView tv_sName = holder.loanNameTv;
        tv_sName.setText(dataSet.get(position).loanName+"");
        ImageView deleteIcon = holder.deleteIconIB;

        deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoanEntity loanEntity = new LoanEntity(dataSet.get(position).id,
                        dataSet.get(position).loanName,
                        dataSet.get(position).isfinancialsupported,
                        dataSet.get(position).financialsupportfrom,
                        dataSet.get(position).loanInstitute,
                        dataSet.get(position).loanAmount,
                        dataSet.get(position).year,
                        dataSet.get(position).month,
                        dataSet.get(position).day,
                        dataSet.get(position).loanPeriod,
                        dataSet.get(position).kinnumber);

                generate_delete_dialog(loanEntity);
                notifyDataSetChanged();
                dataSet.remove(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void generate_delete_dialog(LoanEntity loanEntity){
        final LoanEntity loanEntity_about_to_delete = loanEntity;
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("Warning");
        builder.setIcon(android.R.drawable.ic_delete);
        builder.setMessage("Are you sure to delete?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Repository repository = new Repository(context);
                repository.DeleteTask(loanEntity_about_to_delete);
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

