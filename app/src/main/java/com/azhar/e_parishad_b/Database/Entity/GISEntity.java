package com.azhar.e_parishad_b.Database.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class GISEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "surveyId")
    public String surveyId;

    @ColumnInfo(name = "khanahead")
    public String khanahead;

    @ColumnInfo(name = "holdingnumber")
    public String holdingnumber;


    @ColumnInfo(name = "village")
    public String village;

    @ColumnInfo(name = "latitude")
    public String latitude;

    @ColumnInfo(name = "longitude")
    public String longitude;


    @ColumnInfo(name = "isSync")
    public String isSync;

    public GISEntity(int id, String surveyId, String khanahead, String holdingnumber, String village, String latitude, String longitude, String isSync) {
        this.id = id;
        this.surveyId = surveyId;
        this.khanahead = khanahead;
        this.holdingnumber = holdingnumber;
        this.village = village;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isSync = isSync;
    }

    public GISEntity(String surveyIdi, String khanaheadi, String holdingnumberi, String villagei, String latitudei, String longitudei, String isSynci) {
        this.surveyId = surveyIdi;
        this.khanahead = khanaheadi;
        this.holdingnumber = holdingnumberi;
        this.village = villagei;
        this.latitude = latitudei;
        this.longitude = longitudei;
        this.isSync = isSynci;
    }
}
