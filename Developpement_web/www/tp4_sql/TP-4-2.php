<?php
// Connexion PDO
$host = "localhost";
$user = "root";
$pass = "root";
$charset = "utf8mb4";
$dns = "mysql:host=$host;dbname=mezabi3;charset=$charset";
$options = [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
    PDO::ATTR_EMULATE_PREPARES => false
];

try {
    $pdo = new PDO($dns, $user, $pass, $options);
} catch (PDOException $e) {
    throw new PDOException($e->getMessage(), (int)$e->getCode());
}

// Récupération des clients avec les mêmes colonnes
try {
    $stmt = $pdo->query("SELECT ID_CLIENT as ID, NOM_MAGASIN as 'Nom du magasin', ADRESSE_1 as 'Adresse 1',
                                ADRESSE_2 as 'Adresse 2', CONCAT(CODE_POSTAL,' ',VILLE) as 'Code postal/ville',
                                TELEPHONE as 'Téléphone', EMAIL as 'Adresse mail'
                            FROM clients"); // TODO attention aux changements ici par exemple EMAIL en EMAIL1
    $clients = $stmt->fetchAll();
} catch (PDOException $e) {
    echo "<div class='alert alert-danger'>Erreur : " . $e->getMessage() . "</div>";
}
?>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP4-2 : Vignettes clients</title>
        <link rel="stylesheet" href="css/monStyle.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container py-5">
            <h2 class="mb-4 text-center">TP4-2 : Vignettes clients</h2>

            <?php if (!empty($clients)) : ?> // TODO tester le row , rappel le empty c'est null et isset
                <div class="row g-4">
                    <?php foreach ($clients as $client) : ?>
                        <div class="col-12 col-sm-6 col-md-4">
                            <div class="cadre">

                                <?php foreach ($client as $key => $value) : ?>
                                    <p><strong><?= htmlspecialchars($key) ?> :</strong> <?= htmlspecialchars($value) ?></p>
                                <?php endforeach; ?>
                            </div>
                        </div>
                    <?php endforeach; ?>
                </div>
            <?php else : ?>
                <p class="alert alert-warning text-center">Aucun client trouvé.</p>
            <?php endif; ?>
        </div>
    </body>
</html>
