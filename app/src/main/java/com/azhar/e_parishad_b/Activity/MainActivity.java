package com.azhar.e_parishad_b.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.azhar.e_parishad_b.Database.Entity.FDEntity;
import com.azhar.e_parishad_b.Database.Entity.FaEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.Database.Entity.Member.MNEntity;
import com.azhar.e_parishad_b.Networking.FA.MyWorker;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.Fa.FaAdapter;
import com.azhar.e_parishad_b.RecyclerView.Top.MyTopAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView totalCountTv;
    int totalCount;

    String urlAddress = "http://103.147.182.110:5100/khanas";

    String fauser = "wasifa_fsa@email.com";

    //==========================================
    RecyclerView recyclerViewfd, recyclerViewfa ;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<FDEntity> fdEntityArrayList;
    ArrayList<FaEntity> faEntityArrayList;
    MyTopAdapter myTopAdapter;
    FaAdapter faAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.syncImgId);
        totalCountTv = findViewById(R.id.totalCountTv);
        recyclerViewfd = findViewById(R.id.mainRecyclerViewId);


        totalCount = 0;

//        totalCount = fdEntityArrayList.size();

//        if (dataSet.size() == 1){
//            totalCount = dataSet.size();
//        }

        totalCountTv.setText(String.valueOf(totalCount));

        //===================== RecyclerView =========================


        recyclerViewfd.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewfd.setLayoutManager(layoutManager);
        recyclerViewfd.setItemAnimator(new DefaultItemAnimator());

       LoadDataTask loadDataTask = new LoadDataTask();
       loadDataTask.execute();
    }


    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void showfsadata(View view) {
        Intent intent = new Intent(getApplicationContext(), FSAActivity.class);
        startActivity(intent);
    }

    public void addNewSurvey(View view) {
        Intent intent = new Intent(getApplicationContext(), HoldingNoActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

    class LoadDataTask extends AsyncTask<Void, Void, Void> {

        Repository repository;
        List<FDEntity> fdEntityList;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            repository = new Repository(getApplicationContext());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            fdEntityList = repository.getAllData();
            fdEntityArrayList = new ArrayList<>();

            fdEntityArrayList.addAll(fdEntityList);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            myTopAdapter = new MyTopAdapter(MainActivity.this, fdEntityArrayList);
            recyclerViewfd.setAdapter(myTopAdapter);
        }
    }


}