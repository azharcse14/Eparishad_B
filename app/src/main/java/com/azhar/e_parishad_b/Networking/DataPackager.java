package com.azhar.e_parishad_b.Networking;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

/**
 * 1.BASICALLY PACKS DATA WE WANNA SEND
 */
public class DataPackager {

    String holdingnumber;
    String khananumber;


    /*
    SECTION 1.RECEIVE ALL DATA WE WANNA SEND
     */

    public DataPackager(String holdingnumber, String khananumber) {
        this.holdingnumber = holdingnumber;
        this.khananumber = khananumber;
    }

    /*
       SECTION 2
       1.PACK THEM INTO A JSON OBJECT
       1. READ ALL THIS DATA AND ENCODE IT INTO A FROMAT THAT CAN BE SENT VIA NETWORK
        */
    public String packData()
    {
        JSONObject jo=new JSONObject();
        StringBuffer packedData=new StringBuffer();

        try
        {
            jo.put("holdingnumber",holdingnumber);
            jo.put("khananumber",khananumber);


            Boolean firstValue=true;

            Iterator it=jo.keys();

            do {
                String key=it.next().toString();
                String value=jo.get(key).toString();

                if(firstValue)
                {
                    firstValue=false;
                }else
                {
                    packedData.append("&");
                }

                packedData.append(URLEncoder.encode(key,"UTF-8"));
                packedData.append("=");
                packedData.append(URLEncoder.encode(value,"UTF-8"));

            }while (it.hasNext());

            return packedData.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

}
