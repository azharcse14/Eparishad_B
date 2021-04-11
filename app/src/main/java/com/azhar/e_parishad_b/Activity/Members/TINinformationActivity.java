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

public class TINinformationActivity extends AppCompatActivity {

    RadioGroup tinRG;
    RadioButton radioButton;
    EditText tinNumberEt;
    ImageView csImagView;
    Bitmap captureImage, reduceBitmap, displayImg;
    String basestring, tinRGvalue, tinNumber, tinNumberSp, basestringSp;
    ImageEncoder imageEncoder;
    ImageDecoder imageDecoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_i_ninformation);

        tinRG = findViewById(R.id.tinRG);
        tinNumberEt = findViewById(R.id.tinNumberEt);
        csImagView = findViewById(R.id.bdCaptureIvId);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("TinInformation", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int i = sp.getInt("tinRG_key",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.tinRG)).getChildAt(i)).setChecked(true);
        }

        if (sp.contains("tinNumber")){
            tinNumberSp = sp.getString("tinNumber", "Data Not Found");
            tinNumberEt.setText(tinNumberSp);
        }if (sp.contains("basestring")){
            basestringSp = sp.getString("basestring", "Data Not Found");
            imageDecoder = new ImageDecoder();
            displayImg = imageDecoder.convert(basestringSp);
            csImagView.setImageBitmap(displayImg);
        }else {
//            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
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

        try {
            int selectedId = tinRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            tinRGvalue = radioButton.getText().toString();

        }catch (Exception e){
//            Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
        }

        if (tinNumberEt.getText().toString().isEmpty()) {
            tinNumber = "N/A";
        } else {
            tinNumber = tinNumberEt.getText().toString().trim();
        }

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("TinInformation", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("tinRGvalue", tinRGvalue);
        editor.putString("tinNumber", tinNumber);
        editor.putString("basestring", basestring);

        editor.putInt("tinRG_key", tinRG.indexOfChild(findViewById(tinRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.commit();

        Intent intent = new Intent(getApplicationContext(), PassportActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), SocialSaftyNetActivity.class);
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