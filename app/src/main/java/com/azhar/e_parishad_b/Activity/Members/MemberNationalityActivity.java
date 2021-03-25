package com.azhar.e_parishad_b.Activity.Members;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.azhar.e_parishad_b.Activity.HeadActivity;
import com.azhar.e_parishad_b.Activity.HoldingAddActivity;
import com.azhar.e_parishad_b.ImageProcessing.ImageDecoder;
import com.azhar.e_parishad_b.ImageProcessing.ImageEncoder;
import com.azhar.e_parishad_b.ImageProcessing.ImageResizer;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberSideMenue.MSMAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class MemberNationalityActivity extends AppCompatActivity {

    RadioGroup nationalityRG;
    String nationality;
    RadioButton radioButton;
    EditText nationalIdEt;
    String nationalId, nationalIdSp;
    ImageView csImagView;
    Bitmap captureImage, reduceBitmap, bitmapSp;
    String basestring, basestringSp;
    ImageEncoder imageEncoder;
    SharedPreferences sp;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_nationality);

        nationalityRG = findViewById(R.id.nationalityRG);
        nationalIdEt = findViewById(R.id.nationalIdEt);
        csImagView = findViewById(R.id.bdCaptureIvId);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("Nationality", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int i = sp.getInt("my_choice_key",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.nationalityRG)).getChildAt(i)).setChecked(true);
        }

        if (sp.contains("nationalId")){
            nationalIdSp = sp.getString("nationalId", "Data Not Found");
            nationalIdEt.setText(nationalIdSp);
        }if (sp.contains("basestring")){
            basestringSp = sp.getString("basestring", "Data Not Found");
            ImageDecoder imageDecoder = new ImageDecoder();
            bitmapSp = imageDecoder.convert(basestringSp);
            csImagView.setImageBitmap(bitmapSp);
        }else {
            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
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
        if (nationalIdEt.getText().toString().isEmpty()) {
            nationalId = "N/A";
        } else {
            nationalId = nationalIdEt.getText().toString().trim();
        }

        try {
            int selectedId = nationalityRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            nationality = radioButton.getText().toString();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }



        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("Nationality", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("nationality", nationality);
        editor.putString("nationalId", nationalId);
        editor.putString("basestring", basestring);

        editor.putInt("my_choice_key", nationalityRG.indexOfChild(findViewById(nationalityRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.commit();



        Intent intent = new Intent(getApplicationContext(), MemberVaccinationInformationActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), Member_Details_One_Activity.class);
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

            basestring= "data:image/jpeg;base64,"+imageEncoder.convert(reduceBitmap);
//            testTv.setText(basestring);

        }
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}