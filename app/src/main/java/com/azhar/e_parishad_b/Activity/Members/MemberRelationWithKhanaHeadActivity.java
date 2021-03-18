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

public class MemberRelationWithKhanaHeadActivity extends AppCompatActivity {

    RadioGroup relationRg;
    RadioButton radioButton;
    String relation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_relation_with_khana_head);

        relationRg = findViewById(R.id.relationRg);

        SharedPreferences sp = getSharedPreferences("MRelationWithKh", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int i = sp.getInt("my_choice_key",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.relationRg)).getChildAt(i)).setChecked(true);
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
            int selectedId = relationRg.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            relation = radioButton.getText().toString();

        }catch (Exception e){
//            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("MRelationWithKh", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("relation", relation);

        editor.putInt("my_choice_key", relationRg.indexOfChild(findViewById(relationRg.getCheckedRadioButtonId())));
        editor.apply();

        editor.commit();



        Intent intent = new Intent(getApplicationContext(), Member_Details_One_Activity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), MemberFirstBFMGActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}