package com.azhar.e_parishad_b.Database.FinalDatabase;

import androidx.room.RoomDatabase;

import com.azhar.e_parishad_b.Database.Entity.FDEntity;
import com.azhar.e_parishad_b.Database.Entity.FaEntity;
import com.azhar.e_parishad_b.Database.Entity.Loan.LoanEntity;
import com.azhar.e_parishad_b.Database.Entity.Loan.LoanTempEntity;
import com.azhar.e_parishad_b.Database.Entity.Member.MNEntity;
import com.azhar.e_parishad_b.Database.Entity.Member.MemberTempEntity;

@androidx.room.Database(entities = {FDEntity.class, MNEntity.class, MemberTempEntity.class, LoanEntity.class, LoanTempEntity.class, FaEntity.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    public abstract DAO dao();
}
