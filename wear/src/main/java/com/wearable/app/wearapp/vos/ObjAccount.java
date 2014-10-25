package com.wearable.app.wearapp.vos;

/**
 * Created by Edu on 25/10/2014.
 */
public class ObjAccount {

    private String typeAccount;
    private String numAccount;
    private String amounAccount;

    public ObjAccount(String typeAccount, String numAccount, String amounAccount) {
        this.typeAccount = typeAccount;
        this.numAccount = numAccount;
        this.amounAccount = amounAccount;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getNumAccount() {
        return numAccount;
    }

    public void setNumAccount(String numAccount) {
        this.numAccount = numAccount;
    }

    public String getAmounAccount() {
        return amounAccount;
    }

    public void setAmounAccount(String amounAccount) {
        this.amounAccount = amounAccount;
    }
}
