package com.azhar.e_parishad_b.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

import java.util.Random;

public class HoldingAddActivity extends AppCompatActivity {

    TextView kinNumber;
    String kinNo, generatedString, khanaNosp, wardValue, villageValue, wardValueSp, villageValueSp;
    String[] ward;
    String[] village;
    AutoCompleteTextView wardSpinner, villageSpinner;

    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holding_add);

        kinNumber = findViewById(R.id.kinNumber);

        wardSpinner = findViewById(R.id.wardSpinnerId);
        villageSpinner = findViewById(R.id.villageSpinnerId);





        //================= Random String ==================

        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        generatedString = buffer.toString();

        //===================== KIN Number ===================





        //======================= Spinner =============================

        ward = getResources().getStringArray(R.array.ward);
        village = getResources().getStringArray(R.array.village);

        ArrayAdapter<String> wardAdapter = new ArrayAdapter<String>(this,R.layout.spinner_view, R.id.spinnerTvId, ward);
        wardSpinner.setAdapter(wardAdapter);

        wardSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                wardValue = parent.getItemAtPosition(position).toString();
            }
        });

        ArrayAdapter<String> villageAdapter = new ArrayAdapter<String>(this,R.layout.spinner_view, R.id.spinnerTvId, village);
        villageSpinner.setAdapter(villageAdapter);

        villageSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                villageValue = parent.getItemAtPosition(position).toString();

                // create Toast with user selected value
//                Toast.makeText(getApplicationContext(), "Selected Item is: \t" + villageValue, Toast.LENGTH_LONG).show();

            }
        });



        //================= SharedPreferences Data Retrive ==========

        SharedPreferences sp = getSharedPreferences("HoldingNo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("khanaNo")){
            khanaNosp = sp.getString("khanaNo", "Data Not Found");
            kinNo = "KIN - " + generatedString + " - " + khanaNosp;
            kinNumber.setText(kinNo);
        }else {
//            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }

        SharedPreferences spHd = getSharedPreferences("HoldingAdd", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorHd = spHd.edit();

        if (spHd.contains("wardValue")){
            wardValueSp = spHd.getString("wardValue", "Data Not Found");
            wardSpinner.setText(wardValueSp);

        }if (spHd.contains("villageValue")){
            villageValueSp = spHd.getString("villageValue", "Data Not Found");
            villageSpinner.setText(villageValueSp);

        }
        else {
//            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }

        //========================= RecyclerView =================

        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String [] title = getResources().getStringArray(R.array.title);
        MyAdapter adapter = new MyAdapter(this, title);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void goToNextActivity(View view) {

        //================== Shared Preferences ====================
        SharedPreferences spHd = getSharedPreferences("HoldingAdd", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorHd = spHd.edit();
        editorHd.putString("wardValue", wardValue);
        editorHd.putString("villageValue", villageValue);
        editorHd.putString("kinNo", kinNo);
        editorHd.commit();

        if (wardSpinner.getText().toString().isEmpty()){
            wardSpinner.setError("Field is required!");
        }if (villageSpinner.getText().toString().isEmpty()){
            villageSpinner.setError("Field is required!");
        }else {
            Intent intent = new Intent(getApplicationContext(), HeadActivity.class);
            startActivity(intent);
        }

    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), HoldingNoActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}