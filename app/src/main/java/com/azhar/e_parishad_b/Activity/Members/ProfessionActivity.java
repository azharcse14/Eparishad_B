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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberSideMenue.MSMAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class ProfessionActivity extends AppCompatActivity {

    EditText fooEt, sofEt, notEt;
    String primaryProfession, secondaryProfession, foo, sof, not;
    String primaryProfessionSp, secondaryProfessionSp, fooSp, sofSp, notSp;
    CheckBox unemployedCB;
    String unemployed;
    String unemployedSp;
    AutoCompleteTextView primaryProfessionAcTv, secondaryProfessionAcTv;
    String[] primaryPrfession;
    String[] secondaryPrfession;
    String primaryProfessionValue, secondaryProfessionValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profession);

        unemployedCB = findViewById(R.id.unemployedCB);
        primaryProfessionAcTv = findViewById(R.id.primaryProfessionAcTv);
        secondaryProfessionAcTv = findViewById(R.id.secondaryProfessionAcTv);
        fooEt = findViewById(R.id.fooEtId);
        sofEt = findViewById(R.id.sofEtId);
        notEt = findViewById(R.id.notEtId);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("Profession", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("primaryProfession")){
            primaryProfessionSp = sp.getString("primaryProfession", "Data Not Found");
            primaryProfessionAcTv.setText(primaryProfessionSp);
        }
        if (sp.contains("secondaryProfession")){
            secondaryProfessionSp = sp.getString("secondaryProfession", "Data Not Found");
            secondaryProfessionAcTv.setText(secondaryProfessionSp);
        }
        if (sp.contains("foo")){
            fooSp = sp.getString("foo", "Data Not Found");
            fooEt.setText(fooSp);
        }
        if (sp.contains("sof")){
            sofSp = sp.getString("sof", "Data Not Found");
            sofEt.setText(sofSp);
        }
        if (sp.contains("not")){
            notSp = sp.getString("not", "Data Not Found");
            notEt.setText(notSp);
        }
        if (sp.contains("unemployed")){
            unemployedSp = sp.getString("unemployed", "Data Not Found");
            if (unemployedSp == "Yes"){
                unemployedCB.setChecked(true);
            }
        }
        else {
            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }

        //======================= Spinner =============================

        primaryPrfession = getResources().getStringArray(R.array.occupation);
        secondaryPrfession = getResources().getStringArray(R.array.occupation);

        ArrayAdapter<String> wardAdapter = new ArrayAdapter<String>(this,R.layout.spinner_view, R.id.spinnerTvId, primaryPrfession);
        primaryProfessionAcTv.setAdapter(wardAdapter);

        primaryProfessionAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                primaryProfessionValue = parent.getItemAtPosition(position).toString();
            }
        });

        ArrayAdapter<String> villageAdapter = new ArrayAdapter<String>(this,R.layout.spinner_view, R.id.spinnerTvId, secondaryPrfession);
        secondaryProfessionAcTv.setAdapter(villageAdapter);

//        villageSpinner.setText(villageAdapter.getItem(0).toString(), false);

        secondaryProfessionAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                secondaryProfessionValue = parent.getItemAtPosition(position).toString();
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

        StringBuilder stringBuilder = new StringBuilder();

        if (unemployedCB.isChecked()){
            String value = unemployedCB.getText().toString();
            stringBuilder.append(value);
            unemployed = "Yes";
        }else {
            unemployed = "No";
        }

        String v = String.valueOf(stringBuilder);

        if (fooEt.getText().toString().isEmpty()) {
            foo = "0";
        } else {
            foo = fooEt.getText().toString().trim();
        }

        if (sofEt.getText().toString().isEmpty()) {
            sof = "0";
        } else {
            sof = sofEt.getText().toString().trim();
        }

        if (notEt.getText().toString().isEmpty()) {
            not = "0";
        } else {
            not = notEt.getText().toString().trim();
        }

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("Profession", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("unemployedV", v);
        editor.putString("unemployed", unemployed);
        editor.putString("primaryProfession", primaryProfessionValue);
        editor.putString("secondaryProfession", secondaryProfessionValue);
        editor.putString("foo", foo);
        editor.putString("sof", sof);
        editor.putString("not", not);
        editor.commit();

        Intent intent = new Intent(getApplicationContext(), MaritalStatusDetailActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), TrainingActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}