package com.azhar.e_parishad_b.Database.Entity.Member;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MNEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "member_id")
    public String member_id;

    @ColumnInfo(name = "bloodgroup")
    public String bloodgroup;

    @ColumnInfo(name = "fathername")
    public String fathername;

    @ColumnInfo(name = "mothername")
    public String mothername;

    @ColumnInfo(name = "gender")
    public String gender;

    @ColumnInfo(name = "isHead")
    public String isHead;

    @ColumnInfo(name = "relationship")
    public String relationship;

    @ColumnInfo(name = "bdaydate")
    public String bdaydate;

    @ColumnInfo(name = "bdaymonth")
    public String bdaymonth;

    @ColumnInfo(name = "bdayyear")
    public String bdayyear;

    @ColumnInfo(name = "age")
    public String age;

    @ColumnInfo(name = "birthcertificateno")
    public String birthcertificateno;

    @ColumnInfo(name = "birthcertificateimage")
    public String birthcertificateimage;

    @ColumnInfo(name = "nationality")
    public String nationality;

    @ColumnInfo(name = "nid")
    public String nid;

    @ColumnInfo(name = "nidimage")
    public String nidimage;

    @ColumnInfo(name = "membervaccine")
    public String membervaccine;

    @ColumnInfo(name = "disability")
    public String disability;

    @ColumnInfo(name = "ismothervaccination")
    public String ismothervaccination;

    @ColumnInfo(name = "nearesthospital")
    public String nearesthospital;

    @ColumnInfo(name = "maternitynutritionconsultancy")
    public String maternitynutritionconsultancy;

    @ColumnInfo(name = "consultingwith")
    public String consultingwith;

    @ColumnInfo(name = "iseligiblecouple")
    public String iseligiblecouple;

    @ColumnInfo(name = "anyfamilyplaning")
    public String anyfamilyplaning;

    @ColumnInfo(name = "socialsafetynet")
    public String socialsafetynet;

    @ColumnInfo(name = "socialsafetynetcardinfo")
    public String socialsafetynetcardinfo;

    @ColumnInfo(name = "socialsafetynetcardphoto")
    public String socialsafetynetcardphoto;

    @ColumnInfo(name = "isTinAvaiable")
    public String isTinAvaiable;

    @ColumnInfo(name = "tinNumber")
    public String tinNumber;

    @ColumnInfo(name = "tinimage")
    public String tinimage;

    @ColumnInfo(name = "passportno")
    public String passportno;

    @ColumnInfo(name = "passportimage")
    public String passportimage;

    @ColumnInfo(name = "isDrivingLicenceAvailable")
    public String isDrivingLicenceAvailable;

    @ColumnInfo(name = "drivingLicenceNumber")
    public String drivingLicenceNumber;

    @ColumnInfo(name = "dirivinglicenseimage")
    public String dirivinglicenseimage;

    @ColumnInfo(name = "higheshtEducation")
    public String higheshtEducation;

    @ColumnInfo(name = "doyoustudynow")
    public String doyoustudynow;

    @ColumnInfo(name = "whichLevel")
    public String whichLevel;

    @ColumnInfo(name = "educationinstitution")
    public String educationinstitution;

    @ColumnInfo(name = "educationFinishingWant")
    public String educationFinishingWant;

    @ColumnInfo(name = "training")
    public String training;

    @ColumnInfo(name = "primaryprofession")
    public String primaryprofession;

    @ColumnInfo(name = "secondaryprofession")
    public String secondaryprofession;

    @ColumnInfo(name = "ifunemployednow")
    public String ifunemployednow;

    @ColumnInfo(name = "rickformofownership")
    public String rickformofownership;

    @ColumnInfo(name = "ricksourcesoffinance")
    public String ricksourcesoffinance;

    @ColumnInfo(name = "ricknooftransport")
    public String ricknooftransport;

    @ColumnInfo(name = "maritialstatus")
    public String maritialstatus;

    @ColumnInfo(name = "marriageRegNo")
    public String marriageRegNo;

    @ColumnInfo(name = "marriageRegDate")
    public String marriageRegDate;

    @ColumnInfo(name = "divorceRegNo")
    public String divorceRegNo;

    @ColumnInfo(name = "divorceRegDate")
    public String divorceRegDate;

    @ColumnInfo(name = "incomefromMainOccuption")
    public String incomefromMainOccuption;

    @ColumnInfo(name = "incomefromSecondOccuption")
    public String incomefromSecondOccuption;

    @ColumnInfo(name = "additionalincome")
    public String additionalincome;

    @ColumnInfo(name = "mobaileNumber")
    public String mobaileNumber;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "accountNo")
    public String accountNo;

    @ColumnInfo(name = "mobaileNo")
    public String mobaileNo;

    @ColumnInfo(name = "bankName")
    public String bankName;

    @ColumnInfo(name = "branchName")
    public String branchName;

    @ColumnInfo(name = "ismemberlivehere")
    public String ismemberlivehere;

    @ColumnInfo(name = "mlivingAddress")
    public String mlivingAddress;

    @ColumnInfo(name = "memberimage")
    public String memberimage;

    @ColumnInfo(name = "kinnumber")
    public String kinnumber;

    public MNEntity(String namei, String member_idi, String bloodgroupi, String fathernamei, String mothernamei, String genderi, String isHeadi, String relationshipi, String bdaydatei, String bdaymonthi, String bdayyeari, String agei, String birthcertificatenoi, String birthcertificateimagei, String nationalityi, String nidi, String nidimagei, String membervaccinei, String disabilityi, String ismothervaccinationi, String nearesthospitali, String maternitynutritionconsultancyi, String consultingwithi, String iseligiblecouplei, String anyfamilyplaningi, String socialsafetyneti, String socialsafetynetcardinfoi, String socialsafetynetcardphotoi, String isTinAvaiablei, String tinNumberi, String tinimagei, String passportnoi, String passportimagei, String isDrivingLicenceAvailablei, String drivingLicenceNumberi, String dirivinglicenseimagei, String higheshtEducationi, String doyoustudynowi, String whichLeveli, String educationinstitutioni, String educationFinishingWanti, String trainingi, String primaryprofessioni, String secondaryprofessioni, String ifunemployednowi, String rickformofownershipi, String ricksourcesoffinancei, String ricknooftransporti, String maritialstatusi, String marriageRegNoi, String marriageRegDatei, String divorceRegNoi, String divorceRegDatei, String incomefromMainOccuptioni, String incomefromSecondOccuptioni, String additionalincomei, String mobaileNumberi, String emaili, String accountNoi, String mobaileNoi, String bankNamei, String branchNamei, String ismemberliveherei, String mlivingAddressi, String memberimagei, String kinnumberi) {
        this.name = namei;
        this.member_id = member_idi;
        this.bloodgroup = bloodgroupi;
        this.fathername = fathernamei;
        this.mothername = mothernamei;
        this.gender = genderi;
        this.isHead = isHeadi;
        this.relationship = relationshipi;
        this.bdaydate = bdaydatei;
        this.bdaymonth = bdaymonthi;
        this.bdayyear = bdayyeari;
        this.age = agei;
        this.birthcertificateno = birthcertificatenoi;
        this.birthcertificateimage = birthcertificateimagei;
        this.nationality = nationalityi;
        this.nid = nidi;
        this.nidimage = nidimagei;
        this.membervaccine = membervaccinei;
        this.disability = disabilityi;
        this.ismothervaccination = ismothervaccinationi;
        this.nearesthospital = nearesthospitali;
        this.maternitynutritionconsultancy = maternitynutritionconsultancyi;
        this.consultingwith = consultingwithi;
        this.iseligiblecouple = iseligiblecouplei;
        this.anyfamilyplaning = anyfamilyplaningi;
        this.socialsafetynet = socialsafetyneti;
        this.socialsafetynetcardinfo = socialsafetynetcardinfoi;
        this.socialsafetynetcardphoto = socialsafetynetcardphotoi;
        this.isTinAvaiable = isTinAvaiablei;
        this.tinNumber = tinNumberi;
        this.tinimage = tinimagei;
        this.passportno = passportnoi;
        this.passportimage = passportimagei;
        this.isDrivingLicenceAvailable = isDrivingLicenceAvailablei;
        this.drivingLicenceNumber = drivingLicenceNumberi;
        this.dirivinglicenseimage = dirivinglicenseimagei;
        this.higheshtEducation = higheshtEducationi;
        this.doyoustudynow = doyoustudynowi;
        this.whichLevel = whichLeveli;
        this.educationinstitution = educationinstitutioni;
        this.educationFinishingWant = educationFinishingWanti;
        this.training = trainingi;
        this.primaryprofession = primaryprofessioni;
        this.secondaryprofession = secondaryprofessioni;
        this.ifunemployednow = ifunemployednowi;
        this.rickformofownership = rickformofownershipi;
        this.ricksourcesoffinance = ricksourcesoffinancei;
        this.ricknooftransport = ricknooftransporti;
        this.maritialstatus = maritialstatusi;
        this.marriageRegNo = marriageRegNoi;
        this.marriageRegDate = marriageRegDatei;
        this.divorceRegNo = divorceRegNoi;
        this.divorceRegDate = divorceRegDatei;
        this.incomefromMainOccuption = incomefromMainOccuptioni;
        this.incomefromSecondOccuption = incomefromSecondOccuptioni;
        this.additionalincome = additionalincomei;
        this.mobaileNumber = mobaileNumberi;
        this.email = emaili;
        this.accountNo = accountNoi;
        this.mobaileNo = mobaileNoi;
        this.bankName = bankNamei;
        this.branchName = branchNamei;
        this.ismemberlivehere = ismemberliveherei;
        this.mlivingAddress = mlivingAddressi;
        this.memberimage = memberimagei;
        this.kinnumber = kinnumberi;
    }


    public MNEntity(int id, String name, String member_id, String bloodgroup, String fathername, String mothername, String gender, String isHead, String relationship, String bdaydate, String bdaymonth, String bdayyear, String age, String birthcertificateno, String birthcertificateimage, String nationality, String nid, String nidimage, String membervaccine, String disability, String ismothervaccination, String nearesthospital, String maternitynutritionconsultancy, String consultingwith, String iseligiblecouple, String anyfamilyplaning, String socialsafetynet, String socialsafetynetcardinfo, String socialsafetynetcardphoto, String isTinAvaiable, String tinNumber, String tinimage, String passportno, String passportimage, String isDrivingLicenceAvailable, String drivingLicenceNumber, String dirivinglicenseimage, String higheshtEducation, String doyoustudynow, String whichLevel, String educationinstitution, String educationFinishingWant, String training, String primaryprofession, String secondaryprofession, String ifunemployednow, String rickformofownership, String ricksourcesoffinance, String ricknooftransport, String maritialstatus, String marriageRegNo, String marriageRegDate, String divorceRegNo, String divorceRegDate, String incomefromMainOccuption, String incomefromSecondOccuption, String additionalincome, String mobaileNumber, String email, String accountNo, String mobaileNo, String bankName, String branchName, String ismemberlivehere, String mlivingAddress, String memberimage, String kinnumber) {
        this.id = id;
        this.name = name;
        this.member_id = member_id;
        this.bloodgroup = bloodgroup;
        this.fathername = fathername;
        this.mothername = mothername;
        this.gender = gender;
        this.isHead = isHead;
        this.relationship = relationship;
        this.bdaydate = bdaydate;
        this.bdaymonth = bdaymonth;
        this.bdayyear = bdayyear;
        this.age = age;
        this.birthcertificateno = birthcertificateno;
        this.birthcertificateimage = birthcertificateimage;
        this.nationality = nationality;
        this.nid = nid;
        this.nidimage = nidimage;
        this.membervaccine = membervaccine;
        this.disability = disability;
        this.ismothervaccination = ismothervaccination;
        this.nearesthospital = nearesthospital;
        this.maternitynutritionconsultancy = maternitynutritionconsultancy;
        this.consultingwith = consultingwith;
        this.iseligiblecouple = iseligiblecouple;
        this.anyfamilyplaning = anyfamilyplaning;
        this.socialsafetynet = socialsafetynet;
        this.socialsafetynetcardinfo = socialsafetynetcardinfo;
        this.socialsafetynetcardphoto = socialsafetynetcardphoto;
        this.isTinAvaiable = isTinAvaiable;
        this.tinNumber = tinNumber;
        this.tinimage = tinimage;
        this.passportno = passportno;
        this.passportimage = passportimage;
        this.isDrivingLicenceAvailable = isDrivingLicenceAvailable;
        this.drivingLicenceNumber = drivingLicenceNumber;
        this.dirivinglicenseimage = dirivinglicenseimage;
        this.higheshtEducation = higheshtEducation;
        this.doyoustudynow = doyoustudynow;
        this.whichLevel = whichLevel;
        this.educationinstitution = educationinstitution;
        this.educationFinishingWant = educationFinishingWant;
        this.training = training;
        this.primaryprofession = primaryprofession;
        this.secondaryprofession = secondaryprofession;
        this.ifunemployednow = ifunemployednow;
        this.rickformofownership = rickformofownership;
        this.ricksourcesoffinance = ricksourcesoffinance;
        this.ricknooftransport = ricknooftransport;
        this.maritialstatus = maritialstatus;
        this.marriageRegNo = marriageRegNo;
        this.marriageRegDate = marriageRegDate;
        this.divorceRegNo = divorceRegNo;
        this.divorceRegDate = divorceRegDate;
        this.incomefromMainOccuption = incomefromMainOccuption;
        this.incomefromSecondOccuption = incomefromSecondOccuption;
        this.additionalincome = additionalincome;
        this.mobaileNumber = mobaileNumber;
        this.email = email;
        this.accountNo = accountNo;
        this.mobaileNo = mobaileNo;
        this.bankName = bankName;
        this.branchName = branchName;
        this.ismemberlivehere = ismemberlivehere;
        this.mlivingAddress = mlivingAddress;
        this.memberimage = memberimage;
        this.kinnumber = kinnumber;
    }

}
