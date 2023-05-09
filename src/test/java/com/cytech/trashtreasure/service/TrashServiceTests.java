package com.cytech.trashtreasure.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cytech.trashtreasure.entity.User;

@SpringBootTest
public class TrashServiceTests {
    
    @Autowired
    private UserService userService;
    @Autowired
    private TrashService trashService;

    private static final float PENALTY_FACTOR = 0.2f;

    @Test
    void getAllBinNamesTest() {
        String[] binsInDatabase = trashService.getAllBinNames();
        String[] expectedBins = new String[] {"Verte", "Jaune", "Bleue", "Classique"};

        assertArrayEquals(binsInDatabase, expectedBins);
    }

    @Test
    void getAllTrashNamesTest() {
        String[] trashConfigsInDatabase = trashService.getAllTrashNames();
        String[] expectedTrashConfigs = new String[] {"Bouteille en plastique", "Déchets alimentaires organiques", "Papier essuie-tout", "Bouteille en verre"};

        assertArrayEquals(trashConfigsInDatabase, expectedTrashConfigs);
    }

    @Test
    void putTrashIntoBinTestSuccess() {
        String trashName = "Bouteille en verre";
        Integer trashQuantity = 1;
        String binColor = "Verte";

        // create user with dynamic username and password
        User user = userService.createUserFromCredentials(
            String.valueOf(System.currentTimeMillis()), 
            String.valueOf(System.currentTimeMillis())
        );

        Integer expectedEarnedPoints = 250;
        Integer earnedPoints = trashService.putTrashIntoBin(trashName, trashQuantity, binColor, user).getEarnedPoints();

        assertEquals(expectedEarnedPoints, earnedPoints);
    }

    @Test
    void putTrashIntoBinTestFailure() {
        String trashName = "Bouteille en verre";
        Integer trashQuantity = 1;
        String binColor = "Bleue";

        // create user with dynamic username and password
        User user = userService.createUserFromCredentials(
            String.valueOf(System.currentTimeMillis()), 
            String.valueOf(System.currentTimeMillis())
        );

        Integer expectedEarnedPoints = -(int) (250 * PENALTY_FACTOR);
        Integer earnedPoints = trashService.putTrashIntoBin(trashName, trashQuantity, binColor, user).getEarnedPoints();

        assertEquals(expectedEarnedPoints, earnedPoints);
    }

}
