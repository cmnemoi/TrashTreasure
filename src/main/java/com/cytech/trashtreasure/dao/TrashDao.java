package com.cytech.trashtreasure.dao;

import com.cytech.trashtreasure.entity.Trash;

public class TrashDao {
    private String depositDate;
    private String name;
    private String quantity;
    private String bin;
    private String earnedPoints;

    public TrashDao(Trash trash) {
        this.depositDate = trash.getDepositDate().toString();
        this.name = trash.getName();
        this.quantity = trash.getQuantity().toString();
        this.bin = trash.getBin().getColor();
        this.earnedPoints = trash.getEarnedPoints().toString();
    }

    public String getDepositDate() {
        return depositDate;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getBin() {
        return bin;
    }

    public String getEarnedPoints() {
        return earnedPoints;
    }
}
