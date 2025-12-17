# ChatMe

Application de chat client–serveur développée en Java utilisant les **sockets TCP**, permettant à plusieurs clients de communiquer en temps réel via un serveur central.

## 🧠 Objectif du projet
Ce projet a été réalisé dans le cadre d’un **TP de programmation réseau**.  
L’objectif est de comprendre :
- le fonctionnement des **sockets TCP**
- l’architecture **client / serveur**
- la gestion de connexions concurrentes avec des **threads**
- l’intégration d’une **interface graphique** pour une application réseau

## ⚙️ Technologies utilisées
- Java
- Sockets TCP
- Threads
- Java Swing (interface graphique)

## 🏗️ Architecture de l’application
L’application est composée de **5 classes principales** :

- **AppServeur**  
  Initialise le serveur, écoute les connexions clientes et diffuse les messages.

- **ServeurAppThread**  
  Gère chaque client connecté (réception et diffusion des messages, déconnexion).

- **AppClient**  
  Gère la connexion du client au serveur et l’envoi du pseudo.

- **ClientAppThread**  
  Réception des messages envoyés par le serveur et affichage dans l’interface.

- **ChatMe**  
  Interface graphique : zone de discussion, saisie de messages, boutons *Envoyer* et *Déconnecter*.

## 🚀 Fonctionnalités
- Connexion de plusieurs clients à un serveur
- Envoi et réception de messages en temps réel
- Notification de connexion et de déconnexion des utilisateurs
- Interface graphique simple et interactive
- Gestion propre de la déconnexion (`byebye`)

## ▶️ Exécution
1. Lancer le **serveur**
2. Lancer un ou plusieurs **clients**
3. Entrer un pseudo et commencer à discuter


## 📚 Contexte académique
Projet réalisé en 2022 dans le cadre d’un TP de programmation réseau.

## 📝 Remarque
Ce projet a permis de mieux comprendre le fonctionnement des applications de chat en ligne ainsi que les difficultés liées au développement d’interfaces graphiques.
