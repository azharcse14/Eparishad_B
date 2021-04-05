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
import android.widget.Toast;

import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberSideMenue.MSMAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class IncomeDetailActivity extends AppCompatActivity {

    EditText incomeMainEt, incomeSecondEt, additionalIncomeEt, mobNumEt, emailAddEt;
    String incomeMain, incomeSecond, additionalIncome, mobNum, emailAdd;
    String incomeMainSp, incomeSecondSp, additionalIncomeSp, mobNumSp, emailAddSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_detail);

        incomeMainEt = findViewById(R.id.incomeMainEt);
        incomeSecondEt = findViewById(R.id.incomeSecondEt);
        additionalIncomeEt = findViewById(R.id.additionalIncomeEt);
        mobNumEt = findViewById(R.id.mobNumEtId);
        emailAddEt = findViewById(R.id.emailAddEtId);

        //================= SharedPreferences Data Retrive ==========

        SharedPreferences sp = getSharedPreferences("IncomeDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("incomeMain")){
            incomeMainSp = sp.getString("incomeMain", "Data Not Found");
            incomeMainEt.setText(incomeMainSp);
        }
        if (sp.contains("incomeSecond")){
            incomeSecondSp = sp.getString("incomeSecond", "Data Not Found");
            incomeSecondEt.setText(incomeSecondSp);
        }
        if (sp.contains("additionalIncome")){
            additionalIncomeSp = sp.getString("additionalIncome", "Data Not Found");
            additionalIncomeEt.setText(additionalIncomeSp);
        }
        if (sp.contains("mobNum")){
            mobNumSp = sp.getString("mobNum", "Data Not Found");
            mobNumEt.setText(mobNumSp);
        }
        if (sp.contains("emailAdd")){
            emailAddSp = sp.getString("emailAdd", "Data Not Found");
            emailAddEt.setText(emailAddSp);
        }
        else {
//            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
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
        if (incomeMainEt.getText().toString().isEmpty()) {
            incomeMain = "N/A";
        } else {
            incomeMain = incomeMainEt.getText().toString().trim();
        }

        if (incomeSecondEt.getText().toString().isEmpty()) {
            incomeSecond = "N/A";
        } else {
            incomeSecond = incomeSecondEt.getText().toString().trim();
        }

        if (additionalIncomeEt.getText().toString().isEmpty()) {
            additionalIncome = "N/A";
        } else {
            additionalIncome = additionalIncomeEt.getText().toString().trim();
        }

        if (mobNumEt.getText().toString().isEmpty()) {
            mobNum = "N/A";
        } else {
            mobNum = mobNumEt.getText().toString().trim();
        }

        if (emailAddEt.getText().toString().isEmpty()) {
            emailAdd = "N/A";
        } else {
            emailAdd = emailAddEt.getText().toString().trim();
        }

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("IncomeDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("incomeMain", incomeMain);
        editor.putString("incomeSecond", incomeSecond);
        editor.putString("additionalIncome", additionalIncome);
        editor.putString("mobNum", mobNum);
        editor.putString("emailAdd", emailAdd);
        editor.commit();


        Intent intent = new Intent(getApplicationContext(), BankDetailActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), PersonalStatusDetailActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}