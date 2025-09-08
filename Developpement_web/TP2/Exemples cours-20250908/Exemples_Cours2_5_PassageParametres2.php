<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>Exemple Cours 2 Passage de parametres</title>
	</head>
	<body>
		
		<?php
			// Récupération des données dans la page appelée
			if (isset($_GET['nom']) && isset($_GET['prenom'])) {
				echo "<h1>Passage de paramètres en GET</h1>" ;
				$leNom=$_GET['nom'] ;		
				$prenom=$_GET['prenom'] ;	
				// $leNom=htmlspecialchars($_GET['nom']) ;
				// $prenom=htmlspecialchars($_GET['prenom']) ;
				if ($_GET['nom']=="" or $_GET['prenom']=="") {
					echo "Merci de rentrer votre nom et votre prénom<br />";
				} else {
					echo "Bonjour ".$prenom." ".$leNom."<br />";
				}
			} elseif (isset($_POST['nom']) && isset($_POST['prenom'])) {
				echo "<h1>Passage de paramètres en POST</h1>" ;
				$leNom=$_POST['nom'] ;
				$prenom=$_POST['prenom'] ;
				// $leNom=htmlspecialchars($_POST['nom']) ;
				// $prenom=htmlspecialchars($_POST['prenom']) ;				
				if ($_POST['nom']=="" or $_POST['prenom']=="") {
					echo "Merci de rentrer votre nom et votre prénom<br />";
				} else {
					echo "Bonjour ".$prenom." ".$leNom."<br />";
				}
			} else { 
				$leNom="";
				$prenom="";
				
		}
		?>
		<form action="Exemples_Cours2_5_PassageParametres2.php" method="get">
			Nom : <input type="text" name="nom" placeholder="Tapez votre nom" <?php echo 'value="'.$leNom.'"'; ?>>
			
			Prénom : <input type="text" name="prenom" placeholder="Tapez votre prénom" <?php echo 'value="'.$prenom.'"'; ?>>
			
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