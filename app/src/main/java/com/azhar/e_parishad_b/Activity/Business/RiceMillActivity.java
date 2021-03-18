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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.azhar.e_parishad_b.Activity.ElectricityActivity;
import com.azhar.e_parishad_b.Activity.Loan.LoanActivity;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.BusinessSideMenue.BusinessSmAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class RiceMillActivity extends AppCompatActivity {
    CheckBox ifRiceMillingCB;
    String ifRiceMilling;
    String ifRiceMillingSp;
    EditText rmpcEt, tOfRmEt;
    String rmpc, tOfRm, ownedRGvalue, imrgfrfcbRGvalue, rmpcSp, tOfRmSp;
    RadioGroup ownedRG, imrgfrfcbRG;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice_mill);

        ifRiceMillingCB = findViewById(R.id.ifRiceMillingCB);
        rmpcEt = findViewById(R.id.rmpcEt);
        tOfRmEt = findViewById(R.id.tOfRmEt);
        ownedRG = findViewById(R.id.ownedRG);
        imrgfrfcbRG = findViewById(R.id.imrgfrfcbRG);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("RiceMill", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("ifRiceMilling")){
            ifRiceMillingSp = sp.getString("ifRiceMilling", "Data Not Found");
            if (ifRiceMillingSp == "Yes"){
                ifRiceMillingCB.setChecked(true);
            }
        }
        if (sp.contains("rmpc")){
            rmpcSp = sp.getString("rmpc", "Data Not Found");
            rmpcEt.setText(rmpcSp);
        }
        if (sp.contains("tOfRm")){
            tOfRmSp = sp.getString("tOfRm", "Data Not Found");
            tOfRmEt.setText(tOfRmSp);
        }

        int i = sp.getInt("ownedRG_key",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.ownedRG)).getChildAt(i)).setChecked(true);
        }

        int j = sp.getInt("imrgfrfcbRG_key",-1);
        if( j >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.imrgfrfcbRG)).getChildAt(i)).setChecked(true);
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

        StringBuilder stringBuilder = new StringBuilder();
        if (ifRiceMillingCB.isChecked()){
            String value = ifRiceMillingCB.getText().toString();
            stringBuilder.append(value+ ", ");
            ifRiceMilling = "Yes";
        }else {
            ifRiceMilling = "No";
        }

        String v = String.valueOf(stringBuilder);

        if (rmpcEt.getText().toString().isEmpty()) {
            rmpc = "N/A";
        } else {
            rmpc = rmpcEt.getText().toString().trim();
        }

        if (tOfRmEt.getText().toString().isEmpty()) {
            tOfRm = "N/A";
        } else {
            tOfRm = tOfRmEt.getText().toString().trim();
        }

        try {
            int selectedId = ownedRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            ownedRGvalue = radioButton.getText().toString();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }
        try {
            int selectedId = imrgfrfcbRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            imrgfrfcbRGvalue = radioButton.getText().toString();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("RiceMill", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("ifRm", v);
        editor.putString("ifRiceMilling", ifRiceMilling);
        editor.putString("rmpc", rmpc);
        editor.putString("tOfRm", tOfRm);
        editor.putString("ownedRGvalue", ownedRGvalue);
        editor.putString("imrgfrfcbRGvalue", imrgfrfcbRGvalue);

        editor.putInt("ownedRG_key", ownedRG.indexOfChild(findViewById(ownedRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.putInt("imrgfrfcbRG_key", imrgfrfcbRG.indexOfChild(findViewById(imrgfrfcbRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.commit();


        Intent intent = new Intent(getApplicationContext(), VehicalBusinessActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), IndustryDetailsActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}