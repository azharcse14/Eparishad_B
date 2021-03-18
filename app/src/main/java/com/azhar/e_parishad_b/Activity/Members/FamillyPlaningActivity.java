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

import com.azhar.e_parishad_b.Activity.HeadActivity;
import com.azhar.e_parishad_b.Activity.HoldingAddActivity;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberSideMenue.MSMAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class FamillyPlaningActivity extends AppCompatActivity {

    RadioGroup isEligibleCoupleRG, familyPlanningRG;
    RadioButton radioButton;
    String valueEC, valueFP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familly_planing);

        isEligibleCoupleRG = findViewById(R.id.isEligibleCoupleRG);
        familyPlanningRG = findViewById(R.id.familyPlanningRG);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("FamillyPlaning", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int i = sp.getInt("ec_key",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.isEligibleCoupleRG)).getChildAt(i)).setChecked(true);
        }

        int j = sp.getInt("fp_key",-1);
        if( j >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.familyPlanningRG)).getChildAt(i)).setChecked(true);
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
            int selectedId = isEligibleCoupleRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            valueEC = radioButton.getText().toString();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }

        try {
            int selectedId = familyPlanningRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            valueFP = radioButton.getText().toString();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("FamillyPlaning", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("valueEC", valueEC);
        editor.putString("valueFP", valueFP);

        editor.putInt("ec_key", isEligibleCoupleRG.indexOfChild(findViewById(isEligibleCoupleRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.putInt("fp_key", familyPlanningRG.indexOfChild(findViewById(familyPlanningRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.commit();


        Intent intent = new Intent(getApplicationContext(), SocialSaftyNetActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), MotherHealthCareInformationActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}