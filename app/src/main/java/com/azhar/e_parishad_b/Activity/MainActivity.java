package com.azhar.e_parishad_b.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.azhar.e_parishad_b.Database.Entity.FDEntity;
import com.azhar.e_parishad_b.Database.Entity.FaEntity;
import com.azhar.e_parishad_b.Database.Entity.GISEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.Database.Entity.Member.MNEntity;
import com.azhar.e_parishad_b.ImageProcessing.ImageEncoder;
import com.azhar.e_parishad_b.Networking.EPNET.Service;
import com.azhar.e_parishad_b.Networking.FA.MyWorker;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.Fa.FaAdapter;
import com.azhar.e_parishad_b.RecyclerView.Top.MyTopAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    //==========================================
    ImageView imageView;
    TextView totalCountTv;
    int totalCount;

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
        setContentView(R.layout.nav_drawer_main_activity);

        toolbar=findViewById(R.id.toolBar);


        imageView = findViewById(R.id.syncImgId);
//        totalCountTv = findViewById(R.id.totalCountTv);
        recyclerViewfd = findViewById(R.id.mainRecyclerViewId);


        totalCount = 10;


        //============================ Nav Start =======================================
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        drawerLayout=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener( this);
        //============================ Nav End =======================================

        //=====================================================================================
        //=====================================================================================

        Repository  repository = new Repository(getApplicationContext());
        repository.DeleteAllGIS();


        repository.InsertGISTask(new GISEntity("20211","Jamal Uddin", "22323","Bijoypur", "23.813287730", "90.4103383","0"));
        repository.InsertGISTask(new GISEntity("20212","Kamal Uddin", "22324","Bijoypur", "23.813287730", "90.4103383","0"));
        repository.InsertGISTask(new GISEntity("20213","Kamal Uddin", "22325","Bijoypur", "", "","0"));


        //=====================================================================================
        //=====================================================================================



//        totalCountTv.setText(String.valueOf(totalCount));

        //============================= Fsa Data Loader4=====================================


//            startService(new Intent(this, Service.class));





        //===================== RecyclerView =========================

        recyclerViewfd.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewfd.setLayoutManager(layoutManager);
        recyclerViewfd.setItemAnimator(new DefaultItemAnimator());

       LoadDataTask loadDataTask = new LoadDataTask();
       loadDataTask.execute();

//       refreshPreiodicWork();
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.gis_nav_btn_id) {
            Intent intent =new Intent(MainActivity.this,GisActivity.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
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