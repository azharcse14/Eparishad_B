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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberSideMenue.MSMAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class EducationDetailsActivity extends AppCompatActivity {

    RadioGroup studyNowRG;
    RadioButton radioButton;
    AutoCompleteTextView eduLevelACT;
    EditText educationalInstitutionEt, educationFinishingEt;
    String studyNowRGvalue, educationLevelValue, educationalInstitution, educationFinishing;
    String educationLevelValueSp, educationalInstitutionSp, educationFinishingSp;
    String[] education;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_details);

        studyNowRG = findViewById(R.id.studyNowRG);
        eduLevelACT = findViewById(R.id.eduLevelACTId);
        educationalInstitutionEt = findViewById(R.id.educationalInstitutionEtId);
        educationFinishingEt = findViewById(R.id.educationFinishingEtId);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("EducationDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int i = sp.getInt("my_choice_key",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.studyNowRG)).getChildAt(i)).setChecked(true);
        }

        if (sp.contains("educationLevelValue")){
            educationLevelValueSp = sp.getString("educationLevelValue", "Data Not Found");
            eduLevelACT.setText(educationLevelValueSp);
        }if (sp.contains("educationalInstitution")){
            educationalInstitutionSp = sp.getString("educationalInstitution", "Data Not Found");
            educationalInstitutionEt.setText(educationalInstitutionSp);
        }if (sp.contains("educationFinishing")){
            educationFinishingSp = sp.getString("educationFinishing", "Data Not Found");
            educationFinishingEt.setText(educationFinishingSp);
        }else {
            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }

        //======================= Spinner =============================

        education = getResources().getStringArray(R.array.education);

        ArrayAdapter<String> educationAdapter = new ArrayAdapter<String>(this,R.layout.spinner_view, R.id.spinnerTvId, education);
        eduLevelACT.setAdapter(educationAdapter);

        eduLevelACT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                educationLevelValue = parent.getItemAtPosition(position).toString();
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
            int selectedId = studyNowRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            studyNowRGvalue = radioButton.getText().toString();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }

        if (educationalInstitutionEt.getText().toString().isEmpty()) {
            educationalInstitution = "N/A";
        } else {
            educationalInstitution = educationalInstitutionEt.getText().toString().trim();
        }

        if (educationFinishingEt.getText().toString().isEmpty()) {
            educationFinishing = "N/A";
        } else {
            educationFinishing = educationFinishingEt.getText().toString().trim();
        }

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("EducationDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("studyNowRGvalue", studyNowRGvalue);
        editor.putString("educationLevelValue", educationLevelValue);
        editor.putString("educationalInstitution", educationalInstitution);
        editor.putString("educationFinishing", educationFinishing);

        editor.putInt("my_choice_key", studyNowRG.indexOfChild(findViewById(studyNowRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.commit();


        Intent intent = new Intent(getApplicationContext(), TrainingActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), EducationActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}