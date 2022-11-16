# General Information

- Api Rest pour enregistrer et afficher person List by ordre alphabétique en ajoutant l'âge actuel
- J'aurai pu coder ça d'une façon plus simple mais j'ai essayé plutôt de diversifier les méthodes utilisées pour couvrir plusieurs parties de springBoot
- J'ai pas eu le temps pour faire tout les test mais j'ai testé presque la moitié il reste deux methodes


# Technologies Used

- SpringBoot
- Swagger
- J-Unit 5


# Features

- The ready features :

# Save newPerson
- http://localhost:8080/api/v1/person/save

# Fetching all person with sorting :
- http://localhost:8080/api/v1/person/all


# Fetching all person with sorting and pagination :
- http://localhost:8080/api/v1/person/page/all

# Documentation with swagger :
- http://localhost:8080/swagger-ui.html#




# Screenshots
![Screenshot](https://github.com/jwael/hilary/blob/master/git2.png)
![Screenshot](https://github.com/jwael/hilary/blob/master/github1.png)

# Setup

- H2O database

# Proceed to describe how to install get started with the project:

- Run with springApplication class 
- To Run test : Run PersonServiceImplTest class : comment @in AppStarter

# Project Status

- Project is: in progress :

-                ✔ Save a person  :  complete
-                ✔ validate the age : complete
-                ✔ fetching all person : complete
-                ✔ fetching all person with sorting :
-                                ✔ using Jpa  : complete
-                                ✔ using PaginationAndSorting : complete
-                ✔ handle exception : complete
-                ✔ documentation : complete
-                * Testing :
-                    ✔ Testing saving person : complete
-                    * Testing pagination find all method : in progress
-                    * Testing Exception : in progress

# Room for Improvement

- Trouver une autre façon pour afficher la liste person (comme j'ai utilisé avec les pages ) => fetching  all person not recommended 
- Si dans le future vous utiliser le multithreading watch out for SimpleDateFormat() it s safe thread can cause some problemes
- Using criteria for better control of custom query
# Improvement to be done :
- Adding @CrossOrigin if work with framework front
- En cas de use multi-thread instead of calling final SimpleDateFormat() call a new instance inside the try and catch
- using fastDateFormat
- Testing the rest of the methods
- Si y'a ajout des entity in the project vous devriez pensez Jackson or mapStrcut ... for mapping the object 
# This project was inspired by...

- Task interview by web-atrio

# Contact

- Created by @Wael
- feel free to contact me!
