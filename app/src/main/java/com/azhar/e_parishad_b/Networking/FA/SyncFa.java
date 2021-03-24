package com.azhar.e_parishad_b.Networking.FA;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;


import com.azhar.e_parishad_b.Database.Entity.FaEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;

public class SyncFa {
    InputStream inputStream = null;
    JSONObject jsonObject = null;
    static String json = "";
    JSONObject getJsonObject = null;
    Context context;

    int data_in_roomDB = 0, data_from_server = 0;
    Repository repository;
    List<FaEntity> faEntityList;

    SharedPreferences LOGIN;
    String fauser;


    public SyncFa(Context context) {
        this.context = context;

        new load_numbers_of_record_task().execute();
        new parseSync().execute();
    }

    class parseSync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            make_url_request();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            parser(json);
            System.out.println(json);
            //Toast.makeText(context, json+"", Toast.LENGTH_LONG).show();
        }
    }

    void make_url_request(){

        //==================================================================================
        //================= Shared Preferences value retrive  for db=========================
        //====================================================================================
        LOGIN = context.getSharedPreferences("LOGIN", Context.MODE_PRIVATE);


        if (LOGIN.contains("user")) {
            fauser = LOGIN.getString("user", "Data Not Found");
        }

        try {
            String url = "http://103.147.182.110:5100/khanas?filter%5Bfauser%5D="+fauser;
            HttpHandler httpHandler = new HttpHandler();
            json = httpHandler.makeServiceCall(url);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void parser(String refjson){
        String stringjson = refjson;

        try {
            jsonObject = new JSONObject(stringjson);
            JSONArray jsonArray = jsonObject.getJSONArray("khana");
            data_from_server = jsonArray.length();



            if (jsonArray.length()>0){

                repository.DeleteAllTask();

                if (data_from_server>data_in_roomDB){
                    System.out.println(jsonArray);
                    for (int i=0; i<jsonArray.length(); i++){
                        System.out.println("for");
                        String id = jsonArray.getJSONObject(i).getString("id");
                        String date = jsonArray.getJSONObject(i).getString("date");
                        String holdingnumber = jsonArray.getJSONObject(i).getString("holdingnumber");
                        String isDraft = jsonArray.getJSONObject(i).getString("isDraft");
                        String khanahead = jsonArray.getJSONObject(i).getString("khanahead");
                        String khananumber = jsonArray.getJSONObject(i).getString("khananumber");
                        String surveyID = jsonArray.getJSONObject(i).getString("surveyID");
                        String surveystatus = jsonArray.getJSONObject(i).getString("surveystatus");
                        String timestamp = jsonArray.getJSONObject(i).getString("timestamp");
                        String timestampstr = jsonArray.getJSONObject(i).getString("timestampstr");
                        String union = jsonArray.getJSONObject(i).getString("union");
                        String village = jsonArray.getJSONObject(i).getString("village");
                        String ward = jsonArray.getJSONObject(i).getString("ward");

//                        fdRepository = new DayRepository(context);
                        FaEntity faEntity = new FaEntity(id, date, surveyID, surveystatus, khanahead, holdingnumber, khananumber, village, ward,isDraft);
                        repository.InsertTaskFaEntity(faEntity);


                    }

                }


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    class load_numbers_of_record_task extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            repository = new Repository(context);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            System.out.println("do");
            faEntityList = repository.getAllFaEntityData();
            data_in_roomDB = faEntityList.size();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
