<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/TP3.css">
        <link rel="stylesheet" href="outils/bootstrap-5.3.1-dist/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1>Résultat du formulaire</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-4">
                    <?php
                        $nom = $_GET["nom"] ?? "";
                        if (empty($nom)) {
                            echo "<span class='erreur'>Merci de rentrer votre nom !</span>";
                        } else {
                            echo "<span class='ok'>Votre Nom : $nom</span>";
                        }
                    ?>
                </div>
                <div class="col-4">
                    <?php
                        $prenom = $_GET["prenom"] ?? "";
                        if (empty($prenom)) {
                            echo "<span class='erreur'>Merci de rentrer votre prénom !</span>";
                        } else {
                            echo "<span class='ok'>Votre prénom : $prenom</span>";
                        }
                    ?>
                </div>
                <div class="col-4">
                    <?php
                        $diplome = $_GET["diplome"] ?? "";
                        if (empty($diplome) || $diplome == "Sélectionner dans la liste") {
                            echo "<span class='erreur'>Merci de rentrer votre diplôme !</span>";
                        } else {
                            echo "<span class='ok'>Votre diplôme : $diplome</span>";
                        }
                    ?>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <?php
                        $question = $_GET["question"] ?? "";
                        if (empty($question)) {
                            echo "<span class='erreur'>Merci de rentrer votre question !</span>";
                        } else {
                            echo "<span class='ok'>Votre question : $question</span>";
                        }
                    ?>
                </div>
            </div>
        </div>
    </body>
</html>
