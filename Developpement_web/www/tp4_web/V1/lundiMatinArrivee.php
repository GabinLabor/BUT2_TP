<!doctype html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<title>Les excuses du lundi matin V2</title>
	  
		<link href="css/monStyle.css" rel="stylesheet">
		
		<!-- Bootstrap CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<?php include "tableauPhrases.php"; ?> 
	</head>
	<body>
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
			</div>
		</div>
	</body>
</html>