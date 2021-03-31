package com.azhar.e_parishad_b.Database.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FaEntity {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "surveyId")
    public String surveyId;

    @ColumnInfo(name = "status")
    public String status;

    @ColumnInfo(name = "khanahead")
    public String khanahead;

    @ColumnInfo(name = "holdingnumber")
    public String holdingnumber;

    @ColumnInfo(name = "khananumber")
    public String khananumber;

    @ColumnInfo(name = "village")
    public String village;

    @ColumnInfo(name = "ward")
    public String ward;

    @ColumnInfo(name = "isDraft")
    public String isDraft;



    public FaEntity(String date, String surveyId, String status, String khanahead, String holdingnumber, String khananumber, String village, String ward, String isDraft) {
        this.date = date;
        this.surveyId = surveyId;
        this.status = status;
        this.khanahead = khanahead;
        this.holdingnumber = holdingnumber;
        this.khananumber = khananumber;
        this.village = village;
        this.ward = ward;
        this.isDraft = isDraft;
    }
}
