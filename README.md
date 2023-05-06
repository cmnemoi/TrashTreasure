# TrashTreasure

Dépôt pour notre projet d'application pour la gestion des ordures ménagères pour le cours d'ING1 "Analyse et programmation orientée objet" à CY Tech.

Auteurs : Achraf Assakan, Charles-Meldhine Madi Mnemoi, Dean Bah, Marwa Tourabi

# Configuration de l'environnement de développement

Je vous invite à utiliser [Visual Studio Code](https://code.visualstudio.com/) comme éditeur de code et à installer les extensions :
  -  [**Java Extension Pack**](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) et [**Spring Boot Extension Pack**](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack) pour de l'aide à la programmation Java (génération de classes, débogage, etc.)
  - [**GitHub Copilot**](https://marketplace.visualstudio.com/items?itemName=GitHub.copilot)

## Ubuntu

Le **Java Development Kit (JDK) 11**, **Docker** et **Apache Maven** devraient déjà être installés sur vos PC CY Tech et vous devriez avoir configuré votre compte GitHub suite au projet C.

Il vous suffit simplement de récupérer le code source du projet : `git clone git@github.com:cmnemoi/TrashTreasure.git; cd TrashTreasure`

Et si tout va bien vous devriez pouvoir lancer l'application avec `make run`.

Bonus : installer [SceneBuilder](https://gluonhq.com/products/scene-builder/) pour créer les interfaces graphiques... graphiquement :
  
  ```bash
  curl https://download2.gluonhq.com/scenebuilder/19.0.0/install/linux/SceneBuilder-19.0.0.deb -o SceneBuilder-19.0.0.deb # on télécharge SceneBuilder
  sudo apt install ./SceneBuilder-19.0.0.deb # on l'installe
  rm -f SceneBuilder-19.0.0.deb # on supprime le fichier téléchargé
  ```

## Windows

* Lancer un terminal Powershell en mode administrateur et installer [chocolatey](https://chocolatey.org/install): 

```powershell
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
```

* Installer Git et Maven :
```powershell
choco install git maven -y
```

* Ouvrir VSCode et définir `Git Bash` comme terminal par défaut avec `Ctrl+Shift+P` -> `Terminal: Select Default Profile` -> Git Bash

* Ouvrir ce terminal avec `Ctrl+Shift+ù` pour configurer Git et GitHub :
  * Configurer une clé SSH :
    * [Générer une clé SSH](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)
    * [L'ajouter à votre compte GitHub](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account)
  * Définir votre configuration :
  ```bash
  git config --global user.name VotreNom
  git config --global user.email MailDeVotreCompteGitHub
  ```

* Vous pouvez maintenant récupérer le code source du projet et lancer l'application :
  ```bash
  git clone git@github.com:cmnemoi/TrashTreasure.git # on récupère le code source
  cd TrashTreasure # on se place dans le dossier du projet
  make run # on lance l'application
  ```

* Bonus : installer [SceneBuilder](https://gluonhq.com/products/scene-builder/) :
  
  ```powershell
  choco install scenebuilder -y
  ```

# Commandes

* Lancer l'application : `make run`
* Lancer les tests : `make test`
* Accéder à la base de données : http://localhost:8080/h2-console ou `make see-db` sous Ubuntu
 * JDBC URL : `jdbc:h2:./database/trash-treasure`
 * Username : `mysql`
 * Password : `password`

# Licence

[Licence MIT](LICENSE) 