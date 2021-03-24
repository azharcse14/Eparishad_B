package com.azhar.e_parishad_b.Networking.EPNET.DataObject;

import java.util.ArrayList;

public class KhanaObject {
    String date, facode, fauser, username, surveyID, holdingnumber, khananumber, lat, lng, kinnumber, division, district, upazila, union, postcode,
            village, ward, khanahead, telephoneNumber, khanatype, religion, ethnicity,
            ownlivingland, ownfarmingland, ownleasegiven, ownpond,
            owngarden, ownhill, ownother, ownlandTotal, otherlivingland, otherfarmingland, otherleasetaken, otherpond, othergarden,
            otherhill, otherlandother, otherlandTotal, isNotLandDivided;
    String[] housetype;
    String[]watersupply;
    String[]sanitation;
    String iselectricity, typeofelectricity,
            businesstype, businessname, businesssourcesoffinance, tradelicensemumber, tradelicensemumberimage, businessAddress, businessStartYear, businessStartMonth, businessStartDay,
            industryowner, typeofindustry, industsourcesoffinance, formofownership, ifricemilling, riceMillProductionCapacity, typeofricemilled, isricemilledOwn,
            interestedingovtfixedrate,
            iftruckbusiness, vehicletype, numberoftrucks, trucktotalcapacity, trucksourceoffinance, istruckowned, interestdrivingtrucksforgovt,
            interestofsecurities, incomefromhouseproperty, incomefromagricultural, capitalgain, incomefromaothersources,
            aush, aman, boro, wheat, maize, pulses, oilseeds, potato, tomato, vegetable, sugarcane, jute, farmingsellingtoGovtfixedprice,
            farmingsellingtoPrivatetraders,
            cattle, buffalo, sheep, goat, chicken, egghens, duck, eggsduck,
            ruhi, catla, mixedfish, pangas, koi, magur, tilapia, shrimp, prawn, others, surveystatus;

    ArrayList<MemberObject> members;
    ArrayList<LoanObject> loan;



