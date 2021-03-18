package com.azhar.e_parishad_b.Networking.Notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;

public class NotificationUtils extends ContextWrapper {

    private NotificationManager manager;
    public static final String ANDROID_CHANNEL_ID = "com.azhar.noti";
    public static final String ANDROID_CHANNEL_NAME = "Android Channel";

    public NotificationUtils(Context base) {
        super(base);
    }

    public void createChannel(){
        NotificationChannel notificationChannel = new NotificationChannel(ANDROID_CHANNEL_ID, ANDROID_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationChannel.setLightColor(Color.GRAY);
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getManager().createNotificationChannel(notificationChannel);
    }

    public NotificationManager getManager(){
        if (manager==null){
            manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return manager;
    }

    public Notification.Builder getAndroidChannelNotification(String title, String msg){
        return new Notification.Builder(getApplicationContext(),ANDROID_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(msg)
                .setSmallIcon(android.R.drawable.stat_notify_more)
                .setAutoCancel(true);
    }
}

