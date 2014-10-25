package com.wearable.app.wearapp.vos;

/**
 * Created by Edu on 25/10/2014.
 */
public class ObjCard {

    private String typeCard;
    private String numCard;
    private String availableCard;
    private String totalCard;

    public ObjCard(String typeCard, String numCard, String availableCard, String totalCard) {
        this.typeCard = typeCard;
        this.numCard = numCard;
        this.availableCard = availableCard;
        this.totalCard = totalCard;
    }

    public String getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(String typeCard) {
        this.typeCard = typeCard;
    }

    public String getNumCard() {
        return numCard;
    }

    public void setNumCard(String numCard) {
        this.numCard = numCard;
    }

    public String getAvailableCard() {
        return availableCard;
    }

    public void setAvailableCard(String availableCard) {
        this.availableCard = availableCard;
    }

    public String getTotalCard() {
        return totalCard;
    }

    public void setTotalCard(String totalCard) {
        this.totalCard = totalCard;
    }
}
