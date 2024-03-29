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
import android.widget.TextView;
import com.azhar.e_parishad_b.Database.Entity.FaEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.Networking.FA.MyWorker;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.Fa.FaAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FSAActivity extends AppCompatActivity {


    TextView totalCountTv;
    int totalCount;

    //==========================================
    RecyclerView recyclerViewfa ;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<FaEntity> faEntityArrayList;
    FaAdapter faAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_s_a);


//        totalCountTv = findViewById(R.id.totalCountTv);
        recyclerViewfa = findViewById(R.id.faRecyclerViewId);

        //=-===============================================================

//        SyncFa syncFa = new SyncFa(getApplicationContext());

        totalCount = 0;

//        totalCountTv.setText(String.valueOf(totalCount));

        //===================== RecyclerView =========================
        recyclerViewfa.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewfa.setLayoutManager(layoutManager);
        recyclerViewfa.setItemAnimator(new DefaultItemAnimator());

        LoadDataTask loadDataTask = new LoadDataTask();
        loadDataTask.execute();


    }

    public void goToHome(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    class LoadDataTask extends AsyncTask<Void, Void, Void> {

        Repository repository;
        List<FaEntity> faEntityList;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            repository = new Repository(getApplicationContext());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            faEntityList = repository.getAllFaEntityData();
            faEntityArrayList = new ArrayList<>();

            faEntityArrayList.addAll(faEntityList);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            faAdapter = new FaAdapter(FSAActivity.this, faEntityArrayList);
            recyclerViewfa.setAdapter(faAdapter);
        }

    }




}