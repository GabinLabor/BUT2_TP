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
            <form method="get" action="TP3-2.php">
                <div class="row">
                    <div class="col-12"> 
                        <h1>Formulaire</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-4"> 
                        Nom :
                        <input type="text" class="form-control" name="nom">
                        <br>
                    </div>
                    <div class="col-4"> 
                        Prénom :
                        <input type="text" class="form-control" name="prenom">
                    </div>
                    <div class="col-4"> 
                        Diplôme préparé :
                        <select class="form-control" name="diplome">
                            <option>Sélectionner dans la liste</option>
                            <option>BUT GEA</option>
                            <option>BUT Informatique</option>
                            <option>BUT QLIO</option>
                            <option>BUT CJ</option>
                            <option>BUT InfoCom</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12"> 
                        Votre question :
                        <textarea class="form-control" rows="3" name="question"></textarea>
                        <br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12"> 
                        <button type="submit" class="btn btn-light">Envoyer le formulaire</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