    public KhanaObject( String date, String facode, String fauser, String username, String surveyID, String holdingnumber, String khananumber, String lat, String lng, String kinnumber, String division, String district, String upazila, String union, String postcode, String village, String ward, String khanahead, String telephoneNumber, String khanatype, String religion, String ethnicity, String ownlivingland, String ownfarmingland, String ownleasegiven, String ownpond, String owngarden, String ownhill, String ownother, String ownlandTotal, String otherlivingland, String otherfarmingland, String otherleasetaken, String otherpond, String othergarden, String otherhill, String otherlandother, String otherlandTotal, String isNotLandDivided, String[] housetype, String[] watersupply, String[] sanitation, String iselectricity, String typeofelectricity, String businesstype, String businessname, String businesssourcesoffinance, String tradelicensemumber, String tradelicensemumberimage, String businessAddress, String businessStartYear, String businessStartMonth, String businessStartDay, String industryowner, String typeofindustry, String industsourcesoffinance, String formofownership, String ifricemilling, String riceMillProductionCapacity, String typeofricemilled, String isricemilledOwn, String interestedingovtfixedrate, String iftruckbusiness, String vehicletype, String numberoftrucks, String trucktotalcapacity, String trucksourceoffinance, String istruckowned, String interestdrivingtrucksforgovt, String interestofsecurities, String incomefromhouseproperty, String incomefromagricultural, String capitalgain, String incomefromaothersources, String aush, String aman, String boro, String wheat, String maize, String pulses, String oilseeds, String potato, String tomato, String vegetable, String sugarcane, String jute, String farmingsellingtoGovtfixedprice, String farmingsellingtoPrivatetraders, String cattle, String buffalo, String sheep, String goat, String chicken, String egghens, String duck, String eggsduck, String ruhi, String catla, String mixedfish, String pangas, String koi, String magur, String tilapia, String shrimp, String prawn, String others, String surveystatus, ArrayList<MemberObject> members, ArrayList<LoanObject> loan) {
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
        this.surveystatus = surveystatus;
        this.members = members;
        this.loan = loan;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFacode() {
        return facode;
    }

    public void setFacode(String facode) {
        this.facode = facode;
    }

    public String getFauser() {
        return fauser;
    }

    public void setFauser(String fauser) {
        this.fauser = fauser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(String surveyID) {
        this.surveyID = surveyID;
    }

    public String getHoldingnumber() {
        return holdingnumber;
    }

    public void setHoldingnumber(String holdingnumber) {
        this.holdingnumber = holdingnumber;
    }

    public String getKhananumber() {
        return khananumber;
    }

    public void setKhananumber(String khananumber) {
        this.khananumber = khananumber;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getKinnumber() {
        return kinnumber;
    }

    public void setKinnumber(String kinnumber) {
        this.kinnumber = kinnumber;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUpazila() {
        return upazila;
    }

    public void setUpazila(String upazila) {
        this.upazila = upazila;
    }

    public String getUnion() {
        return union;
    }

    public void setUnion(String union) {
        this.union = union;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getKhanahead() {
        return khanahead;
    }

    public void setKhanahead(String khanahead) {
        this.khanahead = khanahead;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getKhanatype() {
        return khanatype;
    }

    public void setKhanatype(String khanatype) {
        this.khanatype = khanatype;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getOwnlivingland() {
        return ownlivingland;
    }

    public void setOwnlivingland(String ownlivingland) {
        this.ownlivingland = ownlivingland;
    }

    public String getOwnfarmingland() {
        return ownfarmingland;
    }

    public void setOwnfarmingland(String ownfarmingland) {
        this.ownfarmingland = ownfarmingland;
    }

    public String getOwnleasegiven() {
        return ownleasegiven;
    }

    public void setOwnleasegiven(String ownleasegiven) {
        this.ownleasegiven = ownleasegiven;
    }

    public String getOwnpond() {
        return ownpond;
    }

    public void setOwnpond(String ownpond) {
        this.ownpond = ownpond;
    }

    public String getOwngarden() {
        return owngarden;
    }

    public void setOwngarden(String owngarden) {
        this.owngarden = owngarden;
    }

    public String getOwnhill() {
        return ownhill;
    }

    public void setOwnhill(String ownhill) {
        this.ownhill = ownhill;
    }

    public String getOwnother() {
        return ownother;
    }

    public void setOwnother(String ownother) {
        this.ownother = ownother;
    }

    public String getOwnlandTotal() {
        return ownlandTotal;
    }

    public void setOwnlandTotal(String ownlandTotal) {
        this.ownlandTotal = ownlandTotal;
    }

    public String getOtherlivingland() {
        return otherlivingland;
    }

    public void setOtherlivingland(String otherlivingland) {
        this.otherlivingland = otherlivingland;
    }

    public String getOtherfarmingland() {
        return otherfarmingland;
    }

    public void setOtherfarmingland(String otherfarmingland) {
        this.otherfarmingland = otherfarmingland;
    }

    public String getOtherleasetaken() {
        return otherleasetaken;
    }

    public void setOtherleasetaken(String otherleasetaken) {
        this.otherleasetaken = otherleasetaken;
    }

    public String getOtherpond() {
        return otherpond;
    }

    public void setOtherpond(String otherpond) {
        this.otherpond = otherpond;
    }

    public String getOthergarden() {
        return othergarden;
    }

    public void setOthergarden(String othergarden) {
        this.othergarden = othergarden;
    }

    public String getOtherhill() {
        return otherhill;
    }

    public void setOtherhill(String otherhill) {
        this.otherhill = otherhill;
    }

    public String getOtherlandother() {
        return otherlandother;
    }

    public void setOtherlandother(String otherlandother) {
        this.otherlandother = otherlandother;
    }

    public String getOtherlandTotal() {
        return otherlandTotal;
    }

    public void setOtherlandTotal(String otherlandTotal) {
        this.otherlandTotal = otherlandTotal;
    }

    public String getIsNotLandDivided() {
        return isNotLandDivided;
    }

    public void setIsNotLandDivided(String isNotLandDivided) {
        this.isNotLandDivided = isNotLandDivided;
    }

    public String[] getHousetype() {
        return housetype;
    }

    public void setHousetype(String[] housetype) {
        this.housetype = housetype;
    }

    public String[] getWatersupply() {
        return watersupply;
    }

    public void setWatersupply(String[] watersupply) {
        this.watersupply = watersupply;
    }

    public String[] getSanitation() {
        return sanitation;
    }

    public void setSanitation(String[] sanitation) {
        this.sanitation = sanitation;
    }

    public String getIselectricity() {
        return iselectricity;
    }

    public void setIselectricity(String iselectricity) {
        this.iselectricity = iselectricity;
    }

    public String getTypeofelectricity() {
        return typeofelectricity;
    }

    public void setTypeofelectricity(String typeofelectricity) {
        this.typeofelectricity = typeofelectricity;
    }

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getBusinesssourcesoffinance() {
        return businesssourcesoffinance;
    }

    public void setBusinesssourcesoffinance(String businesssourcesoffinance) {
        this.businesssourcesoffinance = businesssourcesoffinance;
    }

    public String getTradelicensemumber() {
        return tradelicensemumber;
    }

    public void setTradelicensemumber(String tradelicensemumber) {
        this.tradelicensemumber = tradelicensemumber;
    }

    public String getTradelicensemumberimage() {
        return tradelicensemumberimage;
    }

    public void setTradelicensemumberimage(String tradelicensemumberimage) {
        this.tradelicensemumberimage = tradelicensemumberimage;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessStartYear() {
        return businessStartYear;
    }

    public void setBusinessStartYear(String businessStartYear) {
        this.businessStartYear = businessStartYear;
    }

    public String getBusinessStartMonth() {
        return businessStartMonth;
    }

    public void setBusinessStartMonth(String businessStartMonth) {
        this.businessStartMonth = businessStartMonth;
    }

    public String getBusinessStartDay() {
        return businessStartDay;
    }

    public void setBusinessStartDay(String businessStartDay) {
        this.businessStartDay = businessStartDay;
    }

    public String getIndustryowner() {
        return industryowner;
    }

    public void setIndustryowner(String industryowner) {
        this.industryowner = industryowner;
    }

    public String getTypeofindustry() {
        return typeofindustry;
    }

    public void setTypeofindustry(String typeofindustry) {
        this.typeofindustry = typeofindustry;
    }

    public String getIndustsourcesoffinance() {
        return industsourcesoffinance;
    }

    public void setIndustsourcesoffinance(String industsourcesoffinance) {
        this.industsourcesoffinance = industsourcesoffinance;
    }

    public String getFormofownership() {
        return formofownership;
    }

    public void setFormofownership(String formofownership) {
        this.formofownership = formofownership;
    }

    public String getIfricemilling() {
        return ifricemilling;
    }

    public void setIfricemilling(String ifricemilling) {
        this.ifricemilling = ifricemilling;
    }

    public String getRiceMillProductionCapacity() {
        return riceMillProductionCapacity;
    }

    public void setRiceMillProductionCapacity(String riceMillProductionCapacity) {
        this.riceMillProductionCapacity = riceMillProductionCapacity;
    }

    public String getTypeofricemilled() {
        return typeofricemilled;
    }

    public void setTypeofricemilled(String typeofricemilled) {
        this.typeofricemilled = typeofricemilled;
    }

    public String getIsricemilledOwn() {
        return isricemilledOwn;
    }

    public void setIsricemilledOwn(String isricemilledOwn) {
        this.isricemilledOwn = isricemilledOwn;
    }

    public String getInterestedingovtfixedrate() {
        return interestedingovtfixedrate;
    }

    public void setInterestedingovtfixedrate(String interestedingovtfixedrate) {
        this.interestedingovtfixedrate = interestedingovtfixedrate;
    }

    public String getIftruckbusiness() {
        return iftruckbusiness;
    }

    public void setIftruckbusiness(String iftruckbusiness) {
        this.iftruckbusiness = iftruckbusiness;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }

    public String getNumberoftrucks() {
        return numberoftrucks;
    }

    public void setNumberoftrucks(String numberoftrucks) {
        this.numberoftrucks = numberoftrucks;
    }

    public String getTrucktotalcapacity() {
        return trucktotalcapacity;
    }

    public void setTrucktotalcapacity(String trucktotalcapacity) {
        this.trucktotalcapacity = trucktotalcapacity;
    }

    public String getTrucksourceoffinance() {
        return trucksourceoffinance;
    }

    public void setTrucksourceoffinance(String trucksourceoffinance) {
        this.trucksourceoffinance = trucksourceoffinance;
    }

    public String getIstruckowned() {
        return istruckowned;
    }

    public void setIstruckowned(String istruckowned) {
        this.istruckowned = istruckowned;
    }

    public String getInterestdrivingtrucksforgovt() {
        return interestdrivingtrucksforgovt;
    }

    public void setInterestdrivingtrucksforgovt(String interestdrivingtrucksforgovt) {
        this.interestdrivingtrucksforgovt = interestdrivingtrucksforgovt;
    }

    public String getInterestofsecurities() {
        return interestofsecurities;
    }

    public void setInterestofsecurities(String interestofsecurities) {
        this.interestofsecurities = interestofsecurities;
    }

    public String getIncomefromhouseproperty() {
        return incomefromhouseproperty;
    }

    public void setIncomefromhouseproperty(String incomefromhouseproperty) {
        this.incomefromhouseproperty = incomefromhouseproperty;
    }

    public String getIncomefromagricultural() {
        return incomefromagricultural;
    }

    public void setIncomefromagricultural(String incomefromagricultural) {
        this.incomefromagricultural = incomefromagricultural;
    }

    public String getCapitalgain() {
        return capitalgain;
    }

    public void setCapitalgain(String capitalgain) {
        this.capitalgain = capitalgain;
    }

    public String getIncomefromaothersources() {
        return incomefromaothersources;
    }

    public void setIncomefromaothersources(String incomefromaothersources) {
        this.incomefromaothersources = incomefromaothersources;
    }

    public String getAush() {
        return aush;
    }

    public void setAush(String aush) {
        this.aush = aush;
    }

    public String getAman() {
        return aman;
    }

    public void setAman(String aman) {
        this.aman = aman;
    }

    public String getBoro() {
        return boro;
    }

    public void setBoro(String boro) {
        this.boro = boro;
    }

    public String getWheat() {
        return wheat;
    }

    public void setWheat(String wheat) {
        this.wheat = wheat;
    }

    public String getMaize() {
        return maize;
    }

    public void setMaize(String maize) {
        this.maize = maize;
    }

    public String getPulses() {
        return pulses;
    }

    public void setPulses(String pulses) {
        this.pulses = pulses;
    }

    public String getOilseeds() {
        return oilseeds;
    }

    public void setOilseeds(String oilseeds) {
        this.oilseeds = oilseeds;
    }

    public String getPotato() {
        return potato;
    }

    public void setPotato(String potato) {
        this.potato = potato;
    }

    public String getTomato() {
        return tomato;
    }

    public void setTomato(String tomato) {
        this.tomato = tomato;
    }

    public String getVegetable() {
        return vegetable;
    }

    public void setVegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    public String getSugarcane() {
        return sugarcane;
    }

    public void setSugarcane(String sugarcane) {
        this.sugarcane = sugarcane;
    }

    public String getJute() {
        return jute;
    }

    public void setJute(String jute) {
        this.jute = jute;
    }

    public String getFarmingsellingtoGovtfixedprice() {
        return farmingsellingtoGovtfixedprice;
    }

    public void setFarmingsellingtoGovtfixedprice(String farmingsellingtoGovtfixedprice) {
        this.farmingsellingtoGovtfixedprice = farmingsellingtoGovtfixedprice;
    }

    public String getFarmingsellingtoPrivatetraders() {
        return farmingsellingtoPrivatetraders;
    }

    public void setFarmingsellingtoPrivatetraders(String farmingsellingtoPrivatetraders) {
        this.farmingsellingtoPrivatetraders = farmingsellingtoPrivatetraders;
    }

    public String getCattle() {
        return cattle;
    }

    public void setCattle(String cattle) {
        this.cattle = cattle;
    }

    public String getBuffalo() {
        return buffalo;
    }

    public void setBuffalo(String buffalo) {
        this.buffalo = buffalo;
    }

    public String getSheep() {
        return sheep;
    }

    public void setSheep(String sheep) {
        this.sheep = sheep;
    }

    public String getGoat() {
        return goat;
    }

    public void setGoat(String goat) {
        this.goat = goat;
    }

    public String getChicken() {
        return chicken;
    }

    public void setChicken(String chicken) {
        this.chicken = chicken;
    }

    public String getEgghens() {
        return egghens;
    }

    public void setEgghens(String egghens) {
        this.egghens = egghens;
    }

    public String getDuck() {
        return duck;
    }

    public void setDuck(String duck) {
        this.duck = duck;
    }

    public String getEggsduck() {
        return eggsduck;
    }

    public void setEggsduck(String eggsduck) {
        this.eggsduck = eggsduck;
    }

    public String getRuhi() {
        return ruhi;
    }

    public void setRuhi(String ruhi) {
        this.ruhi = ruhi;
    }

    public String getCatla() {
        return catla;
    }

    public void setCatla(String catla) {
        this.catla = catla;
    }

    public String getMixedfish() {
        return mixedfish;
    }

    public void setMixedfish(String mixedfish) {
        this.mixedfish = mixedfish;
    }

    public String getPangas() {
        return pangas;
    }

    public void setPangas(String pangas) {
        this.pangas = pangas;
    }

    public String getKoi() {
        return koi;
    }

    public void setKoi(String koi) {
        this.koi = koi;
    }

    public String getMagur() {
        return magur;
    }

    public void setMagur(String magur) {
        this.magur = magur;
    }

    public String getTilapia() {
        return tilapia;
    }

    public void setTilapia(String tilapia) {
        this.tilapia = tilapia;
    }

    public String getShrimp() {
        return shrimp;
    }

    public void setShrimp(String shrimp) {
        this.shrimp = shrimp;
    }

    public String getPrawn() {
        return prawn;
    }

    public void setPrawn(String prawn) {
        this.prawn = prawn;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getSurveystatus() {
        return surveystatus;
    }

    public void setSurveystatus(String surveystatus) {
        this.surveystatus = surveystatus;
    }

    public ArrayList<MemberObject> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<MemberObject> members) {
        this.members = members;
    }

    public ArrayList<LoanObject> getLoan() {
        return loan;
    }

    public void setLoan(ArrayList<LoanObject> loan) {
        this.loan = loan;
    }
}
