package com.azhar.e_parishad_b.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.azhar.e_parishad_b.Activity.Business.BusinessDetailActivity;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class ElectricityActivity extends AppCompatActivity {
    RadioGroup isThereElectricityRG, typeOfElectricityRG;
    String isThereElectricityRGvalue, typeOfElectricityRGvalue;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity);

        isThereElectricityRG = findViewById(R.id.isThereElectricityRG);
        typeOfElectricityRG = findViewById(R.id.typeOfElectricityRG);

        //================= Shared Preferences value retrive =========================
        SharedPreferences sp = getSharedPreferences("Electricity", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int i = sp.getInt("ite_key",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.isThereElectricityRG)).getChildAt(i)).setChecked(true);
        }
        int j = sp.getInt("te_key",-1);
        if( j >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.typeOfElectricityRG)).getChildAt(i)).setChecked(true);
        }
        //========================== RecyclerView ============================
        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String [] title = getResources().getStringArray(R.array.title);
        MyAdapter adapter = new MyAdapter(this, title);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
//        Toast.makeText(getApplicationContext(),"Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void goToNextActivity(View view) {

        try {
            int selectedId = isThereElectricityRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            isThereElectricityRGvalue = radioButton.getText().toString();

        }catch (Exception e){
//            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }

        try {
            int selectedId = typeOfElectricityRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            typeOfElectricityRGvalue = radioButton.getText().toString();

        }catch (Exception e){
//            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("Electricity", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("isThereElectricityRGvalue", isThereElectricityRGvalue);
        editor.putString("typeOfElectricityRGvalue", typeOfElectricityRGvalue);

        editor.putInt("ite_key", isThereElectricityRG.indexOfChild(findViewById(isThereElectricityRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.putInt("te_key", typeOfElectricityRG.indexOfChild(findViewById(typeOfElectricityRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.commit();


        Intent intent = new Intent(getApplicationContext(), BusinessDetailActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), SanitationActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}