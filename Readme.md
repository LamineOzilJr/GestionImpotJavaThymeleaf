# Mouhamadou Lamine NDIAYE
# Sonar Test - Gesion Impots 

Apres avoir fini de developper notre solution, nous allons maintenant tester notre code avec Sonar

Pour utiliser Sonar, il nous faut un compte d'utilisateur.
Pour cela nous avons deux options :
  - Nous pouvons creer un compte directement sur sonar
  - Nous pouvons eventuellemnt aussi linker notre compte github, bitbuckrt, gitlab ou azure devops a sonar qui va a son niveau prendre les informations renseignees sur le compte de la plateforme choisie pour nous creer un compte.

Pour ce test nous allons choisir de Github.
Pour ce faire : 
Nous allons d'abord nous connecter puis clicker sur Github.
![alt text](https://github.com/LamineOzilJr/GestionImpotJavaThymeleaf/blob/main/SonarReport/loginSonar.png?raw=true)

La nous allons creer une nouvelle organisation, cela peut se faire manuellement mais pour plus d'efficacite, nous allons en impoter une depuis notre compte github.
![alt text](https://github.com/LamineOzilJr/GestionImpotJavaThymeleaf/blob/main/SonarReport/createNewOrg.png?raw=true)

Si l'organisation existe deja , ce n'est pas la peine de la recreer.
NB: lors de la creation, nous pouvaons choisir entre :
  - La version précédente Tout code modifié depuis la version précédente est considéré comme un nouveau code. Recommandé pour les projets suivant des versions ou des versions régulières.
  - Nombre de jours Tout code qui a changé au cours des x derniers jours est considéré comme un nouveau code. Si aucune mesure n'est prise sur un nouveau problème après x jours, ce problème fera partie du code global.
 Recommandé pour les projets suivant une livraison continue.
LE CHOIX ENTRE CES DEUX OPTIONS EST TRES IMPORTANT CAR CELA IMPACTE LA GESTION DU CODE NOTAMMENT AVEC L'APPROCHE AGILE 
![alt text](https://github.com/LamineOzilJr/GestionImpotJavaThymeleaf/blob/main/SonarReport/AccesRepo.png?raw=true)

La on s'authentifie avec a notre github
![alt text](https://github.com/LamineOzilJr/GestionImpotJavaThymeleaf/blob/main/SonarReport/GithubAuth.png?raw=true)


Puis que nous avons linker github a sonar, ce dernier est maintenant capable de voir nos repos et de les exploiter
Donc la nous pouvons choisir tous les repos ou bien selectionner le repo que nous voulons utiliser.
On choisi notre repo GestionImpotJavaThymeleaf
![alt text](https://github.com/LamineOzilJr/GestionImpotJavaThymeleaf/blob/main/SonarReport/AccesRepo.png?raw=true)

La nous avons choisi un projet qui se trouve dans le repo qu'on avait choisi en amont
![alt text](https://github.com/LamineOzilJr/GestionImpotJavaThymeleaf/blob/main/SonarReport/selection-faite.png?raw=true)

Sonar est entrain de tester notre projet.
![alt text](https://github.com/LamineOzilJr/GestionImpotJavaThymeleaf/blob/main/SonarReport/sonatTesting.png?raw=true)

Resultat apres premier Test : Nous voyons clairement la majeur partie de nos erreurs ou la mauvaise maniere dont la logique du code a ete etablie en terme de qualite de code.
NB: les noms de projets sont deifferents car nous avions deja fait le travail avec le projet gestionImpot, ensuite refais juste une simulation pour prendre des captures pour ce rapport. Mais le projet teste c'est le projet Spring GestionImpotJavaThymeleaf
![alt text](https://github.com/LamineOzilJr/GestionImpotJavaThymeleaf/blob/main/SonarReport/sonar2bugsShow.png?raw=true)

La non seulement Sonar nous montre nos erreurs, mais en plus il nous les explique et nous suggere meme des solutions. 
## Ah c'est vraiment Genial ca !!!
![alt text](https://github.com/LamineOzilJr/GestionImpotJavaThymeleaf/blob/main/SonarReport/sonar3bugsExplain.png?raw=true)

Donc nous derriere on va suivre ses recommendations et retester une sencode fois sans oublier de faire un :
  - git add .
  - git commit -m "nom du commit"
  - git push
    
Ces commandes ci-dessus permettent de mettre a jour notre projet nous permettant ainsi de prendre en compte les nouvelles modifications.
![alt text](https://github.com/LamineOzilJr/GestionImpotJavaThymeleaf/blob/main/SonarReport/sonar1findCode.png?raw=true)

## Contributeurs

- Mouhamadou Lamine NDIAYE <ndiayelamine2899@gmail.com>

## Copyrigth

Ce projet est developpe par mlnvisiontech mail:ndiayelamine2899@gmail.com Tel:77-871-43-77
