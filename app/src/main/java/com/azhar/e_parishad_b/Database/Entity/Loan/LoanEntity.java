package com.azhar.e_parishad_b.Database.Entity.Loan;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LoanEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "loanName")
    public String loanName;

    @ColumnInfo(name = "isfinancialsupported")
    public String isfinancialsupported;

    @ColumnInfo(name = "financialsupportfrom")
    public String financialsupportfrom;

    @ColumnInfo(name = "loanInstitute")
    public String loanInstitute;

    @ColumnInfo(name = "loanAmount")
    public String loanAmount;

    @ColumnInfo(name = "loanPeriod")
    public String loanPeriod;

    @ColumnInfo(name = "year")
    public String year;

    @ColumnInfo(name = "month")
    public String month;

    @ColumnInfo(name = "day")
    public String day;

    @ColumnInfo(name = "kinnumber")
    public String kinnumber;

    public LoanEntity(int id, String loanName, String isfinancialsupported, String financialsupportfrom, String loanInstitute, String loanAmount, String loanPeriod, String year, String month, String day, String kinnumber) {
        this.id = id;
        this.loanName = loanName;
        this.isfinancialsupported = isfinancialsupported;
        this.financialsupportfrom = financialsupportfrom;
        this.loanInstitute = loanInstitute;
        this.loanAmount = loanAmount;
        this.loanPeriod = loanPeriod;
        this.year = year;
        this.month = month;
        this.day = day;
        this.kinnumber = kinnumber;
    }

    public LoanEntity(String loanNamer, String isfinancialsupportedr, String financialsupportfromr, String loanInstituter, String loanAmountr,  String yearr, String monthr, String dayr, String loanPeriodr, String kinnumberr) {
        this.loanName = loanNamer;
        this.isfinancialsupported = isfinancialsupportedr;
        this.financialsupportfrom = financialsupportfromr;
        this.loanInstitute = loanInstituter;
        this.loanAmount = loanAmountr;
        this.year = yearr;
        this.month = monthr;
        this.day = dayr;
        this.loanPeriod = loanPeriodr;
        this.kinnumber = kinnumberr;
    }


}
