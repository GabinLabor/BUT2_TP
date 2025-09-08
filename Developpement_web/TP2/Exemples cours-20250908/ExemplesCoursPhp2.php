<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>Exemple Cours 2</title>
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
		
		<h1>Include </h1>
		<?php 
			include("le_code_a_inclure.php"); 
			// require("le_code_a_inclure.php"); 
			echo "La suite<br />"
		?>
		
		<h1>Exceptions </h1>		
		
		<?php
		try  {
			$fichier = 'FichireQuiNExistepas.txt';

			 if ( !file_exists($fichier) ) {
				throw new Exception('Fichier inexistant.');
			 }

			 $fp = fopen($fileName, "r");
			 if ( !$fp ) {
				throw new Exception('Impossible d\'ouvrir le fichier.');
			 }  
			 while (!feof($monfichier)) {
				$ligne = fgets($monfichier);
				echo $ligne;
			 }
			 fclose($fp);


		} catch ( Exception $e ) {
			echo "Une exception a été lévée <br/>" ;
			echo  $e->getMessage();
		} 
			
		?>		
		
		<h1>Passage de paramètres </h1>
		
		<?php
			// Récupération des données dans la page appelée
			if (isset($_GET['nom']) && isset($_GET['prenom'])) {
				echo "Les parametres ont été passés en GET<br />";
				$leNom=$_GET['nom'] ;		
				$prenom=$_GET['prenom'] ;	
				// $leNom=htmlspecialchars($_GET['nom']) ;
				// $prenom=htmlspecialchars($_GET['prenom']) ;
				echo "Bonjour ".$prenom." ".$leNom."<br />";
			} elseif (isset($_POST['nom']) && isset($_POST['prenom'])) {
				echo "Les parametres ont été passés en POST<br />";
				$leNom=$_POST['nom'] ;
				$prenom=$_POST['prenom'] ;
				// $leNom=htmlspecialchars($_POST['nom']) ;
				// $prenom=htmlspecialchars($_POST['prenom']) ;				
				echo "Bonjour ".$prenom." ".$leNom."<br />";
			} else { 
				$leNom="";
				$prenom="";
		}
		?>
		<form action="ExemplesCoursPhp2.php" method="post">
			Nom : <input type="text" name="nom" placeholder="Tapez votre nom" /
			<?php echo 'value="'.$leNom.'"'; ?>
			>
			Prénom : <input type="text" name="prenom" placeholder="Tapez votre prénom" /
			<?php echo 'value="'.$prenom.'"'; ?>
			>
			
			<input type="submit" value="OK"><br />
		<form>

		
		<!-- <script type="text/javascript">alert('Coucou me voilà !!')</script>-->
		
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		
	</body>
</html>