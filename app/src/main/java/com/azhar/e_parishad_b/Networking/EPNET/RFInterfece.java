package com.azhar.e_parishad_b.Networking.EPNET;

import com.azhar.e_parishad_b.Networking.EPNET.DataObject.KhanaObject;
import com.azhar.e_parishad_b.Networking.EPNET.DataObject.MemberObject;
import com.azhar.e_parishad_b.Networking.EPNET.Response.ResponseObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RFInterfece {
    @POST("/mobilekhana")
    Call<ResponseObject> PostData(@Body KhanaObject khanaObject);
}
