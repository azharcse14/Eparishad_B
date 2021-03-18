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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberSideMenue.MSMAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class MaritalStatusDetailActivity extends AppCompatActivity {


    RadioGroup marriedRG;
    RadioButton radioButton;
    String marriedRGvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marital_status_detail);

        marriedRG = findViewById(R.id.marriedRG);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("maritalStatus", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int i = sp.getInt("my_choice_key",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.marriedRG)).getChildAt(i)).setChecked(true);
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

        try {
            int selectedId = marriedRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            marriedRGvalue = radioButton.getText().toString();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }



        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("maritalStatus", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("marriedRGvalue", marriedRGvalue);

        editor.putInt("my_choice_key", marriedRG.indexOfChild(findViewById(marriedRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.commit();


        Intent intent = new Intent(getApplicationContext(), PersonalStatusDetailActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), ProfessionActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}