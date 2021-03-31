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
import android.widget.Toast;

import com.azhar.e_parishad_b.Database.Entity.Member.MemberTempEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.Database.Entity.Member.MNEntity;
import com.azhar.e_parishad_b.ImageProcessing.ImageDecoder;
import com.azhar.e_parishad_b.ImageProcessing.ImageEncoder;
import com.azhar.e_parishad_b.ImageProcessing.ImageResizer;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberSideMenue.MSMAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class MemberLiveActivity extends AppCompatActivity {

    RadioGroup dmlopRG;
    RadioButton radioButton;
    EditText livingAddressET;
    ImageView csImagView;
    Bitmap captureImage, reduceBitmap, bitmap;
    String basestring, dmlopRGvalue, livingAddress, livingAddressSp, basestringSp;
    ImageEncoder imageEncoder;
    ImageDecoder imageDecoder;

    //======================================for db ==========================================================
    SharedPreferences MemberName, BFMG, MRelationWithKh, MDONE, Nationality, VaccinationInfo, Disability, MotherHCI, FamillyPlaning, SocialSaftyNet, TinInformation, Passport, DrivingLicence, Education, EducationDetails, Training, Profession, maritalStatus, PersonalStatusDetails, IncomeDetails, BankDetail, sp, HoldingAdd;

    String name, member_id, bloodgroup, fathername, mothername, gender, isHead, relationship,  bdaydate,
            bdaymonth,   bdayyear,   age,   birthcertificateno,   birthcertificateimage, nationality,   nid,
            nidimage, membervaccine, disability, ismothervaccination, nearesthospital, maternitynutritionconsultancy,
            consultingwith, iseligiblecouple, anyfamilyplaning, socialsafetynet, socialsafetynetcardinfo, socialsafetynetcardphoto,
            isTinAvaiable, tinNumber, tinimage, passportno, passportimage, isDrivingLicenceAvailable, drivingLicenceNumber,
            dirivinglicenseimage, higheshtEducation,   doyoustudynow, whichLevel, educationinstitution, educationFinishingWant,
            training, primaryprofession,  secondaryprofession, ifunemployednow, rickformofownership, ricksourcesoffinance,
            ricknooftransport,  maritialstatus, marriageRegNo, marriageRegDate, divorceRegNo, divorceRegDate,
            incomefromMainOccuption, incomefromSecondOccuption, additionalincome, mobaileNumber, email,
            accountNo, mobaileNo, bankName, branchName, ismemberlivehere, mlivingAddress, memberimage, kinnumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_live);

        dmlopRG = findViewById(R.id.dmlopRG);
        livingAddressET = findViewById(R.id.livingAddressET);
        csImagView = findViewById(R.id.bdCaptureIvId);

        //==================================================================================
        //================= Shared Preferences value retrive  for db=========================
        //====================================================================================

