package com.wearable.app.wearapp;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

public class MessageListener extends WearableListenerService {

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        int notificationId = 005;
        String titulo = "";
        String contenido = "";
        String informacion = "";
        if (messageEvent.getPath().equals(getString(R.string.notification_recibo))) {
            titulo = getString(R.string.title_recibo);
            contenido = getString(R.string.description_recibo);
            informacion = getString(R.string.info_recibo);
        } else if (messageEvent.getPath().equals(getString(R.string.notification_ingreso))){
            titulo = getString(R.string.title_ingreso);
            contenido = getString(R.string.description_ingreso);
            informacion = getString(R.string.info_ingreso);
        }else {
            titulo = getString(R.string.title_pago);
            contenido = getString(R.string.description_pago);
            informacion = getString(R.string.info_pago);
        }
        Intent intent = new Intent(this, CardActivity.class);
        intent.putExtra("titulo", titulo);
        //intent.putExtra("contenido", description);
        intent.putExtra("informacion", informacion);
        PendingIntent viewPendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.app_icon)
                        .setContentTitle(messageEvent.getPath())
                        .setContentText(contenido)
                        .setContentIntent(viewPendingIntent);

        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);

        notificationManager.notify(notificationId, notificationBuilder.build());
    }

}