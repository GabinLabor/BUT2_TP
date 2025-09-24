<?php
// TP3-1.php
// Formulaire d’envoi (GET) vers TP3-2.php

// Valeurs préremplies éventuelles (si retour depuis TP3-2 via l’URL)
$nom      = $_GET['nom']      ?? '';
$prenom   = $_GET['prenom']   ?? '';
$question = $_GET['question'] ?? '';
$choix    = $_GET['choix']    ?? '';
?>
<!doctype html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>TP3-1 — Formulaire (GET)</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap (CDN) -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
  <div class="container py-5">
    <div class="row justify-content-center">
      <div class="col-lg-8">
        <div class="card shadow-sm">
          <div class="card-body">
            <h1 class="h3 mb-4">TP3-1 — Formulaire (GET)</h1>

            <form method="get" action="TP3-2.php" class="row g-3">

              <div class="col-md-6">
                <label for="nom" class="form-label">Nom</label>
                <input type="text" class="form-control" id="nom" name="nom" value="<?= htmlspecialchars($nom) ?>">
              </div>

              <div class="col-md-6">
                <label for="prenom" class="form-label">Prénom</label>
                <input type="text" class="form-control" id="prenom" name="prenom" value="<?= htmlspecialchars($prenom) ?>">
              </div>

              <div class="col-12">
                <label for="choix" class="form-label">Sujet</label>
                <select id="choix" name="choix" class="form-select">
                  <option value="">— Choisir —</option>
                  <option value="support"   <?= $choix==='support'   ? 'selected' : '' ?>>Support</option>
                  <option value="commande"  <?= $choix==='commande'  ? 'selected' : '' ?>>Commande</option>
                  <option value="facture"   <?= $choix==='facture'   ? 'selected' : '' ?>>Facture</option>
                  <option value="autre"     <?= $choix==='autre'     ? 'selected' : '' ?>>Autre</option>
                </select>
              </div>

              <div class="col-12">
                <label for="question" class="form-label">Votre question</label>
                <textarea class="form-control" id="question" name="question" rows="4"><?= htmlspecialchars($question) ?></textarea>
              </div>

              <div class="col-12 d-flex gap-2">
                <button type="submit" class="btn btn-primary">Envoyer vers TP3-2</button>
                <button type="reset" class="btn btn-outline-secondary">Réinitialiser</button>
              </div>

            </form>

            <hr class="my-4">
            <p class="text-muted mb-0">
              Envoi en <strong>GET</strong> vers <code>TP3-2.php</code> (affichage + validation rouge/vert). :contentReference[oaicite:1]{index=1}
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
