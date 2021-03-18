package com.azhar.e_parishad_b.Networking.EPNET.DataObject;

public class LoanObject {
    String loanName, loanInstitute, loanAmount, selectedYear,
            selectedMonth, selectedDay, loanPeriod, financialsupportfrom, isfinancialsupported;

    public LoanObject(String loanName, String loanInstitute, String loanAmount, String selectedYear, String selectedMonth, String selectedDay, String loanPeriod, String financialsupportfrom, String isfinancialsupported) {
        this.loanName = loanName;
        this.loanInstitute = loanInstitute;
        this.loanAmount = loanAmount;
        this.selectedYear = selectedYear;
        this.selectedMonth = selectedMonth;
        this.selectedDay = selectedDay;
        this.loanPeriod = loanPeriod;
        this.financialsupportfrom = financialsupportfrom;
        this.isfinancialsupported = isfinancialsupported;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public String getLoanInstitute() {
        return loanInstitute;
    }

    public void setLoanInstitute(String loanInstitute) {
        this.loanInstitute = loanInstitute;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(String selectedYear) {
        this.selectedYear = selectedYear;
    }

    public String getSelectedMonth() {
        return selectedMonth;
    }

    public void setSelectedMonth(String selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    public String getSelectedDay() {
        return selectedDay;
    }

    public void setSelectedDay(String selectedDay) {
        this.selectedDay = selectedDay;
    }

    public String getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getFinancialsupportfrom() {
        return financialsupportfrom;
    }

    public void setFinancialsupportfrom(String financialsupportfrom) {
        this.financialsupportfrom = financialsupportfrom;
    }

    public String getIsfinancialsupported() {
        return isfinancialsupported;
    }

    public void setIsfinancialsupported(String isfinancialsupported) {
        this.isfinancialsupported = isfinancialsupported;
    }
}
