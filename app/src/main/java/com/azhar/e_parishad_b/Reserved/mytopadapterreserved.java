package com.azhar.e_parishad_b.Reserved;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.e_parishad_b.Database.Entity.FDEntity;
import com.azhar.e_parishad_b.Database.Entity.Member.MNEntity;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.Top.MyTopViewHolder;

import java.util.ArrayList;
import java.util.HashMap;

public class mytopadapterreserved extends RecyclerView.Adapter<MyTopViewHolder> {

    String date, facode, fauser, username, holdingnumber, khananumber, lat, lng, kinnumber, division, district, upazila, union, postcode,
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
            ruhi, catla, mixedfish, pangas, koi, magur, tilapia, shrimp, prawn, others;

    String name, member_id, bloodgroup, fathername, mothername, gender, isHead, bdaydate,
            bdaymonth, bdayyear, age, birthcertificateno, birthcertificateimage, nationality, nid,
            nidimage, membervaccine, disability, ismothervaccination, nearesthospital, maternitynutritionconsultancy,
            consultingwith, iseligiblecouple, anyfamilyplaning, socialsafetynet, socialsafetynetcardinfo, socialsafetynetcardphoto,
            isTinAvaiable, tinNumber, tinimage, passportno, passportimage, isDrivingLicenceAvailable, drivingLicenceNumber,
            dirivinglicenseimage, higheshtEducation, doyoustudynow, whichLevel, educationinstitution, educationFinishingWant,
            training, primaryprofession, secondaryprofession, ifunemployednow, rickformofownership, ricksourcesoffinance,
            ricknooftransport, maritialstatus, marriageRegNo, marriageRegDate, divorceRegNo, divorceRegDate,
            incomefromMainOccuption, incomefromSecondOccuption, additionalincome, mobaileNumber, email,
            accountNo, mobaileNo, bankName, branchName, ismemberlivehere, mlivingAddress, memberimage;

    ArrayList<HashMap<String, String>> memberarray = new ArrayList<HashMap<String, String>>();

    Context context;
    ArrayList<FDEntity> dataSet;
    ArrayList<MNEntity> dataSetMn;
    String x;

    String [] kinnumbera = {kinnumber};

    public mytopadapterreserved(Context context, ArrayList<FDEntity> dataSet, String x) {
        this.context = context;
        this.dataSet = dataSet;
    }

    public mytopadapterreserved(Context context, ArrayList<MNEntity> dataSetMn) {
        this.context = context;
        this.dataSetMn = dataSetMn;
    }

    //    public MyTopAdapter(ArrayList<MNEntity> dataSetMn) {
//        this.dataSetMn = dataSetMn;
//    }
//
//    String [] FDArray = (String[]) dataSet.toArray();
//    String [] MNArray = (String[]) dataSetMn.toArray();

