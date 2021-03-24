package com.azhar.e_parishad_b.Networking.EPNET.DataObject;

public class MemberObject {

    String membername, member_id, bloodgroup, fathername, mothername, gender, relationship, bdaydate,
            bdaymonth, bdayyear, age, birthcertificateno, birthcertificateimage, nationality, nid, nidimage;

    String[] membervaccine;
    String[] disability;

    String ismothervaccination, nearesthospital, maternitynutritionconsultancy, consultingwith, iseligiblecouple, anyfamilyplaning;

    String[] socialsafetynet;

    String socialsafetynetcardinfo, socialsafetynetcardphoto,
            isTinAvaiable, tinNumber, tinimage, passportno, passportimage, isDrivingLicenceAvailable, drivingLicenceNumber,
            dirivinglicenseimage, higheshtEducation, doyoustudynow, whichLevel, educationinstitution, educationFinishingWant;
    String[] training;
    String primaryprofession, secondaryprofession, ifunemployednow, rickformofownership, ricksourcesoffinance,
            ricknooftransport, maritialstatus, marriageRegNo, marriageRegDate, divorceRegNo, divorceRegDate,
            incomefromMainOccuption, incomefromSecondOccuption, additionalincome, mobaileNumber, email,
            accountNo, mobaileNo, bankName, branchName, ismemberlivehere, mlivingAddress, memberimage;


