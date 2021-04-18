package com.azhar.e_parishad_b.Activity.Members;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
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

import com.azhar.e_parishad_b.Database.DataPackager.MemberDataPackager;
import com.azhar.e_parishad_b.Database.Entity.Member.MNEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.Database.SQLiteHelper;
import com.azhar.e_parishad_b.Networking.DataPackager;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberSideMenue.MSMAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MemberFirstBFMGActivity extends AppCompatActivity {

    int n;
    AutoCompleteTextView memberNameAcTv, fatherNameAcTv, motherNameAcTv;
    EditText bloodGroupEt;
    String name, member_id, bloodGroup, fathersName, mothersName, gender;
    RadioGroup genderRg;
    RadioButton radioButton;
    String nameSp, bloodGroupSp, fathersNameSp, mothersNameSp;

    ArrayList<String> names;

    ArrayList<MNEntity> mnEntityArrayList;

    ArrayAdapter<String> memberNameAdapter, fatherNameAdapter, motherNameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_first_b_f_m_g);

        memberNameAcTv = findViewById(R.id.memberNameAcTvId);
        fatherNameAcTv = findViewById(R.id.fatherNameAcTvId);
        motherNameAcTv = findViewById(R.id.motherNameAcTvId);

        bloodGroupEt = findViewById(R.id.bloodGroupEt);
        genderRg = findViewById(R.id.genderRG);


        //================================== Data Retrieve from table ============================================================
        SharedPreferences HoldingAdd = getSharedPreferences("HoldingAdd", Context.MODE_PRIVATE);
        String kinnumber = "";
        if (HoldingAdd.contains("kinNo")) {
            kinnumber = HoldingAdd.getString("kinNo", "Data Not Found");
        }

        SQLiteHelper sqLiteHelper = new SQLiteHelper(getApplicationContext());

        names = sqLiteHelper.memberName(kinnumber);

        //=================================================================================================

        memberNameAdapter = new ArrayAdapter<>(MemberFirstBFMGActivity.this, android.R.layout.simple_dropdown_item_1line, names);
        memberNameAcTv.setThreshold(1);
        memberNameAcTv.setAdapter(memberNameAdapter);

        memberNameAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                name = memberNameAdapter.getItem(position);
            }
        });


        fatherNameAdapter = new ArrayAdapter<>(MemberFirstBFMGActivity.this, android.R.layout.simple_dropdown_item_1line, names);
        fatherNameAcTv.setThreshold(1);
        fatherNameAcTv.setAdapter(fatherNameAdapter);

        fatherNameAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fathersName = fatherNameAdapter.getItem(position);
            }
        });

        motherNameAdapter = new ArrayAdapter<>(MemberFirstBFMGActivity.this, android.R.layout.simple_dropdown_item_1line, names);
        motherNameAcTv.setThreshold(1);
        motherNameAcTv.setAdapter(motherNameAdapter);

        motherNameAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mothersName = motherNameAdapter.getItem(position);
            }
        });

        //===========================================================================================


        SharedPreferences sp = getSharedPreferences("BFMG", Context.MODE_PRIVATE);

        if (sp.contains("name")) {
            nameSp = sp.getString("name", "Data Not Found");

            memberNameAcTv.setText(nameSp);
        }

        if (sp.contains("fathersName")) {
            fathersNameSp = sp.getString("fathersName", "Data Not Found");

            fatherNameAcTv.setText(fathersNameSp);
        }
        if (sp.contains("mothersName")) {
            mothersNameSp = sp.getString("mothersName", "Data Not Found");

            motherNameAcTv.setText(mothersNameSp);
        }
        if (sp.contains("bloodGroup")) {
            bloodGroupSp = sp.getString("bloodGroup", "Data Not Found");

            bloodGroupEt.setText(bloodGroupSp);
        }

        int i = sp.getInt("my_choice_key", -1);
        if (i >= 0) {
            ((RadioButton) ((RadioGroup) findViewById(R.id.genderRG)).getChildAt(i)).setChecked(true);
        } else {
//            Toast.makeText(getApplicationContext(), "Empty", Toast.LENGTH_LONG).show();
        }

        //================= RecyclerView =====================
        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] msm = getResources().getStringArray(R.array.msm);
        MSMAdapter adapter = new MSMAdapter(this, msm);
        recyclerView.setAdapter(adapter);

        //======================================================

//        new LoadDataTask().execute();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void goToNextActivity(View view) {

        name = memberNameAcTv.getText().toString().trim();
        fathersName = fatherNameAcTv.getText().toString().trim();
        mothersName = motherNameAcTv.getText().toString().trim();

        final int min = 101;
        final int max = 999;
        final int random = new Random().nextInt((max - min) + 1) + min;
        member_id = String.valueOf(random);

        if (bloodGroupEt.getText().toString().isEmpty()) {
            bloodGroup = "N/A";
        } else {
            bloodGroup = bloodGroupEt.getText().toString().trim();
        }

        try {
            int selectedId = genderRg.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            gender = radioButton.getText().toString();
        } catch (Exception e) {

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

        if (memberNameAcTv.getText().toString().isEmpty()) {
            memberNameAcTv.setError("Field is required!");
        }
        if (fatherNameAcTv.getText().toString().isEmpty()) {
            fatherNameAcTv.setError("Field is required!");
        }
        if (motherNameAcTv.getText().toString().isEmpty()) {
            motherNameAcTv.setError("Field is required!");
        } else {
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

    //================================== AsyncTask Data Retrieve from table ============================================================

    class LoadDataTask extends AsyncTask<Void, Void, Void> {

        Repository repository;
        List<MNEntity> mnEntityList;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            repository = new Repository(getApplicationContext());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mnEntityList = repository.getMembers();
            mnEntityArrayList = new ArrayList<>();

            mnEntityArrayList.addAll(mnEntityList);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

//            dataPackager.setMnEntityArrayList(mnEntityArrayList);

        }
    }

    //======================================================================================================================
}