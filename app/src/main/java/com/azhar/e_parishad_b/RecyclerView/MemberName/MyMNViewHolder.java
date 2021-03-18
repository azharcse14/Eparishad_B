package com.azhar.e_parishad_b.RecyclerView.MemberName;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.e_parishad_b.R;

public class MyMNViewHolder extends RecyclerView.ViewHolder {
    TextView memberNameTv;
    ImageView editIconIB, deleteIconIB;
    ConstraintLayout childLayout;

    public MyMNViewHolder(@NonNull View itemView) {
        super(itemView);

        memberNameTv = itemView.findViewById(R.id.membersNameTv);
        deleteIconIB = itemView.findViewById(R.id.deleteIcon);

        childLayout = itemView.findViewById(R.id.membersNameChildLayoutId);


    }
}
