package com.cytech.trashtreasure.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "user", schema = "public")
public class User {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isAdmin = false;

    @Column(nullable = false)
    private Integer fidelityPoints = 0;

    @OneToMany(targetEntity = Voucher.class, mappedBy = "user")
    private Set<Voucher> vouchers = new HashSet<Voucher>();

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + "]";
    }

    public void addFidelityPoints(Integer fidelityPoints) {
        this.fidelityPoints += fidelityPoints;
    }

    public void removeFidelityPoints(Integer fidelityPoints) {
        this.fidelityPoints -= fidelityPoints;
        if (this.fidelityPoints < 0) {
            this.fidelityPoints = 0;
        }
    }

    public void addVoucher(Voucher voucher) {
        vouchers.add(voucher);
    }
}
