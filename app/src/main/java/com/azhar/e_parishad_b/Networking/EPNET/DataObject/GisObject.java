package com.azhar.e_parishad_b.Networking.EPNET.DataObject;

public class GisObject {
    String surveyId, lat, lng;

    public GisObject(String surveyId, String lat, String lng) {
        this.surveyId = surveyId;
        this.lat = lat;
        this.lng = lng;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
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
}
