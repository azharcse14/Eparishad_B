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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class HouseTypeActivity extends AppCompatActivity {

    CheckBox katchaCB, pakaCB, semiPakaCB, tinerGhorCB, hutCB, bambooHutCB, otherCB;
    String katcha, paka, semiPaka, tinerGhor, hut, bambooHut, other;
    String katchaSp, pakaSp, semiPakaSp, tinerGhorSp, hutSp, bambooHutSp, otherSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_type);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        katchaCB = findViewById(R.id.katchaHtCB);
        pakaCB = findViewById(R.id.pakaHtCB);
        semiPakaCB = findViewById(R.id.semiPakaHtCB);
        tinerGhorCB = findViewById(R.id.tinerGhorHtCB);
        hutCB = findViewById(R.id.hutHtCB);
        bambooHutCB = findViewById(R.id.bambooHutHtCB);
        otherCB = findViewById(R.id.otherHtCB);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("HouseType", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();


        if (sp.contains("katcha")){
            katchaSp = sp.getString("katcha", "Data Not Found");
            if (katchaSp == "katcha"){
                katchaCB.setChecked(true);
            }
        }if (sp.contains("paka")){
            pakaSp = sp.getString("paka", "Data Not Found");
            if (pakaSp == "paka"){
                pakaCB.setChecked(true);
            }
        }if (sp.contains("semiPaka")){
            semiPakaSp = sp.getString("semiPaka", "Data Not Found");
            if (semiPakaSp == "semiPaka"){
                semiPakaCB.setChecked(true);
            }
        }if (sp.contains("tinerGhor")){
            tinerGhorSp = sp.getString("tinerGhor", "Data Not Found");
            if (tinerGhorSp == "tinerGhor"){
                tinerGhorCB.setChecked(true);
            }
        }if (sp.contains("hut")){
            hutSp = sp.getString("hut", "Data Not Found");
            if (hutSp == "hut"){
                hutCB.setChecked(true);
            }
        }if (sp.contains("bambooHut")){
            bambooHutSp = sp.getString("bambooHut", "Data Not Found");
            if (bambooHutSp == "bambooHut"){
                bambooHutCB.setChecked(true);
            }
        }if (sp.contains("other")){
            otherSp = sp.getString("other", "Data Not Found");
            if (otherSp == "other"){
                otherCB.setChecked(true);
            }
        }
       else {
            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }



        //========================= RecyclerView ==========================

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

        StringBuilder stringBuilder = new StringBuilder();
        if (katchaCB.isChecked()){
            String value = katchaCB.getText().toString();
            stringBuilder.append(value+ ", ");
            katcha = "katcha";
        }
        if (pakaCB.isChecked()){
            String value = pakaCB.getText().toString();
            stringBuilder.append(value+ ", ");
            paka = "paka";
        }
        if (semiPakaCB.isChecked()){
            String value = semiPakaCB.getText().toString();
            stringBuilder.append(value+ ", ");
            semiPaka = "semiPaka";
        }
        if (tinerGhorCB.isChecked()){
            String value = tinerGhorCB.getText().toString();
            stringBuilder.append(value+ ", ");
            tinerGhor = "tinerGhor";
        }
        if (hutCB.isChecked()){
            String value = hutCB.getText().toString();
            stringBuilder.append(value+ ", ");
            hut = "hut";
        }

        if (bambooHutCB.isChecked()){
            String value = bambooHutCB.getText().toString();
            stringBuilder.append(value+ ", ");
            bambooHut = "bambooHut";
        }

        if (otherCB.isChecked()){
            String value = otherCB.getText().toString();
            stringBuilder.append(value+ "");
            other = "other";
        }

        String v = String.valueOf(stringBuilder);

        //================== Shared Preferences ====================


        SharedPreferences sp = getSharedPreferences("HouseType", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("houseTypeV", v);
        editor.putString("katcha", katcha);
        editor.putString("paka", paka);
        editor.putString("semiPaka", semiPaka);
        editor.putString("tinerGhor", tinerGhor);
        editor.putString("hut", hut);
        editor.putString("bambooHut", bambooHut);
        editor.putString("other", other);
        editor.commit();


        Intent intent = new Intent(getApplicationContext(), WaterActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), LandActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}