###################################   DAY1   ###################################
#Job1
Qu'est-ce que Spring Initializr et comment peut-il faciliter la création d'un nouveau projet Spring?
With Spring Initilizr we can easily create a new Spring Boot project without the problem of dependencies, versioning and compiler errors
Quick congiguration of the project, we can choose direclty which dependencies we need in our project, also we can generate a standard project

#Job2
Pourquoi le fichier pom.xml est-il crucial dans un projet Maven ?
The pom.xml file is really important in a Maven project since has all the informations necessary to build and manage the project
It defines all the dependencies, plugins for the build, project structur and manage the different versions

#Job3
Qu'est-ce qu'un contrôleur dans le contexte de Spring MVC ?
A controller in Spring MVC is a Java class that manages the HTTP requests received from the web app.
Its the entry point between the client and the application

#Job4
Comment Spring permet-il l'injection de propriétés depuis des fichiers de configuration ?
We can easily inject values in our controllers by using an application.yml or application.properties file.
To inject the values we simply use the @Value followed by the property name and value

#Job5
Pourquoi serait-il utile d'avoir différents profils dans une application Spring ?
Its usefull to have the possibility to create different profiles on the Spring application so based on the development environment (development, production) we can have different behaviours
The application is more flexible since without changing the code, based on the different profile the application adapts

#Job6
En quoi la dépendance DevTools est-elle bénéfique pour le développement ?
The DevTools dependency is really usefull since when we do changes on our code we dont need to restart the server to see the changes, but simply by updating the page (F5) we can see the changes

###################################   DAY2   ###################################
#Job1
Comment le modèle MVC aide-t-il à structurer une application web ?
MVC stands for Model View Controller and is a design pattern that helps structure a web application by separating it into three different components:
Model: Represents the data and the business logic of the application
View: Responsable for displaying the data
Controller: Its a bridge between the View and the Model

#Job2
Quelle est la différence entre Thymeleaf et les templates HTML classiques ?
HTML is static, doesnt contain code that the browser can read (without using Js)
Thymeleaf: is dynamic, we can generate dynamic HTML starting from a Model in a Controller, uses specific termes
RESULT AT http://localhost:8080/view

#Job3
Comment pouvez-vous passer des données d'un contrôleur à une vue dans Spring ?
In Spring Boot we pass the data to the controller to the view using a Model object
RESULT AT http://localhost:8080/view2

#Job4
Comment Spring facilite-t-il la gestion des formulaires ?
Spring gives us different integrated funcionalities to have a simple, ordered and powerfull form management.
For example we can use the @RequestParam to automatically recuperate the data of the form and associate them with the variables in the Java object


###################################   DAY3   ###################################
#Job1
Qu'est-ce que JPA et comment facilite-t-il l'accès aux bases de données ?
JPA can help us access  the database using objects instead of raw SQL
It help us mapping Java classes to databases, we use simple methods instead of SQL queries
We have ORM to write and manage database data as Java objects

#Job2
Pourquoi les bases de données en mémoire, comme H2, sont-elles utiles pendant le développement ?
H2 database are important in development because are fast (saved in RAM), they reset on each run and we dont need a setup (install a database server like MySQL)
Also we can simply access it via the web UI adding /h2-console

#Job3
Quelle est l'importance des annotations, telles que @Entity, dans le contexte de JPA ?
@Entity annotation in the JPA context is really important since it helps telling the JPA provider to map my Java class into a database table. 
Without @Entity, JPA completely ignores the class and it does not create the table

#Job4
Comment Spring Data facilite-t-il la création de requêtes de base de données?
Spring Data makes it easy to create a database query in the repository interface and Spring generates directly the query
We can also have advanced queries using simply keywords

#Job5
Comment pouvez-vous créer et lire des entités avec Spring Data JPA ?
We can read entities with Spring Data JPA using built in methods without writing SQL code
For example:
save() to insert a new row in our person table
findAll() to get all the entries
findById() to get entries by iD

###################################   DAY4   ###################################
#Job1
Pourquoi est-il conseillé de séparer la logique métier des contrôleurs ?
Its better to have a separation between the business logic and the controllers for different reasons:
-Better organisation and readability (controllers focus on handling HTTP requests), business logic centralized in services
-Reausability, we can use our services in different controllers
-Testability, services are easier to test
-Separation of roles, controllers handle routing and views, services handle business rules, repositories manage data access
-Scalability, its easier to scale our app if we have everything separated

#Job2
Quels sont les avantages d'utiliser Spring Security pour protéger une application ?
Thanks to Spring security we have a built-in support for authentication, role-based access controll, protection against attachs, also support for modern authentication protocols

#Job3
Comment personnaliser le formulaire de connexion avec Spring Security ?
To customize our login form we simply have to create a new html page and rout the login form to the newly created page

#Job4
Comment Spring Security gère-t-il les autorisations basées sur les rôles ?
To manage the differet levels of access to our application we can easily define the access levels in our filterChain by adding the access to the different roots
For example
.requestMatchers("/h2-console").hasRole("ADMIN")
