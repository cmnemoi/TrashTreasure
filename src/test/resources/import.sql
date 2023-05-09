INSERT INTO user (username, password, is_admin, fidelity_points) VALUES ('admin', 'admin', 'true', 0);

INSERT INTO trash_config (name, type, weight) VALUES ('Bouteille en plastique', 'Plastique', 20);
INSERT INTO trash_config (name, type, weight) VALUES ('Déchets alimentaires organiques', 'Organique', 500);
INSERT INTO trash_config (name, type, weight) VALUES ('Papier essuie-tout', 'Papier', 5);
INSERT INTO trash_config (name, type, weight) VALUES ('Bouteille en verre', 'Verre', 250);

INSERT INTO bin (color) VALUES ('Verte');
INSERT INTO bin (color) VALUES ('Jaune');
INSERT INTO bin (color) VALUES ('Bleue');
INSERT INTO bin (color) VALUES ('Classique');
