package com.azhar.e_parishad_b.RecyclerView.Fa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.e_parishad_b.Database.Entity.FDEntity;
import com.azhar.e_parishad_b.Database.Entity.FaEntity;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.Top.MyTopViewHolder;

import java.util.ArrayList;

public class FaAdapter extends RecyclerView.Adapter<FaViewHolder> {

    Context context;
    ArrayList<FaEntity> dataSet;

    public FaAdapter(Context context, ArrayList<FaEntity> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public FaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fa_child_layout, parent, false);

        FaViewHolder faViewHolder = new FaViewHolder(view);

        return faViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FaViewHolder holder, int position) {

        TextView snTv = holder.snTv;
        snTv.setText(dataSet.get(position).id+"");

        TextView creationDateTv = holder.creationDateTv;
        creationDateTv.setText(dataSet.get(position).date+"");

        TextView surveyIDTv = holder.surveyIDTv;
        surveyIDTv.setText(dataSet.get(position).surveyId+"");

        TextView statusTv = holder.statusTv;
        statusTv.setText(dataSet.get(position).id+"");

        TextView khanaHeadTv = holder.khanaHeadTv;
        khanaHeadTv.setText(dataSet.get(position).khanahead+"");

        TextView holdingNoTv = holder.holdingNoTv;
        holdingNoTv.setText(dataSet.get(position).holdingnumber+"");

        TextView khanaNoTv = holder.khanaNoTv;
        khanaNoTv.setText(dataSet.get(position).khananumber+"");

        TextView villageTv = holder.villageTv;
        villageTv.setText(dataSet.get(position).village+"");

        TextView wardTv = holder.wardTv;
        wardTv.setText(dataSet.get(position).ward+"");
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}