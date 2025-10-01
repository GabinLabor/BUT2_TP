<?php
// Variables pour stocker les données
$nom = '';
$prenom = '';
$sujet = '';
$question = '';

// Variables pour la validation
$nomValide = true;
$prenomValide = true;
$sujetValide = true;
$questionValide = true;

// Indicateur si le formulaire a été soumis
$formulaireSoumis = false;

// Fonction pour vérifier si une donnée est vide
function estVide($valeur) {
    return empty($valeur) || trim($valeur) === '';
}

// Vérifier si le formulaire a été soumis TODO ça ne sert à rien apparemment
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $formulaireSoumis = true;

    // Récupération des données POST
    $nom = isset($_POST['nom']) ? trim($_POST['nom']) : '';
    $prenom = isset($_POST['prenom']) ? trim($_POST['prenom']) : '';
    $sujet = isset($_POST['sujet']) ? $_POST['sujet'] : '';
    $question = isset($_POST['question']) ? trim($_POST['question']) : '';

    // Validation des données
    $nomValide = !estVide($nom);
    $prenomValide = !estVide($prenom);
    $sujetValide = !estVide($sujet);
    $questionValide = !estVide($question);

    // Si toutes les données sont valides, afficher un message de succès
    $toutesValides = $nomValide && $prenomValide && $sujetValide && $questionValide;
}

// Détermination des classes CSS (logique inversée selon l'énoncé)
$classeNom = ($formulaireSoumis && $nomValide) ? 'ok' : 'erreur';
$classePrenom = ($formulaireSoumis && $prenomValide) ? 'ok' : 'erreur';
$classeSujet = ($formulaireSoumis && $sujetValide) ? 'ok' : 'erreur';
$classeQuestion = ($formulaireSoumis && $questionValide) ? 'ok' : 'erreur';
?>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP3-3 - Formulaire intégré</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <link rel="stylesheet" href="css/TP3.css">
        </head>
    <body>
        <div class="container">
        <div class="container mt-5">
            <h2 class="text-center mb-4">Formulaire de contact intégré</h2>

            <?php if ($formulaireSoumis && isset($toutesValides) && $toutesValides): ?>
                <div class="alert alert-success text-center">
                    <h4>Merci <?php echo htmlspecialchars($prenom . ' ' . $nom); ?> !</h4>
                        <p>Votre message concernant "<?php echo htmlspecialchars($sujet); ?>" a été envoyé avec succès.</p>
                        <a href="TP3-3.php" class="btn btn-primary">Nouveau message</a>
                </div>
            <?php else: ?>
                <!-- Formulaire principal -->
                <form method="POST" action="TP3-3.php">
                    <!-- Ligne : nom et prénom -->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="nom" class="form-label <?php echo $classeNom; ?>">Nom :</label>
                                <input type="text" class="form-control" id="nom" name="nom"
                                    value="<?php echo htmlspecialchars($nom); ?>">

                                <?php if ($formulaireSoumis && !$nomValide): ?>
                                    <small class="text-danger">Le nom est obligatoire</small>
                                <?php endif; ?>

                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="prenom" class="form-label <?php echo $classePrenom; ?>">Prénom :</label>
                                <input type="text" class="form-control" id="prenom" name="prenom"
                                    value="<?php echo htmlspecialchars($prenom); ?>">
                                <?php if ($formulaireSoumis && !$prenomValide): ?>
                                    <small class="text-danger">Le prénom est obligatoire</small>
                                <?php endif; ?>
                            </div>
                        </div>
                    </div>

                    <!-- Ligne : sujet -->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="mb-3">
                                <label for="sujet" class="form-label <?php echo $classeSujet; ?>">Sujet :</label>
                                <select class="form-select" id="sujet" name="sujet">
                                    <option value="">-- Diplôme préparé --</option>
                                    <option value="informatique" <?php echo ($sujet == 'BUT informatique') ? 'selected' : ''; ?>>BUT Informatique</option>
                                    <option value="gea" <?php echo ($sujet == 'gea') ? 'selected' : ''; ?>>GEA</option>
                                    <option value="cj" <?php echo ($sujet == 'cj') ? 'selected' : ''; ?>>CJ</option>
                                    <option value="QLIO" <?php echo ($sujet == 'QLIO') ? 'selected' : ''; ?>>QLIO</option>
                                    <option value="infocom" <?php echo ($sujet == 'infocom') ? 'selected' : ''; ?>>infocom</option>
                                </select>
                                <?php if ($formulaireSoumis && !$sujetValide): ?>
                                    <small class="text-danger">Veuillez sélectionner un sujet</small>
                                <?php endif; ?>
                            </div>
                        </div>
                    </div>

                    <!-- Ligne : question -->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="mb-3">
                                <label for="question" class="form-label <?php echo $classeQuestion; ?>">Question :</label>
                                <textarea class="form-control" id="question" name="question" rows="5"><?php echo htmlspecialchars($question); ?></textarea>
                                <?php if ($formulaireSoumis && !$questionValide): ?>
                                    <small class="text-danger">La question ne peut pas être vide</small>
                                <?php endif; ?>
                            </div>
                        </div>
                    </div>

                    <!-- Boutons de validation / reset -->
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Envoyer</button>
                        <button type="reset" class="btn btn-secondary">Effacer</button>
                    </div>
                </form>
            <?php endif; ?>
        </div>
            </div>
    </body>
</html>