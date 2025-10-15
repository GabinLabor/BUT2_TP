<!doctype html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<title>Les excuses du lundi matin</title>

		<link href="css/monStyle.css" rel="stylesheet">

		<!-- Bootstrap CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

	</head>
	<body>
		<div class="container-fluid">
			<div class="row cadre ">
				<div class="col-12">
					<h1>Tous les lundis, une excuse différente ! </h1>
					Générez votre excuse du lundi matin en selectionnant les différents champs.<br/>
				</div>
			</div>

			<div class="row cadre ">
				<div class="col-12">
					<?php>
						// Inclusion du tableau des phrases //
						include("tableauPhrases.php");

						// Instructions pour l'utilisateur
						echo "<p>Choisissez une proposition dans chaque liste pour générer votre excuse du lundi matin :</p>";
						// Début du formulaire
						echo '<form method="post" action="">';

						// Première liste déroulante
						echo '<label for="var1">Première partie :</label>';
						echo '<select name="var1" id="var1">';
						foreach () {

						}
						echo '</select><br>';

					?>

					<select name="var1">
						<option value="1">Première proposition</option>
						<option value="2">Deuxième proposition</option>
					</select>
					<br>
					<select name="var2">
						<option value="1">Première proposition</option>
						<option value="2">Deuxième proposition</option>
					</select>
				</div>
			</div>
		</div>
	</body>
</html>