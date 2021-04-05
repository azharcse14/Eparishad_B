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
import android.widget.EditText;
import android.widget.Toast;

import com.azhar.e_parishad_b.Activity.ElectricityActivity;
import com.azhar.e_parishad_b.Activity.Loan.LoanActivity;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.BusinessSideMenue.BusinessSmAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class InterestOfSecurityActivity extends AppCompatActivity {

    EditText interestOfSecuritiesEt, ifhpEt, ifaEt, capitalGainEt, ifosEt;
    String interestOfSecurities, ifhp, ifa, capitalGain, ifos;
    String interestOfSecuritiesSp, ifhpSp, ifaSp, capitalGainSp, ifosSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_of_security);

        interestOfSecuritiesEt = findViewById(R.id.interestOfSecuritiesEt);
        ifhpEt = findViewById(R.id.ifhpEt);
        ifaEt = findViewById(R.id.ifaEt);
        capitalGainEt = findViewById(R.id.capitalGainEt);
        ifosEt = findViewById(R.id.ifosEt);

        //================= SharedPreferences Data Retrive ==========

        SharedPreferences sp = getSharedPreferences("InterestOfSecurity", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();


        if (sp.contains("interestOfSecurities")){
            interestOfSecuritiesSp = sp.getString("interestOfSecurities", "Data Not Found");
            interestOfSecuritiesEt.setText(interestOfSecuritiesSp);
        }
        if (sp.contains("ifhp")){
            ifhpSp = sp.getString("ifhp", "Data Not Found");
            ifhpEt.setText(ifhpSp);
        }
        if (sp.contains("ifa")){
            ifaSp = sp.getString("ifa", "Data Not Found");
            ifaEt.setText(ifaSp);
        }
        if (sp.contains("capitalGain")){
            capitalGainSp = sp.getString("capitalGain", "Data Not Found");
            capitalGainEt.setText(capitalGainSp);
        }
        if (sp.contains("ifos")){
            ifosSp = sp.getString("ifos", "Data Not Found");
            ifosEt.setText(ifosSp);
        }
        else {
//            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
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

        if (interestOfSecuritiesEt.getText().toString().isEmpty()) {
            interestOfSecurities = "N/A";
        } else {
            interestOfSecurities = interestOfSecuritiesEt.getText().toString().trim();
        }

        if (ifhpEt.getText().toString().isEmpty()) {
            ifhp = "N/A";
        } else {
            ifhp = ifhpEt.getText().toString().trim();
        }

        if (ifaEt.getText().toString().isEmpty()) {
            ifa = "N/A";
        } else {
            ifa = ifaEt.getText().toString().trim();
        }

        if (capitalGainEt.getText().toString().isEmpty()) {
            capitalGain = "N/A";
        } else {
            capitalGain = capitalGainEt.getText().toString().trim();
        }

        if (ifosEt.getText().toString().isEmpty()) {
            ifos = "N/A";
        } else {
            ifos = ifosEt.getText().toString().trim();
        }

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("InterestOfSecurity", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("interestOfSecurities", interestOfSecurities);
        editor.putString("ifhp", ifhp);
        editor.putString("ifa", ifa);
        editor.putString("capitalGain", capitalGain);
        editor.putString("ifos", ifos);

        editor.commit();


        Intent intent = new Intent(getApplicationContext(), FarmingDetailsActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), VehicalBusinessActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}