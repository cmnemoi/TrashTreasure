package com.cytech.trashtreasure.entity;

import java.util.Date;

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
@Table(name = "trash", schema = "public")
public class Trash {
    
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @OneToOne(targetEntity = TrashConfig.class)
    private TrashConfig trashConfig;

    @Column(nullable = false)
    private Date depositDate;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer earnedPoints;

    @ManyToOne(targetEntity = User.class)
    private User depositor;

    @ManyToOne(targetEntity = Bin.class)
    private Bin bin;

    public String getName() {
        return trashConfig.getName();
    }

    public String getType() {
        return trashConfig.getType();
    }

    public Float getWeight() {
        return trashConfig.getWeight();
    }
}
