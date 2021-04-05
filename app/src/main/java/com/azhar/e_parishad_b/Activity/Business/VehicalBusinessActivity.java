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

public class VehicalBusinessActivity extends AppCompatActivity {
    CheckBox ifBusinessCB;
    String ifBusiness;
    String ifBusinessSp;
    RadioGroup typeOfVehicleRG, ownedVbRG, ifDrivingVforGovtRG;
    String typeOfVehicleRGvalue, ownedVbRGvalue, ifDrivingVforGovtRGvalue;
    RadioButton radioButton;
    EditText numberOfVehicleEt, totalCapacityEt, sourceOfFinanceVbEt;
    String numberOfVehicle, totalCapacity, sourceOfFinanceVb;
    String numberOfVehicleSp, totalCapacitySp, sourceOfFinanceVbSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehical_business);

        ifBusinessCB = findViewById(R.id.ifBusinessCB);
        typeOfVehicleRG = findViewById(R.id.typeOfVehicleRG);
        ownedVbRG = findViewById(R.id.ownedVbRG);
        ifDrivingVforGovtRG = findViewById(R.id.ifDrivingVforGovtRG);
        numberOfVehicleEt = findViewById(R.id.numberOfVehicleEt);
        totalCapacityEt = findViewById(R.id.totalCapacityEt);
        sourceOfFinanceVbEt = findViewById(R.id.sourceOfFinanceVbEt);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("VehicalBusiness", Context.MODE_PRIVATE);

        if (sp.contains("ifBusiness")){
            ifBusinessSp = sp.getString("ifBusiness", "Data Not Found");
            if (ifBusinessSp == "Yes"){
                ifBusinessCB.setChecked(true);
            }
        }

        if (sp.contains("numberOfVehicle")){
            numberOfVehicleSp = sp.getString("numberOfVehicle", "Data Not Found");
            numberOfVehicleEt.setText(numberOfVehicleSp);
        }

        int i = sp.getInt("tvrg_key",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.typeOfVehicleRG)).getChildAt(i)).setChecked(true);
        }

        if (sp.contains("totalCapacity")){
            totalCapacitySp = sp.getString("totalCapacity", "Data Not Found");
            totalCapacityEt.setText(totalCapacitySp);
        }

        if (sp.contains("sourceOfFinanceVb")){
            sourceOfFinanceVbSp = sp.getString("sourceOfFinanceVb", "Data Not Found");
            sourceOfFinanceVbEt.setText(sourceOfFinanceVbSp);
        }

        int j = sp.getInt("ovbrg_key",-1);
        if( j >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.ownedVbRG)).getChildAt(i)).setChecked(true);
        }

        int k = sp.getInt("idvfgrg_key",-1);
        if( k >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.ifDrivingVforGovtRG)).getChildAt(i)).setChecked(true);
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

        StringBuilder stringBuilder = new StringBuilder();
        if (ifBusinessCB.isChecked()){
            String value = ifBusinessCB.getText().toString();
            stringBuilder.append(value+ ", ");
            ifBusiness = "Yes";
        }else {
            ifBusiness = "No";
        }

        String v = String.valueOf(stringBuilder);

        try {
            int selectedId = typeOfVehicleRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            typeOfVehicleRGvalue = radioButton.getText().toString();

        }catch (Exception e){

        }

        if (numberOfVehicleEt.getText().toString().isEmpty()) {
            numberOfVehicle = "0";
        } else {
            numberOfVehicle = numberOfVehicleEt.getText().toString().trim();
        }

        if (totalCapacityEt.getText().toString().isEmpty()) {
            totalCapacity = "0";
        } else {
            totalCapacity = totalCapacityEt.getText().toString().trim();
        }

        if (sourceOfFinanceVbEt.getText().toString().isEmpty()) {
            sourceOfFinanceVb = "N/A";
        } else {
            sourceOfFinanceVb = sourceOfFinanceVbEt.getText().toString().trim();
        }

        try {
            int selectedId = ownedVbRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            ownedVbRGvalue = radioButton.getText().toString();

        }catch (Exception e){
//            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }
        try {
            int selectedId = ifDrivingVforGovtRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            ifDrivingVforGovtRGvalue = radioButton.getText().toString();

        }catch (Exception e){
//            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("VehicalBusiness", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("ifBusinessV", v);
        editor.putString("ifBusiness", ifBusiness);
        editor.putString("typeOfVehicleRGvalue", typeOfVehicleRGvalue);
        editor.putString("numberOfVehicle", numberOfVehicle);
        editor.putString("totalCapacity", totalCapacity);
        editor.putString("sourceOfFinanceVb", sourceOfFinanceVb);
        editor.putString("ownedVbRGvalue", ownedVbRGvalue);
        editor.putString("ifDrivingVforGovtRGvalue", ifDrivingVforGovtRGvalue);

        editor.putInt("tvrg_key", typeOfVehicleRG.indexOfChild(findViewById(typeOfVehicleRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.putInt("ovbrg_key", ownedVbRG.indexOfChild(findViewById(ownedVbRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.putInt("idvfgrg_key", ifDrivingVforGovtRG.indexOfChild(findViewById(ifDrivingVforGovtRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.commit();


        Intent intent = new Intent(getApplicationContext(), InterestOfSecurityActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), RiceMillActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}