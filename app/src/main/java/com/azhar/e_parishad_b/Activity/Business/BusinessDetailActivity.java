package com.azhar.e_parishad_b.Activity.Business;

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

import com.azhar.e_parishad_b.Activity.ElectricityActivity;
import com.azhar.e_parishad_b.ImageProcessing.ImageDecoder;
import com.azhar.e_parishad_b.ImageProcessing.ImageEncoder;
import com.azhar.e_parishad_b.ImageProcessing.ImageResizer;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.BusinessSideMenue.BusinessSmAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class BusinessDetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    EditText typeOfBusinessET, businessNameEt, sourceOfIncomeEt, tradeLicenceNumberEt, businessAddressEt;
    String typeOfBusiness, businessName, sourceOfIncome, tradeLicenceNumber, businessAddress;
    String typeOfBusinessSp, businessNameSp, sourceOfIncomeSp, tradeLicenceNumberSp, businessAddressSp;
    AutoCompleteTextView dayAcTv, monthAcTv, yearAcTv;
    String [] day;
    String[] month;
    String[] year;
    String dayValue, monthValue, yearValue;
    String dayValueSp, monthValueSp, yearValueSp;
    ImageView csImagView;
    Bitmap captureImage, reduceBitmap, bitmapSp;
    String basestring, basestringSp;
    ImageEncoder imageEncoder;
    ImageDecoder imageDecoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        recyclerView = findViewById(R.id.recyclerViewId);
        typeOfBusinessET = findViewById(R.id.typeOfBusinessET);
        businessNameEt = findViewById(R.id.businessNameEt);
        sourceOfIncomeEt = findViewById(R.id.sourceOfIncomeEt);
        tradeLicenceNumberEt = findViewById(R.id.tradeLicenceNumberEt);
        businessAddressEt = findViewById(R.id.businessAddressEt);
        csImagView = findViewById(R.id.bdCaptureIvId);
        dayAcTv = findViewById(R.id.dayAcTv);
        monthAcTv = findViewById(R.id.monthAcTv);
        yearAcTv = findViewById(R.id.yearAcTv);

        //================= SharedPreferences Data Retrive ==========

        SharedPreferences sp = getSharedPreferences("Business", Context.MODE_PRIVATE);
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

        }
        if (sp.contains("typeOfBusiness")){
            typeOfBusinessSp = sp.getString("typeOfBusiness", "Data Not Found");
            typeOfBusinessET.setText(typeOfBusinessSp);
        }
        if (sp.contains("businessName")){
            businessNameSp = sp.getString("businessName", "Data Not Found");
            businessNameEt.setText(businessNameSp);
        }
        if (sp.contains("sourceOfIncome")){
            sourceOfIncomeSp = sp.getString("sourceOfIncome", "Data Not Found");
            sourceOfIncomeEt.setText(sourceOfIncomeSp);
        }
        if (sp.contains("tradeLicenceNumber")){
            tradeLicenceNumberSp = sp.getString("tradeLicenceNumber", "Data Not Found");
            tradeLicenceNumberEt.setText(tradeLicenceNumberSp);
        }
        if (sp.contains("businessAddress")){
            businessAddressSp = sp.getString("businessAddress", "Data Not Found");
            businessAddressEt.setText(businessAddressSp);
        }
        if (sp.contains("basestring")){
            basestringSp = sp.getString("basestring", "Data Not Found");
            imageDecoder = new ImageDecoder();
            bitmapSp = imageDecoder.convert(basestringSp);
            csImagView.setImageBitmap(bitmapSp);
        }
        else {
//            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }



        //================== Camera Permission ==================

        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(BusinessDetailActivity.this, new String[]{
                    Manifest.permission.CAMERA
            }, 100);
        }


        //================= RecyclerView =====================

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] business = getResources().getStringArray(R.array.business);
        BusinessSmAdapter adapter = new BusinessSmAdapter(this, business);
        recyclerView.setAdapter(adapter);

        //======================= Spinner ===========================
        day = getResources().getStringArray(R.array.day);
        month = getResources().getStringArray(R.array.month);
        year = getResources().getStringArray(R.array.year);

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


        if (typeOfBusinessET.getText().toString().isEmpty()) {
            typeOfBusiness = "N/A";
        } else {
            typeOfBusiness = typeOfBusinessET.getText().toString().trim();
        }

        if (businessNameEt.getText().toString().isEmpty()) {
            businessName = "N/A";
        } else {
            businessName = businessNameEt.getText().toString().trim();
        }

        if (sourceOfIncomeEt.getText().toString().isEmpty()) {
            sourceOfIncome = "N/A";
        } else {
            sourceOfIncome = sourceOfIncomeEt.getText().toString().trim();
        }

        if (tradeLicenceNumberEt.getText().toString().isEmpty()) {
            tradeLicenceNumber = "N/A";
        } else {
            tradeLicenceNumber = tradeLicenceNumberEt.getText().toString().trim();
        }

        if (businessAddressEt.getText().toString().isEmpty()) {
            businessAddress = "N/A";
        } else {
            businessAddress = businessAddressEt.getText().toString().trim();
        }


        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("Business", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("dayValue", dayValue);
        editor.putString("monthValue", monthValue);
        editor.putString("yearValue", yearValue);
        editor.putString("typeOfBusiness", typeOfBusiness);
        editor.putString("businessName", businessName);
        editor.putString("sourceOfIncome", sourceOfIncome);
        editor.putString("tradeLicenceNumber", tradeLicenceNumber);
        editor.putString("businessAddress", businessAddress);
        editor.putString("basestring", basestring);
        editor.commit();


        Intent intent = new Intent(getApplicationContext(), IndustryDetailsActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), ElectricityActivity.class);
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

            basestring = imageEncoder.convert(reduceBitmap);
//            testTv.setText(basestring);

        }

    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}