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

public class BankDetailActivity extends AppCompatActivity {

    EditText accountNoEt, mobailNoEt, bankNameEt, branchNameEt;
    String accountNo, mobailNo, bankName, branchName;
    String accountNoSp, mobailNoSp, bankNameSp, branchNameSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_detail);

        accountNoEt = findViewById(R.id.accountNoEt);
        mobailNoEt = findViewById(R.id.mobailNoEt);
        bankNameEt = findViewById(R.id.bankNameEt);
        branchNameEt = findViewById(R.id.branchNameEt);

        //================= SharedPreferences Data Retrive ==========

        SharedPreferences sp = getSharedPreferences("BankDetail", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("accountNo")) {
            accountNoSp = sp.getString("accountNo", "Data Not Found");

            accountNoEt.setText(accountNoSp);
        }
        if (sp.contains("mobailNo")) {
            mobailNoSp = sp.getString("mobailNo", "Data Not Found");

            mobailNoEt.setText(mobailNoSp);
        }
        if (sp.contains("bankName")) {
            bankNameSp = sp.getString("bankName", "Data Not Found");

            bankNameEt.setText(bankNameSp);
        }
        if (sp.contains("branchName")) {
            branchNameSp = sp.getString("branchName", "Data Not Found");

            branchNameEt.setText(branchNameSp);
        } else {
//            Toast.makeText(getApplicationContext(), "Empty", Toast.LENGTH_LONG).show();
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

        if (accountNoEt.getText().toString().isEmpty()) {
            accountNo = "N/A";
        } else {
            accountNo = accountNoEt.getText().toString().trim();
        }

        if (mobailNoEt.getText().toString().isEmpty()) {
            mobailNo = "N/A";
        } else {
            mobailNo = mobailNoEt.getText().toString().trim();
        }

        if (bankNameEt.getText().toString().isEmpty()) {
            bankName = "N/A";
        } else {
            bankName = bankNameEt.getText().toString().trim();
        }

        if (branchNameEt.getText().toString().isEmpty()) {
            branchName = "N/A";
        } else {
            branchName = branchNameEt.getText().toString().trim();
        }


        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("BankDetail", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("accountNo", accountNo);
        editor.putString("mobailNo", mobailNo);
        editor.putString("bankName", bankName);
        editor.putString("branchName", branchName);
        editor.commit();


        Intent intent = new Intent(getApplicationContext(), MemberLiveActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), IncomeDetailActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}