package com.wearable.app.wearapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.WearableListView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.wearable.app.wearapp.utils.MainMenuUtils;
import com.wearable.app.wearapp.vos.ObjMainMenu;

import java.util.ArrayList;

public class CardActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.card_activity);
            String titulo = getIntent().getStringExtra("titulo");
            //String contenido = getIntent().getStringExtra("contenido");
            String information = getIntent().getStringExtra("informacion");
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            CardFragment cardFragment = CardFragment.create(titulo,
                    information,
                    R.drawable.account_detail_icon);
            fragmentTransaction.add(R.id.frame_layout, cardFragment);
            fragmentTransaction.commit();
        }
}
