-- Question 2
-- Génération d’un numéro de facture AAAAMMXXX et insertion dans factures_entetes

DELIMITER //

DROP FUNCTION IF EXISTS cree_facture(client INT) -- supprimer la table si existante
CREATE FUNCTION cree_facture(client INT)
RETURNS INT
BEGIN
    DECLARE prefix_yyyymm INT;
    DECLARE dernierdumois INT;
    DECLARE prog INT;
    DECLARE numero_facture INT;

    -- on isole le format de la date AAAAMM
    SET prefix_yyyymm = DATE_FORMAT(CURDATE(), '%Y%m');

    -- on cherche le plus grand numéro de facture du mois en cours dans NO_FCT
    SELECT MAX(NO_FCT) INTO dernierdumois FROM factures_entetes
    WHERE NO_FCT BETWEEN prefix_yyyymm * 1000 AND prefix_yyyymm * 1000 + 999; -- entre XXXX0000 et 999 le max du mois courant

    -- si x = null ça renvoi y sinon x
    SET prog = IFNULL(dernierdumois MOD 1000, 0) + 1;
    -- on concatène avec le tampon
    SET numero_facture = prefix_yyyymm * 1000 + prog;

    INSERT INTO factures_entetes (NO_FCT, CLIENT, DATE_FCT) VALUES (numero_facture, client, CURDATE());
    RETURN numero_facture;
END//

DELIMITER ;


/*
-- Exemples : générer plusieurs entêtes pour les clients 1 et 2
SELECT cree_facture(1) AS no_fct_client1; //
SELECT cree_facture(1) AS no_fct_client1; //
SELECT cree_facture(2) AS no_fct_client2; //
SELECT cree_facture(2) AS no_fct_client2; //
*/

-- Question 3 - Met tous les codes-barres à NULL dans la table stockprix

DELIMITER //
	UPDATE stockprix
	SET CODE_BARRE = NULL;
//
DELIMITER ;

-- Question 4 - Génération d’un code-barres EAN-13 et mise à jour dans stockprix
DELIMITER //
CREATE FUNCTION genereCodeBarre()
    RETURNS VARCHAR(13)
BEGIN
    DECLARE prefix        VARCHAR(7);
    DECLARE v_last        INT;
    DECLARE v_new         INT;
    DECLARE code12        VARCHAR(12);
    DECLARE code13        VARCHAR(13);
    DECLARE i             INT DEFAULT 1;
    DECLARE somme_pair    INT DEFAULT 0;  -- positions 2,4,6,8,10,12 du code
    DECLARE somme_impair  INT DEFAULT 0;  --      "    1,3,5,7,9,11
    DECLARE cle           INT;

-- 1) on lit le préfixe (DEB_GENCODE)
SELECT contenu_a INTO prefix FROM parametres WHERE id = 'DEB_GENCODE';

-- 2) Récupérer + incrémenter LAST_GENCODE
-- chaque appel de fonction prend le prochain numéro libre
SELECT contenu_n INTO v_last FROM parametres WHERE id = 'LAST_GENCODE';
SET v_new = v_last + 1;
UPDATE parametres SET contenu_n = v_new WHERE id = 'LAST_GENCODE'; -- TODO faire le update avant et le +1 après

-- 3) On concatène Prefixe + numero prod : on construit les 12 premiers chiffres : 7 (prefixe) + 5 (numéro produit, zero-pad)
    SET code12 = CONCAT(
    prefix,
    LPAD(v_new, 5, '0')
);

    -- 4) Somme impairs / pairs (SUBSTRING 1-indexé, aide-mémoire)
    WHILE i <= 12 DO
        IF MOD(i, 2) = 0 THEN
            SET somme_pair = somme_pair + SUBSTRING(code12, i, 1); -- positions paires
          ELSE
            SET somme_impair = somme_impair + SUBSTRING(code12, i, 1); -- positions impaires
        END IF;
        SET i = i + 1;
    END WHILE;

    -- Clé EAN-13 :
    -- On vérifie que le dernier caractère est égal à 0
    SET cle = (10 - ((3 * somme_pair + somme_impair) MOD 10)) MOD 10; -- TODO marche dans tous les cas ?

    -- 5) Retourner le code à 13 chiffres
    SET code13 = CONCAT(code12, cle);
RETURN code13;
END//
DELIMITER ;


UPDATE stockprix
SET CODE_BARRE = genereCodeBarre()
WHERE CODE_BARRE IS NULL;





























/*

DELIMITER //

CREATE FUNCTION genereCodeBarre()
RETURNS VARCHAR(13)
BEGIN
    DECLARE prefixFrance CHAR(7);
    DECLARE intermediaire INT;
    DECLARE base12 CHAR(12);


    SELECT CONTENU_A INTO prefixFrance FROM parametres WHERE ID = 'DEB_GENCODE';

    SELECT IFNULL(CONTENU_N, 0) + 1 INTO intermediaire FROM parametres WHERE ID = 'LAST_GENCODE';

    -- substring typage dynamique on peut addittionner

    END //
DELIMITER ;

*/