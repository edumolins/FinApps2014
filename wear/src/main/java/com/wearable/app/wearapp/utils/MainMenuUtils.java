package com.wearable.app.wearapp.utils;

import com.wearable.app.wearapp.R;
import com.wearable.app.wearapp.vos.ObjAccount;
import com.wearable.app.wearapp.vos.ObjMainMenu;

import java.util.ArrayList;

/**
 * Created by Edu on 25/10/2014.
 */
public class MainMenuUtils {
    private ArrayList <ObjMainMenu> itemsArray;

    public MainMenuUtils(){
        itemsArray = new ArrayList<ObjMainMenu>();
    }

    public ArrayList <ObjMainMenu> getItems(){
        itemsArray.add(new ObjMainMenu(R.drawable.card_icon, "Tus tarjetas"));
        itemsArray.add(new ObjMainMenu(R.drawable.account_icon, "Tus cuentas"));
        itemsArray.add(new ObjMainMenu(R.drawable.alert_icon, "Avisos"));
        return itemsArray;
    }

    public ArrayList <ObjMainMenu> getAlerts(){
        itemsArray.add(new ObjMainMenu(R.drawable.alert_setting_icon, "Ingreso recibido", "Si"));
        itemsArray.add(new ObjMainMenu(R.drawable.alert_setting_icon, "Recibo cargado en cuenta", "No"));
        itemsArray.add(new ObjMainMenu(R.drawable.alert_setting_icon, "Pago realizado", "Si"));
        return itemsArray;
    }


}