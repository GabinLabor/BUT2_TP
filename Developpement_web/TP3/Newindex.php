<?php
// --- Pré-remplissage des champs si la page est appelée en GET avec des paramètres
$nom = isset($_GET['nom']) ? htmlspecialchars($_GET['nom']) : '';
$prenom = isset($_GET['prenom']) ? htmlspecialchars($_GET['prenom']) : '';
$diplome = isset($_GET['diplome']) ? htmlspecialchars($_GET['diplome']) : '';
$question = isset($_GET['question']) ? htmlspecialchars($_GET['question']) : '';
$submitted = !empty($_GET);
?>
<!Doctype html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>TP3-1 — Formulaire</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="tp3.css" rel="stylesheet">
  </head>
<body class="bg-light">
  <div class="container py-4">

    <div class="card shadow-sm border-secondary mb-4">
      <div class="card-body text-center">
        <h1 class="h2 m-0">Formulaire</h1>
      </div>
    </div>







    <?php if ($submitted): ?>
      <div class="alert alert-success shadow-sm" role="alert">
        <strong>Formulaire envoyé !</strong><br>
        <span>Nom :</span> <?php echo $nom ?: '<em>(non renseigné)</em>'; ?> —
        <span>Prénom :</span> <?php echo $prenom ?: '<em>(non renseigné)</em>'; ?> —
        <span>Diplôme :</span> <?php echo $diplome ?: '<em>(non renseigné)</em>'; ?>
        <div class="mt-2"><span>Votre question :</span> <?php echo $question ?: '<em>(non renseignée)</em>'; ?></div>
      </div>
    <?php endif; ?>

    <form method="get" action="<?php echo basename(__FILE__); ?>" autocomplete="off">
      <div class="row g-3">
        <div class="col-12 col-md-4">
          <div class="card h-100 border-secondary">
            <div class="card-body">
              <label for="nom" class="form-label fw-semibold">Nom :</label>
              <input type="text" class="form-control" id="nom" name="nom" value="<?php echo $nom; ?>" placeholder="Saisir votre nom">
            </div>
          </div>
        </div>

        <div class="col-12 col-md-4">
          <div class="card h-100 border-secondary">
            <div class="card-body">
              <label for="prenom" class="form-label fw-semibold">Prénom :</label>
              <input type="text" class="form-control" id="prenom" name="prenom" value="<?php echo $prenom; ?>" placeholder="Saisir votre prénom">
            </div>
          </div>
        </div>

        <div class="col-12 col-md-4">
          <div class="card h-100 border-secondary">
            <div class="card-body">
              <label for="diplome" class="form-label fw-semibold">Diplôme préparé :</label>
              <select id="diplome" name="diplome" class="form-select">
                <option value="" disabled <?php echo $diplome === '' ? 'selected' : ''; ?>>Sélectionner dans la liste</option>
                <option value="BUT GEA" <?php echo $diplome === 'BUT GEA' ? 'selected' : ''; ?>>BUT GEA</option>
                <option value="BUT Informatique" <?php echo $diplome === 'BUT Informatique' ? 'selected' : ''; ?>>BUT Informatique</option>
                <option value="BUT QLIO" <?php echo $diplome === 'BUT QLIO' ? 'selected' : ''; ?>>BUT QLIO</option>
                <option value="BUT CJ" <?php echo $diplome === 'BUT CJ' ? 'selected' : ''; ?>>BUT CJ</option>
                <option value="BUT InfoCom" <?php echo $diplome === 'BUT InfoCom' ? 'selected' : ''; ?>>BUT InfoCom</option>
              </select>
            </div>
          </div>
        </div>

        <div class="col-12">
          <div class="card border-secondary">
            <div class="card-body">
              <label for="question" class="form-label fw-semibold">Votre question :</label>
              <textarea id="question" name="question" class="form-control" rows="6" placeholder="Rédigez votre question ici..."><?php echo $question; ?></textarea>
            </div>
          </div>
        </div>

        <div class="col-12">
          <div class="card border-secondary">
            <div class="card-body p-2 text-center">
              <button type="submit" class="btn btn-secondary w-100">Envoyer le formulaire</button>
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
