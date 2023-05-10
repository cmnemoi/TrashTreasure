package com.cytech.trashtreasure.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cytech.trashtreasure.entity.User;
import com.cytech.trashtreasure.entity.VoucherConfig;

@SpringBootTest
public class VoucherServiceTests {
    
    @Autowired
    private UserService userService;
    @Autowired
    private VoucherService voucherService;

    @Test
    public void getAllVouchersTest() {
        
        String[] expectedVoucherConfigs = getExpectedVoucherConfigs().stream()
            .map(voucherConfig -> voucherConfig.toString()).toArray(String[]::new);
        String[] actualVoucherConfigs = voucherService.getAllVouchers().stream()
            .map(voucherConfig -> voucherConfig.toString()).toArray(String[]::new);

        assertArrayEquals(expectedVoucherConfigs, actualVoucherConfigs);
    }

    @Test
    public void addVoucherToUserTest() {
        User user = createUser();
        user.setFidelityPoints(1000);
        VoucherConfig voucherToAdd = voucherService.getAllVouchers().get(0);
        voucherService.addVoucherToUser(voucherToAdd, user);

        assertEquals(1, user.getVouchers().size());
        assertEquals(500, user.getFidelityPoints());
    }

    private User createUser() {
        String username = String.valueOf(System.currentTimeMillis());
        String password = String.valueOf(System.currentTimeMillis());

        return userService.createUserFromCredentials(username, password);
    }

    private List<VoucherConfig> getExpectedVoucherConfigs() {
        VoucherConfig voucherConfig1 = new VoucherConfig();
        voucherConfig1.setId(1);
        voucherConfig1.setDiscountType("percentage");
        voucherConfig1.setDiscountValue(10);
        voucherConfig1.setFidelityPointsCost(500);
        voucherConfig1.setShop("Auchan");

        VoucherConfig voucherConfig2 = new VoucherConfig();
        voucherConfig2.setId(2);
        voucherConfig2.setDiscountType("flat");
        voucherConfig2.setDiscountValue(5);
        voucherConfig2.setFidelityPointsCost(30);
        voucherConfig2.setShop("Carrefour");

        return List.of(voucherConfig1, voucherConfig2);

    }
}
