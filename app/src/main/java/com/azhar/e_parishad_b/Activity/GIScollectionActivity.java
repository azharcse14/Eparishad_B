package com.azhar.e_parishad_b.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.azhar.e_parishad_b.Database.Entity.GISEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.Database.SQLiteHelper;
import com.azhar.e_parishad_b.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class GIScollectionActivity extends AppCompatActivity {

    FusedLocationProviderClient fusedLocationProviderClient;
    TextView latitudeTv, longitudeTv;

    String surveyId, latitude,  longitude,  isDraft, lat, lng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_i_scollection);

        latitudeTv = findViewById(R.id.gisLatitudeTvId);
        longitudeTv = findViewById(R.id.gisLongitudeTvId);

        //============= Get values from MyAdapter.java ===========

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            surveyId = bundle.getString("surveyId");
            lat = bundle.getString("latitude");
            lng = bundle.getString("longitude");
            isDraft = bundle.getString("isDraft");
        }

        //==========================End===========================

        //============ Set values to UI ======================

        latitudeTv.setText(lat);
        longitudeTv.setText(lng);


        //====================Add permission ===========================

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getApplicationContext());

    }

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
            ActivityCompat.requestPermissions(GIScollectionActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
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

    SQLiteHelper sqLiteHelper = new SQLiteHelper(this);



    public void saveLatLng(View view) {
        Repository repository = new Repository(getApplicationContext());

        repository.UpdateLatLng(latitude, longitude, surveyId);

//        finish();
        startActivity(new Intent(GIScollectionActivity.this, GisActivity.class));
    }
}