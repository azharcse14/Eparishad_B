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
import android.widget.CheckBox;
import android.widget.Toast;

import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class WaterActivity extends AppCompatActivity {

    CheckBox tubewellIHCB, tubewellUHCB, supplyLineCB, poundCB, riverCB, otherCB;
    String tubewellIH, tubewellUH, supplyLine, pound, river, other;
    String tubewellIHSP, tubewellUHSP, supplyLineSP, poundSP, riverSP, otherSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        tubewellIHCB = findViewById(R.id.tubewellIHCB);
        tubewellUHCB = findViewById(R.id.tubewellUHCB);
        supplyLineCB = findViewById(R.id.supplyLineCB);
        poundCB = findViewById(R.id.poundCB);
        riverCB = findViewById(R.id.riverCB);
        otherCB = findViewById(R.id.otherCB);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("waterSupply", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("tubewellIH")){
            tubewellIHSP = sp.getString("tubewellIH", "Data Not Found");
            if (tubewellIHSP == "tubewellIH"){
                tubewellIHCB.setChecked(true);
            }
        }if (sp.contains("tubewellUH")){
            tubewellUHSP = sp.getString("tubewellUH", "Data Not Found");
            if (tubewellUHSP == "tubewellUH"){
                tubewellUHCB.setChecked(true);
            }
        }if (sp.contains("supplyLine")){
            supplyLineSP = sp.getString("supplyLine", "Data Not Found");
            if (supplyLineSP == "supplyLine"){
                supplyLineCB.setChecked(true);
            }
        }if (sp.contains("pound")){
            poundSP = sp.getString("pound", "Data Not Found");
            if (poundSP == "pound"){
                poundCB.setChecked(true);
            }
        }if (sp.contains("river")){
            riverSP = sp.getString("river", "Data Not Found");
            if (riverSP == "river"){
                riverCB.setChecked(true);
            }
        }if (sp.contains("other")){
            otherSP = sp.getString("other", "Data Not Found");
            if (otherSP == "other"){
                otherCB.setChecked(true);
            }
        }
        else {
//            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }


        //================= RecyclerView =====================

        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] title = getResources().getStringArray(R.array.title);
        MyAdapter adapter = new MyAdapter(this, title);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void goToNextActivity(View view) {

        StringBuilder stringBuilder = new StringBuilder();
        if (tubewellIHCB.isChecked()){
            String value = tubewellIHCB.getText().toString();
            stringBuilder.append(value+ ", ");
            tubewellIH = "tubewellIH";
        }
        if (tubewellUHCB.isChecked()){
            String value = tubewellUHCB.getText().toString();
            stringBuilder.append(value+ ", ");
            tubewellUH = "tubewellUH";
        }
        if (supplyLineCB.isChecked()){
            String value = supplyLineCB.getText().toString();
            stringBuilder.append(value+ ", ");
            supplyLine = "supplyLine";
        }
        if (poundCB.isChecked()){
            String value = poundCB.getText().toString();
            stringBuilder.append(value+ ", ");
            pound = "pound";
        }
        if (riverCB.isChecked()){
            String value = riverCB.getText().toString();
            stringBuilder.append(value+ ", ");
            river = "river";
        }
        if (otherCB.isChecked()){
            String value = otherCB.getText().toString();
            stringBuilder.append(value+ "");
            other = "other";
        }

        String v = String.valueOf(stringBuilder);

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("waterSupply", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("waterSupplyV", v);
        editor.putString("tubewellIH", tubewellIH);
        editor.putString("tubewellUH", tubewellUH);
        editor.putString("supplyLine", supplyLine);
        editor.putString("pound", pound);
        editor.putString("river", river);
        editor.putString("other", other);
        editor.commit();



        Intent intent = new Intent(getApplicationContext(), SanitationActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), HouseTypeActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}