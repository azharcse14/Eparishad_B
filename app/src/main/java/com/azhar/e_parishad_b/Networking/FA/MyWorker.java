package com.azhar.e_parishad_b.Networking.FA;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.azhar.e_parishad_b.Networking.SyncGIS;

public class MyWorker extends Worker {
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        new SyncFa(getApplicationContext());
        new SyncGIS(getApplicationContext());
        return Result.success();
    }
}
