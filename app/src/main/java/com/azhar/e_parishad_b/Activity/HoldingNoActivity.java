package com.azhar.e_parishad_b.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class HoldingNoActivity extends AppCompatActivity {

    Button gisButton, nextButton;
    EditText holdingNoEt, khanaNoEt;
    TextView latitudeTv, longitudeTv;
    String holdingNo, khanaNo, latitude, longitude, lat, longi;

    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holding_no);

        holdingNoEt = findViewById(R.id.holdingNoEtId);
        khanaNoEt = findViewById(R.id.khanaNoEtId);
        latitudeTv = findViewById(R.id.latitudeTvId);
        longitudeTv = findViewById(R.id.longitudeTvId);
        gisButton = findViewById(R.id.btnGIS_Id);
        nextButton = findViewById(R.id.nextBtnHno);

        //================= SharedPreferences Data Retrive ==========

        SharedPreferences sp = getSharedPreferences("HoldingNo", Context.MODE_PRIVATE);


        if (sp.contains("holdingNo")){
            holdingNo = sp.getString("holdingNo", "Data Not Found");

            holdingNoEt.setText(holdingNo);
        }if (sp.contains("khanaNo")){
            khanaNo = sp.getString("khanaNo", "Data Not Found");

            khanaNoEt.setText(khanaNo);
        }if (sp.contains("latitude")){
            lat = sp.getString("latitude", "Data Not Found");

            latitudeTv.setText(lat);
        }if (sp.contains("longitude")){
            longi = sp.getString("longitude", "Data Not Found");

            longitudeTv.setText(longi);
        }
        else {
            Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
        }



        //====================Add permission ===========================

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getApplicationContext());


        //=================== RecyclerView ===========================

        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String [] title = getResources().getStringArray(R.array.title);
        MyAdapter adapter = new MyAdapter(this, title);
        recyclerView.setAdapter(adapter);
    }

    //======================== GEO Location =============


    public void getGIScode(View view) {

        //Check condition

        if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext()
                , Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            //When permission is granted
            //Call method
            getCurrentLocation();
        }
        else {
            //When permission is not granted
            //Request permission
            ActivityCompat.requestPermissions(HoldingNoActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION},
                    100);
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //Check condition
        if (requestCode == 100 && (grantResults.length>0)&& (grantResults[0]+grantResults[1] == PackageManager.PERMISSION_GRANTED)){
            //When permission are granted
            //Call method
            getCurrentLocation();
        }else {
            //When permission are denid
            //Display Toast
            Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_LONG).show();
        }
    }

    @SuppressLint("MissingPermission")
    private void getCurrentLocation() {
        //Initialize location manager
        LocationManager locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        //Check condition
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            //When location service is enabled
            //Get last location
            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    //Initialize location
                    Location location = task.getResult();
                    //Check condition
                    if (location !=null){
                        //When location result is not null
                        //Set lattitude
                        latitudeTv.setText(String.valueOf(location.getLatitude()));
                        latitude = String.valueOf(location.getLatitude());
                        //Set longitude
                        longitudeTv.setText(String.valueOf(location.getLongitude()));
                        longitude = String.valueOf(location.getLongitude());
                    }else {
                        //When location result is null
                        //Initialize location request
                        LocationRequest locationRequest = new LocationRequest()
                                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                                .setInterval(10000)
                                .setFastestInterval(1000)
                                .setNumUpdates(1);

                        //Initialize location call back
                        LocationCallback locationCallback = new LocationCallback(){
                            @Override
                            public void onLocationResult(LocationResult locationResult){
                                //Initialize location
                                Location location1 = locationResult.getLastLocation();
                                //Set Latitude
                                latitudeTv.setText(String.valueOf(location.getLatitude()));
                                latitude = String.valueOf(location.getLatitude());
                                //Set Longitude
                                longitudeTv.setText(String.valueOf(location.getLongitude()));
                                longitude = String.valueOf(location.getLongitude());
                            }
                        };
                        //Request location updates
                        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());
                    }

                }
            });
        }else {
            //When location service is not enabled
            //Open location setting
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }



    //=========================== Back Pressed ===========================

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"Please complete the survey", Toast.LENGTH_LONG).show();
    }

    //========================  goToNextActivity ============================

    public void goToNextActivity(View view) {

        //================== Shared Preferences ====================
        holdingNo = holdingNoEt.getText().toString().trim();
        khanaNo = khanaNoEt.getText().toString().trim();

        SharedPreferences sp = getSharedPreferences("HoldingNo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("holdingNo", holdingNo);
        editor.putString("khanaNo", khanaNo);
        editor.putString("latitude", latitude);
        editor.putString("longitude", longitude);
        editor.commit();


        if (holdingNoEt.getText().toString().isEmpty()){
            holdingNoEt.setError("Field is required!");
        }if (khanaNoEt.getText().toString().isEmpty()){
            khanaNoEt.setError("Field is required!");
        }if (latitude == null){
            latitudeTv.setError("Latitude is required!");
            longitudeTv.setError("Longitude is required!");

        }else {
            Intent intent = new Intent(getApplicationContext(), HoldingAddActivity.class);
            startActivity(intent);
        }
    }


    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

    public void goToHome(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}