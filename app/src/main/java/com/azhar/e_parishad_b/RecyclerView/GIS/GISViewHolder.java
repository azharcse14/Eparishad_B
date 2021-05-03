package com.azhar.e_parishad_b.RecyclerView.GIS;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.e_parishad_b.R;

public class GISViewHolder extends RecyclerView.ViewHolder {

    TextView sn, survey_id, khana_head, holding_no, village, latitude, longitude, edit, send;

    public GISViewHolder(@NonNull View itemView) {
        super(itemView);

        sn = itemView.findViewById(R.id.snGisTvId);
        survey_id = itemView.findViewById(R.id.survey_idGisTvId);
        khana_head = itemView.findViewById(R.id.khana_headGisTvId);
        holding_no = itemView.findViewById(R.id.holding_noGisTvId);
        village = itemView.findViewById(R.id.villageGisTvId);
        latitude = itemView.findViewById(R.id.latitudeGisTvId);
        longitude = itemView.findViewById(R.id.longitudeGisTvId);
        edit = itemView.findViewById(R.id.editGisTvId);
        send = itemView.findViewById(R.id.sendGisTvId);
    }
}
