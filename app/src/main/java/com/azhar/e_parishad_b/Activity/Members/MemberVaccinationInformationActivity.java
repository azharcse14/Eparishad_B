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

public class MemberVaccinationInformationActivity extends AppCompatActivity {

    CheckBox bcgFdCB, pentaSdCB, pentaTdCB, typhoidCB, pcvCB, opvCB, mrCB, rotavirusCB, measlesFdCB, chickenpoxCB, hepatitisACB, influenzaCB, covidCB;
    String bcgFdSp, pentaSdSp, pentaTdSp, typhoidSp, pcvSp, opvSp, mrSp, rotavirusSp, measlesFdSp, chickenpoxSp, hepatitisASp, influenzaSp, covidSp;
    String bcgFd, pentaSd, pentaTd, typhoid, pcv, opv, mr, rotavirus, measlesFd, chickenpox, hepatitisA, influenza, covid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_vaccination_information);
        //================= RecyclerView =====================

        bcgFdCB = findViewById(R.id.bcgFdCB);
        pentaSdCB = findViewById(R.id.pentaSdCB);
        pentaTdCB = findViewById(R.id.pentaTdCB);
        typhoidCB = findViewById(R.id.typhoidCB);
        pcvCB = findViewById(R.id.pcvCB);
        opvCB = findViewById(R.id.opvCB);
        mrCB = findViewById(R.id.mrCB);
        rotavirusCB = findViewById(R.id.rotavirusCB);
        measlesFdCB = findViewById(R.id.measlesFdCB);
        chickenpoxCB = findViewById(R.id.chickenpoxCB);
        hepatitisACB = findViewById(R.id.hepatitisACB);
        influenzaCB = findViewById(R.id.influenzaCB);
        covidCB = findViewById(R.id.covidCB);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("VaccinationInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("bcgFd")){
            bcgFdSp = sp.getString("bcgFd", "Data Not Found");
            if (bcgFdSp == "bcgFd"){
                bcgFdCB.setChecked(true);
            }
        }if (sp.contains("pentaSd")){
            pentaSdSp = sp.getString("pentaSd", "Data Not Found");
            if (pentaSdSp == "pentaSd"){
                pentaSdCB.setChecked(true);
            }
        }if (sp.contains("pentaTd")){
            pentaTdSp = sp.getString("pentaTd", "Data Not Found");
            if (pentaTdSp == "pentaTd"){
                pentaTdCB.setChecked(true);
            }
        }if (sp.contains("typhoid")){
            typhoidSp = sp.getString("typhoid", "Data Not Found");
            if (typhoidSp == "typhoid"){
                typhoidCB.setChecked(true);
            }
        }if (sp.contains("pcv")){
            pcvSp = sp.getString("pcv", "Data Not Found");
            if (pcvSp == "pcv"){
                pcvCB.setChecked(true);
            }
        }if (sp.contains("opv")){
            opvSp = sp.getString("opv", "Data Not Found");
            if (opvSp == "opv"){
                opvCB.setChecked(true);
            }
        }if (sp.contains("mr")){
            mrSp = sp.getString("mr", "Data Not Found");
            if (mrSp == "mr"){
                mrCB.setChecked(true);
            }
        }if (sp.contains("rotavirus")){
            rotavirusSp = sp.getString("rotavirus", "Data Not Found");
            if (rotavirusSp == "rotavirus"){
                rotavirusCB.setChecked(true);
            }
        }if (sp.contains("measlesFd")){
            measlesFdSp = sp.getString("measlesFd", "Data Not Found");
            if (measlesFdSp == "measlesFd"){
                measlesFdCB.setChecked(true);
            }
        }if (sp.contains("chickenpox")){
            chickenpoxSp = sp.getString("chickenpox", "Data Not Found");
            if (chickenpoxSp == "chickenpox"){
                chickenpoxCB.setChecked(true);
            }
        }if (sp.contains("hepatitisA")){
            hepatitisASp = sp.getString("hepatitisA", "Data Not Found");
            if (hepatitisASp == "hepatitisA"){
                hepatitisACB.setChecked(true);
            }
        }if (sp.contains("influenza")){
            influenzaSp = sp.getString("influenza", "Data Not Found");
            if (influenzaSp == "influenza"){
                influenzaCB.setChecked(true);
            }
        }if (sp.contains("covid")){
            covidSp = sp.getString("covid", "Data Not Found");
            if (covidSp == "covid"){
                covidCB.setChecked(true);
            }
        }
        else {
//            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }

        //============================= RecyclerView =======================
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
        if (bcgFdCB.isChecked()){
            String value = bcgFdCB.getText().toString();
            stringBuilder.append(value+ ", ");
            bcgFd = "bcgFd";
        }
        if (pentaSdCB.isChecked()){
            String value = pentaSdCB.getText().toString();
            stringBuilder.append(value+ ", ");
            pentaSd = "pentaSd";
        }
        if (pentaTdCB.isChecked()){
            String value = pentaTdCB.getText().toString();
            stringBuilder.append(value+ ", ");
            pentaTd = "pentaTd";
        }
        if (typhoidCB.isChecked()){
            String value = typhoidCB.getText().toString();
            stringBuilder.append(value+ ", ");
            typhoid = "typhoid";
        }
        if (pcvCB.isChecked()){
            String value = pcvCB.getText().toString();
            stringBuilder.append(value+ ", ");
            pcv = "pcv";
        }

        if (opvCB.isChecked()){
            String value = opvCB.getText().toString();
            stringBuilder.append(value+ ", ");
            opv = "opv";
        }

        if (mrCB.isChecked()){
            String value = mrCB.getText().toString();
            stringBuilder.append(value+ "");
            mr = "mr";
        }

        if (rotavirusCB.isChecked()){
            String value = rotavirusCB.getText().toString();
            stringBuilder.append(value+ "");
            rotavirus = "rotavirus";
        }

        if (measlesFdCB.isChecked()){
            String value = measlesFdCB.getText().toString();
            stringBuilder.append(value+ "");
            measlesFd = "measlesFd";
        }

        if (chickenpoxCB.isChecked()){
            String value = chickenpoxCB.getText().toString();
            stringBuilder.append(value+ "");
            chickenpox = "chickenpox";
        }

        if (hepatitisACB.isChecked()){
            String value = hepatitisACB.getText().toString();
            stringBuilder.append(value+ "");
            hepatitisA = "hepatitisA";
        }

        if (influenzaCB.isChecked()){
            String value = influenzaCB.getText().toString();
            stringBuilder.append(value+ "");
            influenza = "influenza";
        }

        if (covidCB.isChecked()){
            String value = covidCB.getText().toString();
            stringBuilder.append(value+ "");
            covid = "covid";
        }

        String v = String.valueOf(stringBuilder);

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("VaccinationInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("vaccine", v);
        editor.putString("bcgFd", bcgFd);
        editor.putString("pentaSd", pentaSd);
        editor.putString("pentaTd", pentaTd);
        editor.putString("typhoid", typhoid);
        editor.putString("pcv", pcv);
        editor.putString("opv", opv);
        editor.putString("mr", mr);
        editor.putString("rotavirus", rotavirus);
        editor.putString("measlesFd", measlesFd);
        editor.putString("chickenpox", chickenpox);
        editor.putString("hepatitisA", hepatitisA);
        editor.putString("influenza", influenza);
        editor.putString("covid", covid);
        editor.commit();



        Intent intent = new Intent(getApplicationContext(), DisabilityActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), MemberNationalityActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}