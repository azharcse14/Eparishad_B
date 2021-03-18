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

import java.util.Random;

public class MemberNameActivity extends AppCompatActivity {

    EditText editText;
    int n;
    String name, member_id;

    String isHead = "", bloodgroup = "B+", fathername = "x", mothername = "y",   disability = "",   socialsafetynet = "",   nearesthospital = "",   iseligiblecouple = "",   gender = "",   relationship = "",   bdaydate = "",   bdaymonth = "",   bdayyear = "",   age = "",   birthcertificateno = "",   birthcertificateimage = "",   nationality = "",   nid = "",   nidimage = "",   higheshtEducation = "",   educationinstitution = "",   socialsecuritycardimage = "",   tinimage = "",   passportimage = "",  dirivinglicenseimage = "",  primaryprofession = "",  secondaryprofession = "",  maritialstatus = "",  ismemberlivehere = "",  memberimage = "";
    //String isHead, bloodgroup, fathername, mothername,   disability,   socialsafetynet,   nearesthospital,   iseligiblecouple,   gender,   relationship,   bdaydate,   bdaymonth,   bdayyear,   age,   birthcertificateno,   birthcertificateimage,   nationality,   nid,   nidimage,   higheshtEducation,   educationinstitution,   socialsecuritycardimage,   tinimage,   passportimage,  dirivinglicenseimage,  primaryprofession,  secondaryprofession,  maritialstatus,  ismemberlivehere,  memberimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_name);


        editText = findViewById(R.id.memberNameEt);

        //================= RecyclerView =====================

        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] msm = getResources().getStringArray(R.array.msm);
        MSMAdapter adapter = new MSMAdapter(this, msm);
        recyclerView.setAdapter(adapter);

        //=========================== Random Number Generate =====================


    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void goToNextActivity(View view) {

        name = editText.getText().toString().trim();
        final int min = 101;
        final int max = 999;
        final int random = new Random().nextInt((max - min) + 1) + min;
        member_id = String.valueOf(random);

            //================== Shared Preferences ====================


        SharedPreferences sp = getSharedPreferences("MemberName", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name", name);
        editor.putString("member_id", member_id);
        editor.commit();

        if (editText.getText().toString().isEmpty()){
            editText.setError("Field is required!");
        }else {
            Intent intent = new Intent(getApplicationContext(), MemberFirstBFMGActivity.class);
            startActivity(intent);
        }

    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), MembersActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}