    @NonNull
    @Override
    public MyTopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_child_layout, parent, false);

        MyTopViewHolder myTopViewHolder = new MyTopViewHolder(view);

        return myTopViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyTopViewHolder holder, int position) {

//        TextView snTv = holder.snTv;
//        snTv.setText(dataSet.get(position).id + "");
//
//        TextView creationDateTv = holder.creationDateTv;
//        creationDateTv.setText(dataSet.get(position).date + "");
//
//        TextView surveyIDTv = holder.surveyIDTv;
//        snTv.setText(dataSet.get(position).id + "");
//
//        TextView statusTv = holder.statusTv;
//
//        statusTv.setText(dataSet.get(position).id + "");
//
//        TextView khanaHeadTv = holder.khanaHeadTv;
//        khanaHeadTv.setText(dataSet.get(position).khanahead + "");
//
//        TextView holdingNoTv = holder.holdingNoTv;
//        holdingNoTv.setText(dataSet.get(position).holdingnumber + "");
//
//        TextView khanaNoTv = holder.khanaNoTv;
//        khanaNoTv.setText(dataSet.get(position).khananumber + "");
//
//        TextView villageTv = holder.villageTv;
//        villageTv.setText(dataSet.get(position).village + "");
//
//        TextView wardTv = holder.wardTv;
//        wardTv.setText(dataSet.get(position).ward + "");
//
//        TextView syncTv = holder.syncTv;
//        syncTv.setText(dataSet.get(position).id + "");
//
//        Button send = holder.send;
//        send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                date = dataSet.get(position).date;
//                facode = dataSet.get(position).facode;
//                fauser = dataSet.get(position).fauser;
//                username = dataSet.get(position).username;
//                holdingnumber = dataSet.get(position).holdingnumber;
//                khananumber = dataSet.get(position).khananumber;
//                lat = dataSet.get(position).lat;
//                lng = dataSet.get(position).lng;
//                kinnumber = dataSet.get(position).kinnumber;
//
//                division = dataSet.get(position).division;
//                district = dataSet.get(position).district;
//                upazila = dataSet.get(position).upazila;
//                union = dataSet.get(position).union;
//                postcode = dataSet.get(position).postcode;
//                village = dataSet.get(position).village;
//                ward = dataSet.get(position).ward;
//                khanahead = dataSet.get(position).khanahead;
//                telephoneNumber = dataSet.get(position).telephoneNumber;
//                khanatype = dataSet.get(position).khanatype;
//                religion = dataSet.get(position).religion;
//                ethnicity = dataSet.get(position).ethnicity;
//                ownlivingland = dataSet.get(position).ownlivingland;
//                ownfarmingland = dataSet.get(position).ownfarmingland;
//                ownleasegiven = dataSet.get(position).ownleasegiven;
//                ownpond = dataSet.get(position).ownpond;
//                owngarden = dataSet.get(position).owngarden;
//                ownhill = dataSet.get(position).ownhill;
//                ownother = dataSet.get(position).ownother;
//                ownlandTotal = dataSet.get(position).ownlandTotal;
//                otherlivingland = dataSet.get(position).otherlivingland;
//                otherfarmingland = dataSet.get(position).otherfarmingland;
//                otherleasetaken = dataSet.get(position).otherleasetaken;
//                otherpond = dataSet.get(position).otherpond;
//                othergarden = dataSet.get(position).othergarden;
//                otherhill = dataSet.get(position).otherhill;
//                otherlandother = dataSet.get(position).otherlandother;
//                otherlandTotal = dataSet.get(position).otherlandTotal;
//                isNotLandDivided = dataSet.get(position).isNotLandDivided;
//                housetype = dataSet.get(position).housetype;
//                watersupply = dataSet.get(position).watersupply;
//                sanitation = dataSet.get(position).sanitation;
//                iselectricity = dataSet.get(position).iselectricity;
//                typeofelectricity = dataSet.get(position).typeofelectricity;
//                businesstype = dataSet.get(position).businesstype;
//                businessname = dataSet.get(position).businessname;
//                businesssourcesoffinance = dataSet.get(position).businesssourcesoffinance;
//                tradelicensemumber = dataSet.get(position).tradelicensemumber;
//                tradelicensemumberimage = dataSet.get(position).tradelicensemumberimage;
//                businessAddress = dataSet.get(position).businessAddress;
//                businessStartYear = dataSet.get(position).businessStartYear;
//                businessStartMonth = dataSet.get(position).businessStartMonth;
//                businessStartDay = dataSet.get(position).businessStartDay;
//                industryowner = dataSet.get(position).industryowner;
//                typeofindustry = dataSet.get(position).typeofindustry;
//                industsourcesoffinance = dataSet.get(position).industsourcesoffinance;
//                formofownership = dataSet.get(position).formofownership;
//                ifricemilling = dataSet.get(position).ifricemilling;
//                riceMillProductionCapacity = dataSet.get(position).riceMillProductionCapacity;
//                typeofricemilled = dataSet.get(position).typeofricemilled;
//                isricemilledOwn = dataSet.get(position).isricemilledOwn;
//                interestedingovtfixedrate = dataSet.get(position).interestedingovtfixedrate;
//                iftruckbusiness = dataSet.get(position).iftruckbusiness;
//                vehicletype = dataSet.get(position).vehicletype;
//                numberoftrucks = dataSet.get(position).numberoftrucks;
//                trucktotalcapacity = dataSet.get(position).trucktotalcapacity;
//                trucksourceoffinance = dataSet.get(position).trucksourceoffinance;
//                istruckowned = dataSet.get(position).istruckowned;
//                interestdrivingtrucksforgovt = dataSet.get(position).interestdrivingtrucksforgovt;
//                interestofsecurities = dataSet.get(position).interestofsecurities;
//                incomefromhouseproperty = dataSet.get(position).incomefromhouseproperty;
//                incomefromagricultural = dataSet.get(position).incomefromagricultural;
//                capitalgain = dataSet.get(position).capitalgain;
//                incomefromaothersources = dataSet.get(position).incomefromaothersources;
//                aush = dataSet.get(position).aush;
//                aman = dataSet.get(position).aman;
//                boro = dataSet.get(position).boro;
//                wheat = dataSet.get(position).wheat;
//                maize = dataSet.get(position).maize;
//                pulses = dataSet.get(position).pulses;
//                oilseeds = dataSet.get(position).oilseeds;
//                potato = dataSet.get(position).potato;
//                tomato = dataSet.get(position).tomato;
//                vegetable = dataSet.get(position).vegetable;
//                sugarcane = dataSet.get(position).sugarcane;
//                jute = dataSet.get(position).jute;
//                farmingsellingtoGovtfixedprice = dataSet.get(position).farmingsellingtoGovtfixedprice;
//                farmingsellingtoPrivatetraders = dataSet.get(position).farmingsellingtoPrivatetraders;
//                cattle = dataSet.get(position).cattle;
//                buffalo = dataSet.get(position).buffalo;
//                sheep = dataSet.get(position).sheep;
//                goat = dataSet.get(position).goat;
//                chicken = dataSet.get(position).chicken;
//                egghens = dataSet.get(position).egghens;
//                duck = dataSet.get(position).duck;
//                eggsduck = dataSet.get(position).eggsduck;
//                ruhi = dataSet.get(position).ruhi;
//                catla = dataSet.get(position).catla;
//                mixedfish = dataSet.get(position).mixedfish;
//                pangas = dataSet.get(position).pangas;
//                koi = dataSet.get(position).koi;
//                magur = dataSet.get(position).magur;
//                tilapia = dataSet.get(position).tilapia;
//                shrimp = dataSet.get(position).shrimp;
//                prawn = dataSet.get(position).prawn;
//                others = dataSet.get(position).others;
//
//
//                ///==================== SQLITE===============
//
//                SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
//                SQLiteDatabase sqLiteDatabase = sqLiteHelper.getReadableDatabase();
//                System.out.println(kinnumber);
//                sqLiteHelper.test(kinnumber);
//
//                System.out.println("kinnumbera"+ kinnumbera);
//
//                Cursor cursor = sqLiteHelper.displayAllData(kinnumber);
////               Cursor cursor = sqLiteHelper.test(kinnumber);
//
//                if (cursor.getCount() == 0) {
//                    Toast.makeText(context, "No DATA", Toast.LENGTH_LONG).show();
//                    return;
//                }
//                StringBuffer stringBuffer = new StringBuffer();
//                System.out.println(cursor.getCount());
//                while(cursor.moveToNext()){
//                    System.out.println("in the while");
//                    name = cursor.getString(1);
//                    System.out.println(name);
//                    member_id = cursor.getString(2);
//                    bloodgroup = cursor.getString(3);
//                    fathername = cursor.getString(4);
//                    mothername = cursor.getString(5);
//                    gender = cursor.getString(6);
//                    isHead = cursor.getString(7);
//                    bdaydate = cursor.getString(8);
//                    bdaymonth = cursor.getString(9);
//                    bdayyear = cursor.getString(10);
//                    age = cursor.getString(11);
//                    birthcertificateno = cursor.getString(12);
//                    birthcertificateimage = cursor.getString(13);
//                    nationality = cursor.getString(14);
//                    nid = cursor.getString(15);
//                    nidimage = cursor.getString(16);
//                    membervaccine = cursor.getString(16);
//                    disability = cursor.getString(18);
//                    ismothervaccination = cursor.getString(19);
//                    nearesthospital = cursor.getString(20);
//                    maternitynutritionconsultancy = cursor.getString(21);
//                    consultingwith = cursor.getString(22);
//                    iseligiblecouple = cursor.getString(23);
//                    anyfamilyplaning = cursor.getString(24);
//                    socialsafetynet = cursor.getString(25);
//                    socialsafetynetcardinfo = cursor.getString(26);
//                    socialsafetynetcardphoto = cursor.getString(27);
//                    isTinAvaiable = cursor.getString(28);
//                    tinNumber = cursor.getString(29);
//                    tinimage = cursor.getString(30);
//                    passportno = cursor.getString(31);
//                    passportimage = cursor.getString(32);
//                    isDrivingLicenceAvailable = cursor.getString(33);
//                    drivingLicenceNumber = cursor.getString(34);
//                    dirivinglicenseimage = cursor.getString(35);
//                    higheshtEducation = cursor.getString(36);
//                    doyoustudynow = cursor.getString(37);
//                    whichLevel = cursor.getString(38);
//                    educationinstitution = cursor.getString(39);
//                    educationFinishingWant = cursor.getString(40);
//                    training = cursor.getString(41);
//                    primaryprofession = cursor.getString(42);
//                    secondaryprofession = cursor.getString(43);
//                    ifunemployednow = cursor.getString(44);
//                    rickformofownership = cursor.getString(45);
//                    ricksourcesoffinance = cursor.getString(46);
//                    ricknooftransport = cursor.getString(47);
//                    maritialstatus = cursor.getString(48);
//                    marriageRegNo = cursor.getString(49);
//                    marriageRegDate = cursor.getString(50);
//                    divorceRegNo = cursor.getString(51);
//                    divorceRegDate = cursor.getString(52);
//                    incomefromMainOccuption = cursor.getString(53);
//                    incomefromSecondOccuption = cursor.getString(54);
//                    additionalincome = cursor.getString(55);
//                    mobaileNumber = cursor.getString(56);
//                    email = cursor.getString(57);
//                    accountNo = cursor.getString(58);
//                    mobaileNo = cursor.getString(59);
//                    bankName = cursor.getString(60);
//                    branchName = cursor.getString(61);
//                    ismemberlivehere = cursor.getString(62);
//                    mlivingAddress = cursor.getString(63);
//                    memberimage = cursor.getString(64);
//                }

//                while (cursor.moveToNext()) {
//////                    stringBuffer.append("ID: " + cursor.getString(1) + "\n");
//////                    stringBuffer.append("Data: " + cursor.getString(1) + "\n");
//////                    stringBuffer.append("Data: " + cursor.getString(2) + "\n");
//////                    stringBuffer.append("Data: " + cursor.getString(3) + "\n");
//////                    stringBuffer.append("Data: " + cursor.getString(4) + "\n");
//////                    stringBuffer.append("Data: " + cursor.getString(5) + "\n");
//////                    stringBuffer.append("Data: " + cursor.getString(6) + "\n");
//////                    stringBuffer.append("Data: " + cursor.getString(7) + "\n");
//////                    stringBuffer.append("Data: " + cursor.getString(8) + "\n");
//////                    stringBuffer.append("Data: " + cursor.getString(9) + "\n");
//////                    stringBuffer.append("Data: " + cursor.getString(10) + "\n");
//////                    stringBuffer.append("Data: " + cursor.getString(111) + "\n");
//////                    stringBuffer.append("Data: " + cursor.getString(115) + "\n");
//////                    stringBuffer.append("Data: " + cursor.getString(125) + "\n");
//////                    stringBuffer.append("Data: " + cursor.getString(135) + "\n");
//
//                    name = cursor.getString(109);
//                    member_id = cursor.getString(110);
//                    bloodgroup = cursor.getString(111);
//                    fathername = cursor.getString(112);
//                    mothername = cursor.getString(113);
//                    gender = cursor.getString(114);
//                    isHead = cursor.getString(115);
//                    bdaydate = cursor.getString(116);
//                    bdaymonth = cursor.getString(117);
//                    bdayyear = cursor.getString(118);
//                    age = cursor.getString(119);
//                    birthcertificateno = cursor.getString(120);
//                    birthcertificateimage = cursor.getString(121);
//                    nationality = cursor.getString(122);
//                    nid = cursor.getString(123);
//                    nidimage = cursor.getString(124);
//                    membervaccine = cursor.getString(125);
//                    disability = cursor.getString(126);
//                    ismothervaccination = cursor.getString(127);
//                    nearesthospital = cursor.getString(128);
//                    maternitynutritionconsultancy = cursor.getString(129);
//                    consultingwith = cursor.getString(130);
//                    iseligiblecouple = cursor.getString(131);
//                    anyfamilyplaning = cursor.getString(132);
//                    socialsafetynet = cursor.getString(133);
//                    socialsafetynetcardinfo = cursor.getString(134);
//                    socialsafetynetcardphoto = cursor.getString(135);
//                    isTinAvaiable = cursor.getString(136);
//                    tinNumber = cursor.getString(137);
//                    tinimage = cursor.getString(138);
//                    passportno = cursor.getString(139);
//                    passportimage = cursor.getString(140);
//                    isDrivingLicenceAvailable = cursor.getString(141);
//                    drivingLicenceNumber = cursor.getString(142);
//                    dirivinglicenseimage = cursor.getString(143);
//                    higheshtEducation = cursor.getString(144);
//                    doyoustudynow = cursor.getString(145);
//                    whichLevel = cursor.getString(146);
//                    educationinstitution = cursor.getString(147);
//                    educationFinishingWant = cursor.getString(148);
//                    training = cursor.getString(149);
//                    primaryprofession = cursor.getString(150);
//                    secondaryprofession = cursor.getString(151);
//                    ifunemployednow = cursor.getString(152);
//                    rickformofownership = cursor.getString(153);
//                    ricksourcesoffinance = cursor.getString(154);
//                    ricknooftransport = cursor.getString(155);
//                    maritialstatus = cursor.getString(156);
//                    marriageRegNo = cursor.getString(157);
//                    marriageRegDate = cursor.getString(158);
//                    divorceRegNo = cursor.getString(159);
//                    divorceRegDate = cursor.getString(160);
//                    incomefromMainOccuption = cursor.getString(161);
//                    incomefromSecondOccuption = cursor.getString(162);
//                    additionalincome = cursor.getString(163);
//                    mobaileNumber = cursor.getString(164);
//                    email = cursor.getString(165);
//                    accountNo = cursor.getString(166);
//                    mobaileNo = cursor.getString(167);
//                    bankName = cursor.getString(168);
//                    branchName = cursor.getString(169);
//                    ismemberlivehere = cursor.getString(170);
//                    mlivingAddress = cursor.getString(171);
//                    memberimage = cursor.getString(172);
//                }


//                for (int i = 0; i<dataSet.size(); i++){
//                    String kin = dataSet.get(position).kinnumber;
//                    System.out.println(kin);
//                    System.out.println("inner");
//                    System.out.println("Dataset mn length");
//                    System.out.println(dataSetMn);


//                    for (int j = 0; j<dataSetMn.size(); j++){
//
//                        if (kin == dataSetMn.get(position).kinnumber){

//                            name = dataSetMn.get(position).name;
//                            System.out.println(name);
//                            member_id = dataSetMn.get(position).member_id;
//                            bloodgroup = dataSetMn.get(position).bloodgroup;
//                            fathername = dataSetMn.get(position).fathername;
//                            mothername = dataSetMn.get(position).mothername;
//                            gender = dataSetMn.get(position).gender;
//                            isHead = dataSetMn.get(position).isHead;
//                            bdaydate = dataSetMn.get(position).bdaydate;
//                            bdaymonth = dataSetMn.get(position).bdaymonth;
//                            bdayyear = dataSetMn.get(position).bdayyear;
//                            age = dataSetMn.get(position).age;
//                            birthcertificateno = dataSetMn.get(position).birthcertificateno;
//                            birthcertificateimage = dataSetMn.get(position).birthcertificateimage;
//                            nationality = dataSetMn.get(position).nationality;
//                            nid = dataSetMn.get(position).nid;
//                            nidimage = dataSetMn.get(position).nidimage;
//                            membervaccine = dataSetMn.get(position).membervaccine;
//                            disability = dataSetMn.get(position).disability;
//                            ismothervaccination = dataSetMn.get(position).ismothervaccination;
//                            nearesthospital = dataSetMn.get(position).nearesthospital;
//                            maternitynutritionconsultancy = dataSetMn.get(position).maternitynutritionconsultancy;
//                            consultingwith = dataSetMn.get(position).consultingwith;
//                            iseligiblecouple = dataSetMn.get(position).iseligiblecouple;
//                            anyfamilyplaning = dataSetMn.get(position).anyfamilyplaning;
//                            socialsafetynet = dataSetMn.get(position).socialsafetynet;
//                            socialsafetynetcardinfo = dataSetMn.get(position).socialsafetynetcardinfo;
//                            socialsafetynetcardphoto = dataSetMn.get(position).socialsafetynetcardphoto;
//                            isTinAvaiable = dataSetMn.get(position).isTinAvaiable;
//                            tinNumber = dataSetMn.get(position).tinNumber;
//                            tinimage = dataSetMn.get(position).tinimage;
//                            passportno = dataSetMn.get(position).passportno;
//                            passportimage = dataSetMn.get(position).passportimage;
//                            isDrivingLicenceAvailable = dataSetMn.get(position).isDrivingLicenceAvailable;
//                            drivingLicenceNumber = dataSetMn.get(position).drivingLicenceNumber;
//                            dirivinglicenseimage = dataSetMn.get(position).dirivinglicenseimage;
//                            higheshtEducation = dataSetMn.get(position).higheshtEducation;
//                            doyoustudynow = dataSetMn.get(position).doyoustudynow;
//                            whichLevel = dataSetMn.get(position).whichLevel;
//                            educationinstitution = dataSetMn.get(position).educationinstitution;
//                            educationFinishingWant = dataSetMn.get(position).educationFinishingWant;
//                            training = dataSetMn.get(position).training;
//                            primaryprofession = dataSetMn.get(position).primaryprofession;
//                            secondaryprofession = dataSetMn.get(position).secondaryprofession;
//                            ifunemployednow = dataSetMn.get(position).ifunemployednow;
//                            rickformofownership = dataSetMn.get(position).rickformofownership;
//                            ricksourcesoffinance = dataSetMn.get(position).ricksourcesoffinance;
//                            ricknooftransport = dataSetMn.get(position).ricknooftransport;
//                            maritialstatus = dataSetMn.get(position).maritialstatus;
//                            marriageRegNo = dataSetMn.get(position).marriageRegNo;
//                            marriageRegDate = dataSetMn.get(position).marriageRegDate;
//                            divorceRegNo = dataSetMn.get(position).divorceRegNo;
//                            divorceRegDate = dataSetMn.get(position).divorceRegDate;
//                            incomefromMainOccuption = dataSetMn.get(position).incomefromMainOccuption;
//                            incomefromSecondOccuption = dataSetMn.get(position).incomefromSecondOccuption;
//                            additionalincome = dataSetMn.get(position).additionalincome;
//                            mobaileNumber = dataSetMn.get(position).mobaileNumber;
//                            email = dataSetMn.get(position).email;
//                            accountNo = dataSetMn.get(position).accountNo;
//                            mobaileNo = dataSetMn.get(position).mobaileNo;
//                            bankName = dataSetMn.get(position).bankName;
//                            branchName = dataSetMn.get(position).branchName;
//                            ismemberlivehere = dataSetMn.get(position).ismemberlivehere;
//                            mlivingAddress = dataSetMn.get(position).mlivingAddress;
//                            memberimage = dataSetMn.get(position).memberimage;
//                        }
//                    }

            }


