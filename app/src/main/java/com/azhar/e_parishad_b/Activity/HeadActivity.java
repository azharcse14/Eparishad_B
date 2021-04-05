package com.azhar.e_parishad_b.Activity;

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

import com.azhar.e_parishad_b.Activity.Members.MembersActivity;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class HeadActivity extends AppCompatActivity {

    EditText khanaHeadEt, tPhoneEt;
    RadioGroup khanaTypeRG;
    RadioButton radioButton;
    String khanaHead, telephoneNo;
    String value;
    String khanaHeadSp, telephoneNoSp, radioGroupSp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        khanaHeadEt = findViewById(R.id.headNameEt);
        tPhoneEt = findViewById(R.id.khanaHeadTPEtId);
        khanaTypeRG = findViewById(R.id.khanaTypeRG);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("KhanaHead", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int i = sp.getInt("my_choice_key",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.khanaTypeRG)).getChildAt(i)).setChecked(true);
        }

        if (sp.contains("khanaHead")){
            khanaHeadSp = sp.getString("khanaHead", "Data Not Found");
            khanaHeadEt.setText(khanaHeadSp);
        }if (sp.contains("telephoneNo")){
            telephoneNoSp = sp.getString("telephoneNo", "Data Not Found");
            tPhoneEt.setText(telephoneNoSp);
        }else {
//            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }

        //================= RecyclerView =====================

        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] title = getResources().getStringArray(R.array.title);
        MyAdapter adapter = new MyAdapter(this, title);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void goToNextActivity(View view) {

        khanaHead = khanaHeadEt.getText().toString().trim();

        if (tPhoneEt.getText().toString().isEmpty()) {
            telephoneNo = "N/A";
        } else {
            telephoneNo = tPhoneEt.getText().toString().trim();
        }

        try {
            int selectedId = khanaTypeRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            value = radioButton.getText().toString();

        }catch (Exception e){
//            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }



        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("KhanaHead", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("khanaHead", khanaHead);
        editor.putString("telephoneNo", telephoneNo);
        editor.putString("radioGroup", value);

        editor.putInt("my_choice_key", khanaTypeRG.indexOfChild(findViewById(khanaTypeRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.commit();

        if (khanaHeadEt.getText().toString().isEmpty()){
            khanaHeadEt.setError("Field is required!");
        }
        else {
            Intent intent = new Intent(getApplicationContext(), MembersActivity.class);
            startActivity(intent);
        }
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), HoldingAddActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}