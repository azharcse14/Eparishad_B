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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.azhar.e_parishad_b.Activity.HeadActivity;
import com.azhar.e_parishad_b.Activity.HoldingAddActivity;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberSideMenue.MSMAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class MotherHealthCareInformationActivity extends AppCompatActivity {

    CheckBox vaccinationCB;
    EditText hospitalNameEt;
    RadioGroup nutritionConsultancyRG, mostlyConsultingRG;
    RadioButton radioButton;
    String vaccination, hospitalName, nutritionConsultancy, mostlyConsulting, valueNc, valueMc, vaccinationSp, hospitalNameSp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother_health_care_information);

        vaccinationCB = findViewById(R.id.vaccinationCB);
        hospitalNameEt = findViewById(R.id.hospitalNameEt);
        nutritionConsultancyRG = findViewById(R.id.nutritionConsultancyRG);
        mostlyConsultingRG = findViewById(R.id.mostlyConsultingRG);

        SharedPreferences sp = getSharedPreferences("MotherHCI", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();


        if (sp.contains("vaccination")){
            vaccinationSp = sp.getString("vaccination", "Data Not Found");
            if (vaccinationSp == "vaccination"){
                vaccinationCB.setChecked(true);
            }
        }

        if (sp.contains("hospitalName")){
            hospitalNameSp = sp.getString("hospitalName", "Data Not Found");
            hospitalNameEt.setText(hospitalNameSp);
        }

        int i = sp.getInt("ncrg_key",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.nutritionConsultancyRG)).getChildAt(i)).setChecked(true);
        }
        int j = sp.getInt("mcrg_key",-1);
        if( j >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.mostlyConsultingRG)).getChildAt(i)).setChecked(true);
        }

        else {
            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
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
        if (vaccinationCB.isChecked()){
            String value = vaccinationCB.getText().toString();
            stringBuilder.append(value+ "");
            vaccination = "vaccination";
        }

        String v = String.valueOf(stringBuilder);

        if (hospitalNameEt.getText().toString().isEmpty()) {
            hospitalName = "N/A";
        } else {
            hospitalName = hospitalNameEt.getText().toString().trim();
        }

        try {
            int selectedId = nutritionConsultancyRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            valueNc = radioButton.getText().toString();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }

        try {
            int selectedId = mostlyConsultingRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            valueMc = radioButton.getText().toString();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }

        //================== Shared Preferences ====================


        SharedPreferences sp = getSharedPreferences("MotherHCI", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("cbVaccination", v);
        editor.putString("vaccination", vaccination);
        editor.putString("hospitalName", hospitalName);
        editor.putString("valueNc", valueNc);
        editor.putString("valueMc", valueMc);

        editor.putInt("ncrg_key", nutritionConsultancyRG.indexOfChild(findViewById(nutritionConsultancyRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.putInt("mcrg_key", mostlyConsultingRG.indexOfChild(findViewById(mostlyConsultingRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.commit();



        Intent intent = new Intent(getApplicationContext(), FamillyPlaningActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), DisabilityActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}