////                try {
////
////                    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://103.147.182.110:5100")
////                            .addConverterFactory(GsonConverterFactory.create())
////                            .build();
////
////                    RFInterfece rfInterfece = retrofit.create(RFInterfece.class);
////
////                    MemberObject memberObject = new MemberObject(name, member_id, bloodgroup, fathername, mothername, gender, isHead,  bdaydate,
////                            bdaymonth,   bdayyear,   age,   birthcertificateno,   birthcertificateimage, nationality,   nid,
////                            nidimage, membervaccine, disability, ismothervaccination, nearesthospital, maternitynutritionconsultancy,
////                            consultingwith, iseligiblecouple, anyfamilyplaning, socialsafetynet, socialsafetynetcardinfo, socialsafetynetcardphoto,
////                            isTinAvaiable, tinNumber, tinimage, passportno, passportimage, isDrivingLicenceAvailable, drivingLicenceNumber,
////                            dirivinglicenseimage, higheshtEducation, doyoustudynow, whichLevel, educationinstitution, educationFinishingWant,
////                            training, primaryprofession,  secondaryprofession, ifunemployednow, rickformofownership, ricksourcesoffinance,
////                            ricknooftransport,  maritialstatus, marriageRegNo, marriageRegDate, divorceRegNo, divorceRegDate,
////                            incomefromMainOccuption, incomefromSecondOccuption, additionalincome, mobaileNumber, email,
////                            accountNo, mobaileNo, bankName, branchName, ismemberlivehere, mlivingAddress, memberimage);
//////
//////                KhanaObject khanaObject = new KhanaObject(date,  facode, fauser, username, holdingnumber, khananumber, lat, lng, kinnumber, division, district, upazila, union, postcode,
//////                        village, ward, khanahead, telephoneNumber, khanatype, religion, ethnicity,
//////                        ownlivingland, ownfarmingland, ownleasegiven, ownpond,
//////                        owngarden, ownhill, ownother, ownlandTotal, otherlivingland, otherfarmingland, otherleasetaken, otherpond, othergarden,
//////                        otherhill, otherlandother, otherlandTotal, isNotLandDivided, housetype, watersupply, sanitation, iselectricity, typeofelectricity,
//////                        businesstype, businessname, businesssourcesoffinance, tradelicensemumber, tradelicensemumberimage,  businessAddress, businessStartYear, businessStartMonth, businessStartDay,
//////                        industryowner, typeofindustry, industsourcesoffinance, formofownership, ifricemilling, riceMillProductionCapacity, typeofricemilled, isricemilledOwn,
//////                        interestedingovtfixedrate,
//////                        iftruckbusiness, vehicletype, numberoftrucks, trucktotalcapacity, trucksourceoffinance, istruckowned, interestdrivingtrucksforgovt,
//////                        interestofsecurities, incomefromhouseproperty, incomefromagricultural, capitalgain,  incomefromaothersources,
//////                        aush, aman, boro, wheat, maize, pulses, oilseeds, potato, tomato, vegetable, sugarcane, jute,  farmingsellingtoGovtfixedprice,
//////                        farmingsellingtoPrivatetraders,
//////                        cattle, buffalo, sheep, goat, chicken, egghens, duck, eggsduck,
//////                        ruhi, catla, mixedfish, pangas, koi, magur, tilapia, shrimp, prawn, others, memberObject);
//////
////
////                    Call<ResponseObject> call = rfInterfece.PostData(memberObject);
////
////                    call.enqueue(new Callback<ResponseObject>() {
////                        @Override
////                        public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
////
////                            Toast.makeText(context,response+"Successfull", Toast.LENGTH_LONG).show();
////                        }
////
////                        @Override
////                        public void onFailure(Call<ResponseObject> call, Throwable t) {
////                            Toast.makeText(context,"Error", Toast.LENGTH_LONG).show();
////
////
////                        }
////                    });
////
////                }catch (Exception e){
////                    System.out.println(e);
////                }
//
//            }
//        });
//
//    }
//
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
