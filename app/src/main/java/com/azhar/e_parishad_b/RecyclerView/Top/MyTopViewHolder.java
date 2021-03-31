package com.azhar.e_parishad_b.RecyclerView.Top;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.e_parishad_b.R;

public class MyTopViewHolder extends RecyclerView.ViewHolder {
    TextView snTv, creationDateTv, surveyIDTv, statusTv, khanaHeadTv, holdingNoTv, khanaNoTv, villageTv, wardTv, done;
    Button send;

    public MyTopViewHolder(@NonNull View itemView) {
        super(itemView);

        snTv = itemView.findViewById(R.id.snTv);
        creationDateTv = itemView.findViewById(R.id.creationDateTv);
        surveyIDTv = itemView.findViewById(R.id.surveyIDTv);
        statusTv = itemView.findViewById(R.id.statusTv);
        khanaHeadTv = itemView.findViewById(R.id.khanaHeadTv);
        holdingNoTv = itemView.findViewById(R.id.holdingNoTv);
        khanaNoTv = itemView.findViewById(R.id.khanaNoTv);
        villageTv = itemView.findViewById(R.id.villageTv);
        wardTv = itemView.findViewById(R.id.wardTv);
        send = itemView.findViewById(R.id.sendBtn);
        done = itemView.findViewById(R.id.doneTv);
    }
}
