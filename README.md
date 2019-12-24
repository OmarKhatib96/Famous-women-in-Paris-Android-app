
## [APP NAME]  
  
Codé par :   
 - [Yuan] [FENG]   
 - [Omar] [KHATIB]   

## Description  
  
URL des données : https://opendata.paris.fr/explore/dataset/femmes-illustres-a-paris-portraits/export/?format=geojson&timezone=Europe%2FBerlin&disjunctive.name&disjunctive.tab_name&disjunctive.short_desc
  
Du jardin Nelson Mandela au Parc des Princes – découvrez Paris à travers ses portraits de femmes illustres.

A l’occasion de la coupe féminine du monde de la FIFA 2019, partez sur les traces des parisiennes illustres à travers les lieux emblématiques de leurs vies. 
Ce jeu de données correspond au contenu de la Web application Paris.fr elle même intégrée au site Parisinfo.com Site officiel de l'Office du Tourisme et des Congrès

Ce jeu de données est mettre en relation avec celui des : Femmes illustres à Paris - Parcours
  
## Librairies externes  
  
- Langage de développement : Kotlin v1.3.50 
- Gestion des requêtes API : Retrofit 2.6.2 
- Affichage de la carte : Play Services Maps 17.0.0 
- Conversion entre des objets Java et JSON : gson 2.8.6 
- Gestion de téléchargement d'image : Glide 4.9.0 
  
## Consignes  
  
Lien vers le sujet : https://docs.google.com/presentation/d/1mwu2xx7_qfCZDfsRxseC94n7oBGYfhw-9xIftaTDbzk/edit#slide=id.p97  
  
### But du projet  
  
 - Le but du projet est de réaliser une application permettant de visualiser une série de données OpenData  
 - Les données devront être récupérées sur un serveur distant et affichées dans une liste et sur une carte  
 - Un clique sur un élément de la liste ou sur un marker de la carte permet d’accéder à un écran présentant le détail de l’élément  
 - Un écran présentera des informations générales sur les données récupérées  
  
### Exigences    
- [ ] Format des données OpenData :   
	 - Format Json  
	 - Avec un champ correspondant à l’url d’une image  
	 - Avec un champ correspondant à une position  
 - [ ] Application composée au minimum de 3 Fragment et 2 Activity  
 - [ ] Une Actionbar sera présente et permettra de rafraîchir les données récupérées et affichées
 
 ## Bonus
 
 - Amélioration de l’expérience utilisateur :
    - Clustering des markers sur la carte en fonction du niveau de zoom
    - Mise en place d’un système de recherche/filtre sur la liste affichée
 
 - Enrichissements techniques :
    - Mise en place d’une base de données locale pour afficher la liste d’élément en mode hors connexion
    - Utilisation de LiveData ou d’Observable pour la récupération de données dans la BDD
 
