package com.cytech.trashtreasure.service;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cytech.trashtreasure.entity.Bin;
import com.cytech.trashtreasure.entity.Trash;
import com.cytech.trashtreasure.entity.User;
import com.cytech.trashtreasure.repository.BinRepository;
import com.cytech.trashtreasure.repository.TrashConfigRepository;
import com.cytech.trashtreasure.repository.TrashRepository;
import com.cytech.trashtreasure.repository.UserRepository;

@Service
public class TrashService {
    
    @Autowired
    private BinRepository binRepository;
    @Autowired
    private TrashConfigRepository trashConfigRepository;
    @Autowired
    private TrashRepository trashRepository;
    @Autowired
    private UserRepository userRepository;

    private static final float PENALTY_FACTOR = 0.2f;

    public String[] getAllBinNames() {
        return binRepository.findAll().stream().map(bin -> bin.getColor()).toArray(String[]::new);
    }

    public String[] getAllTrashNames() {
        return trashConfigRepository.findAll().stream().map(trash -> trash.getName()).toArray(String[]::new);
    }

    public Trash putTrashIntoBin(
        String trashName,
        Integer trashQuantity, 
        String binColor, 
        User user
    ) {
        Trash trash = createTrashFromName(trashName);
        Bin bin = binRepository.findByColor(binColor);
       
        // set the trash's properties
        trash.setDepositDate(new Date());
        trash.setQuantity(trashQuantity);
        Integer earnedPoints = computeFidelityPointsGained(trash, bin);
        trash.setEarnedPoints(earnedPoints);
        trash.setDepositor(user);
        trash.setBin(bin);

        // don't forget to update the user's fidelity points and save it in the database as well
        user.addFidelityPoints(earnedPoints);
        userRepository.save(user);

        // save the trash in the database
        return trashRepository.save(trash);
    }

    private Trash createTrashFromName(String name) {
        Trash trash = new Trash();
        trash.setTrashConfig(trashConfigRepository.findByName(name));
        return trash;
    }

    private Integer computeFidelityPointsGained(Trash trash, Bin bin) {
        Integer fidelityPointsGained = trash.getQuantity() * trash.getWeight().intValue();
        
        if (!isTrashInTheRightBin(trash, bin)) {
            return (int) - (fidelityPointsGained * PENALTY_FACTOR);
        }

        return fidelityPointsGained;
    }

    private Boolean isTrashInTheRightBin(Trash trash, Bin bin) {
        HashMap<String, String> trashBinMap = new HashMap<>();
        trashBinMap.put("Organique", "Classique");
        trashBinMap.put("Plastique", "Jaune");
        trashBinMap.put("Verre", "Verte");
        trashBinMap.put("Papier", "Bleu");

        return trashBinMap.get(trash.getType()).equals(bin.getColor());
    }

    
}