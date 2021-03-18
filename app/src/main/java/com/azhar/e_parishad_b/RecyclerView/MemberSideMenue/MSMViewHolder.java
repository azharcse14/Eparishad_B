package com.azhar.e_parishad_b.RecyclerView.MemberSideMenue;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.e_parishad_b.R;

public class MSMViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    ConstraintLayout childLayout;
    public MSMViewHolder(@NonNull View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.textViewId);
        childLayout = itemView.findViewById(R.id.childLayout);
    }
}

