<?php
$version="";
$server_name="";
$server_port="";

// Étape 2 — Fonction d’insertion d’une facture (AAAAMMXXX)
DELIMITER //

CREATE FUNCTION fonction_creation_facture(client INT)
RETURNS INT
MODIFIES SQL DATA
BEGIN
  DECLARE date_ajd DATE;
  DECLARE prefix INT;
  DECLARE dernier_max INT;
  DECLARE nouveau INT;

SET date_ajd = CURDATE();
SET prefix = DATE

?>

<?php
  $now = new DateTime();        // maintenant
  $annee = $now->format('Y');
  $mois  = $now->format('m');
  $prefix = $now->format('Ym');


?>