    public MemberObject(String membername, String member_id, String bloodgroup, String fathername, String mothername, String gender, String relationship, String bdaydate, String bdaymonth, String bdayyear, String age, String birthcertificateno, String birthcertificateimage, String nationality, String nid, String nidimage, String[] membervaccine, String[] disability, String ismothervaccination, String nearesthospital, String maternitynutritionconsultancy, String consultingwith, String iseligiblecouple, String anyfamilyplaning, String[] socialsafetynet, String socialsafetynetcardinfo, String socialsafetynetcardphoto, String isTinAvaiable, String tinNumber, String tinimage, String passportno, String passportimage, String isDrivingLicenceAvailable, String drivingLicenceNumber, String dirivinglicenseimage, String higheshtEducation, String doyoustudynow, String whichLevel, String educationinstitution, String educationFinishingWant, String[] training, String primaryprofession, String secondaryprofession, String ifunemployednow, String rickformofownership, String ricksourcesoffinance, String ricknooftransport, String maritialstatus, String marriageRegNo, String marriageRegDate, String divorceRegNo, String divorceRegDate, String incomefromMainOccuption, String incomefromSecondOccuption, String additionalincome, String mobaileNumber, String email, String accountNo, String mobaileNo, String bankName, String branchName, String ismemberlivehere, String mlivingAddress, String memberimage) {
        this.membername = membername;
        this.member_id = member_id;
        this.bloodgroup = bloodgroup;
        this.fathername = fathername;
        this.mothername = mothername;
        this.gender = gender;
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
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getBdaydate() {
        return bdaydate;
    }

    public void setBdaydate(String bdaydate) {
        this.bdaydate = bdaydate;
    }

    public String getBdaymonth() {
        return bdaymonth;
    }

    public void setBdaymonth(String bdaymonth) {
        this.bdaymonth = bdaymonth;
    }

    public String getBdayyear() {
        return bdayyear;
    }

    public void setBdayyear(String bdayyear) {
        this.bdayyear = bdayyear;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthcertificateno() {
        return birthcertificateno;
    }

    public void setBirthcertificateno(String birthcertificateno) {
        this.birthcertificateno = birthcertificateno;
    }

    public String getBirthcertificateimage() {
        return birthcertificateimage;
    }

    public void setBirthcertificateimage(String birthcertificateimage) {
        this.birthcertificateimage = birthcertificateimage;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getNidimage() {
        return nidimage;
    }

    public void setNidimage(String nidimage) {
        this.nidimage = nidimage;
    }

    public String[] getMembervaccine() {
        return membervaccine;
    }

    public void setMembervaccine(String[] membervaccine) {
        this.membervaccine = membervaccine;
    }

    public String[] getDisability() {
        return disability;
    }

    public void setDisability(String[] disability) {
        this.disability = disability;
    }

    public String getIsmothervaccination() {
        return ismothervaccination;
    }

    public void setIsmothervaccination(String ismothervaccination) {
        this.ismothervaccination = ismothervaccination;
    }

    public String getNearesthospital() {
        return nearesthospital;
    }

    public void setNearesthospital(String nearesthospital) {
        this.nearesthospital = nearesthospital;
    }

    public String getMaternitynutritionconsultancy() {
        return maternitynutritionconsultancy;
    }

    public void setMaternitynutritionconsultancy(String maternitynutritionconsultancy) {
        this.maternitynutritionconsultancy = maternitynutritionconsultancy;
    }

    public String getConsultingwith() {
        return consultingwith;
    }

    public void setConsultingwith(String consultingwith) {
        this.consultingwith = consultingwith;
    }

    public String getIseligiblecouple() {
        return iseligiblecouple;
    }

    public void setIseligiblecouple(String iseligiblecouple) {
        this.iseligiblecouple = iseligiblecouple;
    }

    public String getAnyfamilyplaning() {
        return anyfamilyplaning;
    }

    public void setAnyfamilyplaning(String anyfamilyplaning) {
        this.anyfamilyplaning = anyfamilyplaning;
    }

    public String[] getSocialsafetynet() {
        return socialsafetynet;
    }

    public void setSocialsafetynet(String[] socialsafetynet) {
        this.socialsafetynet = socialsafetynet;
    }

    public String getSocialsafetynetcardinfo() {
        return socialsafetynetcardinfo;
    }

    public void setSocialsafetynetcardinfo(String socialsafetynetcardinfo) {
        this.socialsafetynetcardinfo = socialsafetynetcardinfo;
    }

    public String getSocialsafetynetcardphoto() {
        return socialsafetynetcardphoto;
    }

    public void setSocialsafetynetcardphoto(String socialsafetynetcardphoto) {
        this.socialsafetynetcardphoto = socialsafetynetcardphoto;
    }

    public String getIsTinAvaiable() {
        return isTinAvaiable;
    }

    public void setIsTinAvaiable(String isTinAvaiable) {
        this.isTinAvaiable = isTinAvaiable;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getTinimage() {
        return tinimage;
    }

    public void setTinimage(String tinimage) {
        this.tinimage = tinimage;
    }

    public String getPassportno() {
        return passportno;
    }

    public void setPassportno(String passportno) {
        this.passportno = passportno;
    }

    public String getPassportimage() {
        return passportimage;
    }

    public void setPassportimage(String passportimage) {
        this.passportimage = passportimage;
    }

    public String getIsDrivingLicenceAvailable() {
        return isDrivingLicenceAvailable;
    }

    public void setIsDrivingLicenceAvailable(String isDrivingLicenceAvailable) {
        this.isDrivingLicenceAvailable = isDrivingLicenceAvailable;
    }

    public String getDrivingLicenceNumber() {
        return drivingLicenceNumber;
    }

    public void setDrivingLicenceNumber(String drivingLicenceNumber) {
        this.drivingLicenceNumber = drivingLicenceNumber;
    }

    public String getDirivinglicenseimage() {
        return dirivinglicenseimage;
    }

    public void setDirivinglicenseimage(String dirivinglicenseimage) {
        this.dirivinglicenseimage = dirivinglicenseimage;
    }

    public String getHigheshtEducation() {
        return higheshtEducation;
    }

    public void setHigheshtEducation(String higheshtEducation) {
        this.higheshtEducation = higheshtEducation;
    }

    public String getDoyoustudynow() {
        return doyoustudynow;
    }

    public void setDoyoustudynow(String doyoustudynow) {
        this.doyoustudynow = doyoustudynow;
    }

    public String getWhichLevel() {
        return whichLevel;
    }

    public void setWhichLevel(String whichLevel) {
        this.whichLevel = whichLevel;
    }

    public String getEducationinstitution() {
        return educationinstitution;
    }

    public void setEducationinstitution(String educationinstitution) {
        this.educationinstitution = educationinstitution;
    }

    public String getEducationFinishingWant() {
        return educationFinishingWant;
    }

    public void setEducationFinishingWant(String educationFinishingWant) {
        this.educationFinishingWant = educationFinishingWant;
    }

    public String[] getTraining() {
        return training;
    }

    public void setTraining(String[] training) {
        this.training = training;
    }

    public String getPrimaryprofession() {
        return primaryprofession;
    }

    public void setPrimaryprofession(String primaryprofession) {
        this.primaryprofession = primaryprofession;
    }

    public String getSecondaryprofession() {
        return secondaryprofession;
    }

    public void setSecondaryprofession(String secondaryprofession) {
        this.secondaryprofession = secondaryprofession;
    }

    public String getIfunemployednow() {
        return ifunemployednow;
    }

    public void setIfunemployednow(String ifunemployednow) {
        this.ifunemployednow = ifunemployednow;
    }

    public String getRickformofownership() {
        return rickformofownership;
    }

    public void setRickformofownership(String rickformofownership) {
        this.rickformofownership = rickformofownership;
    }

    public String getRicksourcesoffinance() {
        return ricksourcesoffinance;
    }

    public void setRicksourcesoffinance(String ricksourcesoffinance) {
        this.ricksourcesoffinance = ricksourcesoffinance;
    }

    public String getRicknooftransport() {
        return ricknooftransport;
    }

    public void setRicknooftransport(String ricknooftransport) {
        this.ricknooftransport = ricknooftransport;
    }

    public String getMaritialstatus() {
        return maritialstatus;
    }

    public void setMaritialstatus(String maritialstatus) {
        this.maritialstatus = maritialstatus;
    }

    public String getMarriageRegNo() {
        return marriageRegNo;
    }

    public void setMarriageRegNo(String marriageRegNo) {
        this.marriageRegNo = marriageRegNo;
    }

    public String getMarriageRegDate() {
        return marriageRegDate;
    }

    public void setMarriageRegDate(String marriageRegDate) {
        this.marriageRegDate = marriageRegDate;
    }

    public String getDivorceRegNo() {
        return divorceRegNo;
    }

    public void setDivorceRegNo(String divorceRegNo) {
        this.divorceRegNo = divorceRegNo;
    }

    public String getDivorceRegDate() {
        return divorceRegDate;
    }

    public void setDivorceRegDate(String divorceRegDate) {
        this.divorceRegDate = divorceRegDate;
    }

    public String getIncomefromMainOccuption() {
        return incomefromMainOccuption;
    }

    public void setIncomefromMainOccuption(String incomefromMainOccuption) {
        this.incomefromMainOccuption = incomefromMainOccuption;
    }

    public String getIncomefromSecondOccuption() {
        return incomefromSecondOccuption;
    }

    public void setIncomefromSecondOccuption(String incomefromSecondOccuption) {
        this.incomefromSecondOccuption = incomefromSecondOccuption;
    }

    public String getAdditionalincome() {
        return additionalincome;
    }

    public void setAdditionalincome(String additionalincome) {
        this.additionalincome = additionalincome;
    }

    public String getMobaileNumber() {
        return mobaileNumber;
    }

    public void setMobaileNumber(String mobaileNumber) {
        this.mobaileNumber = mobaileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getMobaileNo() {
        return mobaileNo;
    }

    public void setMobaileNo(String mobaileNo) {
        this.mobaileNo = mobaileNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIsmemberlivehere() {
        return ismemberlivehere;
    }

    public void setIsmemberlivehere(String ismemberlivehere) {
        this.ismemberlivehere = ismemberlivehere;
    }

    public String getMlivingAddress() {
        return mlivingAddress;
    }

    public void setMlivingAddress(String mlivingAddress) {
        this.mlivingAddress = mlivingAddress;
    }

    public String getMemberimage() {
        return memberimage;
    }

    public void setMemberimage(String memberimage) {
        this.memberimage = memberimage;
    }
}