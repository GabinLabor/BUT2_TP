CREATE TABLE IF NOT EXISTS a_categories (
    code_categorie INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY, -- ensure that a particular column can only hold positive integers and zero
    designation VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS a_couleurs (
    code_couleur INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    designation VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS a_tailles (
    code_taille INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    designation VARCHAR(30) NOT NULL,
);

CREATE TABLE IF NOT EXISTS articles (
    id_article INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    code_article VARCHAR(15)  NOT NULL, -- code article qui est modifiable ici
    designation  VARCHAR(30)  NOT NULL,
    categorie_id INT UNSIGNED NOT NULL,
    CONSTRAINT fk_articles_categorie FOREIGN KEY (categorie_id) REFERENCES a_categories(id) -- FK vers a_categories
);

CREATE TABLE stockprix (
    article INT(11) NOT NULL  ,
    couleur INT(11) NOT NULL,
    taille INT(11) NOT NULL,
    prix DECIMAL(10,2) NOT NULL,
    code_barre VARCHAR(13) NOT NULL,
    STOCK INT(11) NOT NULL DEFAULT 0, --on met 0 par défaut
)

CREATE TABLE c_type (
    id_clienttype INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    designation VARCHAR(30) NOT NULL
)

CREATE TABLE clients (
    code_client INT(15) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nom_magasin VARCHAR(35) NOT NULL,
    adresse1 VARCHAR(35) NOT NULL,
    adresse2 VARCHAR(35),
    code_postal CHAR(5) NOT NULL,
    ville VARCHAR(35) NOT NULL,
    nom_responsable VARCHAR(35) NOT NULL,
    num_telephone CHAR(10) NOT NULL,
    email VARCHAR(35) NOT NULL,
    clienttype_id INT(11) UNSIGNED NOT NULL,
    CONSTRAINT fk_clients_clienttype FOREIGN KEY (clienttype_id) REFERENCES c_type(id_clienttype)
)

CREATE TABLE devis_entetes (
    num_devis INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
)












































/*
-- Étape 1 : créer la base en utf8mb4 / utf8mb4_general_ci
CREATE DATABASE IF NOT EXISTS mezabi
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_general_ci;

USE mezabi;

-- Étape 2 : table a_categories (types d'articles)
-- "désignation" doit pouvoir contenir au moins 30 caractères → on prévoit large (100)
CREATE TABLE IF NOT EXISTS a_categories (
  id           INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  designation  VARCHAR(100) NOT NULL,
  created_at   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY uq_a_categories_designation (designation)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Étape 3 : table a_couleurs (couleurs d’articles)
-- idem : capacité >= 30 caractères → VARCHAR(100)
CREATE TABLE IF NOT EXISTS a_couleurs (
  id           INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  designation  VARCHAR(100) NOT NULL,
  created_at   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY uq_a_couleurs_designation (designation)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Étape 4 : table a_tailles (S, M, L, XL, 38, 40, etc.)
CREATE TABLE IF NOT EXISTS a_tailles (
  id           INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  taille       VARCHAR(20) NOT NULL,
  created_at   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY uq_a_tailles_taille (taille)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- rappel diese veut seulement dire que c'est numérique

USE mezabi;

-- Étape 5 : table articles
-- Remarque : comme le code article peut changer, on utilise un id interne comme PK.
CREATE TABLE IF NOT EXISTS articles (
  id           INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  code         VARCHAR(15)  NOT NULL,              -- code article (modifiable)
  designation  VARCHAR(30)  NOT NULL,
  categorie_id INT UNSIGNED NOT NULL,              -- FK vers a_categories
  created_at   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY uq_articles_code (code),
  KEY idx_articles_categorie (categorie_id),
  CONSTRAINT fk_articles_categorie
    FOREIGN KEY (categorie_id)
    REFERENCES a_categories(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Étape 6 : table stocksPrix
-- Prix/stock/Code-barres par combinaison (Article x Couleur x Taille)
CREATE TABLE IF NOT EXISTS stocksPrix (
  id           INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  article_id   INT UNSIGNED NOT NULL,
  couleur_id   INT UNSIGNED NOT NULL,
  taille_id    INT UNSIGNED NOT NULL,
  prix         DECIMAL(10,2) NOT NULL,             -- 2 décimales
  code_barre   CHAR(13)     NOT NULL,              -- EAN-13
  stock        INT          NOT NULL DEFAULT 0,
  created_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,

  -- Unicité d'une variante (article + couleur + taille)
  UNIQUE KEY uq_stocksPrix_variant (article_id, couleur_id, taille_id),
  -- Code-barres unique (si tu scannes)
  UNIQUE KEY uq_stocksPrix_ean (code_barre),

  KEY idx_stocksPrix_article (article_id),
  KEY idx_stocksPrix_couleur (couleur_id),
  KEY idx_stocksPrix_taille  (taille_id),

  CONSTRAINT fk_stocksPrix_article
    FOREIGN KEY (article_id)
    REFERENCES articles(id)
    ON UPDATE CASCADE
    ON DELETE CASCADE,

  CONSTRAINT fk_stocksPrix_couleur
    FOREIGN KEY (couleur_id)
    REFERENCES a_couleurs(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,

  CONSTRAINT fk_stocksPrix_taille
    FOREIGN KEY (taille_id)
    REFERENCES a_tailles(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,

  -- Contraintes de validité (MySQL 8+) :
  CONSTRAINT chk_stocksPrix_prix_nonneg CHECK (prix >= 0),
  CONSTRAINT chk_stocksPrix_stock_nonneg CHECK (stock >= 0),
  CONSTRAINT chk_stocksPrix_ean CHECK (code_barre REGEXP '^[0-9]{13}$')
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


*/