<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>Exemple Cours 1</title>
	</head>
	<body>
		
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

		?>
			<form action="Exemples_Cours2_4_PassageParametres1.php" method="post">
				Nom : <input type="text" name="nom" placeholder="Tapez votre nom" />
				Prénom : <input type="text" name="prenom" placeholder="Tapez votre prénom" />
				
				<input type="submit" value="OK"><br />
			<form>
		<?php
			}
		?>
		
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