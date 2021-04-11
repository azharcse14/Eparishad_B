package com.azhar.e_parishad_b.Activity.Loan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.azhar.e_parishad_b.Activity.Business.BusinessDetailActivity;
import com.azhar.e_parishad_b.Activity.MainActivity;
import com.azhar.e_parishad_b.Database.Entity.FDEntity;
import com.azhar.e_parishad_b.Database.Entity.Loan.LoanTempEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.Loan.LoanAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoanActivity extends AppCompatActivity {

    RecyclerView recyclerViewS, recyclerViewLoan;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<LoanTempEntity> loanTempEntityArrayList;
    LoanAdapter loanAdapter;

    //==================== for db ===================================

    SharedPreferences LOGIN, HoldingNo, HoldingAdd, KhanaHead, Religion, OwnLand, OtherLand, Land, HouseType, waterSupply, Sanitation, Electricity, Business, IndustryDetails, RiceMill, VehicalBusiness, InterestOfSecurity, FarmingDetails, LiveStockDetail, FisheriseDetails;

    String date, facode, fauser, username, surveyID, holdingnumber, khananumber, lat, lng, kinnumber, division, district, upazila, union, postcode,
            village, ward, khanahead, telephoneNumber, khanatype, religion, ethnicity,
            ownlivingland, ownfarmingland, ownleasegiven, ownpond,
            owngarden, ownhill, ownother, ownlandTotal, otherlivingland, otherfarmingland, otherleasetaken, otherpond, othergarden,
            otherhill, otherlandother, otherlandTotal, isNotLandDivided, housetype, watersupply, sanitation, iselectricity, typeofelectricity,
            businesstype, businessname, businesssourcesoffinance, tradelicensemumber, tradelicensemumberimage, businessAddress, businessStartYear, businessStartMonth, businessStartDay,
            industryowner, typeofindustry, industsourcesoffinance, formofownership, ifricemilling, riceMillProductionCapacity, typeofricemilled, isricemilledOwn,
            interestedingovtfixedrate,
            iftruckbusiness, vehicletype, numberoftrucks, trucktotalcapacity, trucksourceoffinance, istruckowned, interestdrivingtrucksforgovt,
            interestofsecurities, incomefromhouseproperty, incomefromagricultural, capitalgain, incomefromaothersources,
            aush, aman, boro, wheat, maize, pulses, oilseeds, potato, tomato, vegetable, sugarcane, jute, farmingsellingtoGovtfixedprice,
            farmingsellingtoPrivatetraders,
            cattle, buffalo, sheep, goat, chicken, egghens, duck, eggsduck,
            ruhi, catla, mixedfish, pangas, koi, magur, tilapia, shrimp, prawn, others, isSync, surveystatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        recyclerViewS = findViewById(R.id.recyclerViewId);
        recyclerViewLoan = findViewById(R.id.loanRecyclerViewId);

//         date = String.valueOf(java.time.LocalDateTime.now());
        date = String.valueOf(java.time.LocalDate.now());

        //==================================================================================
        //================= Shared Preferences value retrive  for db=========================
        //====================================================================================
        LOGIN = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);

        if (LOGIN.contains("usercode")) {
            facode = LOGIN.getString("usercode", "Data Not Found");
        }
        if (LOGIN.contains("user")) {
            fauser = LOGIN.getString("user", "Data Not Found");
        }
        if (LOGIN.contains("name")) {
            username = LOGIN.getString("name", "Data Not Found");
        }

        //====================================================================================
        String timeStamp = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        surveyID = facode+"-"+timeStamp;
        //====================================================================================
        HoldingNo = getSharedPreferences("HoldingNo", Context.MODE_PRIVATE);
        if (HoldingNo.contains("holdingNo")) {
            holdingnumber = HoldingNo.getString("holdingNo", "Data Not Found");
        }
        if (HoldingNo.contains("khanaNo")) {
            khananumber = HoldingNo.getString("khanaNo", "Data Not Found");
        }
        if (HoldingNo.contains("latitude")) {
            lat = HoldingNo.getString("latitude", "Data Not Found");
        }
        if (HoldingNo.contains("longitude")) {
            lng = HoldingNo.getString("longitude", "Data Not Found");
        }

        //===================================================================================
        HoldingAdd = getSharedPreferences("HoldingAdd", Context.MODE_PRIVATE);

        if (HoldingAdd.contains("kinNo")) {
            kinnumber = HoldingAdd.getString("kinNo", "Data Not Found");
        }

        division = "Cumilla";
        district = "Cumilla";
        upazila = "Cumilla Sadar Dakshin";
        union = " 1 No Bijoypur Union";
        postcode = "3503";

        if (HoldingAdd.contains("wardValue")) {
            ward = HoldingAdd.getString("wardValue", "Data Not Found");
        }
        if (HoldingAdd.contains("villageValue")) {
            village = HoldingAdd.getString("villageValue", "Data Not Found");
        }

        //===================================================================================
        KhanaHead = getSharedPreferences("KhanaHead", Context.MODE_PRIVATE);

        if (KhanaHead.contains("khanaHead")) {
            khanahead = KhanaHead.getString("khanaHead", "Data Not Found");
        }
        if (KhanaHead.contains("telephoneNo")) {
            telephoneNumber = KhanaHead.getString("telephoneNo", "Data Not Found");
        }
        if (KhanaHead.contains("radioGroup")) {
            khanatype = KhanaHead.getString("radioGroup", "Data Not Found");
        }

        //===================================================================================
        Religion = getSharedPreferences("Religion", Context.MODE_PRIVATE);

        if (Religion.contains("radioGroup")) {
            religion = Religion.getString("radioGroup", "Data Not Found");
        }
        if (Religion.contains("ethnicity")) {
            ethnicity = Religion.getString("ethnicity", "Data Not Found");
        }

        //===================================================================================
        OwnLand = getSharedPreferences("OwnLand", Context.MODE_PRIVATE);

        if (OwnLand.contains("livingLandOlAdd")) {
            ownlivingland = OwnLand.getString("livingLandOlAdd", "Data Not Found");
        }
        if (OwnLand.contains("farmingLandOlAdd")) {
            ownfarmingland = OwnLand.getString("farmingLandOlAdd", "Data Not Found");
        }
        if (OwnLand.contains("leasedGivenAdd")) {
            ownleasegiven = OwnLand.getString("leasedGivenAdd", "Data Not Found");
        }
        if (OwnLand.contains("pondOlAdd")) {
            ownpond = OwnLand.getString("pondOlAdd", "Data Not Found");
        }
        if (OwnLand.contains("gardenOlAdd")) {
            owngarden = OwnLand.getString("gardenOlAdd", "Data Not Found");
        }
        if (OwnLand.contains("hillOlAdd")) {
            ownhill = OwnLand.getString("hillOlAdd", "Data Not Found");
        }
        if (OwnLand.contains("otherLandOlAdd")) {
            ownother = OwnLand.getString("otherLandOlAdd", "Data Not Found");
        }
        if (OwnLand.contains("totalOwnLand")) {
            ownlandTotal = OwnLand.getString("totalOwnLand", "Data Not Found");
        }

        OtherLand = getSharedPreferences("OtherLand", Context.MODE_PRIVATE);

        if (OtherLand.contains("livingLandNOl")) {
            otherlivingland = OtherLand.getString("livingLandNOl", "Data Not Found");
        }
        if (OtherLand.contains("farmingLandNOl")) {
            otherfarmingland = OtherLand.getString("farmingLandNOl", "Data Not Found");
        }
        if (OtherLand.contains("leasedTaken")) {
            otherleasetaken = OtherLand.getString("leasedTaken", "Data Not Found");
        }
        if (OtherLand.contains("pondNOl")) {
            otherpond = OtherLand.getString("pondNOl", "Data Not Found");
        }
        if (OtherLand.contains("gardenNOl")) {
            othergarden = OtherLand.getString("gardenNOl", "Data Not Found");
        }
        if (OtherLand.contains("hillNOl")) {
            otherhill = OtherLand.getString("hillNOl", "Data Not Found");
        }
        if (OtherLand.contains("otherLandNOl")) {
            otherlandother = OtherLand.getString("otherLandNOl", "Data Not Found");
        }
        if (OtherLand.contains("totalOtherLand")) {
            otherlandTotal = OtherLand.getString("totalOtherLand", "Data Not Found");
        }

        Land = getSharedPreferences("Land", Context.MODE_PRIVATE);

        if (Land.contains("landhasnotbeendividedyet")) {
            isNotLandDivided = Land.getString("landhasnotbeendividedyet", "Data Not Found");
        }

        //===================================================================================
        HouseType = getSharedPreferences("HouseType", Context.MODE_PRIVATE);

        if (HouseType.contains("houseTypeV")) {
            housetype = HouseType.getString("houseTypeV", "Data Not Found");
        }

        //===================================================================================
        waterSupply = getSharedPreferences("waterSupply", Context.MODE_PRIVATE);
        if (waterSupply.contains("waterSupplyV")) {
            watersupply = waterSupply.getString("waterSupplyV", "Data Not Found");
        }

        //===================================================================================
        Sanitation = getSharedPreferences("Sanitation", Context.MODE_PRIVATE);
        if (Sanitation.contains("SanitationV")) {
            sanitation = Sanitation.getString("SanitationV", "Data Not Found");
        }

        //===================================================================================
        Electricity = getSharedPreferences("Electricity", Context.MODE_PRIVATE);

        if (Electricity.contains("isThereElectricityRGvalue")) {
            iselectricity = Electricity.getString("isThereElectricityRGvalue", "Data Not Found");
        }
        if (Electricity.contains("typeOfElectricityRGvalue")) {
            typeofelectricity = Electricity.getString("typeOfElectricityRGvalue", "Data Not Found");
        }

        //===================================================================================
        Business = getSharedPreferences("Business", Context.MODE_PRIVATE);

        if (Business.contains("typeOfBusiness")) {
            businesstype = Business.getString("typeOfBusiness", "Data Not Found");
        }
        if (Business.contains("businessName")) {
            businessname = Business.getString("businessName", "Data Not Found");
        }
        if (Business.contains("sourceOfIncome")) {
            businesssourcesoffinance = Business.getString("sourceOfIncome", "Data Not Found");
        }
        if (Business.contains("tradeLicenceNumber")) {
            tradelicensemumber = Business.getString("tradeLicenceNumber", "Data Not Found");
        }
        if (Business.contains("basestring")) {
            tradelicensemumberimage = "data:image/jpeg;base64,"+Business.getString("basestring", "Data Not Found");
        }
        if (Business.contains("businessAddress")) {
            businessAddress = Business.getString("businessAddress", "Data Not Found");
        }
        if (Business.contains("dayValue")) {
            businessStartDay = Business.getString("dayValue", "Data Not Found");
        }
        if (Business.contains("monthValue")) {
            businessStartMonth = Business.getString("monthValue", "Data Not Found");
        }
        if (Business.contains("yearValue")) {
            businessStartYear = Business.getString("yearValue", "Data Not Found");
        }

        //===================================================================================
        IndustryDetails = getSharedPreferences("IndustryDetails", Context.MODE_PRIVATE);

        if (IndustryDetails.contains("industryOwner")) {
            industryowner = IndustryDetails.getString("industryOwner", "Data Not Found");
        }
        if (IndustryDetails.contains("typeOfIndustry")) {
            typeofindustry = IndustryDetails.getString("typeOfIndustry", "Data Not Found");
        }
        if (IndustryDetails.contains("sourceOfFinance")) {
            industsourcesoffinance = IndustryDetails.getString("sourceOfFinance", "Data Not Found");
        }
        if (IndustryDetails.contains("valueRG")) {
            formofownership = IndustryDetails.getString("valueRG", "Data Not Found");
        }

        //===================================================================================
        RiceMill = getSharedPreferences("RiceMill", Context.MODE_PRIVATE);

        if (RiceMill.contains("ifRiceMilling")) {
            ifricemilling = RiceMill.getString("ifRiceMilling", "Data Not Found");
        }
        if (RiceMill.contains("rmpc")) {
            riceMillProductionCapacity = RiceMill.getString("rmpc", "Data Not Found");
        }
        if (RiceMill.contains("tOfRm")) {
            typeofricemilled = RiceMill.getString("tOfRm", "Data Not Found");
        }
        if (RiceMill.contains("ownedRGvalue")) {
            isricemilledOwn = RiceMill.getString("ownedRGvalue", "Data Not Found");
        }
        if (RiceMill.contains("imrgfrfcbRGvalue")) {
            interestedingovtfixedrate = RiceMill.getString("imrgfrfcbRGvalue", "Data Not Found");
        }

        //===================================================================================
        VehicalBusiness = getSharedPreferences("VehicalBusiness", Context.MODE_PRIVATE);

        if (VehicalBusiness.contains("ifBusiness")) {
            iftruckbusiness = VehicalBusiness.getString("ifBusiness", "Data Not Found");
        }
        if (VehicalBusiness.contains("typeOfVehicleRGvalue")) {
            vehicletype = VehicalBusiness.getString("typeOfVehicleRGvalue", "Data Not Found");
        }
        if (VehicalBusiness.contains("numberOfVehicle")) {
            numberoftrucks = VehicalBusiness.getString("numberOfVehicle", "Data Not Found");
        }
        if (VehicalBusiness.contains("totalCapacity")) {
            trucktotalcapacity = VehicalBusiness.getString("totalCapacity", "Data Not Found");
        }
        if (VehicalBusiness.contains("sourceOfFinanceVb")) {
            trucksourceoffinance = VehicalBusiness.getString("sourceOfFinanceVb", "Data Not Found");
        }
        if (VehicalBusiness.contains("ownedVbRGvalue")) {
            istruckowned = VehicalBusiness.getString("ownedVbRGvalue", "Data Not Found");
        }
        if (VehicalBusiness.contains("ifDrivingVforGovtRGvalue")) {
            interestdrivingtrucksforgovt = VehicalBusiness.getString("ifDrivingVforGovtRGvalue", "Data Not Found");
        }

        //===================================================================================
        InterestOfSecurity = getSharedPreferences("InterestOfSecurity", Context.MODE_PRIVATE);

        if (InterestOfSecurity.contains("interestOfSecurities")) {
            interestofsecurities = InterestOfSecurity.getString("interestOfSecurities", "Data Not Found");
        }
        if (InterestOfSecurity.contains("ifhp")) {
            incomefromhouseproperty = InterestOfSecurity.getString("ifhp", "Data Not Found");
        }
        if (InterestOfSecurity.contains("ifa")) {
            incomefromagricultural = InterestOfSecurity.getString("ifa", "Data Not Found");
        }
        if (InterestOfSecurity.contains("capitalGain")) {
            capitalgain = InterestOfSecurity.getString("capitalGain", "Data Not Found");
        }
        if (InterestOfSecurity.contains("ifos")) {
            incomefromaothersources = InterestOfSecurity.getString("ifos", "Data Not Found");
        }

        //===================================================================================
        FarmingDetails = getSharedPreferences("FarmingDetails", Context.MODE_PRIVATE);

        if (FarmingDetails.contains("aush")) {
            aush = FarmingDetails.getString("aush", "Data Not Found");
        }
        if (FarmingDetails.contains("aman")) {
            aman = FarmingDetails.getString("aman", "Data Not Found");
        }
        if (FarmingDetails.contains("boro")) {
            boro = FarmingDetails.getString("boro", "Data Not Found");
        }
        if (FarmingDetails.contains("wheat")) {
            wheat = FarmingDetails.getString("wheat", "Data Not Found");
        }
        if (FarmingDetails.contains("maize")) {
            maize = FarmingDetails.getString("maize", "Data Not Found");
        }
        if (FarmingDetails.contains("pulses")) {
            pulses = FarmingDetails.getString("pulses", "Data Not Found");
        }
        if (FarmingDetails.contains("oilSeeds")) {
            oilseeds = FarmingDetails.getString("oilSeeds", "Data Not Found");
        }

        if (FarmingDetails.contains("potato")) {
            potato = FarmingDetails.getString("potato", "Data Not Found");
        }
        if (FarmingDetails.contains("tomato")) {
            tomato = FarmingDetails.getString("tomato", "Data Not Found");
        }
        if (FarmingDetails.contains("vegetable")) {
            vegetable = FarmingDetails.getString("vegetable", "Data Not Found");
        }
        if (FarmingDetails.contains("sugarcane")) {
            sugarcane = FarmingDetails.getString("sugarcane", "Data Not Found");
        }
        if (FarmingDetails.contains("jute")) {
            jute = FarmingDetails.getString("jute", "Data Not Found");
        }
        if (FarmingDetails.contains("sgfp")) {
            farmingsellingtoGovtfixedprice = FarmingDetails.getString("sgfp", "Data Not Found");
        }
        if (FarmingDetails.contains("spt")) {
            farmingsellingtoPrivatetraders = FarmingDetails.getString("spt", "Data Not Found");
        }

        //===================================================================================
        LiveStockDetail = getSharedPreferences("LiveStockDetail", Context.MODE_PRIVATE);

        if (LiveStockDetail.contains("cattle")) {
            cattle = LiveStockDetail.getString("cattle", "Data Not Found");
        }
        if (LiveStockDetail.contains("buffalo")) {
            buffalo = LiveStockDetail.getString("buffalo", "Data Not Found");
        }
        if (LiveStockDetail.contains("sheep")) {
            sheep = LiveStockDetail.getString("sheep", "Data Not Found");
        }
        if (LiveStockDetail.contains("goat")) {
            goat = LiveStockDetail.getString("goat", "Data Not Found");
        }
        if (LiveStockDetail.contains("chicken")) {
            chicken = LiveStockDetail.getString("chicken", "Data Not Found");
        }
        if (LiveStockDetail.contains("eggHens")) {
            egghens = LiveStockDetail.getString("eggHens", "Data Not Found");
        }
        if (LiveStockDetail.contains("duck")) {
            duck = LiveStockDetail.getString("duck", "Data Not Found");
        }
        if (LiveStockDetail.contains("eggsDuck")) {
            eggsduck = LiveStockDetail.getString("eggsDuck", "Data Not Found");
        }


        //===================================================================================
        FisheriseDetails = getSharedPreferences("FisheriseDetails", Context.MODE_PRIVATE);

        if (FisheriseDetails.contains("rui")) {
            ruhi = FisheriseDetails.getString("rui", "Data Not Found");
        }
        if (FisheriseDetails.contains("catla")) {
            catla = FisheriseDetails.getString("catla", "Data Not Found");
        }
        if (FisheriseDetails.contains("mixedFish")) {
            mixedfish = FisheriseDetails.getString("mixedFish", "Data Not Found");
        }
        if (FisheriseDetails.contains("pangas")) {
            pangas = FisheriseDetails.getString("pangas", "Data Not Found");
        }
        if (FisheriseDetails.contains("koi")) {
            koi = FisheriseDetails.getString("koi", "Data Not Found");
        }
        if (FisheriseDetails.contains("shing")) {
            magur = FisheriseDetails.getString("shing", "Data Not Found");
        }
        if (FisheriseDetails.contains("telapia")) {
            tilapia = FisheriseDetails.getString("telapia", "Data Not Found");
        }
        if (FisheriseDetails.contains("shrimp")) {
            shrimp = FisheriseDetails.getString("shrimp", "Data Not Found");
        }
        if (FisheriseDetails.contains("prawn")) {
            prawn = FisheriseDetails.getString("prawn", "Data Not Found");
        }
        if (FisheriseDetails.contains("others")) {
            others = FisheriseDetails.getString("others", "Data Not Found");
        }

        //===================================================================================
        isSync = "0";

        surveystatus = "draft";


        //===================================================================================
        //===================================================================================
        //===================================================================================


        //================= RecyclerView =====================

        recyclerViewS.setLayoutManager(new LinearLayoutManager(this));
        String[] title = getResources().getStringArray(R.array.title);
        MyAdapter adapterS = new MyAdapter(this, title);
        recyclerViewS.setAdapter(adapterS);

        //===================== RecyclerView =========================


        recyclerViewLoan.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewLoan.setLayoutManager(layoutManager);
        recyclerViewLoan.setItemAnimator(new DefaultItemAnimator());

        new LoadDataTask().execute();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void goToNextActivity(View view) {

        Repository repository = new Repository(getApplicationContext());

        FDEntity fdEntity = new FDEntity(date, facode, fauser, username, surveyID, holdingnumber, khananumber, lat, lng, kinnumber, division, district, upazila, union, postcode,
                village, ward, khanahead, telephoneNumber, khanatype, religion, ethnicity,
                ownlivingland, ownfarmingland, ownleasegiven, ownpond,
                owngarden, ownhill, ownother, ownlandTotal, otherlivingland, otherfarmingland, otherleasetaken, otherpond, othergarden,
                otherhill, otherlandother, otherlandTotal, isNotLandDivided, housetype, watersupply, sanitation, iselectricity, typeofelectricity,
                businesstype, businessname, businesssourcesoffinance, tradelicensemumber, tradelicensemumberimage, businessAddress, businessStartYear, businessStartMonth, businessStartDay,
                industryowner, typeofindustry, industsourcesoffinance, formofownership, ifricemilling, riceMillProductionCapacity, typeofricemilled, isricemilledOwn,
                interestedingovtfixedrate,
                iftruckbusiness, vehicletype, numberoftrucks, trucktotalcapacity, trucksourceoffinance, istruckowned, interestdrivingtrucksforgovt,
                interestofsecurities, incomefromhouseproperty, incomefromagricultural, capitalgain, incomefromaothersources,
                aush, aman, boro, wheat, maize, pulses, oilseeds, potato, tomato, vegetable, sugarcane, jute, farmingsellingtoGovtfixedprice,
                farmingsellingtoPrivatetraders,
                cattle, buffalo, sheep, goat, chicken, egghens, duck, eggsduck,
                ruhi, catla, mixedfish, pangas, koi, magur, tilapia, shrimp, prawn, others, isSync, surveystatus);
        repository.InsertTask(fdEntity);


        //===================== DELETE TABLE =====================
        repository.DeleteAllTaskMemberTemp();
        repository.DeleteAllLoanTemp();

        //==========================
        cleanSharedPreferences();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), BusinessDetailActivity.class);
        startActivity(intent);
    }

    public void addLoanDetails(View view) {
        Intent intent = new Intent(getApplicationContext(), FinanceSupportActivity.class);
        startActivity(intent);
    }

    class LoadDataTask extends AsyncTask<Void, Void, Void> {

        Repository repository;
        List<LoanTempEntity> loanTempEntityList;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            repository = new Repository(getApplicationContext());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            loanTempEntityList = repository.getLoanTemp();
            loanTempEntityArrayList = new ArrayList<>();

            for (int i = 0; i < loanTempEntityList.size(); i++) {
                loanTempEntityArrayList.add(loanTempEntityList.get(i));
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            loanAdapter = new LoanAdapter(LoanActivity.this, loanTempEntityArrayList);
            recyclerViewLoan.setAdapter(loanAdapter);
        }
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void cleanSharedPreferences() {

        SharedPreferences.Editor hn = HoldingNo.edit();
        hn.clear();
        hn.commit();

        SharedPreferences.Editor hd = HoldingAdd.edit();
        hd.clear();
        hd.commit();

        SharedPreferences.Editor kh = KhanaHead.edit();
        kh.clear();
        kh.commit();

        SharedPreferences.Editor rlgn = Religion.edit();
        rlgn.clear();
        rlgn.commit();

        SharedPreferences.Editor ownlnd = OwnLand.edit();
        ownlnd.clear();
        ownlnd.commit();

        SharedPreferences.Editor othlnd = OtherLand.edit();
        othlnd.clear();
        othlnd.commit();

        SharedPreferences.Editor lnd = Land.edit();
        lnd.clear();
        lnd.commit();

        SharedPreferences.Editor ht = HouseType.edit();
        ht.clear();
        ht.commit();

        SharedPreferences.Editor ws = waterSupply.edit();
        ws.clear();
        ws.commit();

        SharedPreferences.Editor snttn = Sanitation.edit();
        snttn.clear();
        snttn.commit();

        SharedPreferences.Editor elctcty = Electricity.edit();
        elctcty.clear();
        elctcty.commit();

        SharedPreferences.Editor bus = Business.edit();
        bus.clear();
        bus.commit();

        SharedPreferences.Editor id = IndustryDetails.edit();
        id.clear();
        id.commit();

        SharedPreferences.Editor rm = RiceMill.edit();
        rm.clear();
        rm.commit();

        SharedPreferences.Editor vb = VehicalBusiness.edit();
        vb.clear();
        vb.commit();

        SharedPreferences.Editor iOFs = InterestOfSecurity.edit();
        iOFs.clear();
        iOFs.commit();

        SharedPreferences.Editor frnd = FarmingDetails.edit();
        frnd.clear();
        frnd.commit();

        SharedPreferences.Editor lsd = LiveStockDetail.edit();
        lsd.clear();
        lsd.commit();

        SharedPreferences.Editor fshd = FisheriseDetails.edit();
        fshd.clear();
        fshd.commit();

    }
}