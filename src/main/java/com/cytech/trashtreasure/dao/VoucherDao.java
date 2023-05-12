package com.cytech.trashtreasure.dao;

import com.cytech.trashtreasure.entity.Voucher;

import lombok.Getter;

@Getter
public class VoucherDao {
    
    private String discount;
    private String shop;
    private String cost;

    public VoucherDao(Voucher voucher) {
        if (voucher.getDiscountType().equals("percentage")) {
            this.discount = "-" + voucher.getDiscountValue().toString() + "%";
        } else {
            this.discount = "-" + voucher.getDiscountValue().toString() + "€";
        }
        this.shop = voucher.getShop();
        this.cost = voucher.getFidelityPointsCost().toString();
    }
}
