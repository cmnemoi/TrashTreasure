INSERT INTO user (username, password, is_admin, fidelity_points) VALUES ('admin', 'admin', 'true', 0);

INSERT INTO trash_config (name, type, weight) VALUES ('Bouteille en plastique', 'Plastique', 20);
INSERT INTO trash_config (name, type, weight) VALUES ('Déchets alimentaires organiques', 'Organique', 500);
INSERT INTO trash_config (name, type, weight) VALUES ('Papier essuie-tout', 'Papier', 5);
INSERT INTO trash_config (name, type, weight) VALUES ('Bouteille en verre', 'Verre', 250);
INSERT INTO trash_config (name, type, weight) VALUES ('Canette en aluminium', 'Métallique', 10);
INSERT INTO trash_config (name, type, weight) VALUES ('Gobelet en polystyrène', 'Plastique', 15);
INSERT INTO trash_config (name, type, weight) VALUES ('Peau de banane', 'Organique', 30);
INSERT INTO trash_config (name, type, weight) VALUES ('Boîte en carton', 'Papier', 50);
INSERT INTO trash_config (name, type, weight) VALUES ('Bouteille de vin', 'Verre', 750);
INSERT INTO trash_config (name, type, weight) VALUES ('Boîte de conserve en acier', 'Métallique', 50);
INSERT INTO trash_config (name, type, weight) VALUES ('Sac d''épicerie en plastique', 'Plastique', 5);
INSERT INTO trash_config (name, type, weight) VALUES ('Coquilles d''œufs', 'Organique', 20);
INSERT INTO trash_config (name, type, weight) VALUES ('Journal', 'Papier', 50);
INSERT INTO trash_config (name, type, weight) VALUES ('Ampoule', 'Verre', 100);
INSERT INTO trash_config (name, type, weight) VALUES ('Fil de cuivre', 'Métallique', 5);
INSERT INTO trash_config (name, type, weight) VALUES ('Paille en plastique', 'Plastique', 1);
INSERT INTO trash_config (name, type, weight) VALUES ('Marc de café', 'Organique', 15);
INSERT INTO trash_config (name, type, weight) VALUES ('Enveloppe', 'Papier', 3);
INSERT INTO trash_config (name, type, weight) VALUES ('Miroir cassé', 'Verre', 200);
INSERT INTO trash_config (name, type, weight) VALUES ('Boîte de conserve en étain', 'Métallique', 20);

INSERT INTO bin (color) VALUES ('Verte');
INSERT INTO bin (color) VALUES ('Jaune');
INSERT INTO bin (color) VALUES ('Bleue');
INSERT INTO bin (color) VALUES ('Classique');

INSERT INTO voucher_config (discount_type, discount_value, fidelity_points_cost, shop) VALUES ('percentage', 10, 500, 'Auchan');
INSERT INTO voucher_config (discount_type, discount_value, fidelity_points_cost, shop) VALUES ('flat', 5, 30, 'Carrefour');
INSERT INTO voucher_config (discount_type, discount_value, fidelity_points_cost, shop) VALUES ('percentage', 15, 750, 'Boulanger');
INSERT INTO voucher_config (discount_type, discount_value, fidelity_points_cost, shop) VALUES ('flat', 7, 40, 'Leclerc');
INSERT INTO voucher_config (discount_type, discount_value, fidelity_points_cost, shop) VALUES ('percentage', 20, 1000, 'Intermarché');
INSERT INTO voucher_config (discount_type, discount_value, fidelity_points_cost, shop) VALUES ('flat', 3, 20, 'Fnac');
INSERT INTO voucher_config (discount_type, discount_value, fidelity_points_cost, shop) VALUES ('percentage', 12, 600, 'Darty');
INSERT INTO voucher_config (discount_type, discount_value, fidelity_points_cost, shop) VALUES ('flat', 8, 45, 'Super U');
INSERT INTO voucher_config (discount_type, discount_value, fidelity_points_cost, shop) VALUES ('percentage', 18, 900, 'Monoprix');
INSERT INTO voucher_config (discount_type, discount_value, fidelity_points_cost, shop) VALUES ('flat', 4, 25, 'Cora');