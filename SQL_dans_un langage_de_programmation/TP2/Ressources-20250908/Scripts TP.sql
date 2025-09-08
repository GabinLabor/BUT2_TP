--2
INSERT INTO a_couleurs (designation)
 VALUES
 ('Rouge'),
 ('Vert'),
 ('Bleu'),
 ('Noir');

 --3
INSERT INTO  a_categories (designation)
VALUES
('Pantalons'),
('Vestes'),
('Tee-shirt');

--4
INSERT INTO a_tailles (designation)
VALUES
('XS'),
('S'),
('M'),
('L'),
('XL'),
('XXL');

--5
INSERT INTO articles (code_article, designation, categorie)
VALUES
('PTL002', 'Pantalon taille basse', 1);

/* 6 Créer un stock de 10 pièces en taille XL couleur rouge avec un code barre
"0000000000001" au prix de 35,90 pour l'article pantalon créé précédemment.
Créer un stock de 150 pièces taille L couleur Bleue avec un code barre "0000000000002"
au prix de 36,90 pour l'article pantalon créé précédemment.
Faire cela en une seule requête.

Etape 7
Modifier le stock de la couleur bleu taille L pour le pantalon à 160 unités
*/
INSERT INTO stockprix (couleur, taille, prix, code_barre, stock)
VALUES
(1, 5, 35.90, '0000000000001', 10);
(pantalon, 4, 36.90,"0000000000002", 150)