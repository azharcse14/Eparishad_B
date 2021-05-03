package com.azhar.e_parishad_b.Database.FinalDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.azhar.e_parishad_b.Database.Entity.FDEntity;
import com.azhar.e_parishad_b.Database.Entity.FaEntity;
import com.azhar.e_parishad_b.Database.Entity.GISEntity;
import com.azhar.e_parishad_b.Database.Entity.Loan.LoanEntity;
import com.azhar.e_parishad_b.Database.Entity.Loan.LoanTempEntity;
import com.azhar.e_parishad_b.Database.Entity.Member.MNEntity;
import com.azhar.e_parishad_b.Database.Entity.Member.MemberTempEntity;

@Database(entities = {FDEntity.class, MNEntity.class, MemberTempEntity.class, LoanEntity.class, LoanTempEntity.class, FaEntity.class, GISEntity.class}, version = 1, exportSchema = false)
public abstract class DATABASE extends RoomDatabase {

    public abstract DAO dao();
}
