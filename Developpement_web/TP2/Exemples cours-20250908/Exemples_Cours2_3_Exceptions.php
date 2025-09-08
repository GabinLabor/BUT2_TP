<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>Exemple Cours</title>
	</head>
	<body>
		
		<h1>Exceptions </h1>		
		
		<?php
		try  {
			$fichier = 'FichierQuiNExistepas.txt';

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
		
		
		
	</body>
</html>