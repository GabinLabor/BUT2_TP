<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
		<link rel="stylesheet" href="../../tp1/librairie/bootstrap-5.3.1-dist/css/bootstrap.css">
		<link rel="stylesheet" href="../../tp1/librairie/fontawesome-free-7.0.0-web/css/all.css">
		<title>IUT BANK - Détail du compte</title>
	</head>
	<body>

		<!-- Header -->
		<div class="container">
			<div class="row header">
				<div class="row">
					<div class="col-md-2 col-sm-12"> <img src="images/Logo.jpg" alt="Logo IUT BANK" id="logoIUTBank"> </div>
					<div class="col-md-10 col-sm-12 text"> <h1> Ma Banque en ligne</h1><h1> IUT BANK ONLINE </h1> </div>
				</div>
			</div>

			<div class="row bordure">
				<div class="col-12 text"> <h1> -- Bienvenue M. Gabin Laborieux -- </h1>
					<h2> Vous pourrez grâce à cette interface voir le détail de vos comptes et faire toutes vos opérations à distance. </h2> </div>
			</div>

        <!-- Compte -->
            <div class="row bordure">
                <div class="col-md-2 d-none d-md-block d-flex align-items-center justify-content-center text">
                    <img src="images/CompteCourant.jpg" alt="Logo Compte courant" id="logoCompteCourant">
                </div>
                <div class="col-sm-12 col-md-10 d-flex align-items-center justify-content-center text"> <h3>Compte No 123456789ABC - Type : Compte courant </h3>
                </div>
            </div>

        <!-- Tableau -->
            <div class="row bordure">
                <?php
                    $nomFich="FichiersDonnees/Ecritures.csv";
                    $nomFichType="FichiersDonnees/TypeEcritures.csv";
                    if (file_exists($nomFich) && file_exists($nomFichType)) {
                        $tabTypes = file($nomFich,FILE_IGNORE_NEW_LINES);
                        $typeEcriture = file($nomFichType,FILE_IGNORE_NEW_LINES);
                ?>
                <!-- Si le fichier existe on crée la table -->
                <table>
                    <?php
                        // Création de la liste déroulante ; on préapre une chaine HTML qui contient le form avec le select(filtre)
                        // TODO décimales, libéllé / type  collection avec les 2 lettres
                        // changement emplace
                        $btnFiltreEtListe = "
                        <br>
                        <form action='compte1.php' method='get'>
                            <select name='filtre'>
                                <option value=''>Tous</option>";
                        foreach($typeEcriture as $nbLign => $line) {
                            $tab = explode(';', $line);
                            $type = $tab[0];
                            $libelle = $tab[1];
                            $selectedOrNot = '';
                            // Si la page contient un filtre, le mettre en valeur par défaut
                            if (isset($_GET['filtre']) && $_GET['filtre'] == $type){
                                $selectedOrNot = 'selected';
                            }
                            if ((int) $nbLign != 0) {  // saute la 1ère ligne (en-têtes)
                                $btnFiltreEtListe = $btnFiltreEtListe."<option value='$type' $selectedOrNot>$libelle</option>";
                            }
                        }
                        $btnFiltreEtListe = $btnFiltreEtListe."</select> <input type='submit' value='Filtre'></form>";

                        // Affichage des lignes
                        foreach($tabTypes as $nbLign => $line) {
                            $tab = explode(';', $line);
                            $date = $tab[0];
                            $type = $tab[1];
                            $libelle = $tab[2];
                            $debit = $tab[3];
                            $credit = $tab[4];

                            //Si on est à la premiere ligne : afficher le bouton filtre en plus
                            if($nbLign == 0) {
                                // Ligne d'entête
                                $btnFiltre = $btnFiltreEtListe; // on injecte le menu de filtre dans la 1ere cellule filtre
                                $solde = "Solde";
                            } elseif ($nbLign == 1) {
                                //Deuxieme ligne initialise le solde : recalcule du solde suivant
                                $solde = (int) $credit - (int) $debit;
                                $btnFiltre = "";
                            } else {
                                //Calculer le solde
                                $btnFiltre = "";
                                if (isset($_GET['filtre']) && $_GET['filtre'] == '') {
                                    $solde = (int) $solde - (int) $debit + (int) $credit ;
                                } else {
                                    $solde ='';
                                }
                            }
                            if((int) $solde > 0) {
                                $classeSolde = 'gain';
                            } else {
                                $classeSolde = 'perte';
                            }

                            // Si les valeurs sont du bon type (ou si c'est la premiere ligne)
                            if (!isset($_GET['filtre']) || $nbLign == 0 || $_GET['filtre'] == $type || $_GET['filtre'] == '') {
                                echo "<tr>";
                                echo "<td>$date</td>";
                                echo "<td>$type$btnFiltre</td>";
                                echo "<td>$libelle</td>";
                                if ($nbLign == 0) {
                                    echo "<td>$debit</td>";
                                    echo "<td>$credit</td>";
                                    echo "<td>$solde</td>";
                                } else {
                                    echo "<td><span class='perte'>$debit</span></td>";
                                    echo "<td><span class='gain'>$credit</span></td>";
                                    echo "<td><span class='$classeSolde'>$solde</span></td>";
                                }
                                echo "</tr>";
                            }
                        }

                    } else {
                        echo "Le fichier n'existe pas";
                    }
                    ?>
                </table>
            </div>

        <!-- Footer -->
			<div class="row bordure">
				<div class="col-md-3 col-3 d-flex align-items-center">
					<a href="../pages/contact.html">
						<button class="btn btn-primary"> Nous contacter <i class="fas fa-envelope"></i> </button>
					</a>
				</div>
                <div class="col-md-3 col-3 d-flex align-items-center justify-content-center">
                    <a href="comptes.html">
						<button class="btn btn-primary"> Retour à la liste des comptes </button>
					</a>
                </div>
                <div class="col-md-3 col-3 d-flex align-items-center justify-content-end ">
					<a href="index.html"><button class="btn btn-danger"> Déconnexion <i class="fas fa-circle-xmark"></i></button></a>
				</div>
				<div class="col-md-3 col-3 text">
					Réalisé par
					<img src="images/LogoIut.png" alt="Logo IUT" id="logoIUT">
				</div>
			</div>
		</div>

	</body>
</html>