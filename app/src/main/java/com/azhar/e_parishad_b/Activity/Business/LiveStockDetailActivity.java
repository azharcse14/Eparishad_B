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

public class LiveStockDetailActivity extends AppCompatActivity {

    EditText cattleEt, buffaloEt, sheepEt, goatEt, chickenEt, eggHensEt, duckEt, eggsDuckEt;
    String cattle, buffalo, sheep, goat, chicken, eggHens, duck, eggsDuck;
    String cattleSp, buffaloSp, sheepSp, goatSp, chickenSp, eggHensSp, duckSp, eggsDuckSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_stock_detail);

        cattleEt = findViewById(R.id.cattleEt);
        buffaloEt = findViewById(R.id.buffaloEt);
        sheepEt = findViewById(R.id.sheepEt);
        goatEt = findViewById(R.id.goatEt);
        chickenEt = findViewById(R.id.chickenEt);
        eggHensEt = findViewById(R.id.eggHensEt);
        duckEt = findViewById(R.id.duckEt);
        eggsDuckEt = findViewById(R.id.eggsDuckEt);

        //================= SharedPreferences Data Retrive ==========

        SharedPreferences sp = getSharedPreferences("LiveStockDetail", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("cattle")){
            cattleSp = sp.getString("cattle", "Data Not Found");
            cattleEt.setText(cattleSp);
        }
        if (sp.contains("buffalo")){
            buffaloSp = sp.getString("buffalo", "Data Not Found");
            buffaloEt.setText(buffaloSp);
        }
        if (sp.contains("sheep")){
            sheepSp = sp.getString("sheep", "Data Not Found");
            sheepEt.setText(sheepSp);
        }
        if (sp.contains("goat")){
            goatSp = sp.getString("goat", "Data Not Found");
            goatEt.setText(goatSp);
        }
        if (sp.contains("chicken")){
            chickenSp = sp.getString("chicken", "Data Not Found");
            chickenEt.setText(chickenSp);
        }if (sp.contains("eggHens")){
            eggHensSp = sp.getString("eggHens", "Data Not Found");
            eggHensEt.setText(eggHensSp);
        }if (sp.contains("duck")){
            duckSp = sp.getString("duck", "Data Not Found");
            duckEt.setText(duckSp);
        }if (sp.contains("eggsDuck")){
            eggsDuckSp = sp.getString("eggsDuck", "Data Not Found");
            eggsDuckEt.setText(eggsDuckSp);
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

        if (cattleEt.getText().toString().isEmpty()) {
            cattle = "0";
        } else {
            cattle = cattleEt.getText().toString().trim();
        }

        if (buffaloEt.getText().toString().isEmpty()) {
            buffalo = "0";
        } else {
            buffalo = buffaloEt.getText().toString().trim();
        }

        if (sheepEt.getText().toString().isEmpty()) {
            sheep = "0";
        } else {
            sheep = sheepEt.getText().toString().trim();
        }

        if (goatEt.getText().toString().isEmpty()) {
            goat = "0";
        } else {
            goat = goatEt.getText().toString().trim();
        }

        if (chickenEt.getText().toString().isEmpty()) {
            chicken = "0";
        } else {
            chicken = chickenEt.getText().toString().trim();
        }

        if (eggHensEt.getText().toString().isEmpty()) {
            eggHens = "0";
        } else {
            eggHens = eggHensEt.getText().toString().trim();
        }

        if (duckEt.getText().toString().isEmpty()) {
            duck = "0";
        } else {
            duck = duckEt.getText().toString().trim();
        }

        if (eggsDuckEt.getText().toString().isEmpty()) {
            eggsDuck = "0";
        } else {
            eggsDuck = eggsDuckEt.getText().toString().trim();
        }
        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("LiveStockDetail", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("cattle", cattle);
        editor.putString("buffalo", buffalo);
        editor.putString("sheep", sheep);
        editor.putString("goat", goat);
        editor.putString("chicken", chicken);
        editor.putString("eggHens", eggHens);
        editor.putString("duck", duck);
        editor.putString("eggsDuck", eggsDuck);

        editor.commit();


        Intent intent = new Intent(getApplicationContext(), FisheriseDetailsActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), FarmingDetailsActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}