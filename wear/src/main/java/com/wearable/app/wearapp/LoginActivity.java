package com.wearable.app.wearapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.GridViewPager;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.model.Circle;
import com.wearable.app.wearapp.R;
import com.wearable.app.wearapp.grid.GridPagerAccountAdapter;
import com.wearable.app.wearapp.grid.GridPagerCardAdapter;


public class LoginActivity extends Activity {

    private Button mButton;
    private CircledImageView mImage;
    private EditText mEditText;

    private String password = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override public void onLayoutInflated(WatchViewStub stub) {
                // Now you can access your views
            mButton = (Button)stub.findViewById(R.id.item1);
            mButton = (Button)stub.findViewById(R.id.item2);
            mButton = (Button)stub.findViewById(R.id.item3);
            mButton = (Button)stub.findViewById(R.id.item4);
            mButton = (Button)stub.findViewById(R.id.item5);
            mButton = (Button)stub.findViewById(R.id.item6);
            mButton = (Button)stub.findViewById(R.id.item7);
            mButton = (Button)stub.findViewById(R.id.item8);
            mButton = (Button)stub.findViewById(R.id.item9);
            mButton = (Button)stub.findViewById(R.id.item0);
            mImage = (CircledImageView)stub.findViewById(R.id.ok);
            mImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendPassword();
                }
            });
            mEditText = (EditText)stub.findViewById(R.id.edit);

            }
        });

    }

    public void writeNumber(View v){
        password += password + ((Button)v).getText().toString();
        mEditText.setText(mEditText.getText().toString()+"*");

    }

    private void sendPassword (){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
