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

public class FisheriseDetailsActivity extends AppCompatActivity {

    EditText ruiEt, catlaEt, mixedFishEt, pangasEt, koiEt, shingEt, telapiaEt, shrimpEt, prawnEt, othersEt;
    String rui, catla, mixedFish, pangas, koi, shing, telapia, shrimp, prawn, others;
    String ruiSp, catlaSp, mixedFishSp, pangasSp, koiSp, shingSp, telapiaSp, shrimpSp, prawnSp, othersSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisherise_details);

        ruiEt = findViewById(R.id.ruiEt);
        catlaEt = findViewById(R.id.catlaEt);
        mixedFishEt = findViewById(R.id.mixedFishEt);
        pangasEt = findViewById(R.id.pangasEt);
        koiEt = findViewById(R.id.koiEt);
        shingEt = findViewById(R.id.shingEt);
        telapiaEt = findViewById(R.id.telapiaEt);
        shrimpEt = findViewById(R.id.shrimpEt);
        prawnEt = findViewById(R.id.prawnEt);
        othersEt = findViewById(R.id.othersEt);

        //================= SharedPreferences Data Retrive ==========

        SharedPreferences sp = getSharedPreferences("FisheriseDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("rui")){
            ruiSp = sp.getString("rui", "Data Not Found");
            ruiEt.setText(ruiSp);
        }
        if (sp.contains("catla")){
            catlaSp = sp.getString("catla", "Data Not Found");
            catlaEt.setText(catlaSp);
        }
        if (sp.contains("mixedFish")){
            mixedFishSp = sp.getString("mixedFish", "Data Not Found");
            mixedFishEt.setText(mixedFishSp);
        }
        if (sp.contains("pangas")){
            pangasSp = sp.getString("pangas", "Data Not Found");
            pangasEt.setText(pangasSp);
        }
        if (sp.contains("koi")){
            koiSp = sp.getString("koi", "Data Not Found");
            koiEt.setText(koiSp);
        }
        if (sp.contains("shing")){
            shingSp = sp.getString("shing", "Data Not Found");
            shingEt.setText(shingSp);
        }
        if (sp.contains("telapia")){
            telapiaSp = sp.getString("telapia", "Data Not Found");
            telapiaEt.setText(telapiaSp);
        }
        if (sp.contains("shrimp")){
            shrimpSp = sp.getString("shrimp", "Data Not Found");
            shrimpEt.setText(shrimpSp);
        }
        if (sp.contains("prawn")){
            prawnSp = sp.getString("prawn", "Data Not Found");
            prawnEt.setText(prawnSp);
        }
        if (sp.contains("others")){
            othersSp = sp.getString("others", "Data Not Found");
            othersEt.setText(othersSp);
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

        if (ruiEt.getText().toString().isEmpty()) {
            rui = "0";
        } else {
            rui = ruiEt.getText().toString().trim();
        }

        if (catlaEt.getText().toString().isEmpty()) {
            catla = "0";
        } else {
            catla = catlaEt.getText().toString().trim();
        }

        if (mixedFishEt.getText().toString().isEmpty()) {
            mixedFish = "0";
        } else {
            mixedFish = mixedFishEt.getText().toString().trim();
        }

        if (pangasEt.getText().toString().isEmpty()) {
            pangas = "0";
        } else {
            pangas = pangasEt.getText().toString().trim();
        }

        if (koiEt.getText().toString().isEmpty()) {
            koi = "0";
        } else {
            koi = koiEt.getText().toString().trim();
        }

        if (shingEt.getText().toString().isEmpty()) {
            shing = "0";
        } else {
            shing = shingEt.getText().toString().trim();
        }

        if (telapiaEt.getText().toString().isEmpty()) {
            telapia = "0";
        } else {
            telapia = telapiaEt.getText().toString().trim();
        }

        if (shrimpEt.getText().toString().isEmpty()) {
            shrimp = "0";
        } else {
            shrimp = shrimpEt.getText().toString().trim();
        }

        if (prawnEt.getText().toString().isEmpty()) {
            prawn = "0";
        } else {
            prawn = prawnEt.getText().toString().trim();
        }

        if (othersEt.getText().toString().isEmpty()) {
            others = "0";
        } else {
            others = othersEt.getText().toString().trim();
        }

            //================== Shared Preferences ====================

            SharedPreferences sp = getSharedPreferences("FisheriseDetails", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("rui", rui);
            editor.putString("catla", catla);
            editor.putString("mixedFish", mixedFish);
            editor.putString("pangas", pangas);
            editor.putString("koi", koi);
            editor.putString("shing", shing);
            editor.putString("telapia", telapia);
            editor.putString("shrimp", shrimp);
            editor.putString("prawn", prawn);
            editor.putString("others", others);

            editor.commit();


            Intent intent = new Intent(getApplicationContext(), LoanActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), LiveStockDetailActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}