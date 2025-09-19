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
Faire cela en une seule requête. */

INSERT INTO stockprix (ARTICLE, COULEUR, TAILLE, PRIX, CODE_BARRE, STOCK)
VALUES
(
  (SELECT ID_ARTICLE FROM articles WHERE CODE_ARTICLE='PTL002'),
  (SELECT CODE_COULEUR FROM a_couleurs WHERE DESIGNATION='Rouge'),
  (SELECT CODE_TAILLE  FROM a_tailles  WHERE DESIGNATION='XL'),
  35.90, '0000000000001', 10
),
(
  (SELECT ID_ARTICLE FROM articles WHERE CODE_ARTICLE='PTL002'),
  (SELECT CODE_COULEUR FROM a_couleurs WHERE DESIGNATION='Bleu'),
  (SELECT CODE_TAILLE  FROM a_tailles  WHERE DESIGNATION='L'),
  36.90, '0000000000002', 150
);


/* =========================
ÉTAPE 7 — MODIFIER LE STOCK (Bleu, taille L) → 160
========================= */
UPDATE stockprix S
JOIN articles A ON A.ID_ARTICLE = S.ARTICLE
SET S.STOCK = 160
WHERE A.CODE_ARTICLE = 'PTL002'
    AND S.COULEUR = (SELECT CODE_COULEUR FROM a_couleurs WHERE DESIGNATION='Bleu')
    AND S.TAILLE  = (SELECT CODE_TAILLE  FROM a_tailles  WHERE DESIGNATION='L');


/* =========================
ÉTAPE 8 — SUPPRIMER LE STOCK DE COULEUR ROUGE POUR LE PANTALON
(supprime toutes les tailles rouges de l’article ; ici on avait XL)
========================= */
DELETE S
FROM stockprix S
JOIN articles A ON A.ID_ARTICLE = S.ARTICLE
WHERE A.CODE_ARTICLE='PTL002'
    AND S.COULEUR = (SELECT CODE_COULEUR FROM a_couleurs WHERE DESIGNATION='Rouge');


/* =========================
ÉTAPE 9 — SUPPRIMER L’ARTICLE
(d’abord supprimer ses lignes de stock à cause de la contrainte FK)
   ========================= */
DELETE S
FROM stockprix S
JOIN articles A ON A.ID_ARTICLE = S.ARTICLE
WHERE A.CODE_ARTICLE='PTL002';

DELETE FROM articles
WHERE CODE_ARTICLE='PTL002';


/* =========================
ÉTAPE 10 — SUPPRIMER TOUTES LES TABLES + VÉRIFICATION
(désactive/active les FKs pour éviter l’ordre de drop)
   ========================= */
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS
    factures_lignes,
    factures_entetes,
    devis_lignes,
    devis_entetes,
    stockprix,
    articles,
    a_couleurs,
    a_tailles,
    a_categories,
    clients,
    c_types;

SET FOREIGN_KEY_CHECKS = 1;
SHOW TABLES; -- Vérification

/* =========================
   ÉTAPE 12 — Lister les articles de la catégorie 3
   Affichage : CODE_ARTICLE, DESIGNATION
   ========================= */
SELECT CODE_ARTICLE, DESIGNATION
FROM articles
WHERE CATEGORIE = 3
ORDER BY CODE_ARTICLE;

/* =========================
   ÉTAPE 13 — Lister les articles de la catégorie 3 avec le nom de la catégorie
   Affichage : CODE_ARTICLE, DESIGNATION, CATEGORIE (nom)
   ========================= */
SELECT A.CODE_ARTICLE,
            A.DESIGNATION,
            C.DESIGNATION AS CATEGORIE
FROM articles A
JOIN a_categories C ON C.CODE_CATEGORIE = A.CATEGORIE
WHERE A.CATEGORIE = 3
ORDER BY A.CODE_ARTICLE;


/* =========================
   ÉTAPE 14 — Lignes de stock avec STOCK < 100
   Tri : code article ASC, stock ASC
   Affichage : CODE_ARTICLE, DESIGNATION, STOCK
   ========================= */
SELECT A.CODE_ARTICLE,
        A.DESIGNATION,
        S.STOCK
FROM articles A
JOIN stockprix S ON S.ARTICLE = A.ID_ARTICLE
WHERE S.STOCK < 100
ORDER BY A.CODE_ARTICLE ASC, S.STOCK ASC;


