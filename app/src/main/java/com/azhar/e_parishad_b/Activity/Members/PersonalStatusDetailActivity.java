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

public class PersonalStatusDetailActivity extends AppCompatActivity {

    EditText mrnEt, mrdEt, drnEt, drdEt;
    String mrn, mrd, drn, drd;
    String mrnSp, mrdSp, drnSp, drdSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_status_detail);

        mrnEt = findViewById(R.id.mrnEtId);
        mrdEt = findViewById(R.id.mrdEtId);
        drnEt = findViewById(R.id.drnEtId);
        drdEt = findViewById(R.id.drdEtId);

        //================= SharedPreferences Data Retrive ==========

        SharedPreferences sp = getSharedPreferences("PersonalStatusDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("mrn")){
            mrnSp = sp.getString("mrn", "Data Not Found");
            mrnEt.setText(mrnSp);
        }
        if (sp.contains("mrd")){
            mrdSp = sp.getString("mrd", "Data Not Found");
            mrdEt.setText(mrdSp);
        }
        if (sp.contains("drn")){
            drnSp = sp.getString("drn", "Data Not Found");
            drnEt.setText(drnSp);
        }
        if (sp.contains("drd")){
            drdSp = sp.getString("drd", "Data Not Found");
            drdEt.setText(drdSp);
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

        if (mrnEt.getText().toString().isEmpty()) {
            mrn = "N/A";
        } else {
            mrn = mrnEt.getText().toString().trim();
        }

        if (mrdEt.getText().toString().isEmpty()) {
            mrd = "N/A";
        } else {
            mrd = mrdEt.getText().toString().trim();
        }

        if (drnEt.getText().toString().isEmpty()) {
            drn = "N/A";
        } else {
            drn = drnEt.getText().toString().trim();
        }

        if (drdEt.getText().toString().isEmpty()) {
            drd = "N/A";
        } else {
            drd = drdEt.getText().toString().trim();
        }

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("PersonalStatusDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("mrn", mrn);
        editor.putString("mrd", mrd);
        editor.putString("drn", drn);
        editor.putString("drd", drd);
        editor.commit();

        Intent intent = new Intent(getApplicationContext(), IncomeDetailActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), MaritalStatusDetailActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}