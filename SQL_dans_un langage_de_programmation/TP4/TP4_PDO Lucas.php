<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<title>TP4-PDO1</title>

		<!-- Lien vers mon CSS -->
		<link href="css/monStyle.css" rel="stylesheet">
		<link rel="stylesheet" href="../../outils/bootstrap-5.3.2-dist/css/bootstrap.min.css">

	</head>

	<body>
    <h1> Etape 1 </h1>
	<?php
		$host='localhost';	// Serveur de BD
		$db='mezabi3';		// Nom de la BD
		$user='root';		// User
		$pass='root';		// Mot de passe
		$charset='utf8mb4';	// charset utilisé

		// Constitution variable DSN
		$dsn="mysql:host=$host;dbname=$db;charset=$charset";

		// Réglage des options
		$options=[
			PDO::ATTR_ERRMODE=>PDO::ERRMODE_EXCEPTION,
			PDO::ATTR_DEFAULT_FETCH_MODE=>PDO::FETCH_ASSOC,
			PDO::ATTR_EMULATE_PREPARES=>false];

		try {	// Bloc try bd injoignable ou si erreur SQL
			$pdo=new PDO($dsn,$user,$pass,$options);	                                    // Connexion PDO

            $requete="SELECT ID_CLIENT, CODE_CLIENT, NOM_MAGASIN, ADRESSE_1, ADRESSE_2, CODE_POSTAL, VILLE, TELEPHONE, EMAIL  FROM clients ORDER BY ID_CLIENT ASC"  ;	// Définition de la requête
			$resultats=$pdo->query($requete);  												// Execution de la requête


            echo '<table class="table table-striped">' ;
																		// Début table
				echo "<tr><th>ID</th><th>Code Client</th><th>Nom du magasin</th><th>Adresse1</th><th>Adresse2</th><th>Code postal/Ville</th><th>Téléphone</th><th>Adresse email</th><tr>";			// Première ligne titre

				while( $ligne = $resultats->fetch() ) { 									// Parcours des lignes
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
					echo "<tr>";															// Fin ligne
				}
			echo "</table>" ;																// Fin table
			echo "<hr>";


		} catch(PDOException $e){
			//Il y a eu une erreur
			echo "<h1>Erreur BD ".$e->getMessage();
		}
	?>

	</body>
</html>