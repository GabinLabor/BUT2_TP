<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>Exemple Cours</title>
	</head>
	<body>
		<h1>Fonctions prédéfinies</h1>
		<?php
			$machaine="   vive le PHP   " ; 
			echo '$machaine="'.$machaine.'"<br />';
			
			echo 'strlen($machaine) > '.strlen($machaine)."<br />";							// Longueur de la chaine
			echo 'trim($machaine) > '.trim($machaine)."<br />";								// Suppression des espaces en début ou fin de chaine
			echo 'strtoupper($machaine) > '.strtoupper($machaine)."<br />";					// Chaine en majuscules
			echo 'ucwords ($machaine) > '.ucwords ($machaine)."<br />"; 						// Premières lettres en majuscules
			echo 'stripos(trim($machaine),"PHP") > '.stripos(trim($machaine),"PHP")."<br />";	// Position de la sous chaine
			echo 'strrev($machaine) > '.strrev($machaine)."<br />";								// Chaine inversée
			
			echo 'explode(" ", trim($machaine))  <br />';
			$decoupage = explode(" ", trim($machaine));
			foreach($decoupage as $mot){
				echo " > ".$mot . '<br />'; // 
			}
			echo 'join("_",$decoupage) > '.join("_",$decoupage)."<br />";
			
			
			echo "<hr />";
			echo 'echo abs(-5.65) > '. abs(-5.65)."<br />";	
			echo 'echo fmod(5,2) > '. fmod(5,2) ."<br />";	
			
		?>
		
		<h1>Fonctions</h1>
		<?php
		
			function multiplication($a,$i) {
				return $a*$i ;
			}
			echo 'echo multiplication(5,2) > '. multiplication(5,2) ."<br />";

		?>
		
		
		
	</body>
</html>