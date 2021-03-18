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
import android.widget.CheckBox;
import android.widget.Toast;

import com.azhar.e_parishad_b.Activity.HeadActivity;
import com.azhar.e_parishad_b.Activity.HoldingAddActivity;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberSideMenue.MSMAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class DisabilityActivity extends AppCompatActivity {

    CheckBox blindCB, deafCB, dumbCB, chronicDiseaseCB, specialChildCB, physicallyChallengedCB, autismCB, accidentCB, otherCB;
    String blindSp, deafSp, dumbSp, chronicDiseasep, specialChildSp, physicallyChallengedSP, autismSP, accidentSP, otherSP;
    String blind, deaf, dumb, chronicDisease, specialChild, physicallyChallenged, autism, accident, other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disability);

        blindCB = findViewById(R.id.blindCB);
        deafCB = findViewById(R.id.deafCB);
        dumbCB = findViewById(R.id.dumbCB);
        chronicDiseaseCB = findViewById(R.id.chronicDiseaseCB);
        specialChildCB = findViewById(R.id.specialChildCB);
        physicallyChallengedCB = findViewById(R.id.physicallyChallengedCB);
        autismCB = findViewById(R.id.autismCB);
        accidentCB = findViewById(R.id.accidentCB);
        otherCB = findViewById(R.id.otherCB);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("Disability", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("blind")){
            blindSp = sp.getString("blind", "Data Not Found");
            if (blindSp == "blind"){
                blindCB.setChecked(true);
            }
        }if (sp.contains("deaf")){
            deafSp = sp.getString("deaf", "Data Not Found");
            if (deafSp == "deaf"){
                deafCB.setChecked(true);
            }
        }if (sp.contains("dumb")){
            dumbSp = sp.getString("dumb", "Data Not Found");
            if (dumbSp == "dumb"){
                dumbCB.setChecked(true);
            }
        }if (sp.contains("chronicDisease")){
            chronicDiseasep = sp.getString("chronicDisease", "Data Not Found");
            if (chronicDiseasep == "chronicDisease"){
                chronicDiseaseCB.setChecked(true);
            }
        }if (sp.contains("specialChild")){
            specialChildSp = sp.getString("specialChild", "Data Not Found");
            if (specialChildSp == "specialChild"){
                specialChildCB.setChecked(true);
            }
        }if (sp.contains("physicallyChallenged")){
            physicallyChallengedSP = sp.getString("physicallyChallenged", "Data Not Found");
            if (physicallyChallengedSP == "physicallyChallenged"){
                physicallyChallengedCB.setChecked(true);
            }
        }if (sp.contains("autism")){
            autismSP = sp.getString("autism", "Data Not Found");
            if (autismSP == "autism"){
                autismCB.setChecked(true);
            }
        }if (sp.contains("accident")){
            accidentSP = sp.getString("accident", "Data Not Found");
            if (accidentSP == "accident"){
                accidentCB.setChecked(true);
            }
        }if (sp.contains("other")){
            otherSP = sp.getString("other", "Data Not Found");
            if (otherSP == "other"){
                otherCB.setChecked(true);
            }
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

        StringBuilder stringBuilder = new StringBuilder();
        if (blindCB.isChecked()){
            String value = blindCB.getText().toString();
            stringBuilder.append(value+ ", ");
            blind = "blind";
        }
        if (deafCB.isChecked()){
            String value = deafCB.getText().toString();
            stringBuilder.append(value+ ", ");
            deaf = "deaf";
        }
        if (dumbCB.isChecked()){
            String value = dumbCB.getText().toString();
            stringBuilder.append(value+ ", ");
            dumb = "dumb";
        }
        if (chronicDiseaseCB.isChecked()){
            String value = chronicDiseaseCB.getText().toString();
            stringBuilder.append(value+ ", ");
            chronicDisease = "chronicDisease";
        }
        if (specialChildCB.isChecked()){
            String value = specialChildCB.getText().toString();
            stringBuilder.append(value+ ", ");
            specialChild = "specialChild";
        }

        if (physicallyChallengedCB.isChecked()){
            String value = physicallyChallengedCB.getText().toString();
            stringBuilder.append(value+ ", ");
            physicallyChallenged = "physicallyChallenged";
        }

        if (autismCB.isChecked()){
            String value = autismCB.getText().toString();
            stringBuilder.append(value+ "");
            autism = "autism";
        }if (otherCB.isChecked()){
            String value = otherCB.getText().toString();
            stringBuilder.append(value+ "");
            other = "other";
        }if (accidentCB.isChecked()){
            String value = accidentCB.getText().toString();
            stringBuilder.append(value+ "");
            accident = "accident";
        }

        String v = String.valueOf(stringBuilder);

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("Disability", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("disability", v);
        editor.putString("blind", blind);
        editor.putString("deaf", deaf);
        editor.putString("dumb", dumb);
        editor.putString("chronicDisease", chronicDisease);
        editor.putString("specialChild", specialChild);
        editor.putString("physicallyChallenged", physicallyChallenged);
        editor.putString("autism", autism);
        editor.putString("accident", accident);
        editor.putString("other", other);
        editor.commit();





        Intent intent = new Intent(getApplicationContext(), MotherHealthCareInformationActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), MemberVaccinationInformationActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}