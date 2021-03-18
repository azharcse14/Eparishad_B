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

public class ReligionActivity extends AppCompatActivity {

    RadioGroup religionRG;
    RadioButton radioButton;
    EditText ethnicityEt;
    String value, ethnicity, ethnicitySp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_religion);

        religionRG = findViewById(R.id.religionRG);
        ethnicityEt = findViewById(R.id.ethnicityEt);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("Religion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int i = sp.getInt("my_choice_key",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.religionRG)).getChildAt(i)).setChecked(true);
        }

        if (sp.contains("ethnicity")){
            ethnicitySp = sp.getString("ethnicity", "Data Not Found");
            ethnicityEt.setText(ethnicitySp);
        }else {
            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }


        //==================== Side bar RecyclerView ================================
        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String [] title = getResources().getStringArray(R.array.title);
        MyAdapter adapter = new MyAdapter(this, title);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void goToNextActivity(View view) {

        if (ethnicityEt.getText().toString().isEmpty()) {
            ethnicity = "N/A";
        } else {
            ethnicity = ethnicityEt.getText().toString().trim();
        }

        try {
            int selectedId = religionRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            value = radioButton.getText().toString();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }



        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("Religion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("ethnicity", ethnicity);
        editor.putString("radioGroup", value);

        editor.putInt("my_choice_key", religionRG.indexOfChild(findViewById(religionRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.commit();




        Intent intent = new Intent(getApplicationContext(), LandActivity.class);
        startActivity(intent);
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