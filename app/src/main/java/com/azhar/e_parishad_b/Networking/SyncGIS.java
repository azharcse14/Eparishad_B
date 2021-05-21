package com.azhar.e_parishad_b.Networking;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;

import com.azhar.e_parishad_b.Database.Entity.GISEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.Networking.FA.HttpHandler;
import com.azhar.e_parishad_b.Networking.Notification.NotificationUtils;
import com.azhar.e_parishad_b.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.List;

public class SyncGIS {
    JSONObject jsonObject = null;
    static String json = "";
    Context context;

    int data_in_roomDB = 0, data_from_server = 0;
    Repository repository;
    List<GISEntity> gisEntityList;

    SharedPreferences LOGIN;
    String fauser;


    public SyncGIS(Context context) {
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
            String http = "http://103.147.182.110:5030/khanas?filter%5Bfauser%5D=";
            String url = http +fauser;

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
                        String surveyID = jsonArray.getJSONObject(i).getString("surveyID");
                        String khanahead = jsonArray.getJSONObject(i).getString("khanahead");
                        String holdingnumber = jsonArray.getJSONObject(i).getString("holdingnumber");
                        String village = jsonArray.getJSONObject(i).getString("village");
                        String lat = jsonArray.getJSONObject(i).getString("lat");
                        String lng = jsonArray.getJSONObject(i).getString("lng");
                        String isDraft = jsonArray.getJSONObject(i).getString("isDraft");


                        GISEntity gisEntity = new GISEntity(surveyID, khanahead, holdingnumber, village, lat, lng, isDraft);
                        repository.InsertGISTask(gisEntity);
                    }

                    createNotification(data_from_server - data_in_roomDB);

                }


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void createNotification(int diff){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationUtils notificationUtils = new NotificationUtils(context);
            Notification.Builder nb = notificationUtils.getAndroidChannelNotification("Survey Message", +diff+ "Survey");
            notificationUtils.getManager().notify(101, nb.build());
        }else {
            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            Notification.Builder builder = new Notification.Builder(context, "Survey Message")
                    .setContentTitle("Survey Message")
                    .setContentText("New" +diff+ "Survey Message")
                    .setSmallIcon(R.mipmap.ic_launcher);
            manager.notify(1, builder.build());
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
            gisEntityList = repository.getGIS();
            data_in_roomDB = gisEntityList.size();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}

