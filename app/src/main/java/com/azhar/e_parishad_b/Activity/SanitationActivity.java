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
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.azhar.e_parishad_b.Activity.HeadActivity;
import com.azhar.e_parishad_b.Activity.HoldingAddActivity;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class SanitationActivity extends AppCompatActivity {

    CheckBox attachedToRoomCB, flashSafeCB, flashUnSafeCB, pitLatrineWithSlabCB, pitLatrineWithOutSlabCB, compotingLatrineCB, hangingLatrineCB, ecoToiletCB, otherCB;
    String attachedToRoom, flashSafe, flashUnSafe, pitLatrineWithSlab, pitLatrineWithOutSlab, compotingLatrine, hangingLatrine, ecoToilet, other;
    String attachedToRoomSP, flashSafeSP, flashUnSafeSP, pitLatrineWithSlabSP, pitLatrineWithOutSlabSP, compotingLatrineSP, hangingLatrineSP, ecoToiletSP, otherSP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanitation);

        attachedToRoomCB = findViewById(R.id.attachedToRoomCB);
        flashSafeCB = findViewById(R.id.flashSafeCB);
        flashUnSafeCB = findViewById(R.id.flashUnSafeCB);
        pitLatrineWithSlabCB = findViewById(R.id.pitLatrineWithSlabCB);
        pitLatrineWithOutSlabCB = findViewById(R.id.pitLatrineWithOutSlabCB);
        compotingLatrineCB = findViewById(R.id.compotingLatrineCB);
        hangingLatrineCB = findViewById(R.id.hangingLatrineCB);
        ecoToiletCB = findViewById(R.id.ecoToiletCB);
        otherCB = findViewById(R.id.otherCB);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("Sanitation", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("attachedToRoom")){
            attachedToRoomSP = sp.getString("attachedToRoom", "Data Not Found");
            if (attachedToRoomSP == "attachedToRoom"){
                attachedToRoomCB.setChecked(true);
            }
        }if (sp.contains("flashSafe")){
            flashSafeSP = sp.getString("flashSafe", "Data Not Found");
            if (flashSafeSP == "flashSafe"){
                flashSafeCB.setChecked(true);
            }
        }if (sp.contains("flashUnSafe")){
            flashUnSafeSP = sp.getString("flashUnSafe", "Data Not Found");
            if (flashUnSafeSP == "flashUnSafe"){
                flashUnSafeCB.setChecked(true);
            }
        }if (sp.contains("pitLatrineWithSlab")){
            pitLatrineWithSlabSP = sp.getString("pitLatrineWithSlab", "Data Not Found");
            if (pitLatrineWithSlabSP == "pitLatrineWithSlab"){
                pitLatrineWithSlabCB.setChecked(true);
            }
        }if (sp.contains("pitLatrineWithOutSlab")){
            pitLatrineWithOutSlabSP = sp.getString("pitLatrineWithOutSlab", "Data Not Found");
            if (pitLatrineWithOutSlabSP == "pitLatrineWithOutSlab"){
                pitLatrineWithOutSlabCB.setChecked(true);
            }
        }if (sp.contains("compotingLatrine")){
            compotingLatrineSP = sp.getString("compotingLatrine", "Data Not Found");
            if (compotingLatrineSP == "compotingLatrine"){
                compotingLatrineCB.setChecked(true);
            }
        }if (sp.contains("hangingLatrine")){
            hangingLatrineSP = sp.getString("hangingLatrine", "Data Not Found");
            if (hangingLatrineSP == "hangingLatrine"){
                hangingLatrineCB.setChecked(true);
            }
        }if (sp.contains("ecoToilet")){
            ecoToiletSP = sp.getString("ecoToilet", "Data Not Found");
            if (ecoToiletSP == "ecoToilet"){
                ecoToiletCB.setChecked(true);
            }
        }if (sp.contains("other")){
            otherSP = sp.getString("other", "Data Not Found");
            if (otherSP == "other"){
                otherCB.setChecked(true);
            }
        }
        else {
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

         StringBuilder stringBuilder = new StringBuilder();
        if (attachedToRoomCB.isChecked()){
            String value = attachedToRoomCB.getText().toString();
            stringBuilder.append(value+ ", ");
            attachedToRoom = "attachedToRoom";
        }
        if (flashSafeCB.isChecked()){
            String value = flashSafeCB.getText().toString();
            stringBuilder.append(value+ ", ");
            flashSafe = "flashSafe";
        }
        if (flashUnSafeCB.isChecked()){
            String value = flashUnSafeCB.getText().toString();
            stringBuilder.append(value+ ", ");
            flashUnSafe = "flashUnSafe";
        }
        if (pitLatrineWithSlabCB.isChecked()){
            String value = pitLatrineWithSlabCB.getText().toString();
            stringBuilder.append(value+ ", ");
            pitLatrineWithSlab = "pitLatrineWithSlab";
        }
        if (pitLatrineWithOutSlabCB.isChecked()){
            String value = pitLatrineWithOutSlabCB.getText().toString();
            stringBuilder.append(value+ ", ");
            pitLatrineWithOutSlab = "pitLatrineWithOutSlab";
        }

        if (compotingLatrineCB.isChecked()){
            String value = compotingLatrineCB.getText().toString();
            stringBuilder.append(value+ ", ");
            compotingLatrine = "compotingLatrine";
        }if (hangingLatrineCB.isChecked()){
            String value = hangingLatrineCB.getText().toString();
            stringBuilder.append(value+ ", ");
            hangingLatrine = "hangingLatrine";
        }if (ecoToiletCB.isChecked()){
            String value = ecoToiletCB.getText().toString();
            stringBuilder.append(value+ ", ");
            ecoToilet = "ecoToilet";
        }
        if (otherCB.isChecked()){
            String value = otherCB.getText().toString();
            stringBuilder.append(value+ "");
            other = "other";
        }

        String v = String.valueOf(stringBuilder);

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("Sanitation", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("SanitationV", v);
        editor.putString("attachedToRoom", attachedToRoom);
        editor.putString("flashSafe", flashSafe);
        editor.putString("flashUnSafe", flashUnSafe);
        editor.putString("pitLatrineWithSlab", pitLatrineWithSlab);
        editor.putString("pitLatrineWithOutSlab", pitLatrineWithOutSlab);
        editor.putString("compotingLatrine", compotingLatrine);
        editor.putString("hangingLatrine", hangingLatrine);
        editor.putString("ecoToilet", ecoToilet);
        editor.putString("other", other);
        editor.commit();

        Intent intent = new Intent(getApplicationContext(), ElectricityActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), WaterActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}