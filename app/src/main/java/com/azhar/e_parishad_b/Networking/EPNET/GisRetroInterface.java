package com.azhar.e_parishad_b.Networking.EPNET;

import android.util.Log;

import com.azhar.e_parishad_b.Networking.EPNET.DataObject.GisObject;
import com.azhar.e_parishad_b.Networking.EPNET.Response.ResponseObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GisRetroInterface {

    @POST("/khanaseditgis")
    Call<ResponseObject> PostData(@Body GisObject gisObject);

}
