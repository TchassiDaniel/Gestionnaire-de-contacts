<h1 align="center">Welcome to Gestionnaire de repertoire 👋</h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-1.0-blue.svg?cacheSeconds=2592000" />
  <a href="Voirs cours de POO" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
  <a href="https://opensource.org/license/MIT" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
  </a>
</p>

> une application JAVA pour gérer le répertoire des contacts d'un établissement. Un Contact est un Etudiant, un Enseignant ou un Agent administratif. Les contacts sont enregistrés dans le répertoire sous forme d’une collection.

## Utilisation

Pour tester l'application avec la Base de données, il faut creer les tables 
* agent(code varchar(30), nom varchar(30), dateDeNaissance Date, adress varchar(30), email varchar(30), telNumber varchar(30), salaire double, statut varchar(30), categorie varchar(30), indiceDeSalaire varchar(30), occupation varchar(30))
* etudiant(code varchar(30), nom varchar(30), dateDeNaissance Date, adress varchar(30), email varchar(30), telNumber varchar(30), cycle varchar(30), niveau int)
* enseignant(code varchar(30), nom varchar(30), dateDeNaissance Date, adress varchar(30), email varchar(30), telNumber varchar(30), statut varchar(30))

**N.B:** Le nombre de caractère pour les varchar dependent entièrement de vous.

Ensuite dans la classe MainFrmApplication au niveau de la ligne 40 veuillez entrer les information de connexion à votre BD

## Test

Utiliser netBeans pour un meilleur resultat: ouvrer le dossier comme un projet avec NetBeans


## Auteur

👤 **Tchassi Daniel**

* Website: [tchassidaniel.github.io](tchassidaniel.github.io)
* Github: [@TchassiDaniel](https://github.com/TchassiDaniel)
* LinkedIn: [@tchassidaniel](https://linkedin.com/in/tchassidaniel)

## Show your support

Give a ⭐️ if this project helped you!

## 📝 License

Copyright © 2024 [Tchassi Daniel](https://github.com/TchassiDaniel).<br />
This project is [MIT](https://opensource.org/license/MIT) licensed.

***
