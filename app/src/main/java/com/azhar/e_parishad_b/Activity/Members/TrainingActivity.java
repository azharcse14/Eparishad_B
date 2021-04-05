package com.azhar.e_parishad_b.Activity.Members;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.Toast;

import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberSideMenue.MSMAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class TrainingActivity extends AppCompatActivity {
    CheckBox agricultureCB,veterinaryCB,sewingCB,ictCB,otherCB;
    String agriculture,veterinary,sewing,ict,other;
    String agricultureSp,veterinarySp,sewingSp,ictSp,otherSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        agricultureCB = findViewById(R.id.agricultureCB);
        veterinaryCB = findViewById(R.id.veterinaryCB);
        sewingCB = findViewById(R.id.sewingCB);
        ictCB = findViewById(R.id.ictCB);
        otherCB = findViewById(R.id.otherCB);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("Training", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("agriculture")){
            agricultureSp = sp.getString("agriculture", "Data Not Found");
            if (agricultureSp == "agriculture"){
                agricultureCB.setChecked(true);
            }
        }if (sp.contains("veterinary")){
            veterinarySp = sp.getString("veterinary", "Data Not Found");
            if (veterinarySp == "veterinary"){
                veterinaryCB.setChecked(true);
            }
        }if (sp.contains("sewing")){
            sewingSp = sp.getString("sewing", "Data Not Found");
            if (sewingSp == "sewing"){
                sewingCB.setChecked(true);
            }
        }if (sp.contains("ict")){
            ictSp = sp.getString("ict", "Data Not Found");
            if (ictSp == "ict"){
                ictCB.setChecked(true);
            }
        }if (sp.contains("other")){
            otherSp = sp.getString("other", "Data Not Found");
            if (otherSp == "other"){
                otherCB.setChecked(true);
            }
        }
        else {
//            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }


        //================= RecyclerView =====================

        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] msm = getResources().getStringArray(R.array.msm);
        MSMAdapter adapter = new MSMAdapter(this, msm);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void goToNextActivity(View view) {

        StringBuilder stringBuilder = new StringBuilder();

        if (agricultureCB.isChecked()){
            String value = agricultureCB.getText().toString();
            stringBuilder.append(value+ ", ");
            agriculture = "agriculture";
        }

        if (veterinaryCB.isChecked()){
            String value = veterinaryCB.getText().toString();
            stringBuilder.append(value+ ", ");
            veterinary = "veterinary";
        }
        if (sewingCB.isChecked()){
            String value = sewingCB.getText().toString();
            stringBuilder.append(value+ ", ");
            sewing = "sewing";
        }
        if (ictCB.isChecked()){
            String value = ictCB.getText().toString();
            stringBuilder.append(value+ ", ");
            ict = "ict";
        }
        if (otherCB.isChecked()){
            String value = otherCB.getText().toString();
            stringBuilder.append(value+ "");
            other = "other";
        }

        String v = String.valueOf(stringBuilder);

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("Training", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("training", v);
        editor.putString("agriculture", agriculture);
        editor.putString("veterinary", veterinary);
        editor.putString("sewing", sewing);
        editor.putString("ict", ict);
        editor.putString("other", other);
        editor.commit();


        Intent intent = new Intent(getApplicationContext(), ProfessionActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), EducationDetailsActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}