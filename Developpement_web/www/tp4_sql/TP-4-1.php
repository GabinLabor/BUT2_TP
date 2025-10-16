<?php
    $host = "localhost";
    $user = "root";
    $pass = "root";
    $charset = "utf8mb4";
    $dns = "mysql:host=$host;dbname=mezabi3;charset=$charset";
    $options =[
        PDO::ATTR_ERRMODE    => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES => false
    ];

    try{
        $pdo= new PDO($dns,$user,$pass,$options);
    } catch (PDOException $e){
        throw new PDOException($e->getMessage(), (int)$e->getCode());
    }
    // Recuperation des clients
    try {
        $stmt = $pdo->query("SELECT ID_CLIENT as ID, NOM_MAGASIN as 'Nom du magasin', ADRESSE_1 as 'Adresse 1',
                                    ADRESSE_2 as 'Adresse 2', CONCAT(CODE_POSTAL,'',VILLE) as 'Code postal/ville',
                                    TELEPHONE as 'Téléphone', EMAIL as 'Adresse mail'
                                FROM clients");
        $clients = $stmt->fetchAll();
    } catch (PDOException $e) {
        echo "Erreur lors de la récupération des clients : " . $e->getMessage();
    }

?>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title> Listes des clients</title>
        <link rel="stylesheet" href="css/monStyle.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-5">
            <h1 class="mb-4">Etape 1 : Liste des clients</h1>
            <?php if(!empty($clients)) : ?>
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <?php foreach (array_keys($clients[0]) as $column): ?>
                                <th><?= htmlspecialchars($column) ?></th>
                            <?php endforeach; ?>
                        </tr>
                    </thead>
                    <tbody>
                        <?php foreach ($clients as $client): ?>
                            <tr>
                                <?php foreach($client as $value) : ?>
                                    <td><?= htmlspecialchars($value) ?></td>
                                <?php endforeach; ?>
                            </tr>
                        <?php endforeach; ?>
                    </tbody>
                </table>
            <?php else : ?>
                <p class="alert alert-warning">Aucun client trouvé.</p>
            <?php endif; ?>
        </div>
    </body>
</html>

