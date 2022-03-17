package com.example.assignmenttops.firebase_practice;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.assignmenttops.R;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.jetbrains.annotations.NotNull;

public class MyFirebaseMessagingService extends FirebaseMessagingService {


    @Override
    public void onNewToken(@NonNull @NotNull String s) {
        super.onNewToken(s);
        Log.i("NewToken",s);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onMessageReceived(@NonNull @NotNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.i("message",remoteMessage.getNotification().getBody());
        showNotification(remoteMessage.getNotification());

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showNotification(RemoteMessage.Notification notification) {
        Notification.Builder builder=new Notification.Builder(this,"n1")
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setSmallIcon(R.mipmap.ic_launcher);
        Notification mNotification=builder.build();

        NotificationManager manager=null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            manager=getSystemService(NotificationManager.class);
        }else{
            manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        }
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            int importance=NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel("Firebase","FMS channel",importance);
            manager.createNotificationChannel(channel);
        }
        manager.notify(1,mNotification);

    }
}
