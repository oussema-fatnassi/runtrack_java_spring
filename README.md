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

