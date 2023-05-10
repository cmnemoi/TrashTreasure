package com.cytech.trashtreasure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "voucher_config", schema = "public")
public class VoucherConfig {
    
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(nullable = false)
    private String discountType;

    @Column(nullable = false)
    private Integer discountValue;

    @Column(nullable = false)
    private Integer fidelityPointsCost;

    @Column(nullable = false)
    private String shop;

    @Override
    public String toString() {
        String formattedDiscountValue = "-" + discountValue.toString();
        if (discountType.equals("percentage")) {
            formattedDiscountValue += "%";
        } else {
            formattedDiscountValue += "€";
        }

        return formattedDiscountValue + " à " + shop + " - Coût : " + fidelityPointsCost + " points de fidélité";
    }
}
