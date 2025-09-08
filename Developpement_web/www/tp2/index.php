<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>TP2 avec PHP</title>
	</head>
	<body>
		<?php echo 'Hello world!';?>

		<?php
			$chaine = "Bonjour tout le monde";
			$inverse = "";
			$longueur = strlen($chaine);
		    // On veut parcourir la chaîne à l'envers
			echo "<br>".strlen($chaine);

			/* echo "<br/>".var_dump($longueur);
			print_r($longueur);
			*/
			echo "<br><br><br>";
			for ($i = $longueur - 1; $i >= 0; $i--) {
				$inverse .= mb_substr($chaine, $i, 1);
			}
			echo "<br>".$inverse;
		?>

		<br>

		<?php
			$chaine2 = "Bonjour à tous cette fois";

		for ($i = 0; $i < strlen($chaine2); $i++) {
			// on extrait le caractère à la position $i
			$lettre = mb_substr($chaine2, $i, 1);

			// Vérif si la position est paire ou impaire
			if ($i % 2 == 0) {				
				echo $lettre; // Si position paire, affiche normalement
			} else {
				// Si position impaire, afficher en rouge
				echo "<span style='color:#FF0000;'>$lettre</span>";
			}
		}
		?>

		<br>
		
		<?php

		?>
	</body>
</html>
				