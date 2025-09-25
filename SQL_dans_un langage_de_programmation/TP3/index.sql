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
    DECLARE prefixFrance CHAR(7);
    DECLARE intermediaire INT;
    DECLARE base12 CHAR(12);


    SELECT CONTENU_A INTO prefixFrance FROM parametres WHERE ID = 'DEB_GENCODE';

    SELECT IFNULL(CONTENU_N, 0) + 1 INTO intermediaire FROM parametres WHERE ID = 'LAST_GENCODE';

    -- substring typage dynamique on peut addittionner

    END //
DELIMITER ;
















MODIFIES SQL DATA

    DECLARE sum_odd INT DEFAULT 0;   -- positions 1,3,5,7,9,11
    DECLARE sum_even INT DEFAULT 0;  -- positions 2,4,6,8,10,12
    DECLARE digit INT;
    DECLARE i INT DEFAULT 1;
    DECLARE total INT;
    DECLARE key_digit INT;
    DECLARE code CHAR(13);

    -- 1) Récupérer le préfixe fabricant/pays (7 chiffres)
    SELECT CONTENU_A INTO prefix
		FROM parametres
		WHERE ID = 'DEB_GENCODE';

    -- 2) Incrémenter le dernier numéro produit (5 chiffres)
    SELECT IFNULL(CONTENU_N, 0) + 1 INTO next_num
		FROM parametres
		WHERE ID = 'LAST_GENCODE';

    UPDATE parametres
		SET CONTENU_N = next_num
		WHERE ID = 'LAST_GENCODE';

    -- 3) Former les 12 premiers chiffres (préfixe + produit)
    SET base12 = CONCAT(prefix, LPAD(next_num, 5, '0'));

    -- 4) Calcul de la clé EAN-13
    WHILE i <= 12 DO
        SET digit = CAST(SUBSTRING(base12, i, 1) AS UNSIGNED);
        IF (i MOD 2) = 1 THEN
            SET sum_odd = sum_odd + digit;
        ELSE
            SET sum_even = sum_even + digit;
        END IF;
        SET i = i + 1;
    END WHILE;

    SET total = sum_odd + (sum_even * 3);
    SET key_digit = (10 - (total MOD 10)) MOD 10;

    -- 5) Code barre final
    SET code = CONCAT(base12, key_digit);

    RETURN code;
END//
//

DELIMITER ;