//        MemberName = getSharedPreferences("MemberName", Context.MODE_PRIVATE);
//        if (MemberName.contains("name")){
//            name = MemberName.getString("name", "Data Not Found");
//        }
//        if (MemberName.contains("member_id")){
//            member_id = MemberName.getString("member_id", "Data Not Found");
//        }
        //===================================================================================

        BFMG = getSharedPreferences("BFMG", Context.MODE_PRIVATE);

        if (BFMG.contains("name")){
            name = BFMG.getString("name", "Data Not Found");
        }
        if (BFMG.contains("member_id")){
            member_id = BFMG.getString("member_id", "Data Not Found");
        }

        if (BFMG.contains("bloodGroup")){
            bloodgroup = BFMG.getString("bloodGroup", "Data Not Found");
        }
        if (BFMG.contains("fathersName")){
            fathername = BFMG.getString("fathersName", "Data Not Found");
        }
        if (BFMG.contains("mothersName")){
            mothername = BFMG.getString("mothersName", "Data Not Found");
        }
        if (BFMG.contains("gender")){
            gender = BFMG.getString("gender", "Data Not Found");
        }
        //===================================================================================

        MRelationWithKh = getSharedPreferences("MRelationWithKh", Context.MODE_PRIVATE);
        if (MRelationWithKh.contains("relation")){
            relationship = MRelationWithKh.getString("relation", "Data Not Found");
        }

        isHead = "0";
        //===================================================================================

        MDONE = getSharedPreferences("MDONE", Context.MODE_PRIVATE);

        if (MDONE.contains("dayValue")){
            bdaydate = MDONE.getString("dayValue", "Data Not Found");
        }
        if (MDONE.contains("monthValue")){
            bdaymonth = MDONE.getString("monthValue", "Data Not Found");
        }
        if (MDONE.contains("yearValue")){
            bdayyear = MDONE.getString("yearValue", "Data Not Found");
        }
        if (MDONE.contains("age")){
            age = MDONE.getString("age", "Data Not Found");
        }
        if (MDONE.contains("bcId")){
            birthcertificateno = MDONE.getString("bcId", "Data Not Found");
        }
        if (MDONE.contains("basestring")){
            birthcertificateimage = MDONE.getString("basestring", "Data Not Found");
        }

        //===================================================================================

        Nationality = getSharedPreferences("Nationality", Context.MODE_PRIVATE);
        if (Nationality.contains("nationality")){
            nationality = Nationality.getString("nationality", "Data Not Found");
        }
        if (Nationality.contains("nationalId")){
            nid = Nationality.getString("nationalId", "Data Not Found");
        }
        if (Nationality.contains("basestring")){
            nidimage = Nationality.getString("basestring", "Data Not Found");
        }

        //===================================================================================

        VaccinationInfo = getSharedPreferences("VaccinationInfo", Context.MODE_PRIVATE);

        if (VaccinationInfo.contains("vaccine")){
            membervaccine = VaccinationInfo.getString("vaccine", "Data Not Found");
        }

        //===================================================================================

        Disability = getSharedPreferences("Disability", Context.MODE_PRIVATE);
        if (Disability.contains("disability")){
            disability = Disability.getString("disability", "Data Not Found");
        }

        //===================================================================================

        MotherHCI = getSharedPreferences("MotherHCI", Context.MODE_PRIVATE);
        if (MotherHCI.contains("vaccination")){
            ismothervaccination = MotherHCI.getString("vaccination", "Data Not Found");
        }
        if (MotherHCI.contains("hospitalName")){
            nearesthospital = MotherHCI.getString("hospitalName", "Data Not Found");
        }
        if (MotherHCI.contains("valueNc")){
            maternitynutritionconsultancy = MotherHCI.getString("valueNc", "Data Not Found");
        }
        if (MotherHCI.contains("valueMc")){
            consultingwith = MotherHCI.getString("valueMc", "Data Not Found");
        }

        //===================================================================================

        FamillyPlaning = getSharedPreferences("FamillyPlaning", Context.MODE_PRIVATE);
        if (FamillyPlaning.contains("valueEC")){
            iseligiblecouple = FamillyPlaning.getString("valueEC", "Data Not Found");
        }
        if (FamillyPlaning.contains("valueFP")){
            anyfamilyplaning = FamillyPlaning.getString("valueFP", "Data Not Found");
        }

        //===================================================================================

        SocialSaftyNet = getSharedPreferences("SocialSaftyNet", Context.MODE_PRIVATE);
        if (SocialSaftyNet.contains("issnp")){
            socialsafetynet = SocialSaftyNet.getString("issnp", "Data Not Found");
        }
        if (SocialSaftyNet.contains("ssnci")){
            socialsafetynetcardinfo = SocialSaftyNet.getString("ssnci", "Data Not Found");
        }
        if (SocialSaftyNet.contains("basestring")){
            socialsafetynetcardphoto = SocialSaftyNet.getString("basestring", "Data Not Found");
        }

        //===================================================================================

        TinInformation = getSharedPreferences("TinInformation", Context.MODE_PRIVATE);
        if (TinInformation.contains("tinRGvalue")){
            isTinAvaiable = TinInformation.getString("tinRGvalue", "Data Not Found");
        }
        if (TinInformation.contains("tinNumber")){
            tinNumber = TinInformation.getString("tinNumber", "Data Not Found");
        }
        if (TinInformation.contains("basestring")){
            tinimage = TinInformation.getString("basestring", "Data Not Found");
        }

        //===================================================================================

        Passport = getSharedPreferences("Passport", Context.MODE_PRIVATE);
        if (Passport.contains("passportNo")){
            passportno = Passport.getString("passportNo", "Data Not Found");
        }
        if (Passport.contains("basestring")){
            passportimage = Passport.getString("basestring", "Data Not Found");
        }

        //===================================================================================

        DrivingLicence = getSharedPreferences("DrivingLicence", Context.MODE_PRIVATE);
        if (DrivingLicence.contains("tlRGvalue")){
            isDrivingLicenceAvailable = DrivingLicence.getString("tlRGvalue", "Data Not Found");
        }
        if (DrivingLicence.contains("drivingLicenceNumber")){
            drivingLicenceNumber = DrivingLicence.getString("drivingLicenceNumber", "Data Not Found");
        }
        if (DrivingLicence.contains("basestring")){
            dirivinglicenseimage = DrivingLicence.getString("basestring", "Data Not Found");
        }

        //===================================================================================

        Education = getSharedPreferences("Education", Context.MODE_PRIVATE);
        if (Education.contains("educationRGvalue")){
            higheshtEducation = Education.getString("educationRGvalue", "Data Not Found");
        }

        //===================================================================================

        EducationDetails = getSharedPreferences("EducationDetails", Context.MODE_PRIVATE);

        if (EducationDetails.contains("studyNowRGvalue")){
            doyoustudynow = EducationDetails.getString("studyNowRGvalue", "Data Not Found");
        }
        if (EducationDetails.contains("educationLevelValue")){
            whichLevel = EducationDetails.getString("educationLevelValue", "Data Not Found");
        }
        if (EducationDetails.contains("educationalInstitution")){
            educationinstitution = EducationDetails.getString("educationalInstitution", "Data Not Found");
        }
        if (EducationDetails.contains("educationFinishing")){
            educationFinishingWant = EducationDetails.getString("educationFinishing", "Data Not Found");
        }

        //===================================================================================

        Training = getSharedPreferences("Training", Context.MODE_PRIVATE);

        if (Training.contains("training")){
            training = Training.getString("training", "Data Not Found");
        }

        //===================================================================================


        Profession = getSharedPreferences("Profession", Context.MODE_PRIVATE);
        if (Profession.contains("primaryProfession")){
            primaryprofession = Profession.getString("primaryProfession", "Data Not Found");
        }
        if (Profession.contains("secondaryProfession")){
            secondaryprofession = Profession.getString("secondaryProfession", "Data Not Found");
        }
        if (Profession.contains("unemployed")){
            ifunemployednow = Profession.getString("unemployed", "Data Not Found");
        }
        if (Profession.contains("foo")){
            rickformofownership = Profession.getString("foo", "Data Not Found");
        }
        if (Profession.contains("sof")){
            ricksourcesoffinance = Profession.getString("sof", "Data Not Found");
        }
        if (Profession.contains("not")){
            ricknooftransport = Profession.getString("not", "Data Not Found");
        }

        //===================================================================================

        maritalStatus = getSharedPreferences("maritalStatus", Context.MODE_PRIVATE);
        if (maritalStatus.contains("marriedRGvalue")){
            maritialstatus = maritalStatus.getString("marriedRGvalue", "Data Not Found");
        }

        //===================================================================================

        PersonalStatusDetails = getSharedPreferences("PersonalStatusDetails", Context.MODE_PRIVATE);

        if (PersonalStatusDetails.contains("mrn")){
            marriageRegNo = PersonalStatusDetails.getString("mrn", "Data Not Found");
        }
        if (PersonalStatusDetails.contains("mrd")){
            marriageRegDate = PersonalStatusDetails.getString("mrd", "Data Not Found");
        }
        if (PersonalStatusDetails.contains("drn")){
            divorceRegNo = PersonalStatusDetails.getString("drn", "Data Not Found");
        }
        if (PersonalStatusDetails.contains("drd")){
            divorceRegDate = PersonalStatusDetails.getString("drd", "Data Not Found");
        }

        //===================================================================================

        IncomeDetails = getSharedPreferences("IncomeDetails", Context.MODE_PRIVATE);
        if (IncomeDetails.contains("incomeMain")){
            incomefromMainOccuption = IncomeDetails.getString("incomeMain", "Data Not Found");
        }
        if (IncomeDetails.contains("incomeSecond")){
            incomefromSecondOccuption = IncomeDetails.getString("incomeSecond", "Data Not Found");
        }
        if (IncomeDetails.contains("additionalIncome")){
            additionalincome = IncomeDetails.getString("additionalIncome", "Data Not Found");
        }
        if (IncomeDetails.contains("mobNum")){
            mobaileNumber = IncomeDetails.getString("mobNum", "Data Not Found");
        }
        if (IncomeDetails.contains("emailAdd")){
            email = IncomeDetails.getString("emailAdd", "Data Not Found");
        }

        //===================================================================================

        BankDetail = getSharedPreferences("BankDetail", Context.MODE_PRIVATE);

        if (BankDetail.contains("accountNo")){
            accountNo = BankDetail.getString("accountNo", "Data Not Found");
        }
        if (BankDetail.contains("mobailNo")){
            mobaileNo = BankDetail.getString("mobailNo", "Data Not Found");
        }
        if (BankDetail.contains("bankName")){
            bankName = BankDetail.getString("bankName", "Data Not Found");
        }
        if (BankDetail.contains("branchName")){
            branchName = BankDetail.getString("branchName", "Data Not Found");
        }

        //===================================================================================
        ismemberlivehere = dmlopRGvalue;
        mlivingAddress = livingAddress;
        memberimage = basestring;

        //===================================================================================

        HoldingAdd = getSharedPreferences("HoldingAdd", Context.MODE_PRIVATE);

        if (HoldingAdd.contains("kinNo")){
            kinnumber = HoldingAdd.getString("kinNo", "Data Not Found");
        }
        //===================================================================================
        //===================================================================================

        //================= Shared Preferences value retrive =========================

        sp = getSharedPreferences("MemberLive", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int i = sp.getInt("my_choice_key", -1);
        if (i >= 0) {
            ((RadioButton) ((RadioGroup) findViewById(R.id.dmlopRG)).getChildAt(i)).setChecked(true);
        }

        if (sp.contains("livingAddress")) {
            livingAddressSp = sp.getString("livingAddress", "Data Not Found");
            livingAddressET.setText(livingAddressSp);
        }
        if (sp.contains("basestring")) {
            basestringSp = sp.getString("basestring", "Data Not Found");
            imageDecoder = new ImageDecoder();
            bitmap = imageDecoder.convert(basestringSp);
            csImagView.setImageBitmap(bitmap);
        } else {
            Toast.makeText(getApplicationContext(), "Empty", Toast.LENGTH_LONG).show();
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
            int selectedId = dmlopRG.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);
            dmlopRGvalue = radioButton.getText().toString();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e + "", Toast.LENGTH_SHORT).show();
        }

        if (livingAddressET.getText().toString().isEmpty()) {
            livingAddress = "N/A";
        } else {
            livingAddress = livingAddressET.getText().toString().trim();
        }

        ismemberlivehere = dmlopRGvalue;
        mlivingAddress = livingAddress;
        memberimage = basestring;


        //================== Shared Preferences ====================

        SharedPreferences sp = getSharedPreferences("MemberLive", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("dmlopRGvalue", dmlopRGvalue);
        editor.putString("livingAddress", livingAddress);
        editor.putString("basestring", basestring);

        editor.putInt("my_choice_key", dmlopRG.indexOfChild(findViewById(dmlopRG.getCheckedRadioButtonId())));
        editor.apply();

        editor.commit();

        //============================ Room Insert ====================================

        Repository repository = new Repository(getApplicationContext());

        MNEntity mnEntity = new MNEntity(name, member_id, bloodgroup, fathername, mothername, gender, isHead, relationship,  bdaydate,
                bdaymonth,   bdayyear,   age,   birthcertificateno,   birthcertificateimage, nationality,   nid,
                nidimage, membervaccine, disability, ismothervaccination, nearesthospital, maternitynutritionconsultancy,
                consultingwith, iseligiblecouple, anyfamilyplaning, socialsafetynet, socialsafetynetcardinfo, socialsafetynetcardphoto,
                isTinAvaiable, tinNumber, tinimage, passportno, passportimage, isDrivingLicenceAvailable, drivingLicenceNumber,
                dirivinglicenseimage, higheshtEducation,   doyoustudynow, whichLevel, educationinstitution, educationFinishingWant,
                training, primaryprofession,  secondaryprofession, ifunemployednow, rickformofownership, ricksourcesoffinance,
                ricknooftransport,  maritialstatus, marriageRegNo, marriageRegDate, divorceRegNo, divorceRegDate,
                incomefromMainOccuption, incomefromSecondOccuption, additionalincome, mobaileNumber, email,
                accountNo, mobaileNo, bankName, branchName, ismemberlivehere, mlivingAddress, memberimage, kinnumber);
        repository.InsertTaskMNEntity(mnEntity);

        MemberTempEntity memberTempEntity = new MemberTempEntity(name, member_id, bloodgroup, fathername, mothername, gender, isHead, relationship,  bdaydate,
                bdaymonth,   bdayyear,   age,   birthcertificateno,   birthcertificateimage, nationality,   nid,
                nidimage, membervaccine, disability, ismothervaccination, nearesthospital, maternitynutritionconsultancy,
                consultingwith, iseligiblecouple, anyfamilyplaning, socialsafetynet, socialsafetynetcardinfo, socialsafetynetcardphoto,
                isTinAvaiable, tinNumber, tinimage, passportno, passportimage, isDrivingLicenceAvailable, drivingLicenceNumber,
                dirivinglicenseimage, higheshtEducation,   doyoustudynow, whichLevel, educationinstitution, educationFinishingWant,
                training, primaryprofession,  secondaryprofession, ifunemployednow, rickformofownership, ricksourcesoffinance,
                ricknooftransport,  maritialstatus, marriageRegNo, marriageRegDate, divorceRegNo, divorceRegDate,
                incomefromMainOccuption, incomefromSecondOccuption, additionalincome, mobaileNumber, email,
                accountNo, mobaileNo, bankName, branchName, ismemberlivehere, mlivingAddress, memberimage, kinnumber);
        repository.InsertTaskMemberTemp(memberTempEntity);



        cleanSharedPreferences();

        Intent intent = new Intent(getApplicationContext(), MembersActivity.class);
        startActivity(intent);
    }

    private void cleanSharedPreferences() {


//        SharedPreferences.Editor mn = MemberName.edit();
//        mn.clear();
//        mn.commit();

        SharedPreferences.Editor BFMGsp = BFMG.edit();
        BFMGsp.clear();
        BFMGsp.commit();

        SharedPreferences.Editor mrw = MRelationWithKh.edit();
        mrw.clear();
        mrw.commit();

        SharedPreferences.Editor mdmn = MDONE.edit();
        mdmn.clear();
        mdmn.commit();

        SharedPreferences.Editor nat = Nationality.edit();
        nat.clear();
        nat.commit();

        SharedPreferences.Editor vac = VaccinationInfo.edit();
        vac.clear();
        vac.commit();

        SharedPreferences.Editor dis = Disability.edit();
        dis.clear();
        dis.commit();

        SharedPreferences.Editor mhci = MotherHCI.edit();
        mhci.clear();
        mhci.commit();

        SharedPreferences.Editor fp = FamillyPlaning.edit();
        fp.clear();
        fp.commit();

        SharedPreferences.Editor ssn = SocialSaftyNet.edit();
        ssn.clear();
        ssn.commit();

        SharedPreferences.Editor ti = TinInformation.edit();
        ti.clear();
        ti.commit();

        SharedPreferences.Editor pp = Passport.edit();
        pp.clear();
        pp.commit();

        SharedPreferences.Editor dl = DrivingLicence.edit();
        dl.clear();
        dl.commit();

        SharedPreferences.Editor edu = Education.edit();
        edu.clear();
        edu.commit();

        SharedPreferences.Editor edud = EducationDetails.edit();
        edud.clear();
        edud.commit();

        SharedPreferences.Editor trn = Training.edit();
        trn.clear();
        trn.commit();

        SharedPreferences.Editor prof = Profession.edit();
        prof.clear();
        prof.commit();

        SharedPreferences.Editor ms = maritalStatus.edit();
        ms.clear();
        ms.commit();

        SharedPreferences.Editor psd = PersonalStatusDetails.edit();
        psd.clear();
        psd.commit();

        SharedPreferences.Editor id = IncomeDetails.edit();
        id.clear();
        id.commit();

        SharedPreferences.Editor bd = BankDetail.edit();
        bd.clear();
        bd.commit();

        SharedPreferences.Editor spe = sp.edit();
        spe.clear();
        spe.commit();

    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), BankDetailActivity.class);
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

            basestring = "data:image/jpeg;base64,"+imageEncoder.convert(reduceBitmap);
//            testTv.setText(basestring);

        }

    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}