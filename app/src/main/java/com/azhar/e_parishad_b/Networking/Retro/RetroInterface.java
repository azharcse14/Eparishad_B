package com.azhar.e_parishad_b.Networking.Retro;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetroInterface {

    @POST("/mobilekhana")
    Call<DataSet> PostData(@Body DataSet dataSet);
}
