package com.azhar.e_parishad_b.Database.DataPackager;

import com.azhar.e_parishad_b.Database.Entity.Member.MNEntity;

import java.util.ArrayList;

public class MemberDataPackager {

    ArrayList<MNEntity> mnEntityArrayList;

    public ArrayList<MNEntity> getMnEntityArrayList() {
        return mnEntityArrayList;
    }

    public void setMnEntityArrayList(ArrayList<MNEntity> mnEntityArrayList) {
        this.mnEntityArrayList = mnEntityArrayList;
    }
}
