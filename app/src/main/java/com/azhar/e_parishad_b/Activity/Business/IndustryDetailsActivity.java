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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.BusinessSideMenue.BusinessSmAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class IndustryDetailsActivity extends AppCompatActivity {

    EditText industryOwnerEt, typeOfIndustryEt, sourceOfFinanceEt;
    String industryOwner, typeOfIndustry, sourceOfFinance;
    String industryOwnerSp, typeOfIndustrySp, sourceOfFinanceSp, value;
    RadioGroup formOfOwnerShipRG;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_industry_details);

        industryOwnerEt = findViewById(R.id.industryOwnerEt);
        typeOfIndustryEt = findViewById(R.id.typeOfIndustryEt);
        sourceOfFinanceEt = findViewById(R.id.sourceOfFinanceEt);
        formOfOwnerShipRG = findViewById(R.id.formOfOwnerShipRG);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("IndustryDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();


        if (sp.contains("industryOwner")){
            industryOwnerSp = sp.getString("industryOwner", "Data Not Found");
            industryOwnerEt.setText(industryOwnerSp);
        }
        if (sp.contains("typeOfIndustry")){
            typeOfIndustrySp = sp.getString("typeOfIndustry", "Data Not Found");
            typeOfIndustryEt.setText(typeOfIndustrySp);
        }
        if (sp.contains("sourceOfFinance")){
            sourceOfFinanceSp = sp.getString("sourceOfFinance", "Data Not Found");
            sourceOfFinanceEt.setText(sourceOfFinanceSp);
        }

        int i = sp.getInt("my_choice_key",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.formOfOwnerShipRG)).getChildAt(i)).setChecked(true);
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

        if (industryOwnerEt.getText().toString().isEmpty()) {
            industryOwner = "N/A";
        } else {
            industryOwner = industryOwnerEt.getText().toString().trim();
        }
        if (typeOfIndustryEt.getText().toString().isEmpty()) {
            typeOfIndustry = "N/A";
        } else {
            typeOfIndustry = typeOfIndustryEt.getText().toString().trim();
        }
        if (sourceOfFinanceEt.getText().toString().isEmpty()) {
            sourceOfFinance = "N/A";
        } else {
            sourceOfFinance = sourceOfFinanceEt.getText().toString().trim();
        }

        try {
            int selectedId = formOfOwnerShipRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            value = radioButton.getText().toString();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("IndustryDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("industryOwner", industryOwner);
        editor.putString("typeOfIndustry", typeOfIndustry);
        editor.putString("sourceOfFinance", sourceOfFinance);
        editor.putString("valueRG", value);

        editor.putInt("my_choice_key", formOfOwnerShipRG.indexOfChild(findViewById(formOfOwnerShipRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.commit();


        Intent intent = new Intent(getApplicationContext(), RiceMillActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), BusinessDetailActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}