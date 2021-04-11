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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberSideMenue.MSMAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class MaritalStatusDetailActivity extends AppCompatActivity {


    RadioGroup marriedRG;
    RadioButton radioButton;
    String marriedRGvalue;

    TextView spouseNameTv;
    EditText spouseNameEt;

    String spouseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marital_status_detail);

        marriedRG = findViewById(R.id.marriedRG);
        spouseNameTv = findViewById(R.id.spouseNameId);
        spouseNameEt = findViewById(R.id.spouseNameEtId);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("maritalStatus", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int i = sp.getInt("my_choice_key",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.marriedRG)).getChildAt(i)).setChecked(true);
        }

        if (sp.contains("spouseName")) {
            spouseName = sp.getString("spouseName", "Data Not Found");
            spouseNameEt.setText(spouseName);
        }

        spouseNameTv.setVisibility(View.GONE);
        spouseNameEt.setVisibility(View.GONE);

        marriedRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                radioButton = (RadioButton) findViewById(checkedId);

                if (checkedId == 1){
                    spouseNameTv.setVisibility(View.VISIBLE);
                    spouseNameEt.setVisibility(View.VISIBLE);


//                    Toast.makeText(getBaseContext(), radioButton.getText(), Toast.LENGTH_SHORT).show();

                }else {
                    spouseNameTv.setVisibility(View.GONE);
                    spouseNameEt.setVisibility(View.GONE);
                }
            }
        });

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
//            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }

        if (spouseNameEt.getText().toString().isEmpty()) {
            spouseName = "N/A";
        } else {
            spouseName = spouseNameEt.getText().toString().trim();
        }


        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("maritalStatus", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("marriedRGvalue", marriedRGvalue);
        editor.putString("spouseName", spouseName);

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