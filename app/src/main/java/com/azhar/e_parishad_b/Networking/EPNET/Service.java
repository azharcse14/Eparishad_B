package com.azhar.e_parishad_b.Networking.EPNET;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

import com.azhar.e_parishad_b.Networking.FA.SyncFa;

public class Service extends android.app.Service {



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);

        SyncFa syncFa = new SyncFa(getApplicationContext());

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

