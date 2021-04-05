package com.azhar.e_parishad_b.Activity.Loan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.azhar.e_parishad_b.Database.Entity.Loan.LoanTempEntity;
import com.azhar.e_parishad_b.Database.FinalDatabase.Repository;
import com.azhar.e_parishad_b.Database.Entity.Loan.LoanEntity;
import com.azhar.e_parishad_b.R;
import com.azhar.e_parishad_b.RecyclerView.SideMenue.MyAdapter;

public class FinanceSupportActivity extends AppCompatActivity {

    EditText loanNameEt, fstfEt, instituteEt, amountEt, periodsEt;
    String loanName, fstf, institute, amount, periods, kinnumber;
    CheckBox ifFsCbID;
    String date;
    String isfinancialsupported;
    AutoCompleteTextView dayAcTv, monthAcTv, yearAcTv;
    String[] day, month, year;
    String dayValue, monthValue, yearValue;
    String dayValueSp, monthValueSp, yearValueSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_support);

        loanNameEt = findViewById(R.id.loanNameEt);
        fstfEt = findViewById(R.id.fstfEt);
        instituteEt = findViewById(R.id.instituteEt);
        amountEt = findViewById(R.id.amountEt);
        dayAcTv = findViewById(R.id.dayAcTv);
        monthAcTv = findViewById(R.id.monthAcTv);
        yearAcTv = findViewById(R.id.yearAcTv);
        periodsEt = findViewById(R.id.periodsEt);
        ifFsCbID = findViewById(R.id.ifFsCbID);


        //====================================================================

        SharedPreferences HoldingAdd = getSharedPreferences("HoldingAdd", Context.MODE_PRIVATE);

        if (HoldingAdd.contains("kinNo")) {
            kinnumber = HoldingAdd.getString("kinNo", "Data Not Found");
        }

        //======================= Spinner ===========================
        day = getResources().getStringArray(R.array.day);
        month = getResources().getStringArray(R.array.month);
        year = getResources().getStringArray(R.array.year);

        ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_view, R.id.spinnerTvId, day);
        dayAcTv.setAdapter(dayAdapter);

        dayAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dayValue = parent.getItemAtPosition(position).toString();
            }
        });

        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(this, R.layout.spinner_view, R.id.spinnerTvId, month);
        monthAcTv.setAdapter(monthAdapter);

        monthAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                monthValue = parent.getItemAtPosition(position).toString();
            }
        });

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this, R.layout.spinner_view, R.id.spinnerTvId, year);
        yearAcTv.setAdapter(yearAdapter);

        yearAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                yearValue = parent.getItemAtPosition(position).toString();
            }
        });


        //================= RecyclerView =====================

        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] title = getResources().getStringArray(R.array.title);
        MyAdapter adapter = new MyAdapter(this, title);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please complete the survey", Toast.LENGTH_LONG).show();
    }

    public void goToNextActivity(View view) {

        if (loanNameEt.getText().toString().isEmpty()) {
            loanName = "N/A";
        } else {
            loanName = loanNameEt.getText().toString().trim();
        }

        if (fstfEt.getText().toString().isEmpty()) {
            fstf = "N/A";
        } else {
            fstf = fstfEt.getText().toString().trim();
        }

        if (instituteEt.getText().toString().isEmpty()) {
            institute = "N/A";
        } else {
            institute = instituteEt.getText().toString().trim();
        }

        if (amountEt.getText().toString().isEmpty()) {
            amount = "N/A";
        } else {
            amount = amountEt.getText().toString().trim();
        }

        if (periodsEt.getText().toString().isEmpty()) {
            periods = "N/A";
        } else {
            periods = periodsEt.getText().toString().trim();
        }

        if (ifFsCbID.isChecked()){
            isfinancialsupported = "Yes";
        }else {
            isfinancialsupported = "No";
        }

//        isfinancialsupported = "Yes";

        Repository repository = new Repository(getApplicationContext());

        LoanEntity loanEntity = new LoanEntity(loanName, isfinancialsupported, fstf, institute, amount, yearValue, monthValue, dayValue, periods, kinnumber);
        repository.InsertTask(loanEntity);

        LoanTempEntity loanTempEntity = new LoanTempEntity(loanName, isfinancialsupported, fstf, institute, amount, yearValue, monthValue, dayValue, periods, kinnumber);
        repository.InsertTaskLoanTemp(loanTempEntity);


        Intent intent = new Intent(getApplicationContext(), LoanActivity.class);
        startActivity(intent);
    }

    public void goToPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), LoanActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}