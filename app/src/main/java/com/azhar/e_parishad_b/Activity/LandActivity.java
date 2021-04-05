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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class LandActivity extends AppCompatActivity {

    TextView ownLandTv, notOwnLandTv;
    String ownLandSp, notOwnLandSp;
    EditText livingLandOlEt, farmingLandOlEt, leasedGivenEt, pondOlEt, gardenOlEt, hillOlEt, otherLandOlEt;
    String livingLandOlSp, farmingLandOlSp, leasedGivenSp, pondOlSp, gardenOlSp, hillOlSp, otherLandOlSp;
    String livingLandOlAdd, farmingLandOlAdd, leasedGivenAdd, pondOlAdd, gardenOlAdd, hillOlAdd, otherLandOlAdd, totalOwnLand;
    EditText livingLandNOlEt, farmingLandNOlEt, leasedTakenEt, pondNOlEt, gardenNOlEt, hillNOlEt, otherLandNOlEt;
    String livingLandNOl, farmingLandNOl, leasedTaken, pondNOl, gardenNOl, hillNOl, otherLandNOl, totalOtherLand;
    String livingLandNOlSp, farmingLandNOlSp, leasedTakenSp, pondNOlSp, gardenNOlSp, hillNOlSp, otherLandNOlSp, totalOtherLandSp;
    CheckBox landhasnotbeendividedyetCB;
    String landhasnotbeendividedyet, landhasnotbeendividedyetSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land);

        //======================== OL =====================
        ownLandTv = findViewById(R.id.ownLandTv);
        livingLandOlEt = findViewById(R.id.livingLandOlEt);
        farmingLandOlEt = findViewById(R.id.farmingLandOlEt);
        leasedGivenEt = findViewById(R.id.leasedGivenEt);
        pondOlEt = findViewById(R.id.pondOlEt);
        gardenOlEt = findViewById(R.id.gardenOlEt);
        hillOlEt = findViewById(R.id.hillOlEt);
        otherLandOlEt = findViewById(R.id.otherLandOlEt);

        //======================= NOL==============================
        notOwnLandTv = findViewById(R.id.notOwnLandTv);
        livingLandNOlEt = findViewById(R.id.livingLandNolEt);
        farmingLandNOlEt = findViewById(R.id.farmingLandNolEt);
        leasedTakenEt = findViewById(R.id.leasedTakenEt);
        pondNOlEt = findViewById(R.id.pondNolEt);
        gardenNOlEt = findViewById(R.id.gardenNolEt);
        hillNOlEt = findViewById(R.id.hillNolEt);
        otherLandNOlEt = findViewById(R.id.otherLandNolEt);


        landhasnotbeendividedyetCB = findViewById(R.id.landhasnotbeendividedyetCB);

        //================= Shared Preferences value retrive =========================

        SharedPreferences spOtherLand = getSharedPreferences("OtherLand", Context.MODE_PRIVATE);

        if (spOtherLand.contains("totalOtherLand")){
            notOwnLandSp = spOtherLand.getString("totalOtherLand", "Data Not Found");
            notOwnLandTv.setText(notOwnLandSp);
        }if (spOtherLand.contains("livingLandNOl")){
            livingLandNOlSp = spOtherLand.getString("livingLandNOl", "Data Not Found");
            livingLandNOlEt.setText(livingLandNOlSp);
        }if (spOtherLand.contains("farmingLandNOl")){
            farmingLandNOlSp = spOtherLand.getString("farmingLandNOl", "Data Not Found");
            farmingLandNOlEt.setText(farmingLandNOlSp);
        }if (spOtherLand.contains("leasedTaken")){
            leasedTakenSp = spOtherLand.getString("leasedTaken", "Data Not Found");
            leasedTakenEt.setText(leasedTakenSp);
        }if (spOtherLand.contains("pondNOl")){
            pondNOlSp = spOtherLand.getString("pondNOl", "Data Not Found");
            pondNOlEt.setText(pondNOlSp);
        }if (spOtherLand.contains("gardenNOl")){
            gardenNOlSp = spOtherLand.getString("gardenNOl", "Data Not Found");
            gardenNOlEt.setText(gardenNOlSp);
        }if (spOtherLand.contains("hillNOl")){
            hillNOlSp = spOtherLand.getString("hillNOl", "Data Not Found");
            hillNOlEt.setText(hillNOlSp);
        }if (spOtherLand.contains("otherLandNOl")){
            otherLandNOlSp = spOtherLand.getString("otherLandNOl", "Data Not Found");
            otherLandNOlEt.setText(otherLandNOlSp);
        }else {
//            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }

        SharedPreferences sp = getSharedPreferences("OwnLand", Context.MODE_PRIVATE);

        if (sp.contains("totalOwnLand")){
            ownLandSp = sp.getString("totalOwnLand", "Data Not Found");
            ownLandTv.setText(ownLandSp);
        }if (sp.contains("livingLandOlAdd")){
            livingLandOlSp = sp.getString("livingLandOlAdd", "Data Not Found");
            livingLandOlEt.setText(livingLandOlSp);
        }if (sp.contains("farmingLandOlAdd")){
            farmingLandOlSp = sp.getString("farmingLandOlAdd", "Data Not Found");
            farmingLandOlEt.setText(farmingLandOlSp);
        }if (sp.contains("leasedGivenAdd")){
            leasedGivenSp = sp.getString("leasedGivenAdd", "Data Not Found");
            leasedGivenEt.setText(leasedGivenSp);
        }if (sp.contains("pondOlAdd")){
            pondOlSp = sp.getString("pondOlAdd", "Data Not Found");
            pondOlEt.setText(pondOlSp);
        }if (sp.contains("gardenOlAdd")){
            gardenOlSp = sp.getString("gardenOlAdd", "Data Not Found");
            gardenOlEt.setText(gardenOlSp);
        }if (sp.contains("hillOlAdd")){
            hillOlSp = sp.getString("hillOlAdd", "Data Not Found");
            hillOlEt.setText(hillOlSp);
        }if (sp.contains("otherLandOlAdd")){
            otherLandOlSp = sp.getString("otherLandOlAdd", "Data Not Found");
            otherLandOlEt.setText(otherLandOlSp);
        }else {
//            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }


        SharedPreferences spLand = getSharedPreferences("Land", Context.MODE_PRIVATE);

        if (spLand.contains("landhasnotbeendividedyet")) {
            landhasnotbeendividedyetSp = spLand.getString("landhasnotbeendividedyet", "Data Not Found");
            if (landhasnotbeendividedyetSp == "Yes") {
                landhasnotbeendividedyetCB.setChecked(true);
            }
        } else {
//            Toast.makeText(getApplicationContext(), "Empty", Toast.LENGTH_LONG).show();
        }


        //=================== RecyclerView ==========================

        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] title = getResources().getStringArray(R.array.title);
        MyAdapter adapter = new MyAdapter(this, title);
        recyclerView.setAdapter(adapter);
        //====================================================================
    }


    //==================================== onBackPressed =============================

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void goToNextActivity(View view) {

        StringBuilder stringBuilder = new StringBuilder();

        if (landhasnotbeendividedyetCB.isChecked()) {
            String value = landhasnotbeendividedyetCB.getText().toString();
            stringBuilder.append(value + ", ");
            landhasnotbeendividedyet = "Yes";
        }else {
            landhasnotbeendividedyet = "No";
        }
        String v = String.valueOf(stringBuilder);

        SharedPreferences spLand = getSharedPreferences("Land", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spLand.edit();
        editor.putString("landhasnotbeendividedyet", landhasnotbeendividedyet);
        editor.putString("landhasnotbeendividedyetCB", v);

        editor.commit();

        Intent intent = new Intent(getApplicationContext(), HouseTypeActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), ReligionActivity.class);
        startActivity(intent);
    }

    public void totalOwnLand(View view) {

        if (livingLandOlEt.getText().toString().isEmpty()) {
            livingLandOlAdd = "0";
        } else {
            livingLandOlAdd = livingLandOlEt.getText().toString().trim();
        }

        if (farmingLandOlEt.getText().toString().isEmpty()) {
            farmingLandOlAdd = "0";
        } else {
            farmingLandOlAdd = farmingLandOlEt.getText().toString().trim();
        }

        if (leasedGivenEt.getText().toString().isEmpty()) {
            leasedGivenAdd = "0";
        } else {
            leasedGivenAdd = leasedGivenEt.getText().toString().trim();
        }

        if (pondOlEt.getText().toString().isEmpty()) {
            pondOlAdd = "0";
        } else {
            pondOlAdd = pondOlEt.getText().toString().trim();
        }

        if (gardenOlEt.getText().toString().isEmpty()) {
            gardenOlAdd = "0";
        } else {
            gardenOlAdd = gardenOlEt.getText().toString().trim();
        }

        if (hillOlEt.getText().toString().isEmpty()) {
            hillOlAdd = "0";
        } else {
            hillOlAdd = hillOlEt.getText().toString().trim();
        }

        if (otherLandOlEt.getText().toString().isEmpty()) {
            otherLandOlAdd = "0";
        } else {
            otherLandOlAdd = otherLandOlEt.getText().toString().trim();
        }

        int sum = Integer.parseInt(livingLandOlAdd)
                + Integer.parseInt(farmingLandOlAdd)
                + Integer.parseInt(leasedGivenAdd)
                + Integer.parseInt(pondOlAdd)
                + Integer.parseInt(gardenOlAdd)
                + Integer.parseInt(hillOlAdd)
                + Integer.parseInt(otherLandOlAdd);

        System.out.println(sum);
        totalOwnLand = String.valueOf(sum);
        ownLandTv.setText(totalOwnLand);

        SharedPreferences sp = getSharedPreferences("OwnLand", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("livingLandOlAdd", livingLandOlAdd);
        editor.putString("farmingLandOlAdd", farmingLandOlAdd);
        editor.putString("leasedGivenAdd", leasedGivenAdd);
        editor.putString("pondOlAdd", pondOlAdd);
        editor.putString("gardenOlAdd", gardenOlAdd);
        editor.putString("hillOlAdd", hillOlAdd);
        editor.putString("otherLandOlAdd", otherLandOlAdd);
        editor.putString("totalOwnLand", totalOwnLand);
        editor.commit();

    }

    public void totalOtherLand(View view) {

        if (livingLandNOlEt.getText().toString().isEmpty()) {
            livingLandNOl = "0";
        } else {
            livingLandNOl = livingLandNOlEt.getText().toString().trim();
        }

        if (farmingLandNOlEt.getText().toString().isEmpty()) {
            farmingLandNOl = "0";
        } else {
            farmingLandNOl = farmingLandNOlEt.getText().toString().trim();
        }

        if (leasedTakenEt.getText().toString().isEmpty()) {
            leasedTaken = "0";
        } else {
            leasedTaken = leasedTakenEt.getText().toString().trim();
        }

        if (pondNOlEt.getText().toString().isEmpty()) {
            pondNOl = "0";
        } else {
            pondNOl = pondNOlEt.getText().toString().trim();
        }

        if (gardenNOlEt.getText().toString().isEmpty()) {
            gardenNOl = "0";
        } else {
            gardenNOl = gardenNOlEt.getText().toString().trim();
        }

        if (hillNOlEt.getText().toString().isEmpty()) {
            hillNOl = "0";
        } else {
            hillNOl = hillNOlEt.getText().toString().trim();
        }

        if (otherLandNOlEt.getText().toString().isEmpty()) {
            otherLandNOl = "0";
        } else {
            otherLandNOl = otherLandNOlEt.getText().toString().trim();
        }

        int sum = Integer.parseInt(livingLandNOl)
                + Integer.parseInt(farmingLandNOl)
                + Integer.parseInt(leasedTaken)
                + Integer.parseInt(pondNOl)
                + Integer.parseInt(gardenNOl)
                + Integer.parseInt(hillNOl)
                + Integer.parseInt(otherLandNOl);

        System.out.println(sum);
        totalOtherLand = String.valueOf(sum);
        notOwnLandTv.setText(totalOtherLand);

        SharedPreferences spOtherLand = getSharedPreferences("OtherLand", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spOtherLand.edit();
        editor.putString("livingLandNOl", livingLandNOl);
        editor.putString("farmingLandNOl", farmingLandNOl);
        editor.putString("leasedTaken", leasedTaken);
        editor.putString("pondNOl", pondNOl);
        editor.putString("gardenNOl", gardenNOl);
        editor.putString("hillNOl", hillNOl);
        editor.putString("otherLandNOl", otherLandNOl);
        editor.putString("totalOtherLand", totalOtherLand);
        editor.commit();

    }


    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


}