package com.cytech.trashtreasure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cytech.trashtreasure.entity.User;
import com.cytech.trashtreasure.entity.Voucher;
import com.cytech.trashtreasure.entity.VoucherConfig;
import com.cytech.trashtreasure.repository.UserRepository;
import com.cytech.trashtreasure.repository.VoucherConfigRepository;
import com.cytech.trashtreasure.repository.VoucherRepository;

@Service
public class VoucherService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VoucherConfigRepository voucherConfigRepository;
    @Autowired
    private VoucherRepository voucherRepository;

    public List<VoucherConfig> getAllVouchers() {
        return voucherConfigRepository.findAll();
    }

    public Integer getNumberOfClaimedVouchers() {
        return voucherRepository.findAll().size();
    }

    public Voucher addVoucherToUser(VoucherConfig voucherConfig, User user) {
        Voucher voucher = createVoucherFromConfig(voucherConfig);
        voucher.setUser(user);

        voucherRepository.save(voucher);

        user.removeFidelityPoints(voucher.getFidelityPointsCost());
        user.addVoucher(voucher);
        userRepository.save(user);

        return voucher;
    }

    private Voucher createVoucherFromConfig(VoucherConfig voucherConfig) {
        Voucher voucher = new Voucher();
        voucher.setVoucherConfig(voucherConfig);

        return voucher;
    }
}
