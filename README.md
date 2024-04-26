```
 _____ _                      ______                              _  
/  ___| |                     | ___ \                            | | 
\ `--.| |_ ___  __ _ _ __ ___ | |_/ /____      _____ _ __ ___  __| | 
 `--. \ __/ _ \/ _` | '_ ` _ \|  __/ _ \ \ /\ / / _ \ '__/ _ \/ _` | 
/\__/ / ||  __/ (_| | | | | | | | | (_) \ V  V /  __/ | |  __/ (_| | 
\____/ \__\___|\__,_|_| |_| |_\_|  \___/ \_/\_/ \___|_|  \___|\__,_| 
                                                                                                                        
```
                                           
                                                                     
* **Steampowered is a Group Project for GGC Softdev2 during Spring 2024 Semester**

* **Steampowered is a website that allows steam users to have a random game from their library randomly selected for them. To make it a little more fun, a roulette wheel will be filled with a random selection of the user's games and spun.  There is a genre filter on the page where users can select one or multiple genres that they would like to play, and the wheel will populate only with games marked with that genre on the steam api.**  

* **The ideal user for this website would be a Steam user that has many games.  Over time, their Steam library can get filled with a ton of games.  When a user has so many games, it can be hard to make a decision on what they should actually play.  If they are being indecisive, they can come to this website and allow the wheel to make the choice for them.**


# Team
* **Paul Berger**
    * Code Architect
* **Jason Urquilla-Martinez**
    * UI/UX Designer
* **Julian Ramirez**
    * Team lead/Documentation lead
* **Zuberi Thompson**
    * Data modeler
* **Albert Austin IV**
    * Testing Lead

# Requirements
As of 4/26/24 Steampowered is not yet hosted anywhere and must be run from the code itself.

To run the code, you need and IDE that can run Java and having Maven installed on the machine is recommended.  There is a maven wrapped included in the project itself in case the user does not have maven installed.

The code needs to be run from the terminal with maven and the user will need to open a browser and go to localhost:8080 as long as the port number as not been changed in the configuration file.

# Out-of-Box Installation

# Developer Installation
# 1. Clone the master branck of this repository.
   ```
   git clone https://github.com/PaulBerger56/Steampowered/
   ```  

# 2. Install Maven on the machine (This step is optional because there is a Maven Wrapper inside the Project itself)
   * https://maven.apache.org/install.html 

 
# 3. Run Maven in a terminal inside the root folder of the project.  It is recommended to open the project in your preferred IDE and starting a new terminal there.
   
   * If you have maven installed on the machine, run this command:
     ```
     mvn clean spring-boot:run
     ```
   * If you do not have Maven installed on the machine, run this command:
     ```
     ./mvnw clean spring-boot:run
     ```



# Dependencies
Release       | Short Description
------------- | -------------
[Spring Boot Starter Thymeleaf](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-thymeleaf)  | Starter for building MVC web applications using Thymeleaf views **Version: None**
[Spring Boot Starter Web](https://github.com/markfullmer/grammark](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web))  | Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container **Version: None**
[Spring Boot Starter Test](https://github.com/markfullmer/grammark/tree/No-SQL](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test))  | Starter for testing Spring Boot applications with libraries including JUnit Jupiter, Hamcrest and Mockito **Scope: Test**
[Spring Boot DevTools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools))  | Spring Boot Developer Tools. **Scope: Runtime**
[JOpenId](https://mvnrepository.com/artifact/org.expressme/JOpenId)  | Java client library for OpenID, Steam uses this for user logins **Version: 1.08**
[Firebase Admin](https://github.com/markfullmer/grammark/tree/Version-1](https://mvnrepository.com/artifact/com.google.firebase/firebase-admin))  | This is the official Firebase Admin Java SDK. Build extraordinary native JVM apps in minutes with Firebase. The Firebase platform can power your app’s backend, user authentication, static hosting, and more. **Version: 9.2.0**
