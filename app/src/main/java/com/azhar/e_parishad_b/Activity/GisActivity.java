package com.azhar.e_parishad_b.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.azhar.e_parishad_b.Database.Entity.FDEntity;
import com.azhar.e_parishad_b.Database.Entity.FaEntity;
import com.azhar.e_parishad_b.Database.Entity.GISEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.Networking.FA.MyWorker;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.GIS.GISAdapter;
import com.azhar.e_parishad_b.RecyclerView.Top.MyTopAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GisActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<GISEntity> gisEntityArrayList;
    GISAdapter gisAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gis);

        recyclerView = findViewById(R.id.gisRecyclerViewId);



        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        LoadDataTask loadDataTask = new LoadDataTask();
        loadDataTask.execute();

//        refreshPreiodicWork();

    }

    public void refresh(View view) {
        startActivity(new Intent(GisActivity.this, GisActivity.class));
    }

    public void goToHome(View view) {
        startActivity(new Intent(GisActivity.this, MainActivity.class));
    }

    class LoadDataTask extends AsyncTask<Void, Void, Void> {

        Repository repository;
        List<GISEntity> gisEntityList;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            repository = new Repository(getApplicationContext());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            gisEntityList = repository.getGIS();
            gisEntityArrayList = new ArrayList<>();

            gisEntityArrayList.addAll(gisEntityList);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            gisAdapter = new GISAdapter(GisActivity.this, gisEntityArrayList);
            recyclerView.setAdapter(gisAdapter);
        }
    }

//    public static void refreshPreiodicWork(){
//        Constraints constraints = new Constraints.Builder()
//                .setRequiresDeviceIdle(false)
//                .setRequiresCharging(false)
//                .setRequiredNetworkType(NetworkType.CONNECTED)
//                .setRequiresBatteryNotLow(true)
//                .setRequiresStorageNotLow(true)
//                .build();
//
//        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(MyWorker.class, 15, TimeUnit.MINUTES).setConstraints(constraints).build();
//        WorkManager.getInstance().enqueue(periodicWorkRequest);
//    }
}