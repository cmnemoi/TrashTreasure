INSERT INTO user (username, password, is_admin, fidelity_points) VALUES ('admin', 'admin', 'true', 0);

INSERT INTO trash_config (name, type, weight) VALUES ('Bouteille en plastique', 'Plastique', 20);
INSERT INTO trash_config (name, type, weight) VALUES ('Déchets alimentaires organiques', 'Organique', 500);
INSERT INTO trash_config (name, type, weight) VALUES ('Papier essuie-tout', 'Papier', 5);
INSERT INTO trash_config (name, type, weight) VALUES ('Bouteille en verre', 'Verre', 250);

INSERT INTO bin (color) VALUES ('Verte');
INSERT INTO bin (color) VALUES ('Jaune');
INSERT INTO bin (color) VALUES ('Bleue');
INSERT INTO bin (color) VALUES ('Classique');

INSERT INTO voucher_config (discount_type, discount_value, fidelity_points_cost, shop) VALUES ('percentage', 10, 500, 'Auchan');
INSERT INTO voucher_config (discount_type, discount_value, fidelity_points_cost, shop) VALUES ('flat', 5, 30, 'Carrefour');
