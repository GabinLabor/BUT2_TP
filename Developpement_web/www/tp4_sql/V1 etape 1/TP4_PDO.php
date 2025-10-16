<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<title>TP4-PDO1</title>

		<!-- Lien vers mon CSS et cdn boostrap -->
		<link href="css/monStyle.css" rel="stylesheet">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

	</head>

	<body>
    <h1>Etape 1</h1>
	<?php
		$host='localhost';	// Serveur de BD
		$db='mezabi3';		// Nom de la BD
		$user='root';		// User
		$pass='root';		// Mot de passe
		$charset='utf8mb4';	// charset utilisé

		// Variable DSN data source name = comment se connecter à la base ; que PDO utilise pour se co
		$dsn="mysql:host=$host;dbname=$db;charset=$charset";

		// Réglage des options pour PDO : sécurité, ...
		$options=[
			PDO::ATTR_ERRMODE=>PDO::ERRMODE_EXCEPTION];

		try {	// Bloc try bd injoignable ou si erreur SQL, on tente la connexion
			// si tout va bien, pdo contient la connexion sinon catch
			$pdo=new PDO($dsn,$user,$pass,$options);

			// Définition de la requête, demande tous les clients, triés par ID croissant
            $requete="SELECT ID_CLIENT, CODE_CLIENT, NOM_MAGASIN, ADRESSE_1, ADRESSE_2,
							CODE_POSTAL, VILLE, TELEPHONE, EMAIL
						FROM clients
						ORDER BY ID_CLIENT ASC";
			// Execution de la requête, $resultats contient les données
			$resultats=$pdo->query($requete);  												// Execution de la requête


            echo '<table class="table table-striped">' ;
			// Début table
				echo "<tr><th>ID</th><th>Code Client</th><th>Nom du magasin</th><th>Adresse1</th><th>Adresse2</th><th>Code postal/Ville</th><th>Téléphone</th><th>Adresse email</th></tr>";			// Première ligne titre

				// Ouverture tableau bootstrap et boucle while pour fetch affichage de chaque ligne
				while($ligne = $resultats->fetch() ) { 									// Parcours des lignes
																					        // Incrémentation compteur de lignes
					echo "<tr>";
						echo "<td>".$ligne['ID_CLIENT']."</td>";							// Cellule ID
						echo "<td>".$ligne['CODE_CLIENT']."</td>";							// Cellule code client
						echo "<td>".$ligne['NOM_MAGASIN']."</td>";							// Cellule nom du magasin
                        echo "<td>".$ligne['ADRESSE_1']."</td>";
                        echo "<td>".$ligne['ADRESSE_2']."</td>";
                        echo "<td>".$ligne['CODE_POSTAL']. " " . $ligne['VILLE']."</td>";
                        echo "<td>".$ligne['TELEPHONE']."</td>";
                        echo "<td>".$ligne['EMAIL']."</td>";
					echo "</tr>";															// Fin ligne
				}
			echo "</table>" ;																// Fin table
			echo "<hr>";


		} catch(PDOException $e){
			//Il y a eu une erreur
			echo "<h1>Erreur connexion base de données".$e->getMessage();
		}
	?>

	</body>
</html>