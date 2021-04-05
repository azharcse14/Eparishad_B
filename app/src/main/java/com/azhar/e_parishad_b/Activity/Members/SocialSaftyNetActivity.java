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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
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

public class SocialSaftyNetActivity extends AppCompatActivity {

    CheckBox elderlyAllowanceCB, maternityAllowanceCB, educationAllowanceCB, autismAllowanceCB, freedomFighterAllowanceCB, vgfCB, widowAllowanceCB, disabilityAllowanceCB, scholarshipCB, pensionCB, otherCB;
    String elderlyAllowance, maternityAllowance, educationAllowance, autismAllowance, freedomFighterAllowance, vgf, widowAllowance, disabilityAllowance, scholarship, pension, other;
    String elderlyAllowanceSp, maternityAllowanceSp, educationAllowanceSp, autismAllowanceSp, freedomFighterAllowanceSp, vgfSp, widowAllowanceSp, disabilityAllowanceSp, scholarshipSp, pensionSp, otherSp;
    EditText ssnciEt;
    String ssnci;
    String ssnciSp;
    ImageView csImagView;
    Bitmap captureImage, reduceBitmap, displayImg;
    String basestring, basestringSp;
    ImageEncoder imageEncoder;
    ImageDecoder imageDecoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_safty_net);

        elderlyAllowanceCB = findViewById(R.id.elderlyAllowanceCB);
        maternityAllowanceCB = findViewById(R.id.maternityAllowanceCB);
        educationAllowanceCB = findViewById(R.id.educationAllowanceCB);
        autismAllowanceCB = findViewById(R.id.autismAllowanceCB);
        freedomFighterAllowanceCB = findViewById(R.id.freedomFighterAllowanceCB);
        vgfCB = findViewById(R.id.vgfCB);
        widowAllowanceCB = findViewById(R.id.widowAllowanceCB);
        disabilityAllowanceCB = findViewById(R.id.disabilityAllowanceCB);
        scholarshipCB = findViewById(R.id.scholarshipCB);
        pensionCB = findViewById(R.id.pensionCB);
        otherCB = findViewById(R.id.otherCB);
        ssnciEt = findViewById(R.id.ssnciEt);
        csImagView = findViewById(R.id.bdCaptureIvId);

        //================= Shared Preferences value retrive =========================

        SharedPreferences sp = getSharedPreferences("SocialSaftyNet", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("elderlyAllowance")){
            elderlyAllowanceSp = sp.getString("elderlyAllowance", "Data Not Found");
            if (elderlyAllowanceSp == "elderlyAllowance"){
                elderlyAllowanceCB.setChecked(true);
            }
        }if (sp.contains("maternityAllowance")){
            maternityAllowanceSp = sp.getString("maternityAllowance", "Data Not Found");
            if (maternityAllowanceSp == "maternityAllowance"){
                maternityAllowanceCB.setChecked(true);
            }
        }if (sp.contains("educationAllowance")){
            educationAllowanceSp = sp.getString("educationAllowance", "Data Not Found");
            if (educationAllowanceSp == "educationAllowance"){
                educationAllowanceCB.setChecked(true);
            }
        }if (sp.contains("autismAllowance")){
            autismAllowanceSp = sp.getString("autismAllowance", "Data Not Found");
            if (autismAllowanceSp == "autismAllowance"){
                autismAllowanceCB.setChecked(true);
            }
        }if (sp.contains("freedomFighterAllowance")){
            freedomFighterAllowanceSp = sp.getString("freedomFighterAllowance", "Data Not Found");
            if (freedomFighterAllowanceSp == "freedomFighterAllowance"){
                freedomFighterAllowanceCB.setChecked(true);
            }
        }if (sp.contains("vgf")){
            vgfSp = sp.getString("vgf", "Data Not Found");
            if (vgfSp == "vgf"){
                vgfCB.setChecked(true);
            }
        }if (sp.contains("widowAllowance")){
            widowAllowanceSp = sp.getString("widowAllowance", "Data Not Found");
            if (widowAllowanceSp == "widowAllowance"){
                widowAllowanceCB.setChecked(true);
            }
        }if (sp.contains("disabilityAllowance")){
            disabilityAllowanceSp = sp.getString("disabilityAllowance", "Data Not Found");
            if (disabilityAllowanceSp == "disabilityAllowance"){
                disabilityAllowanceCB.setChecked(true);
            }
        }if (sp.contains("scholarship")){
            scholarshipSp = sp.getString("scholarship", "Data Not Found");
            if (scholarshipSp == "scholarship"){
                scholarshipCB.setChecked(true);
            }
        }if (sp.contains("pension")){
            pensionSp = sp.getString("pension", "Data Not Found");
            if (pensionSp == "pension"){
                pensionCB.setChecked(true);
            }
        }if (sp.contains("other")){
            otherSp = sp.getString("other", "Data Not Found");
            if (otherSp == "other"){
                otherCB.setChecked(true);
            }
        }if (sp.contains("ssnci")){
            ssnciSp = sp.getString("ssnci", "Data Not Found");
            ssnciEt.setText(ssnciSp);
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

        //========================== Checkbox input ==================================

        StringBuilder stringBuilder = new StringBuilder();
        if (elderlyAllowanceCB.isChecked()){
            String value = elderlyAllowanceCB.getText().toString();
            stringBuilder.append(value+ ", ");
            elderlyAllowance = "elderlyAllowance";
        }
        if (maternityAllowanceCB.isChecked()){
            String value = maternityAllowanceCB.getText().toString();
            stringBuilder.append(value+ ", ");
            maternityAllowance = "maternityAllowance";
        }
        if (educationAllowanceCB.isChecked()){
            String value = educationAllowanceCB.getText().toString();
            stringBuilder.append(value+ ", ");
            educationAllowance = "educationAllowance";
        }
        if (autismAllowanceCB.isChecked()){
            String value = autismAllowanceCB.getText().toString();
            stringBuilder.append(value+ ", ");
            autismAllowance = "autismAllowance";
        }
        if (freedomFighterAllowanceCB.isChecked()){
            String value = freedomFighterAllowanceCB.getText().toString();
            stringBuilder.append(value+ ", ");
            freedomFighterAllowance = "freedomFighterAllowance";
        }
        if (vgfCB.isChecked()){
            String value = vgfCB.getText().toString();
            stringBuilder.append(value+ ", ");
            vgf = "vgf";
        }
        if (widowAllowanceCB.isChecked()){
            String value = widowAllowanceCB.getText().toString();
            stringBuilder.append(value+ ", ");
            widowAllowance = "widowAllowance";
        }if (disabilityAllowanceCB.isChecked()){
            String value = disabilityAllowanceCB.getText().toString();
            stringBuilder.append(value+ ", ");
            disabilityAllowance = "disabilityAllowance";
        }if (scholarshipCB.isChecked()){
            String value = scholarshipCB.getText().toString();
            stringBuilder.append(value+ ", ");
            scholarship = "scholarship";
        }if (pensionCB.isChecked()){
            String value = pensionCB.getText().toString();
            stringBuilder.append(value+ ", ");
            pension = "pension";
        }

        if (otherCB.isChecked()){
            String value = otherCB.getText().toString();
            stringBuilder.append(value+ "");
            other = "other";
        }

        String v = String.valueOf(stringBuilder);

        //====================== EditText input ========================

        if (ssnciEt.getText().toString().isEmpty()) {
            ssnci = "N/A";
        } else {
            ssnci = ssnciEt.getText().toString().trim();
        }

        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("SocialSaftyNet", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("issnp", v);
        editor.putString("elderlyAllowance", elderlyAllowance);
        editor.putString("maternityAllowance", maternityAllowance);
        editor.putString("educationAllowance", educationAllowance);
        editor.putString("autismAllowance", autismAllowance);
        editor.putString("freedomFighterAllowance", freedomFighterAllowance);
        editor.putString("vgf", vgf);
        editor.putString("widowAllowance", widowAllowance);
        editor.putString("disabilityAllowance", disabilityAllowance);
        editor.putString("scholarship", scholarship);
        editor.putString("pension", pension);
        editor.putString("other", other);
        editor.putString("ssnci", ssnci);
        editor.putString("basestring", basestring);
        editor.commit();



        Intent intent = new Intent(getApplicationContext(), TINinformationActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), FamillyPlaningActivity.class);
        startActivity(intent);
    }

    //======================= Image Input ======================

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

            basestring = "data:image/jpeg;base64,"+imageEncoder.convert(reduceBitmap);
//            testTv.setText(basestring);

        }

    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}