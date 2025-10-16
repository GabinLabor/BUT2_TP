<!doctype html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<title>Les excuses du lundi matin</title>
	  
		<link href="css/monStyle.css" rel="stylesheet">
		
		<!-- Bootstrap CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<?php include "tableauPhrases.php"; ?> 
	</head>
	<body>
		<?php 
		// Si on a appuyé sur le bouton auparavant
		if (isset($_POST["var1"])) {
			?> 
			<div class="container-fluid">
			<div class="row cadre ">	 
				<div class="col-12">
					<h1>Mon excuse : </h1>
					<br>
				</div>
			</div>
			<div class="row cadre ">
				<?php
				$texteAAfficher = "";
				$compteurTab = 1;
				foreach($_POST as $morceau) {
					$texteAAfficher = $texteAAfficher." ".$tabExGen[$compteurTab][$morceau];
					$compteurTab++;
				}
				echo "$texteAAfficher";
				?>
				<br>
				(Vous pouvez modifier votre excuse en changeant les champs.)
			</div>

		<?php 
		// SI c'est la première fois qu'on arrive sur la page (pas de clic bouton)
		} else {
			?>
			<div class="container-fluid">
			<div class="row cadre ">	 
				<div class="col-12">
					<h1>Tous les lundis, une excuse différente ! </h1>
					Générez votre excuse du lundi matin en selectionnant les différents champs.<br/>
				</div>
			</div>
		<?php }?>

			<div class="row cadre ">
				<form action="lundiMatinDepart.php" method="post">
					<div class="col-12">
						<?php 
							$compteurVar = 1; 
							foreach($tabExGen as $tableau) {
								
								echo "<select name='var$compteurVar'>";

								$compteurValue = 1;
								foreach($tableau as $phrase) {
									// Récupérer la valeur sélectionnée si elle existe
									$selected = '';
									if (isset($_POST["var$compteurVar"]) && $_POST["var$compteurVar"] == $compteurValue) {
										$selected = 'selected';
									}
									echo "<option value='$compteurValue' $selected>$phrase</option>";
									$compteurValue++;
								}

								echo "</select><br>";
								$compteurVar++;
							}
						?>
					</div>
					<button>Générer l'excuse</button>
				</form>
			</div>
		</div> 
		
	</body>
</html>