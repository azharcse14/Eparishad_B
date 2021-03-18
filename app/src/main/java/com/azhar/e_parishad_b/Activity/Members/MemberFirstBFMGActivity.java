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
import android.widget.Toast;

import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberSideMenue.MSMAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

import java.util.Random;

public class MemberFirstBFMGActivity extends AppCompatActivity {

    EditText memberNameEt, bloodGroupEt, fathersNameEt, mothersNameEt;
    int n;
    String name, member_id, bloodGroup, fathersName, mothersName, gender;
    RadioGroup genderRg;
    RadioButton radioButton;
    String nameSp, bloodGroupSp, fathersNameSp, mothersNameSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_first_b_f_m_g);

        memberNameEt = findViewById(R.id.memberNameEt);
        bloodGroupEt = findViewById(R.id.bloodGroupEt);
        fathersNameEt = findViewById(R.id.fatherNameEtId);
        mothersNameEt = findViewById(R.id.motherNameEtId);
        genderRg = findViewById(R.id.genderRG);

        SharedPreferences sp = getSharedPreferences("BFMG", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (sp.contains("name")) {
            nameSp = sp.getString("name", "Data Not Found");

            memberNameEt.setText(nameSp);
        }

        if (sp.contains("fathersName")) {
            fathersNameSp = sp.getString("fathersName", "Data Not Found");

            fathersNameEt.setText(fathersNameSp);
        }
        if (sp.contains("mothersName")) {
            mothersNameSp = sp.getString("mothersName", "Data Not Found");

            mothersNameEt.setText(mothersNameSp);
        }
        if (sp.contains("bloodGroup")) {
            bloodGroupSp = sp.getString("bloodGroup", "Data Not Found");

            bloodGroupEt.setText(bloodGroupSp);
        }

        int i = sp.getInt("my_choice_key", -1);
        if (i >= 0) {
            ((RadioButton) ((RadioGroup) findViewById(R.id.genderRG)).getChildAt(i)).setChecked(true);
        }
        else {
            Toast.makeText(getApplicationContext(), "Empty", Toast.LENGTH_LONG).show();
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

        name = memberNameEt.getText().toString().trim();
        final int min = 101;
        final int max = 999;
        final int random = new Random().nextInt((max - min) + 1) + min;
        member_id = String.valueOf(random);

        if (fathersNameEt.getText().toString().isEmpty()) {
            fathersName = "N/A";
        } else {
            fathersName = fathersNameEt.getText().toString().trim();
        }

        if (mothersNameEt.getText().toString().isEmpty()) {
            mothersName = "N/A";
        } else {
            mothersName = mothersNameEt.getText().toString().trim();
        }

        if (bloodGroupEt.getText().toString().isEmpty()) {
            bloodGroup = "N/A";
        } else {
            bloodGroup = bloodGroupEt.getText().toString().trim();
        }

        try {
            int selectedId = genderRg.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            gender = radioButton.getText().toString();
        }catch (Exception e){

        }

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("BFMG", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name", name);
        editor.putString("member_id", member_id);
        editor.putString("fathersName", fathersName);
        editor.putString("mothersName", mothersName);
        editor.putString("bloodGroup", bloodGroup);
        editor.putString("gender", gender);
        editor.putInt("my_choice_key", genderRg.indexOfChild(findViewById(genderRg.getCheckedRadioButtonId())));
        editor.apply();
        editor.commit();

        if (memberNameEt.getText().toString().isEmpty()){
            memberNameEt.setError("Field is required!");
        }if (fathersNameEt.getText().toString().isEmpty()){
            fathersNameEt.setError("Field is required!");
        }if (mothersNameEt.getText().toString().isEmpty()){
            mothersNameEt.setError("Field is required!");
        }else {
            Intent intent = new Intent(getApplicationContext(), MemberRelationWithKhanaHeadActivity.class);
            startActivity(intent);
        }

    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), MemberNameActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}