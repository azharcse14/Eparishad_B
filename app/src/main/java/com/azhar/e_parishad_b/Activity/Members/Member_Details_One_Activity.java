package com.azhar.e_parishad_b.Activity.Members;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.azhar.e_parishad_b.ImageProcessing.ImageDecoder;
import com.azhar.e_parishad_b.ImageProcessing.ImageEncoder;
import com.azhar.e_parishad_b.ImageProcessing.ImageResizer;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberSideMenue.MSMAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class Member_Details_One_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView csImagView;
    AutoCompleteTextView dayAcTv, monthAcTv, yearAcTv;
    EditText ageEt, featEt, inchEt, weightEt, bcIdEt, bpEt, brnIAEt;
    String age, feat, inch, weight, bcId, bp, brnIA;
    String ageSp, featSp, inchSp, weightSp, bcIdSp, bpSp, brnIASp;
    String [] day, month, year;
    String dayValue, monthValue, yearValue;
    String dayValueSp, monthValueSp, yearValueSp;
    Bitmap captureImage, reduceBitmap, bitmapSp;
    String basestring, basestringSp;
    ImageEncoder imageEncoder;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member__details__one_);

        recyclerView = findViewById(R.id.recyclerViewId);
        csImagView = findViewById(R.id.bdCaptureIvId);
        dayAcTv = findViewById(R.id.dayAcTv);
        monthAcTv = findViewById(R.id.monthAcTv);
        yearAcTv = findViewById(R.id.yearAcTv);
        ageEt = findViewById(R.id.ageEt);
        featEt = findViewById(R.id.featEt);
        inchEt = findViewById(R.id.inchEt);
        weightEt = findViewById(R.id.weightEt);
        bcIdEt = findViewById(R.id.bcEt);
        bpEt = findViewById(R.id.bpEt);
        brnIAEt = findViewById(R.id.brnIAEt);

        //================= SharedPreferences Data Retrive ==========

        SharedPreferences sp = getSharedPreferences("MDONE", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("dayValue")){
            dayValueSp = sp.getString("dayValue", "Data Not Found");
            dayAcTv.setText(dayValueSp);
        }
        if (sp.contains("monthValue")){
            monthValueSp = sp.getString("monthValue", "Data Not Found");
            monthAcTv.setText(monthValueSp);
        }
        if (sp.contains("yearValue")){
            yearValueSp = sp.getString("yearValue", "Data Not Found");
            yearAcTv.setText(yearValueSp);
        }if (sp.contains("age")){
            ageSp = sp.getString("age", "Data Not Found");
            ageEt.setText(ageSp);
        }if (sp.contains("feat")){
            featSp = sp.getString("feat", "Data Not Found");
            featEt.setText(featSp);
        }if (sp.contains("inch")){
            inchSp = sp.getString("inch", "Data Not Found");
            inchEt.setText(inchSp);
        }if (sp.contains("weight")){
            weightSp = sp.getString("weight", "Data Not Found");
            weightEt.setText(weightSp);
        }if (sp.contains("bcId")){
            bcIdSp = sp.getString("bcId", "Data Not Found");
            bcIdEt.setText(bcIdSp);
        }if (sp.contains("bp")){
            bpSp = sp.getString("bp", "Data Not Found");
            bpEt.setText(bpSp);
        }if (sp.contains("brnIA")){
            brnIASp = sp.getString("brnIA", "Data Not Found");
            brnIAEt.setText(brnIASp);
        }if (sp.contains("basestring")){
            basestringSp = sp.getString("basestring", "Data Not Found");
            ImageDecoder imageDecoder = new ImageDecoder();
            bitmapSp = imageDecoder.convert(basestringSp);
            csImagView.setImageBitmap(bitmapSp);
        }
        else {
            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }

        //================== Camera Permission ==================

        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Member_Details_One_Activity.this, new String[]{
                    Manifest.permission.CAMERA
            }, 100);
        }

        //================= RecyclerView =====================

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] msm = getResources().getStringArray(R.array.msm);
        MSMAdapter adapter = new MSMAdapter(this, msm);
        recyclerView.setAdapter(adapter);

        //======================= Spinner ===========================
        day = getResources().getStringArray(R.array.day);
        month = getResources().getStringArray(R.array.month);
        year = getResources().getStringArray(R.array.year);

        ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(this,R.layout.spinner_view, R.id.spinnerTvId, day);
        dayAcTv.setAdapter(dayAdapter);

        dayAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dayValue = parent.getItemAtPosition(position).toString();
            }
        });

        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(this,R.layout.spinner_view, R.id.spinnerTvId, month);
        monthAcTv.setAdapter(monthAdapter);

        monthAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                monthValue = parent.getItemAtPosition(position).toString();
            }
        });

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this,R.layout.spinner_view, R.id.spinnerTvId, year);
        yearAcTv.setAdapter(yearAdapter);

        yearAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                yearValue = parent.getItemAtPosition(position).toString();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void goToNextActivity(View view) {

        if (ageEt.getText().toString().isEmpty()) {
            age = "0";
        } else {
            age = ageEt.getText().toString().trim();
        }

        if (featEt.getText().toString().isEmpty()) {
            feat = "0";
        } else {
            feat = featEt.getText().toString().trim();
        }

        if (inchEt.getText().toString().isEmpty()) {
            inch = "0";
        } else {
            inch = inchEt.getText().toString().trim();
        }

        if (weightEt.getText().toString().isEmpty()) {
            weight = "0";
        } else {
            weight = weightEt.getText().toString().trim();
        }

        if (bcIdEt.getText().toString().isEmpty()) {
            bcId = "N/A";
        } else {
            bcId = bcIdEt.getText().toString().trim();
        }

        if (bpEt.getText().toString().isEmpty()) {
            bp = "N/A";
        } else {
            bp = bpEt.getText().toString().trim();
        }

        if (brnIAEt.getText().toString().isEmpty()) {
            brnIA = "N/A";
        } else {
            brnIA = brnIAEt.getText().toString().trim();
        }

        //================== Shared Preferences ====================

        sp = getSharedPreferences("MDONE", Context.MODE_PRIVATE);
        editor = sp.edit();
        editor.putString("dayValue", dayValue);
        editor.putString("monthValue", monthValue);
        editor.putString("yearValue", yearValue);
        editor.putString("age", age);
        editor.putString("feat", feat);
        editor.putString("inch", inch);
        editor.putString("weight", weight);
        editor.putString("bcId", bcId);
        editor.putString("basestring", basestring);
        editor.putString("bp", bp);
        editor.putString("brnIA", brnIA);
        editor.commit();


        Intent intent = new Intent(getApplicationContext(), MemberNationalityActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), MemberRelationWithKhanaHeadActivity.class);
        startActivity(intent);
    }

    public void captureImg(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 100);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            //Get Capture Image
            captureImage = (Bitmap) data.getExtras().get("data");
            //Set Capture Image to ImageView
            csImagView.setImageBitmap(captureImage);


            reduceBitmap = ImageResizer.reduceBitmapSize(captureImage, 24000);
//            imageTest.setImageBitmap(reduceBitmap);

            imageEncoder = new ImageEncoder();

            basestring= imageEncoder.convert(reduceBitmap);
//            testTv.setText(basestring);

        }
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}