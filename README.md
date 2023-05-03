# TrashTreasure

Dépôt pour notre projet d'application pour la gestion des ordures ménagères pour le cours d'ING1 "Analyse et programmation orientée objet" à CY Tech.

Auteurs : Achraf Assakan, Charles-Meldhine Madi Mnemoi, Dean Bah, Marwa Tourabi

# Configuration de l'environnement de développement

Je vous invite à utiliser [Visual Studio Code](https://code.visualstudio.com/) comme éditeur de code et à installer les extensions :
  -  [**Java Extension Pack**](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) et [**Spring Boot Extension Pack**](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack) pour de l'aide à la programmation Java (génération de classes, débogage, etc.)
  - [**SQLTools**](https://marketplace.visualstudio.com/items?itemName=mtxr.sqltools) et [**SQLTools PostgresSQL/CockroachDB Driver**](https://marketplace.visualstudio.com/items?itemName=mtxr.sqltools-driver-pg) pour visualiser la base de données
  - [**GitHub Copilot**](https://marketplace.visualstudio.com/items?itemName=GitHub.copilot)

## Ubuntu

Le **Java Development Kit (JDK) 11**, **Docker** et **Apache Maven** devraient déjà être installés sur vos PC CY Tech et vous devriez avoir configuré votre compte GitHub suite au projet C.

1) Récupérer le code source du projet : `git clone git@github.com:cmnemoi/TrashTreasure.git; cd TrashTreasure`
2) Installer la base de données : `make db-install`

C'est tout ! 🥳

## Windows

TODO (vérifier que ça marche)

# Commandes

* Lancer l'application : `make run`
* Démarrer la base de données : `make db-start`
* Lancer les tests : `make test`

# Licence

[Licence MIT](LICENSE) 