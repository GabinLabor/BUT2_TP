<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>TP2 avec PHP</title>
	</head>
	<style>
		body { font-family: Arial, Helvetica, sans-serif; font-size: 20px; }
		table.tableau { border-collapse: collapse; margin: 20px 0; }
		table.tableau, table.mul th, table.tableau td { border: 3px double #000; }
		table.tableau th, table.tableau td {
			width: 30px; height: 30px;
			text-align: center; vertical-align: middle; padding: 2px;
		}
		table.tableau th { font-size: 25px; font-weight: bold; }
		table.tableau td.gris { background: #bfbfbf; } /* diagonale grise */
	</style>
	<body>
		<?php // Question 1
			echo 'Hello world!';
		?>

		<?php // Question 2
			$chaine = "Bonjour tout le monde";
			$inverse = "";
			$longueur = strlen($chaine);
		    // On veut parcourir la chaîne à l'envers
			echo "<br>".strlen($chaine);

			/* echo "<br/>".var_dump($longueur);
			print_r($longueur);
			*/
			echo "<br><br>";

			for ($i = $longueur - 1; $i >= 0; $i--) {
				$inverse .= mb_substr($chaine, $i, 1);
			}
			echo "<br>".$inverse;
		?>

		<br><br>

		<?php // Question 3
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

		<br><br>

		<?php
			// Question 4
			// On crée un tableau associatif comme vu en java, ville => url
			$destinations = array(
				"Toulouse" => "https://metropole.toulouse.fr/",
				"Paris"    => "https://www.paris.fr/",
				"Lyon"     => "https://www.grandlyon.com/",
				"Bordeaux" => "https://www.bordeaux.fr/",
				"Rodez"    => "https://www.ville-rodez.fr/",
				"Marseille"=> "https://www.marseille.fr/"
			);

			$cle = array_rand($destinations); // au hasard, on tire une clé du tableau

			$url = $destinations[$cle]; // on récupère et associe l'url correspondant à la ville

			// affichage résultat avec un lien blank !
			echo "Mes prochaines vacances seront à <a href='$url' target='_blank'>$cle</a> !";
		?>

		<br><br>

		<?php // Question 5 : Table de multiplication 1–9 ?>
			<h4>Question 5 – Table de multiplication</h4>

			<table class="tableau">
			<tr>
				<th>X</th> <!-- premiere cellule de la table row, juste un X -->
				<?php for ($j = 1; $j <= 9; $j++): //boucle for pour afficher les entetes de 1 à 9 ?>
				<th><?= $j ?></th>
				<?php endfor; ?>
			</tr>

			<?php for ($i = 1; $i <= 9; $i++): // boucle externe pr chq ligne du tableau?>
				<tr>
				<th><?= $i ?></th> <!-- en-tête de ligne -->
				<?php for ($j = 1; $j <= 9; $j++): // boucle j à l'intérieur pour chaque colonne
					$val = $i * $j; // calcul de la valeur affichée
					$cls = ($i === $j) ? ' class="gris"' : ''; //si on est sur la diagonale on colorie en gris
				?>
					<td<?= $cls ?>><?= $val ?></td> <!-- affichage de la cellule -->
				<?php endfor; ?>
				</tr>
			<?php endfor; ?>
			</table>

	</body>
</html>