/* =========================
   ÉTAPE 15 — Même filtre + infos détaillées (couleur, taille, prix)
   Tri : code article, couleur, taille, stock croissant
   ========================= */
SELECT A.CODE_ARTICLE,
       A.DESIGNATION,
       C.DESIGNATION AS COULEUR,
       T.DESIGNATION AS TAILLE,
       S.STOCK,
       S.PRIX
FROM articles A
JOIN stockprix  S ON S.ARTICLE = A.ID_ARTICLE
JOIN a_couleurs C ON C.CODE_COULEUR = S.COULEUR
JOIN a_tailles  T ON T.CODE_TAILLE  = S.TAILLE
WHERE S.STOCK < 100
ORDER BY A.CODE_ARTICLE ASC, COULEUR ASC, TAILLE ASC, S.STOCK ASC;


/* =========================
   ÉTAPE 16 — Prix maximum parmi toutes les lignes de stock
   ========================= */
SELECT MAX(PRIX) AS MAXIMUM
FROM stockprix;


/* =========================
   ÉTAPE 17 — Articles aux lignes au PRIX maximum
   Tri : code article, couleur, taille, stock croissant
   ========================= */
SELECT A.CODE_ARTICLE,
        A.DESIGNATION,
        C.DESIGNATION AS COULEUR,
        T.DESIGNATION AS TAILLE,
        S.STOCK,
        S.PRIX
FROM articles A
JOIN stockprix  S ON S.ARTICLE = A.ID_ARTICLE
JOIN a_couleurs C ON C.CODE_COULEUR = S.COULEUR
JOIN a_tailles  T ON T.CODE_TAILLE  = S.TAILLE
WHERE S.PRIX = (SELECT MAX(PRIX) FROM stockprix)
ORDER BY A.CODE_ARTICLE ASC, COULEUR ASC, TAILLE ASC, S.STOCK ASC;


/* =========================
   ÉTAPE 18 — Baisser le prix de toutes les lignes de 10 %
   (vérifier ensuite avec la requête de l’étape 17)
   ========================= */
UPDATE stockprix
SET PRIX = PRIX * 0.90;


/* =========================
   ÉTAPE 19 — Afficher les lignes des factures avec MONTANT = QUANTITE*PRIX
   Affichage : NO_FCT, DATE_FCT, NOM_MAGASIN, RESPONSABLE,
               CODE_ARTICLE, DESIGNATION, COULEUR, TAILLE,
               QUANTITE, PRIX, MONTANT
   ========================= */
SELECT E.NO_FCT,
       E.DATE_FCT,
       CL.NOM_MAGASIN,
       CL.RESPONSABLE,
       A.CODE_ARTICLE,
       A.DESIGNATION,
       C.DESIGNATION AS COULEUR,
       T.DESIGNATION AS TAILLE,
       L.QUANTITE,
       L.PRIX,
       (L.QUANTITE * L.PRIX) AS MONTANT
FROM factures_lignes  L
JOIN factures_entetes E  ON E.ID_ENT_FCT = L.ID_FCT
JOIN clients         CL  ON CL.ID_CLIENT = E.CLIENT
JOIN articles        A   ON A.ID_ARTICLE = L.ARTICLE
JOIN a_couleurs      C   ON C.CODE_COULEUR = L.COULEUR
JOIN a_tailles       T   ON T.CODE_TAILLE  = L.TAILLE
ORDER BY E.NO_FCT ASC, A.CODE_ARTICLE ASC;


/* =========================
   ÉTAPE 20 — Montant total par facture
   Affichage : NO_FCT, DATE_FCT, NOM_MAGASIN, RESPONSABLE, MONTANT
   ========================= */
SELECT E.NO_FCT,
        E.DATE_FCT,
        CL.NOM_MAGASIN,
        CL.RESPONSABLE,
        SUM(L.QUANTITE * L.PRIX) AS MONTANT
FROM factures_lignes  L
JOIN factures_entetes E  ON E.ID_ENT_FCT = L.ID_FCT
JOIN clients         CL  ON CL.ID_CLIENT = E.CLIENT
GROUP BY E.NO_FCT, E.DATE_FCT, CL.NOM_MAGASIN, CL.RESPONSABLE
ORDER BY E.NO_FCT ASC;