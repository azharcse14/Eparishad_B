package com.azhar.e_parishad_b.Activity.Members;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.azhar.e_parishad_b.Activity.HeadActivity;
import com.azhar.e_parishad_b.Activity.ReligionActivity;
import com.azhar.e_parishad_b.Database.Entity.Member.MemberTempEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.Database.Entity.Member.MNEntity;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.MemberName.MyMNAdapter;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;
import com.azhar.e_parishad_b.RecyclerView.Top.MyTopAdapter;

import java.util.ArrayList;
import java.util.List;

public class MembersActivity extends AppCompatActivity {

    RecyclerView recyclerViewS, recyclerViewMn;
    RecyclerView.LayoutManager layoutManager;
    ArrayList <MemberTempEntity> memberTempEntityArrayList;
    MyMNAdapter myMNAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);
        recyclerViewS = findViewById(R.id.recyclerViewId);
        recyclerViewMn = findViewById(R.id.membersNameRecyclerViewId);


        //================= RecyclerView =====================

        recyclerViewS.setLayoutManager(new LinearLayoutManager(this));
        String[] title = getResources().getStringArray(R.array.title);
        MyAdapter adapterS = new MyAdapter(this, title);
        recyclerViewS.setAdapter(adapterS);

        //===================== RecyclerView =========================


        recyclerViewMn.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewMn.setLayoutManager(layoutManager);
        recyclerViewMn.setItemAnimator(new DefaultItemAnimator());

        new LoadDataTask().execute();

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void goToNextActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), ReligionActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), HeadActivity.class);
        startActivity(intent);
    }

    public void addMembers(View view) {
        Intent intent = new Intent(getApplicationContext(), MemberFirstBFMGActivity.class);
        startActivity(intent);
    }


    class LoadDataTask extends AsyncTask<Void, Void, Void> {

        Repository repository;
        List<MemberTempEntity> memberTempEntityList;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            repository = new Repository(getApplicationContext());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            memberTempEntityList = repository.getTempMembers();
            memberTempEntityArrayList = new ArrayList<>();

            for (int i=0; i<memberTempEntityList.size(); i++){
                memberTempEntityArrayList.add(memberTempEntityList.get(i));
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            myMNAdapter = new MyMNAdapter(MembersActivity.this, memberTempEntityArrayList);
            recyclerViewMn.setAdapter(myMNAdapter);
        }
    }


    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

}