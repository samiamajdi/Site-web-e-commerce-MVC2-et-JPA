# Site-web-e-commerce-MVC2-et-JPA
Ce travail entre dans le cadre d'une atelier qui sert à appliquer nos connaissances en jpa et en mvc2 pour construire un site web e-commerce , qui se base sur le diagramme de classe suivant :
![WhatsApp Image 2022-11-30 at 01 07 48](https://user-images.githubusercontent.com/85033376/204676363-75a35b9c-5fb9-4553-8e4e-0362b1aba201.jpeg)  
Ce site offre la possibilité de s'inscrire et se connecter autant qu'utilisateur ordinaire et avoir la possibilité de consulter la liste des categories des vetements    offerts par le propriétaire du site , ainsi que la consultation des articles sous une certaine catégorie et les commander , et puis consulter le panier qui contient la   articles commandés et leur quantité et valider ce panier , l'utilisateur peut aussi se deconnecter de sa session .  
DESCRIPTION :  
L'architecture du projet se compose des elements suivants :  
Deux packages :   
ma.fstt.persistence : Contient les entités .  
ma.fstt.servlet : contient les servlets qui vont gerer le tout.  
fichier persistence.xml qui contient la configuration du projet à savoir le nom de la base de donnée à utiliser et les differentes classes entités.  
Un dossier ressources qui se situe dans webapp qui contient quelques images qu'on a utilisé pour la bonne description des articles.  
Un fichier pom.xml qui contient les differentes dépendences sur lequelles on a compté pour garantir la connexion à la base de données et la création des tables.  
CLARIFICATION :  
Un client va avoir un seul panier , qui va contenier plusieurs articles d'ou en ajoute une table association PanierArticle qui va traduire la relation manytomany entre ces deux entités.  
Une categorie contient plusieurs articles , et un article appartient à une seule categorie.  
DEMONSTRATION :  
localhost:[PORT]/Vitrine2/ServletInternaute
![image](https://user-images.githubusercontent.com/85033376/204678365-017b042b-24ac-4f5f-bc17-3de689bb898d.png)
On choisit Inscription en premier pour créer un compte : 
![image](https://user-images.githubusercontent.com/85033376/204678459-9298e162-2c05-45b0-ad3d-ffd23acae92c.png)
Puis apres l'inscription on se redirige à la premiere page , dans laquel on choisit la connexion à notre compte ,
![image](https://user-images.githubusercontent.com/85033376/204678580-f6362c94-a3bb-49a3-af82-e63cd91b2024.png)
apres ceci , on vous affiche la liste des categories que vous pouvez consulter ,
![image](https://user-images.githubusercontent.com/85033376/204678702-71886763-4b3f-41f5-918d-4e20c58f2f13.png)
On choisit une categorie pour voir ses articles ,
![image](https://user-images.githubusercontent.com/85033376/204678778-03c8c15d-5114-4b18-bbc5-d2ba6552dfd4.png)
On commande un article en cliquant sur commander,
![image](https://user-images.githubusercontent.com/85033376/204678841-e7e99d10-07e2-4d25-8730-5f64be4cc061.png)
il vous dirige une autre fois à la meme page pour commander encore une fois ou vous pouvez simplemet consulter votre panier et le valider :
![image](https://user-images.githubusercontent.com/85033376/204678919-94a28ab1-fa98-412e-83e4-a3850fd8df92.png)
![image](https://user-images.githubusercontent.com/85033376/204678939-9b96a1b1-dc61-4cc3-9e74-3ae4c7b89c96.png)
ou encore supprimer l'article de votre panier avec le boutton "Delete" :
![image](https://user-images.githubusercontent.com/85033376/204679277-0ee37a0f-90ed-408e-8192-e7bc775c2260.png)

Enfin , vous avez la possibilité de se déconnecter via ce boutton :
![image](https://user-images.githubusercontent.com/85033376/204679047-afd60bde-fb08-4b4f-8e49-49081164cb00.png)


Note :
Les categories et les articles sont inserés directement dans la base de données en utilisant le fichier .sql attaché à de projet .  
Ce projet doit etre executé dans un ordinateur qui a de la connexion pour des raisons de visibilité des icones.  
