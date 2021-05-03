package com.azhar.e_parishad_b.Database.FinalDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.azhar.e_parishad_b.Database.Entity.FDEntity;
import com.azhar.e_parishad_b.Database.Entity.FaEntity;
import com.azhar.e_parishad_b.Database.Entity.GISEntity;
import com.azhar.e_parishad_b.Database.Entity.Loan.LoanEntity;
import com.azhar.e_parishad_b.Database.Entity.Loan.LoanTempEntity;
import com.azhar.e_parishad_b.Database.Entity.Member.MNEntity;
import com.azhar.e_parishad_b.Database.Entity.Member.MemberTempEntity;

import java.util.List;

@Dao
public interface DAO {

    @Insert
    Long insertTask(FDEntity fdEntity);

    @Query("select*from fdentity order by id asc")
    List<FDEntity> getAll();

    @Update
    void updateTask(FDEntity fdEntity);

    @Query("UPDATE FDEntity SET isSync= '1' WHERE id = :id")
    void updateIsSync(int id);

    @Delete
    void deleteTask(FDEntity fdEntity);


    @Query("DELETE FROM FDEntity")
    public void deleteAll();

    //===================================================================================================
    @Insert
    Long insertTaskMNEntity(MNEntity mnEntity);

    @Query("select*from mnentity order by id asc")
    List<MNEntity>getAllMNEntity();

    @Update
    void updateTaskMNEntity(MNEntity mnEntity);

    @Delete
    void deleteTaskMNEntity(MNEntity mnEntity);

    @Query("DELETE FROM MNEntity")
    public void deleteAllMNEntity();

    //===================================================================================================
    @Insert
    Long insertTaskMemberTempEntity(MemberTempEntity memberTempEntity);

    @Query("select*from membertempentity order by id asc")
    List<MemberTempEntity>getAllMemberTempEntity();

    @Update
    void updateTaskMemberTempEntity(MemberTempEntity memberTempEntity);

    @Delete
    void deleteTaskMemberTempEntity(MemberTempEntity memberTempEntity);

    @Query("DELETE FROM MemberTempEntity")
    public void deleteAllMemberTempEntity();

    //========================================================================================
    @Insert
    Long insertTaskLoanEntity(LoanEntity loanEntity);

    @Query("select*from loanentity order by id asc")
    List<LoanEntity> getAllLoanEntity();

    @Update
    void updateTaskLoanEntity(LoanEntity loanEntity);

    @Delete
    void deleteTaskLoanEntity(LoanEntity loanEntity);

    @Query("DELETE FROM LoanEntity")
    public void deleteAllLoanEntity();

    //========================================================================================
    @Insert
    Long insertTaskLoanTempEntity(LoanTempEntity loanTempEntity);

    @Query("select*from loantempentity order by id asc")
    List<LoanTempEntity> getAllLoanTempEntity();

    @Update
    void updateLoanTempEntity(LoanTempEntity LoanTempEntity);

    @Delete
    void deleteTaskLoanTempEntity(LoanTempEntity LoanTempEntity);

    @Query("DELETE FROM LoanTempEntity")
    public void deleteAllLoanTempEntity();

    //==========================================================================================================
    @Insert
    Long insertTaskFaEntity(FaEntity faEntity);

    @Query("select*from faentity order by id asc")
    List<FaEntity> getAllFaEntity();

    @Query("DELETE FROM FaEntity")
    public void deleteAllFaEntity();

    //========================================================================================
    @Insert
    Long insertTaskGISEntity(GISEntity gisEntity);

    @Query("select*from gisentity order by id asc")
    List<GISEntity> getAllGISEntity();

    @Update
    void updateGISEntity(GISEntity gisEntity);

    @Query("UPDATE GISEntity SET latitude = :lat , longitude = :lng WHERE surveyID = :surveyid")
    void updateLatLng(String lat, String lng, String surveyid);

    @Delete
    void deleteTaskGISEntity(GISEntity gisEntity);

    @Query("DELETE FROM GISEntity")
    public void deleteAllGISEntity();

}
