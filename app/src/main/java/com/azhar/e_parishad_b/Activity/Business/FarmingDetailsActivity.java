package com.azhar.e_parishad_b.Activity.Business;

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
import android.widget.EditText;
import android.widget.Toast;

import com.azhar.e_parishad_b.Activity.ElectricityActivity;
import com.azhar.e_parishad_b.Activity.Loan.LoanActivity;
import com.azhar.e_parishad_b.ImageProcessing.ImageDecoder;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.BusinessSideMenue.BusinessSmAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class FarmingDetailsActivity extends AppCompatActivity {

    EditText aushEt, amanEt, boroEt, wheatEt, maizeEt, pulsesEt, oilSeedsEt, potatoEt, tomatoEt, vegetableEt, sugarcaneEt, juteEt;
    String aush, aman, boro, wheat, maize, pulses, oilSeeds, potato, tomato, vegetable, sugarcane, jute;
    String aushSp, amanSp, boroSp, wheatSp, maizeSp, pulsesSp, oilSeedsSp, potatoSp, tomatoSp, vegetableSp, sugarcaneSp, juteSp;
    CheckBox sgfpCB, sptCB;
    String sgfp, spt;
    String sgfpSp, sptSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farming_details);

        aushEt = findViewById(R.id.aushEt);
        amanEt = findViewById(R.id.amanEt);
        boroEt = findViewById(R.id.boroEt);
        wheatEt = findViewById(R.id.wheatEt);
        maizeEt = findViewById(R.id.maizeEt);
        pulsesEt = findViewById(R.id.pulsesEt);
        oilSeedsEt = findViewById(R.id.oilSeedsEt);
        potatoEt = findViewById(R.id.potatoEt);
        tomatoEt = findViewById(R.id.tomatoEt);
        vegetableEt = findViewById(R.id.vegetableEt);
        sugarcaneEt = findViewById(R.id.sugarcaneEt);
        juteEt = findViewById(R.id.juteEt);
        sgfpCB = findViewById(R.id.sgfpCB);
        sptCB = findViewById(R.id.sptCB);

        //================= SharedPreferences Data Retrive ==========

        SharedPreferences sp = getSharedPreferences("FarmingDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();


        if (sp.contains("aush")){
            aushSp = sp.getString("aush", "Data Not Found");
            aushEt.setText(aushSp);
        }
        if (sp.contains("aman")){
            amanSp = sp.getString("aman", "Data Not Found");
            amanEt.setText(amanSp);
        }
        if (sp.contains("boro")){
            boroSp = sp.getString("boro", "Data Not Found");
            boroEt.setText(boroSp);

        }
        if (sp.contains("wheat")){
            wheatSp = sp.getString("wheat", "Data Not Found");
            wheatEt.setText(wheatSp);
        }
        if (sp.contains("maize")){
            maizeSp = sp.getString("maize", "Data Not Found");
            maizeEt.setText(maizeSp);
        }
        if (sp.contains("pulses")){
            pulsesSp = sp.getString("pulses", "Data Not Found");
            pulsesEt.setText(pulsesSp);
        }
        if (sp.contains("oilSeeds")){
            oilSeedsSp = sp.getString("oilSeeds", "Data Not Found");
            oilSeedsEt.setText(oilSeedsSp);
        }
        if (sp.contains("potato")){
            potatoSp = sp.getString("potato", "Data Not Found");
            potatoEt.setText(potatoSp);
        }
        if (sp.contains("tomato")){
            tomatoSp = sp.getString("tomato", "Data Not Found");
            tomatoEt.setText(tomatoSp);
        }
        if (sp.contains("vegetable")){
            vegetableSp = sp.getString("vegetable", "Data Not Found");
            vegetableEt.setText(vegetableSp);
        }
        if (sp.contains("sugarcane")){
            sugarcaneSp = sp.getString("sugarcane", "Data Not Found");
            sugarcaneEt.setText(sugarcaneSp);
        }
        if (sp.contains("jute")){
            juteSp = sp.getString("jute", "Data Not Found");
            juteEt.setText(juteSp);
        }
        if (sp.contains("sgfp")){
            sgfpSp = sp.getString("sgfp", "Data Not Found");
            if (sgfpSp == "Yes"){
                sgfpCB.setChecked(true);
            }
        }
        if (sp.contains("spt")){
            sptSp = sp.getString("spt", "Data Not Found");
            if (sptSp == "Yes"){
                sptCB.setChecked(true);
            }
        }

        else {
            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }

        //================= RecyclerView =====================

        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] business = getResources().getStringArray(R.array.business);
        BusinessSmAdapter adapter = new BusinessSmAdapter(this, business);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void goToNextActivity(View view) {

        if (aushEt.getText().toString().isEmpty()) {
            aush = "0";
        } else {
            aush = aushEt.getText().toString().trim();
        }
        if (amanEt.getText().toString().isEmpty()) {
            aman = "0";
        } else {
            aman = amanEt.getText().toString().trim();
        }

        if (boroEt.getText().toString().isEmpty()) {
            boro = "0";
        } else {
            boro = boroEt.getText().toString().trim();
        }

        if (wheatEt.getText().toString().isEmpty()) {
            wheat = "0";
        } else {
            wheat = wheatEt.getText().toString().trim();
        }

        if (maizeEt.getText().toString().isEmpty()) {
            maize = "0";
        } else {
            maize = maizeEt.getText().toString().trim();
        }

        if (pulsesEt.getText().toString().isEmpty()) {
            pulses = "0";
        } else {
            pulses = pulsesEt.getText().toString().trim();
        }

        if (oilSeedsEt.getText().toString().isEmpty()) {
            oilSeeds = "0";
        } else {
            oilSeeds = oilSeedsEt.getText().toString().trim();
        }

        if (potatoEt.getText().toString().isEmpty()) {
            potato = "0";
        } else {
            potato = potatoEt.getText().toString().trim();
        }

        if (tomatoEt.getText().toString().isEmpty()) {
            tomato = "0";
        } else {
            tomato = tomatoEt.getText().toString().trim();
        }

        if (vegetableEt.getText().toString().isEmpty()) {
            vegetable = "0";
        } else {
            vegetable = vegetableEt.getText().toString().trim();
        }

        if (sugarcaneEt.getText().toString().isEmpty()) {
            sugarcane = "0";
        } else {
            sugarcane = sugarcaneEt.getText().toString().trim();
        }

        if (juteEt.getText().toString().isEmpty()) {
            jute = "0";
        } else {
            jute = juteEt.getText().toString().trim();
        }


        StringBuilder stringBuilder = new StringBuilder();

        if (sgfpCB.isChecked()){
            String value = sgfpCB.getText().toString();
            stringBuilder.append(value+ ", ");
            sgfp = "Yes";
        }else {
            sgfp = "No";
        }
        if (sptCB.isChecked()){
            String value = sptCB.getText().toString();
            stringBuilder.append(value+ "");
            spt = "Yes";
        }else {
            spt = "No";
        }

        String v = String.valueOf(stringBuilder);


        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("FarmingDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("aush", aush);
        editor.putString("aman", aman);
        editor.putString("boro", boro);
        editor.putString("wheat", wheat);
        editor.putString("maize", maize);
        editor.putString("pulses", pulses);
        editor.putString("oilSeeds", oilSeeds);
        editor.putString("potato", potato);
        editor.putString("tomato", tomato);
        editor.putString("vegetable", vegetable);
        editor.putString("sugarcane", sugarcane);
        editor.putString("jute", jute);
        editor.putString("cb", v);
        editor.putString("sgfp", sgfp);
        editor.putString("spt", spt);
        editor.commit();


        Intent intent = new Intent(getApplicationContext(), LiveStockDetailActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), InterestOfSecurityActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}