package com.azhar.e_parishad_b.Database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FDEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "facode")
    public String facode;

    @ColumnInfo(name = "fauser")
    public String fauser;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "surveyID")
    public String surveyID;

    @ColumnInfo(name = "holdingnumber")
    public String holdingnumber;

    @ColumnInfo(name = "khananumber")
    public String khananumber;

    @ColumnInfo(name = "lat")
    public String lat;

    @ColumnInfo(name = "lng")
    public String lng;

    @ColumnInfo(name = "kinnumber")
    public String kinnumber;

    @ColumnInfo(name = "division")
    public String division;

    @ColumnInfo(name = "district")
    public String district;

    @ColumnInfo(name = "upazila")
    public String upazila;

    @ColumnInfo(name = "union")
    public String union;

    @ColumnInfo(name = "postcode")
    public String postcode;

    @ColumnInfo(name = "village")
    public String village;

    @ColumnInfo(name = "ward")
    public String ward;

    @ColumnInfo(name = "khanahead")
    public String khanahead;

    @ColumnInfo(name = "telephoneNumber")
    public String telephoneNumber;

    @ColumnInfo(name = "khanatype")
    public String khanatype;

    @ColumnInfo(name = "religion")
    public String religion;

    @ColumnInfo(name = "ethnicity")
    public String ethnicity;

    @ColumnInfo(name = "ownlivingland")
    public String ownlivingland;

    @ColumnInfo(name = "ownfarmingland")
    public String ownfarmingland;

    @ColumnInfo(name = "ownleasegiven")
    public String ownleasegiven;

    @ColumnInfo(name = "ownpond")
    public String ownpond;

    @ColumnInfo(name = "owngarden")
    public String owngarden;

    @ColumnInfo(name = "ownhill")
    public String ownhill;

    @ColumnInfo(name = "ownother")
    public String ownother;

    @ColumnInfo(name = "ownlandTotal")
    public String ownlandTotal;

    @ColumnInfo(name = "otherlivingland")
    public String otherlivingland;

    @ColumnInfo(name = "otherfarmingland")
    public String otherfarmingland;

    @ColumnInfo(name = "otherleasetaken")
    public String otherleasetaken;

    @ColumnInfo(name = "otherpond")
    public String otherpond;

    @ColumnInfo(name = "othergarden")
    public String othergarden;

    @ColumnInfo(name = "otherhill")
    public String otherhill;

    @ColumnInfo(name = "otherlandother")
    public String otherlandother;

    @ColumnInfo(name = "otherlandTotal")
    public String otherlandTotal;

    @ColumnInfo(name = "isNotLandDivided")
    public String isNotLandDivided;

    @ColumnInfo(name = "housetype")
    public String housetype;

    @ColumnInfo(name = "watersupply")
    public String watersupply;

    @ColumnInfo(name = "sanitation")
    public String sanitation;

    @ColumnInfo(name = "iselectricity")
    public String iselectricity;

    @ColumnInfo(name = "typeofelectricity")
    public String typeofelectricity;

    @ColumnInfo(name = "businesstype")
    public String businesstype;

    @ColumnInfo(name = "businessname")
    public String businessname;

    @ColumnInfo(name = "businesssourcesoffinance")
    public String businesssourcesoffinance;

    @ColumnInfo(name = "tradelicensemumber")
    public String tradelicensemumber;

    @ColumnInfo(name = "tradelicensemumberimage")
    public String tradelicensemumberimage;

    @ColumnInfo(name = "businessAddress")
    public String businessAddress;

    @ColumnInfo(name = "businessStartYear")
    public String businessStartYear;

    @ColumnInfo(name = "businessStartMonth")
    public String businessStartMonth;

    @ColumnInfo(name = "businessStartDay")
    public String businessStartDay;
    @ColumnInfo(name = "industryowner")
    public String industryowner;

    @ColumnInfo(name = "typeofindustry")
    public String typeofindustry;

    @ColumnInfo(name = "industsourcesoffinance")
    public String industsourcesoffinance;

    @ColumnInfo(name = "formofownership")
    public String formofownership;

    @ColumnInfo(name = "ifricemilling")
    public String ifricemilling;

    @ColumnInfo(name = "riceMillProductionCapacity")
    public String riceMillProductionCapacity;

    @ColumnInfo(name = "typeofricemilled")
    public String typeofricemilled;

    @ColumnInfo(name = "isricemilledOwn")
    public String isricemilledOwn;

    @ColumnInfo(name = "interestedingovtfixedrate")
    public String interestedingovtfixedrate;

    @ColumnInfo(name = "iftruckbusiness")
    public String iftruckbusiness;

    @ColumnInfo(name = "vehicletype")
    public String vehicletype;

    @ColumnInfo(name = "numberoftrucks")
    public String numberoftrucks;

    @ColumnInfo(name = "trucktotalcapacity")
    public String trucktotalcapacity;

    @ColumnInfo(name = "trucksourceoffinance")
    public String trucksourceoffinance;

    @ColumnInfo(name = "istruckowned")
    public String istruckowned;

    @ColumnInfo(name = "interestdrivingtrucksforgovt")
    public String interestdrivingtrucksforgovt;

    @ColumnInfo(name = "interestofsecurities")
    public String interestofsecurities;

    @ColumnInfo(name = "incomefromhouseproperty")
    public String incomefromhouseproperty;

    @ColumnInfo(name = "incomefromagricultural")
    public String incomefromagricultural;

    @ColumnInfo(name = "capitalgain")
    public String capitalgain;

    @ColumnInfo(name = "incomefromaothersources")
    public String incomefromaothersources;

    @ColumnInfo(name = "aush")
    public String aush;

    @ColumnInfo(name = "aman")
    public String aman;

    @ColumnInfo(name = "boro")
    public String boro;

    @ColumnInfo(name = "wheat")
    public String wheat;

    @ColumnInfo(name = "maize")
    public String maize;

    @ColumnInfo(name = "pulses")
    public String pulses;

    @ColumnInfo(name = "oilseeds")
    public String oilseeds;

    @ColumnInfo(name = "potato")
    public String potato;

    @ColumnInfo(name = "tomato")
    public String tomato;

    @ColumnInfo(name = "vegetable")
    public String vegetable;

    @ColumnInfo(name = "sugarcane")
    public String sugarcane;

    @ColumnInfo(name = "jute")
    public String jute;

    @ColumnInfo(name = "farmingsellingtoGovtfixedprice")
    public String farmingsellingtoGovtfixedprice;

    @ColumnInfo(name = "farmingsellingtoPrivatetraders")
    public String farmingsellingtoPrivatetraders;

    @ColumnInfo(name = "cattle")
    public String cattle;

    @ColumnInfo(name = "buffalo")
    public String buffalo;

    @ColumnInfo(name = "sheep")
    public String sheep;

    @ColumnInfo(name = "goat")
    public String goat;

    @ColumnInfo(name = "chicken")
    public String chicken;

    @ColumnInfo(name = "egghens")
    public String egghens;

    @ColumnInfo(name = "duck")
    public String duck;

    @ColumnInfo(name = "eggsduck")
    public String eggsduck;

    @ColumnInfo(name = "ruhi")
    public String ruhi;

    @ColumnInfo(name = "catla")
    public String catla;

    @ColumnInfo(name = "mixedfish")
    public String mixedfish;

    @ColumnInfo(name = "pangas")
    public String pangas;

    @ColumnInfo(name = "koi")
    public String koi;

    @ColumnInfo(name = "magur")
    public String magur;

    @ColumnInfo(name = "tilapia")
    public String tilapia;

    @ColumnInfo(name = "shrimp")
    public String shrimp;

    @ColumnInfo(name = "prawn")
    public String prawn;

    @ColumnInfo(name = "others")
    public String others;

    @ColumnInfo(name = "isSync")
    public String isSync;

    @ColumnInfo(name = "surveystatus")
    public String surveystatus;


    public FDEntity(String datei, String facodei, String fauseri, String usernamei, String surveyIDi, String holdingnumberi, String khananumberi, String lati, String lngi, String kinnumberi, String divisioni, String districti, String upazilai, String unioni, String postcodei, String villagei, String wardi, String khanaheadi, String telephoneNumberi, String khanatypei, String religioni, String ethnicityi, String ownlivinglandi, String ownfarminglandi, String ownleasegiveni, String ownpondi, String owngardeni, String ownhilli, String ownotheri, String ownlandTotali, String otherlivinglandi, String otherfarminglandi, String otherleasetakeni, String otherpondi, String othergardeni, String otherhilli, String otherlandotheri, String otherlandTotali, String isNotLandDividedi, String housetypei, String watersupplyi, String sanitationi, String iselectricityi, String typeofelectricityi, String businesstypei, String businessnamei, String businesssourcesoffinancei, String tradelicensemumberi, String tradelicensemumberimagei, String businessAddressi, String businessStartYeari, String businessStartMonthi, String businessStartDayi, String industryowneri, String typeofindustryi, String industsourcesoffinancei, String formofownershipi, String ifricemillingi, String riceMillProductionCapacityi, String typeofricemilledi, String isricemilledOwni, String interestedingovtfixedratei, String iftruckbusinessi, String vehicletypei, String numberoftrucksi, String trucktotalcapacityi, String trucksourceoffinancei, String istruckownedi, String interestdrivingtrucksforgovti, String interestofsecuritiesi, String incomefromhousepropertyi, String incomefromagriculturali, String capitalgaini, String incomefromaothersourcesi, String aushi, String amani, String boroi, String wheati, String maizei, String pulsesi, String oilseedsi, String potatoi, String tomatoi, String vegetablei, String sugarcanei, String jutei, String farmingsellingtoGovtfixedpricei, String farmingsellingtoPrivatetradersi, String cattlei, String buffaloi, String sheepi, String goati, String chickeni, String egghensi, String ducki, String eggsducki, String ruhii, String catlai, String mixedfishi, String pangasi, String koii, String maguri, String tilapiai, String shrimpi, String prawni, String othersi, String isSynci, String surveystatusi ) {
        this.date = datei;
        this.facode = facodei;
        this.fauser = fauseri;
        this.username = usernamei;
        this.surveyID = surveyIDi;
        this.holdingnumber = holdingnumberi;
        this.khananumber = khananumberi;
        this.lat = lati;
        this.lng = lngi;
        this.kinnumber = kinnumberi;
        this.division = divisioni;
        this.district = districti;
        this.upazila = upazilai;
        this.union = unioni;
        this.postcode = postcodei;
        this.village = villagei;
        this.ward = wardi;
        this.khanahead = khanaheadi;
        this.telephoneNumber = telephoneNumberi;
        this.khanatype = khanatypei;
        this.religion = religioni;
        this.ethnicity = ethnicityi;
        this.ownlivingland = ownlivinglandi;
        this.ownfarmingland = ownfarminglandi;
        this.ownleasegiven = ownleasegiveni;
        this.ownpond = ownpondi;
        this.owngarden = owngardeni;
        this.ownhill = ownhilli;
        this.ownother = ownotheri;
        this.ownlandTotal = ownlandTotali;
        this.otherlivingland = otherlivinglandi;
        this.otherfarmingland = otherfarminglandi;
        this.otherleasetaken = otherleasetakeni;
        this.otherpond = otherpondi;
        this.othergarden = othergardeni;
        this.otherhill = otherhilli;
        this.otherlandother = otherlandotheri;
        this.otherlandTotal = otherlandTotali;
        this.isNotLandDivided = isNotLandDividedi;
        this.housetype = housetypei;
        this.watersupply = watersupplyi;
        this.sanitation = sanitationi;
        this.iselectricity = iselectricityi;
        this.typeofelectricity = typeofelectricityi;
        this.businesstype = businesstypei;
        this.businessname = businessnamei;
        this.businesssourcesoffinance = businesssourcesoffinancei;
        this.tradelicensemumber = tradelicensemumberi;
        this.tradelicensemumberimage = tradelicensemumberimagei;
        this.businessAddress = businessAddressi;
        this.businessStartYear = businessStartYeari;
        this.businessStartMonth = businessStartMonthi;
        this.businessStartDay = businessStartDayi;
        this.industryowner = industryowneri;
        this.typeofindustry = typeofindustryi;
        this.industsourcesoffinance = industsourcesoffinancei;
        this.formofownership = formofownershipi;
        this.ifricemilling = ifricemillingi;
        this.riceMillProductionCapacity = riceMillProductionCapacityi;
        this.typeofricemilled = typeofricemilledi;
        this.isricemilledOwn = isricemilledOwni;
        this.interestedingovtfixedrate = interestedingovtfixedratei;
        this.iftruckbusiness = iftruckbusinessi;
        this.vehicletype = vehicletypei;
        this.numberoftrucks = numberoftrucksi;
        this.trucktotalcapacity = trucktotalcapacityi;
        this.trucksourceoffinance = trucksourceoffinancei;
        this.istruckowned = istruckownedi;
        this.interestdrivingtrucksforgovt = interestdrivingtrucksforgovti;
        this.interestofsecurities = interestofsecuritiesi;
        this.incomefromhouseproperty = incomefromhousepropertyi;
        this.incomefromagricultural = incomefromagriculturali;
        this.capitalgain = capitalgaini;
        this.incomefromaothersources = incomefromaothersourcesi;
        this.aush = aushi;
        this.aman = amani;
        this.boro = boroi;
        this.wheat = wheati;
        this.maize = maizei;
        this.pulses = pulsesi;
        this.oilseeds = oilseedsi;
        this.potato = potatoi;
        this.tomato = tomatoi;
        this.vegetable = vegetablei;
        this.sugarcane = sugarcanei;
        this.jute = jutei;
        this.farmingsellingtoGovtfixedprice = farmingsellingtoGovtfixedpricei;
        this.farmingsellingtoPrivatetraders = farmingsellingtoPrivatetradersi;
        this.cattle = cattlei;
        this.buffalo = buffaloi;
        this.sheep = sheepi;
        this.goat = goati;
        this.chicken = chickeni;
        this.egghens = egghensi;
        this.duck = ducki;
        this.eggsduck = eggsducki;
        this.ruhi = ruhii;
        this.catla = catlai;
        this.mixedfish = mixedfishi;
        this.pangas = pangasi;
        this.koi = koii;
        this.magur = maguri;
        this.tilapia = tilapiai;
        this.shrimp = shrimpi;
        this.prawn = prawni;
        this.others = othersi;
        this.isSync = isSynci;
        this.surveystatus = surveystatusi;
    }

    public FDEntity(int id, String date, String facode, String fauser, String username, String surveyID, String holdingnumber, String khananumber, String lat, String lng, String kinnumber, String division, String district, String upazila, String union, String postcode, String village, String ward, String khanahead, String telephoneNumber, String khanatype, String religion, String ethnicity, String ownlivingland, String ownfarmingland, String ownleasegiven, String ownpond, String owngarden, String ownhill, String ownother, String ownlandTotal, String otherlivingland, String otherfarmingland, String otherleasetaken, String otherpond, String othergarden, String otherhill, String otherlandother, String otherlandTotal, String isNotLandDivided, String housetype, String watersupply, String sanitation, String iselectricity, String typeofelectricity, String businesstype, String businessname, String businesssourcesoffinance, String tradelicensemumber, String tradelicensemumberimage, String businessAddress, String businessStartYear, String businessStartMonth, String businessStartDay, String industryowner, String typeofindustry, String industsourcesoffinance, String formofownership, String ifricemilling, String riceMillProductionCapacity, String typeofricemilled, String isricemilledOwn, String interestedingovtfixedrate, String iftruckbusiness, String vehicletype, String numberoftrucks, String trucktotalcapacity, String trucksourceoffinance, String istruckowned, String interestdrivingtrucksforgovt, String interestofsecurities, String incomefromhouseproperty, String incomefromagricultural, String capitalgain, String incomefromaothersources, String aush, String aman, String boro, String wheat, String maize, String pulses, String oilseeds, String potato, String tomato, String vegetable, String sugarcane, String jute, String farmingsellingtoGovtfixedprice, String farmingsellingtoPrivatetraders, String cattle, String buffalo, String sheep, String goat, String chicken, String egghens, String duck, String eggsduck, String ruhi, String catla, String mixedfish, String pangas, String koi, String magur, String tilapia, String shrimp, String prawn, String others, String isSync, String surveystatus) {
        this.id = id;
        this.date = date;
        this.facode = facode;
        this.fauser = fauser;
        this.username = username;
        this.surveyID = surveyID;
        this.holdingnumber = holdingnumber;
        this.khananumber = khananumber;
        this.lat = lat;
        this.lng = lng;
        this.kinnumber = kinnumber;
        this.division = division;
        this.district = district;
        this.upazila = upazila;
        this.union = union;
        this.postcode = postcode;
        this.village = village;
        this.ward = ward;
        this.khanahead = khanahead;
        this.telephoneNumber = telephoneNumber;
        this.khanatype = khanatype;
        this.religion = religion;
        this.ethnicity = ethnicity;
        this.ownlivingland = ownlivingland;
        this.ownfarmingland = ownfarmingland;
        this.ownleasegiven = ownleasegiven;
        this.ownpond = ownpond;
        this.owngarden = owngarden;
        this.ownhill = ownhill;
        this.ownother = ownother;
        this.ownlandTotal = ownlandTotal;
        this.otherlivingland = otherlivingland;
        this.otherfarmingland = otherfarmingland;
        this.otherleasetaken = otherleasetaken;
        this.otherpond = otherpond;
        this.othergarden = othergarden;
        this.otherhill = otherhill;
        this.otherlandother = otherlandother;
        this.otherlandTotal = otherlandTotal;
        this.isNotLandDivided = isNotLandDivided;
        this.housetype = housetype;
        this.watersupply = watersupply;
        this.sanitation = sanitation;
        this.iselectricity = iselectricity;
        this.typeofelectricity = typeofelectricity;
        this.businesstype = businesstype;
        this.businessname = businessname;
        this.businesssourcesoffinance = businesssourcesoffinance;
        this.tradelicensemumber = tradelicensemumber;
        this.tradelicensemumberimage = tradelicensemumberimage;
        this.businessAddress = businessAddress;
        this.businessStartYear = businessStartYear;
        this.businessStartMonth = businessStartMonth;
        this.businessStartDay = businessStartDay;
        this.industryowner = industryowner;
        this.typeofindustry = typeofindustry;
        this.industsourcesoffinance = industsourcesoffinance;
        this.formofownership = formofownership;
        this.ifricemilling = ifricemilling;
        this.riceMillProductionCapacity = riceMillProductionCapacity;
        this.typeofricemilled = typeofricemilled;
        this.isricemilledOwn = isricemilledOwn;
        this.interestedingovtfixedrate = interestedingovtfixedrate;
        this.iftruckbusiness = iftruckbusiness;
        this.vehicletype = vehicletype;
        this.numberoftrucks = numberoftrucks;
        this.trucktotalcapacity = trucktotalcapacity;
        this.trucksourceoffinance = trucksourceoffinance;
        this.istruckowned = istruckowned;
        this.interestdrivingtrucksforgovt = interestdrivingtrucksforgovt;
        this.interestofsecurities = interestofsecurities;
        this.incomefromhouseproperty = incomefromhouseproperty;
        this.incomefromagricultural = incomefromagricultural;
        this.capitalgain = capitalgain;
        this.incomefromaothersources = incomefromaothersources;
        this.aush = aush;
        this.aman = aman;
        this.boro = boro;
        this.wheat = wheat;
        this.maize = maize;
        this.pulses = pulses;
        this.oilseeds = oilseeds;
        this.potato = potato;
        this.tomato = tomato;
        this.vegetable = vegetable;
        this.sugarcane = sugarcane;
        this.jute = jute;
        this.farmingsellingtoGovtfixedprice = farmingsellingtoGovtfixedprice;
        this.farmingsellingtoPrivatetraders = farmingsellingtoPrivatetraders;
        this.cattle = cattle;
        this.buffalo = buffalo;
        this.sheep = sheep;
        this.goat = goat;
        this.chicken = chicken;
        this.egghens = egghens;
        this.duck = duck;
        this.eggsduck = eggsduck;
        this.ruhi = ruhi;
        this.catla = catla;
        this.mixedfish = mixedfish;
        this.pangas = pangas;
        this.koi = koi;
        this.magur = magur;
        this.tilapia = tilapia;
        this.shrimp = shrimp;
        this.prawn = prawn;
        this.others = others;
        this.isSync = isSync;
        this.surveystatus = surveystatus;
    }


}
