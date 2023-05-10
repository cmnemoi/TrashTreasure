package com.cytech.trashtreasure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "voucher", schema = "public")
public class Voucher {
    
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @OneToOne(targetEntity = VoucherConfig.class)
    private VoucherConfig voucherConfig;

    @ManyToOne(targetEntity = User.class)
    private User user;

    public String getDiscountType() {
        return voucherConfig.getDiscountType();
    }

    public Integer getDiscountValue() {
        return voucherConfig.getDiscountValue();
    }

    public Integer getFidelityPointsCost() {
        return voucherConfig.getFidelityPointsCost();
    }

    public String getShop() {
        return voucherConfig.getShop();
    }
    
}
