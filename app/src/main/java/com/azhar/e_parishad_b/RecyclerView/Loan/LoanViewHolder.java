package com.azhar.e_parishad_b.RecyclerView.Loan;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.e_parishad_b.R;

public class LoanViewHolder extends RecyclerView.ViewHolder {
    TextView loanNameTv;
    ImageView deleteIconIB;

    public LoanViewHolder(@NonNull View itemView) {
        super(itemView);

        loanNameTv = itemView.findViewById(R.id.loanNameTv);
        deleteIconIB = itemView.findViewById(R.id.loanDeleteIcon);
    }
}
