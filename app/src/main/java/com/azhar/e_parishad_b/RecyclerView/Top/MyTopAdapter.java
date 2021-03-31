package com.azhar.e_parishad_b.RecyclerView.Top;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.e_parishad_b.Activity.MainActivity;
import com.azhar.e_parishad_b.Database.Entity.FDEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.Database.SQLiteHelper;
import com.azhar.e_parishad_b.Networking.EPNET.DataObject.KhanaObject;
import com.azhar.e_parishad_b.Networking.EPNET.DataObject.LoanObject;
import com.azhar.e_parishad_b.Networking.EPNET.DataObject.MemberObject;
import com.azhar.e_parishad_b.Networking.EPNET.RFInterfece;
import com.azhar.e_parishad_b.Networking.EPNET.Response.ResponseObject;
import com.azhar.e_parishad_b.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyTopAdapter extends RecyclerView.Adapter<MyTopViewHolder> {


    KhanaObject khanaObject;
    MemberObject memberObject;
    LoanObject loanObject;
    ArrayList<MemberObject> memberObjectArrayList = new ArrayList<>();
    ArrayList<LoanObject> loanObjectArrayList = new ArrayList<>();
    String[] arrOfHousetype, arrOfWaterSupply, arrOfSanitation;
    String[] arrOfMemberVaccine, arrOfDisability, arrOfSocialSafetyNet, arrOfTraining;

    View successfulLayout, errorLayout;


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
            ruhi, catla, mixedfish, pangas, koi, magur, tilapia, shrimp, prawn, others, surveystatus;


    String membername, member_id, bloodgroup, fathername, mothername, gender, isHead, relationship, bdaydate,
            bdaymonth, bdayyear, age, birthcertificateno, birthcertificateimage, nationality, nid,
            nidimage, membervaccine, disability, ismothervaccination, nearesthospital, maternitynutritionconsultancy,
            consultingwith, iseligiblecouple, anyfamilyplaning, socialsafetynet, socialsafetynetcardinfo, socialsafetynetcardphoto,
            isTinAvaiable, tinNumber, tinimage, passportno, passportimage, isDrivingLicenceAvailable, drivingLicenceNumber,
            dirivinglicenseimage, higheshtEducation, doyoustudynow, whichLevel, educationinstitution, educationFinishingWant,
            training, primaryprofession, secondaryprofession, ifunemployednow, rickformofownership, ricksourcesoffinance,
            ricknooftransport, maritialstatus, marriageRegNo, marriageRegDate, divorceRegNo, divorceRegDate,
            incomefromMainOccuption, incomefromSecondOccuption, additionalincome, mobaileNumber, email,
            accountNo, mobaileNo, bankName, branchName, ismemberlivehere, mlivingAddress, memberimage;

    String loanName, loanInstitute, loanAmount, selectedYear,
            selectedMonth, selectedDay, loanPeriod, financialsupportfrom, isfinancialsupported;

    Context context;
    ArrayList<FDEntity> dataSet;

    public MyTopAdapter(Context context, ArrayList<FDEntity> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public MyTopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_child_layout, parent, false);
        successfulLayout = LayoutInflater.from(context).inflate(R.layout.successful_toast_layout, parent, false);
        errorLayout = LayoutInflater.from(context).inflate(R.layout.error_toast_layout, parent, false);

        MyTopViewHolder myTopViewHolder = new MyTopViewHolder(view);

        return myTopViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyTopViewHolder holder, int position) {


        TextView snTv = holder.snTv;
        snTv.setText(dataSet.get(position).id + "");

        TextView creationDateTv = holder.creationDateTv;
        creationDateTv.setText(dataSet.get(position).date + "");

        TextView surveyIDTv = holder.surveyIDTv;
        snTv.setText(dataSet.get(position).id + "");

        TextView statusTv = holder.statusTv;

        statusTv.setText(dataSet.get(position).id + "");

        TextView khanaHeadTv = holder.khanaHeadTv;
        khanaHeadTv.setText(dataSet.get(position).khanahead + "");

        TextView holdingNoTv = holder.holdingNoTv;
        holdingNoTv.setText(dataSet.get(position).holdingnumber + "");

        TextView khanaNoTv = holder.khanaNoTv;
        khanaNoTv.setText(dataSet.get(position).khananumber + "");

        TextView villageTv = holder.villageTv;
        villageTv.setText(dataSet.get(position).village + "");

        TextView wardTv = holder.wardTv;
        wardTv.setText(dataSet.get(position).ward + "");

        Button send = holder.send;

        TextView doneTv = holder.done;

        if (dataSet.get(position).isSync.equals("0")) {
            send.setVisibility(View.VISIBLE);
            doneTv.setVisibility(View.GONE);

            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    date = dataSet.get(position).date;
                    facode = dataSet.get(position).facode;
                    fauser = dataSet.get(position).fauser;
                    username = dataSet.get(position).username;
                    surveyID = dataSet.get(position).surveyID;
                    holdingnumber = dataSet.get(position).holdingnumber;
                    khananumber = dataSet.get(position).khananumber;
                    lat = dataSet.get(position).lat;
                    lng = dataSet.get(position).lng;
                    kinnumber = dataSet.get(position).kinnumber;
                    division = dataSet.get(position).division;
                    district = dataSet.get(position).district;
                    upazila = dataSet.get(position).upazila;
                    union = dataSet.get(position).union;
                    postcode = dataSet.get(position).postcode;
                    village = dataSet.get(position).village;
                    ward = dataSet.get(position).ward;
                    khanahead = dataSet.get(position).khanahead;
                    telephoneNumber = dataSet.get(position).telephoneNumber;
                    khanatype = dataSet.get(position).khanatype;
                    religion = dataSet.get(position).religion;
                    ethnicity = dataSet.get(position).ethnicity;
                    ownlivingland = dataSet.get(position).ownlivingland;
                    ownfarmingland = dataSet.get(position).ownfarmingland;
                    ownleasegiven = dataSet.get(position).ownleasegiven;
                    ownpond = dataSet.get(position).ownpond;
                    owngarden = dataSet.get(position).owngarden;
                    ownhill = dataSet.get(position).ownhill;
                    ownother = dataSet.get(position).ownother;
                    ownlandTotal = dataSet.get(position).ownlandTotal;
                    otherlivingland = dataSet.get(position).otherlivingland;
                    otherfarmingland = dataSet.get(position).otherfarmingland;
                    otherleasetaken = dataSet.get(position).otherleasetaken;
                    otherpond = dataSet.get(position).otherpond;
                    othergarden = dataSet.get(position).othergarden;
                    otherhill = dataSet.get(position).otherhill;
                    otherlandother = dataSet.get(position).otherlandother;
                    otherlandTotal = dataSet.get(position).otherlandTotal;
                    isNotLandDivided = dataSet.get(position).isNotLandDivided;
                    housetype = dataSet.get(position).housetype;
                    watersupply = dataSet.get(position).watersupply;
                    sanitation = dataSet.get(position).sanitation;
                    iselectricity = dataSet.get(position).iselectricity;
                    typeofelectricity = dataSet.get(position).typeofelectricity;
                    businesstype = dataSet.get(position).businesstype;
                    businessname = dataSet.get(position).businessname;
                    businesssourcesoffinance = dataSet.get(position).businesssourcesoffinance;
                    tradelicensemumber = dataSet.get(position).tradelicensemumber;
                    tradelicensemumberimage = dataSet.get(position).tradelicensemumberimage;
                    businessAddress = dataSet.get(position).businessAddress;
                    businessStartYear = dataSet.get(position).businessStartYear;
                    businessStartMonth = dataSet.get(position).businessStartMonth;
                    businessStartDay = dataSet.get(position).businessStartDay;
                    industryowner = dataSet.get(position).industryowner;
                    typeofindustry = dataSet.get(position).typeofindustry;
                    industsourcesoffinance = dataSet.get(position).industsourcesoffinance;
                    formofownership = dataSet.get(position).formofownership;
                    ifricemilling = dataSet.get(position).ifricemilling;
                    riceMillProductionCapacity = dataSet.get(position).riceMillProductionCapacity;
                    typeofricemilled = dataSet.get(position).typeofricemilled;
                    isricemilledOwn = dataSet.get(position).isricemilledOwn;
                    interestedingovtfixedrate = dataSet.get(position).interestedingovtfixedrate;
                    iftruckbusiness = dataSet.get(position).iftruckbusiness;
                    vehicletype = dataSet.get(position).vehicletype;
                    numberoftrucks = dataSet.get(position).numberoftrucks;
                    trucktotalcapacity = dataSet.get(position).trucktotalcapacity;
                    trucksourceoffinance = dataSet.get(position).trucksourceoffinance;
                    istruckowned = dataSet.get(position).istruckowned;
                    interestdrivingtrucksforgovt = dataSet.get(position).interestdrivingtrucksforgovt;
                    interestofsecurities = dataSet.get(position).interestofsecurities;
                    incomefromhouseproperty = dataSet.get(position).incomefromhouseproperty;
                    incomefromagricultural = dataSet.get(position).incomefromagricultural;
                    capitalgain = dataSet.get(position).capitalgain;
                    incomefromaothersources = dataSet.get(position).incomefromaothersources;
                    aush = dataSet.get(position).aush;
                    aman = dataSet.get(position).aman;
                    boro = dataSet.get(position).boro;
                    wheat = dataSet.get(position).wheat;
                    maize = dataSet.get(position).maize;
                    pulses = dataSet.get(position).pulses;
                    oilseeds = dataSet.get(position).oilseeds;
                    potato = dataSet.get(position).potato;
                    tomato = dataSet.get(position).tomato;
                    vegetable = dataSet.get(position).vegetable;
                    sugarcane = dataSet.get(position).sugarcane;
                    jute = dataSet.get(position).jute;
                    farmingsellingtoGovtfixedprice = dataSet.get(position).farmingsellingtoGovtfixedprice;
                    farmingsellingtoPrivatetraders = dataSet.get(position).farmingsellingtoPrivatetraders;
                    cattle = dataSet.get(position).cattle;
                    buffalo = dataSet.get(position).buffalo;
                    sheep = dataSet.get(position).sheep;
                    goat = dataSet.get(position).goat;
                    chicken = dataSet.get(position).chicken;
                    egghens = dataSet.get(position).egghens;
                    duck = dataSet.get(position).duck;
                    eggsduck = dataSet.get(position).eggsduck;
                    ruhi = dataSet.get(position).ruhi;
                    catla = dataSet.get(position).catla;
                    mixedfish = dataSet.get(position).mixedfish;
                    pangas = dataSet.get(position).pangas;
                    koi = dataSet.get(position).koi;
                    magur = dataSet.get(position).magur;
                    tilapia = dataSet.get(position).tilapia;
                    shrimp = dataSet.get(position).shrimp;
                    prawn = dataSet.get(position).prawn;
                    others = dataSet.get(position).others;
                    surveystatus = dataSet.get(position).surveystatus;


                    ///==================== SQLITE===============

                    SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
                    SQLiteDatabase sqLiteDatabase = sqLiteHelper.getReadableDatabase();
                    System.out.println(kinnumber);


                    Cursor cursor = sqLiteHelper.displayAllData(kinnumber);

                    if (cursor.getCount() == 0) {
                        Toast.makeText(context, "No DATA", Toast.LENGTH_LONG).show();
                        return;
                    }

                    System.out.println("Cursor print: " + cursor.getCount());

                    if (cursor.getCount() > 0) {
                        while (cursor.moveToNext()) {
                            membername = cursor.getString(1);
                            System.out.println("in: " + membername);
                            member_id = cursor.getString(2);
                            bloodgroup = cursor.getString(3);
                            fathername = cursor.getString(4);
                            mothername = cursor.getString(5);
                            gender = cursor.getString(6);
                            isHead = cursor.getString(7);
                            relationship = cursor.getString(8);
                            bdaydate = cursor.getString(9);
                            bdaymonth = cursor.getString(10);
                            bdayyear = cursor.getString(11);
                            age = cursor.getString(12);
                            birthcertificateno = cursor.getString(13);
                            birthcertificateimage = cursor.getString(14);
                            nationality = cursor.getString(15);
                            nid = cursor.getString(16);
                            nidimage = cursor.getString(17);
                            membervaccine = cursor.getString(18);
                            disability = cursor.getString(19);
                            ismothervaccination = cursor.getString(20);
                            nearesthospital = cursor.getString(21);
                            maternitynutritionconsultancy = cursor.getString(22);
                            consultingwith = cursor.getString(23);
                            iseligiblecouple = cursor.getString(24);
                            anyfamilyplaning = cursor.getString(25);
                            socialsafetynet = cursor.getString(26);
                            socialsafetynetcardinfo = cursor.getString(27);
                            socialsafetynetcardphoto = cursor.getString(28);
                            isTinAvaiable = cursor.getString(29);
                            tinNumber = cursor.getString(30);
                            tinimage = cursor.getString(31);
                            passportno = cursor.getString(32);
                            passportimage = cursor.getString(33);
                            isDrivingLicenceAvailable = cursor.getString(34);
                            drivingLicenceNumber = cursor.getString(35);
                            dirivinglicenseimage = cursor.getString(36);
                            higheshtEducation = cursor.getString(37);
                            doyoustudynow = cursor.getString(38);
                            whichLevel = cursor.getString(39);
                            educationinstitution = cursor.getString(40);
                            educationFinishingWant = cursor.getString(41);
                            training = cursor.getString(42);
                            primaryprofession = cursor.getString(43);
                            secondaryprofession = cursor.getString(44);
                            ifunemployednow = cursor.getString(45);
                            rickformofownership = cursor.getString(46);
                            ricksourcesoffinance = cursor.getString(47);
                            ricknooftransport = cursor.getString(48);
                            maritialstatus = cursor.getString(49);
                            marriageRegNo = cursor.getString(50);
                            marriageRegDate = cursor.getString(51);
                            divorceRegNo = cursor.getString(52);
                            divorceRegDate = cursor.getString(53);
                            incomefromMainOccuption = cursor.getString(54);
                            incomefromSecondOccuption = cursor.getString(55);
                            additionalincome = cursor.getString(56);
                            mobaileNumber = cursor.getString(57);
                            email = cursor.getString(58);
                            accountNo = cursor.getString(59);
                            mobaileNo = cursor.getString(60);
                            bankName = cursor.getString(61);
                            branchName = cursor.getString(62);
                            ismemberlivehere = cursor.getString(63);
                            mlivingAddress = cursor.getString(64);
                            memberimage = cursor.getString(65);

                            memberObject = new MemberObject(membername, member_id, bloodgroup, fathername, mothername, gender, isHead, relationship, bdaydate,
                                    bdaymonth, bdayyear, age, birthcertificateno, birthcertificateimage, nationality, nid,
                                    nidimage, arrOfMemberVaccine, arrOfDisability, ismothervaccination, nearesthospital, maternitynutritionconsultancy,
                                    consultingwith, iseligiblecouple, anyfamilyplaning, arrOfSocialSafetyNet, socialsafetynetcardinfo, socialsafetynetcardphoto,
                                    isTinAvaiable, tinNumber, tinimage, passportno, passportimage, isDrivingLicenceAvailable, drivingLicenceNumber,
                                    dirivinglicenseimage, higheshtEducation, doyoustudynow, whichLevel, educationinstitution, educationFinishingWant,
                                    arrOfTraining, primaryprofession, secondaryprofession, ifunemployednow, rickformofownership, ricksourcesoffinance,
                                    ricknooftransport, maritialstatus, marriageRegNo, marriageRegDate, divorceRegNo, divorceRegDate,
                                    incomefromMainOccuption, incomefromSecondOccuption, additionalincome, mobaileNumber, email,
                                    accountNo, mobaileNo, bankName, branchName, ismemberlivehere, mlivingAddress, memberimage);


                            memberObjectArrayList.add(memberObject);
                        }

                    }


                    Cursor cursor1 = sqLiteHelper.loanData(kinnumber);
                    if (cursor.getCount() == 0) {
                        Toast.makeText(context, "No DATA", Toast.LENGTH_LONG).show();
                        return;
                    }

                    System.out.println(cursor1.getCount());

                    if (cursor1.getCount() > 0) {
                        while (cursor1.moveToNext()) {
                            loanName = cursor1.getString(1);
                            isfinancialsupported = cursor1.getString(2);
                            financialsupportfrom = cursor1.getString(3);
                            loanInstitute = cursor1.getString(4);
                            loanAmount = cursor1.getString(5);
                            loanPeriod = cursor1.getString(6);
                            selectedYear = cursor1.getString(7);
                            selectedMonth = cursor1.getString(8);
                            selectedDay = cursor1.getString(9);

                            loanObject = new LoanObject(loanName, loanInstitute, loanAmount, selectedYear,
                                    selectedMonth, selectedDay, loanPeriod, financialsupportfrom, isfinancialsupported);
                            loanObjectArrayList.add(loanObject);

                        }

                    }

                    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://103.147.182.110:5030")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    RFInterfece rfInterfece = retrofit.create(RFInterfece.class);

                    if (housetype == null) {
                        arrOfHousetype = new String[0];
                    } else {
                        arrOfHousetype = housetype.split(",");
                    }

                    if (watersupply == null) {
                        arrOfWaterSupply = new String[0];
                    } else {
                        arrOfWaterSupply = watersupply.split(",");
                    }

                    if (sanitation == null) {
                        arrOfSanitation = new String[0];
                    } else {
                        arrOfSanitation = sanitation.split(",");
                    }


//                System.out.println(Arrays.toString(arrOfHousetype));
//                System.out.println(Arrays.asList(arrOfHousetype));

                    if (membervaccine == null) {
                        arrOfMemberVaccine = new String[0];
                    } else {
                        arrOfMemberVaccine = membervaccine.split(",");
                    }

                    if (disability == null) {
                        arrOfDisability = new String[0];
                    } else {
                        arrOfDisability = disability.split(",");
                    }

                    if (socialsafetynet == null) {
                        arrOfSocialSafetyNet = new String[0];
                    } else {
                        arrOfSocialSafetyNet = socialsafetynet.split(",");
                    }

                    if (training == null) {
                        arrOfTraining = new String[0];
                    } else {
                        arrOfTraining = training.split(",");
                    }


                    System.out.println(memberObjectArrayList.size());


                    khanaObject = new KhanaObject(date, facode, fauser, username, surveyID, holdingnumber, khananumber, lat, lng, kinnumber, division, district, upazila, union, postcode,
                            village, ward, khanahead, telephoneNumber, khanatype, religion, ethnicity,
                            ownlivingland, ownfarmingland, ownleasegiven, ownpond,
                            owngarden, ownhill, ownother, ownlandTotal, otherlivingland, otherfarmingland, otherleasetaken, otherpond, othergarden,
                            otherhill, otherlandother, otherlandTotal, isNotLandDivided, arrOfHousetype, arrOfWaterSupply, arrOfSanitation, iselectricity, typeofelectricity,
                            businesstype, businessname, businesssourcesoffinance, tradelicensemumber, tradelicensemumberimage, businessAddress, businessStartYear, businessStartMonth, businessStartDay,
                            industryowner, typeofindustry, industsourcesoffinance, formofownership, ifricemilling, riceMillProductionCapacity, typeofricemilled, isricemilledOwn,
                            interestedingovtfixedrate,
                            iftruckbusiness, vehicletype, numberoftrucks, trucktotalcapacity, trucksourceoffinance, istruckowned, interestdrivingtrucksforgovt,
                            interestofsecurities, incomefromhouseproperty, incomefromagricultural, capitalgain, incomefromaothersources,
                            aush, aman, boro, wheat, maize, pulses, oilseeds, potato, tomato, vegetable, sugarcane, jute, farmingsellingtoGovtfixedprice,
                            farmingsellingtoPrivatetraders,
                            cattle, buffalo, sheep, goat, chicken, egghens, duck, eggsduck,
                            ruhi, catla, mixedfish, pangas, koi, magur, tilapia, shrimp, prawn, others, surveystatus, memberObjectArrayList, loanObjectArrayList);


                    Call<ResponseObject> call = rfInterfece.PostData(khanaObject);

                    call.enqueue(new Callback<ResponseObject>() {
                        @Override
                        public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {

//                        Toast.makeText(context, "Successful", Toast.LENGTH_LONG).show();

                            //Creating the Toast object
                            Toast toast = new Toast(context);
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                            toast.setView(successfulLayout);//setting the view of custom toast layout
                            toast.show();

                            Repository repository = new Repository(context);
                            repository.UpdateIsSync(dataSet.get(position).id);

                            memberObjectArrayList.clear();
                            loanObjectArrayList.clear();
                            System.out.println(response);

                            Intent intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<ResponseObject> call, Throwable t) {
//                        Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
                            //Creating the Toast object
                            Toast toast = new Toast(context);
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                            toast.setView(errorLayout);//setting the view of custom toast layout
                            toast.show();

                        }
                    });

                }

            });
        } else {
            send.setVisibility(View.GONE);
            doneTv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
