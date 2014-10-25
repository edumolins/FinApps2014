package com.wearable.app.wearapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.Wearable;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MainActivity extends Activity {

    private GoogleApiClient client;
    String nodeId;
    private static final String START_ACTIVITY = "/start_activity";

    private Button mButton;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Logout
        mText = (TextView)findViewById(R.id.logout);
        mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //Notification de recibo
        mButton = (Button)findViewById(R.id.notification1);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sendNotification(getString(R.string.notification_recibo));
            }
        });
        //Notification de ingreso
        mButton = (Button)findViewById(R.id.notification2);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification(getString(R.string.notification_ingreso));
            }
        });
        //Notification de pago
        mButton = (Button)findViewById(R.id.notification3);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification(getString(R.string.notification_pago));
            }
        });
        client = getGoogleApiClient(this);
        retrieveDeviceNode();
    }

    private GoogleApiClient getGoogleApiClient(Context context) {
        return new GoogleApiClient.Builder(context)
                .addApi(Wearable.API)
                .build();
    }

    private void retrieveDeviceNode() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                client.blockingConnect(100, TimeUnit.MILLISECONDS);
                NodeApi.GetConnectedNodesResult result =
                        Wearable.NodeApi.getConnectedNodes(client).await();
                List<Node> nodes = result.getNodes();

                if (nodes.size() > 0) {
                    nodeId = nodes.get(0).getId();
                }
                client.disconnect();
            }
        }).start();
    }

    private void sendNotification(final String type) {
        if (nodeId != null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    client.blockingConnect(100, TimeUnit.MILLISECONDS);
                    Wearable.MessageApi.sendMessage(client, nodeId, type, null);
                    client.disconnect();
                }
            }).start();
        }
    }


}
