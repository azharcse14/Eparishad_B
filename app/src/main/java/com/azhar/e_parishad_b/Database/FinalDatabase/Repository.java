package com.azhar.e_parishad_b.Database.FinalDatabase;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.room.Room;

import com.azhar.e_parishad_b.Database.Entity.FDEntity;
import com.azhar.e_parishad_b.Database.Entity.FaEntity;
import com.azhar.e_parishad_b.Database.Entity.Loan.LoanEntity;
import com.azhar.e_parishad_b.Database.Entity.Loan.LoanTempEntity;
import com.azhar.e_parishad_b.Database.Entity.Member.MNEntity;
import com.azhar.e_parishad_b.Database.Entity.Member.MemberTempEntity;

import java.util.List;

public class Repository {

    private final Database database;
    Context context;
    String DB_NAME;

    public Repository(Context context){
        this.context = context;
        DB_NAME = "final.db";
        database = Room.databaseBuilder(context, Database.class, DB_NAME).build();

        Toast.makeText(context, "Database created", Toast.LENGTH_LONG).show();

    }

    //===============Delete Task Start=================

    public void DeleteTask(final FDEntity fdEntity){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().deleteTask(fdEntity);
                return null;
            }
        }.execute();
    }
    //===============Delete Task End=================

    //===============Update Task Start=================

    public void UpdateTask(final FDEntity fdEntity){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().updateTask(fdEntity);
                return null;
            }
        }.execute();
    }
    //===============Update Task End=================

    //============= Fetch Task ==========
    public List<FDEntity> getAllData(){
        List<FDEntity> fdEntityList = database.dao().getAll();
        return fdEntityList;
    }

    //========== Insert Task =================
    public void InsertTask(final FDEntity fdEntity){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().insertTask(fdEntity);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, fdEntity.id+" is inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }


    //==============================================================================================
    //==============================================================================================
    //==============================================================================================

    //===============Delete Task Start=================

    public void DeleteTaskMNEntity(final MNEntity mnEntity){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().deleteTaskMNEntity(mnEntity);
                return null;
            }
        }.execute();
    }

    //===============Delete Task End=================

    //===============Update Task Start=================

    public void UpdateTaskMNEntity(final MNEntity mnEntity){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().updateTaskMNEntity(mnEntity);
                return null;
            }
        }.execute();
    }
    //===============Update Task End=================

    //============= Fetch Task ==========
    public List<MNEntity> getMembers(){
        List<MNEntity> mnEntityList = database.dao().getAllMNEntity();
        return mnEntityList;
    }

    //========== Insert Task =================
    public void InsertTaskMNEntity(final MNEntity mnEntity){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().insertTaskMNEntity(mnEntity);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, mnEntity.name+"is inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }

    //============================================================================================================
    //=================================================MEMBER TEMP===========================================================
    //============================================================================================================

    //=================== Delete All Task ===========================
    public void DeleteAllTaskMemberTemp(){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().deleteAllMemberTempEntity();
                return null;
            }
        }.execute();
    }
    
        //===============Delete Task Start=================

    public void DeleteTaskMemberTemp(final MemberTempEntity memberTempEntity){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().deleteTaskMemberTempEntity(memberTempEntity);
                return null;
            }
        }.execute();
    }

    //===============Delete Task End=================

    //===============Update Task Start=================

    public void UpdateTaskMemberTemp(final MemberTempEntity memberTempEntity){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().updateTaskMemberTempEntity(memberTempEntity);
                return null;
            }
        }.execute();
    }
    //===============Update Task End=================

    //============= Fetch Task ==========
    public List<MemberTempEntity> getTempMembers(){
        List<MemberTempEntity> memberTempEntityList = database.dao().getAllMemberTempEntity();
        return memberTempEntityList;
    }

    //========== Insert Task =================
    public void InsertTaskMemberTemp(final MemberTempEntity memberTempEntity){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().insertTaskMemberTempEntity(memberTempEntity);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, memberTempEntity.name+"is inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }
    //============================================================================================================
    //=============================================================LOAN===============================================
    //============================================================================================================

    //===============Delete Task Start=================

    public void DeleteTask(final LoanEntity loanEntity){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().updateTaskLoanEntity(loanEntity);
                return null;
            }
        }.execute();
    }
    //===============Delete Task End=================

    //===============Update Task Start=================

    public void UpdateTask(final LoanEntity loanEntity){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().updateTaskLoanEntity(loanEntity);
                return null;
            }
        }.execute();
    }
    //===============Update Task End=================

    //============= Fetch Task ==========
    public List<LoanEntity> getLoans(){
        List<LoanEntity> loanEntityList = database.dao().getAllLoanEntity();
        return loanEntityList;
    }

    //========== Insert Task =================
    public void InsertTask(final LoanEntity loanEntity){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().insertTaskLoanEntity(loanEntity);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, loanEntity.loanName+"is inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }


    //============================================================================================================
    //=================================================MEMBER TEMP===========================================================
    //============================================================================================================

    //=================== Delete All Task ===========================
    public void DeleteAllLoanTemp(){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().deleteAllLoanTempEntity();
                return null;
            }
        }.execute();
    }

    //===============Delete Task Start=================

    public void DeleteTaskLoanTemp(final LoanTempEntity loanTempEntity){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().deleteTaskLoanTempEntity(loanTempEntity);
                return null;
            }
        }.execute();
    }

    //===============Delete Task End=================

    //===============Update Task Start=================

    public void UpdateTaskLoanTemp(final LoanTempEntity loanTempEntity){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().updateLoanTempEntity(loanTempEntity);
                return null;
            }
        }.execute();
    }
    //===============Update Task End=================

    //============= Fetch Task ==========
    public List<LoanTempEntity> getLoanTemp(){
        List<LoanTempEntity> loanTempEntityList = database.dao().getAllLoanTempEntity();
        return loanTempEntityList;
    }

    //========== Insert Task =================
    public void InsertTaskLoanTemp(final LoanTempEntity loanTempEntity){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().insertTaskLoanTempEntity(loanTempEntity);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, loanTempEntity.id+"is inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }



    //==================================================================================================================
    //======================================================= FaEntity ===========================================================
    //===================================================================================================================
    //============= Fetch Task ==========
    public List<FaEntity> getAllFaEntityData(){
        List<FaEntity> faEntityList = database.dao().getAllFaEntity();
        return faEntityList;
    }

    //========== Insert Task =================
    public void InsertTaskFaEntity(final FaEntity faEntity){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().insertTaskFaEntity(faEntity);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, faEntity.id+" is inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }


    //=================== Delete All Task ===========================
    public void DeleteAllTask(){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().deleteAllFaEntity();
                return null;
            }
        }.execute();
    }



}

