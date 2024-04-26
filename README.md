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
 * At this time, the Out-of-Box installation is the same as the Developer installation.  Please refer to the Developer Installation section for instructions.

# Developer Installation
**1. Clone the master branck of this repository.**
   ```
   git clone https://github.com/PaulBerger56/Steampowered/
   ```  
<br>

**2. Install Maven on the machine (This step is optional because there is a Maven Wrapper inside the Project itself)**
   * https://maven.apache.org/install.html 

<br>
 
**3. Run Maven in a terminal inside the root folder of the project.  It is recommended to open the project in your preferred IDE and starting a new terminal there. This will install and update all dependencies, but the project will not be fully functional yet.**
   
   * If you have maven installed on the machine, run this command:
     ```
     mvn clean spring-boot:run
     ```
   * If you do not have Maven installed on the machine, run this command:
     ```
     ./mvnw clean spring-boot:run
     ```
<br>

**4. Create your own firebase database and attach it to the program.**

  * Create a Firebase account and click Add Project on the console page. Fill in your credentials and click create project.
     * https://firebase.google.com
       
  * Once in the new project, click on the firestore tab. On the next page, click create database, then select your server location and press next.  On the next page, select Start in test mode and press create.
  
  * After the database has been made, click the cog wheel in the side bar and then click on Project settings.
     * Once on the project settings page, click on the Service accounts tab.
     * In the Admin SDK configuration snippet box, click the Java radio button.  Once the code is updated to java, press the generate new private key button at the bottom.  This will download a JSON file to your machine.
     * Rename this JSON file serviceAccountKey.json and add it to the root folder of Steampowered.  This file needs to be renamed precisely so that the code recognizes it and it is properly added to the gitignore to keep your information from being uploaded to github.

<br>


**5. Run the code**

 * Repeat step 3 with whichever Maven command you used then.
 * If you get any errors here, check the dependencies in the pom.xml.  Depending on how long from the time we built this project, they could have been updated.
 * Once you see the project loaded in the terminal, open a web browser and go to localhost:8080
 * At this point the website should work as intended.  There will be a very long delay between when you log in with the Steam openId and being redirected to the wheel page.  This is due to the fact that your database is empty and the code is having to make a call for each game in your library.  Once several people log in, the database will start to fill and this login time will be reduced significantly.



# Dependencies
Release       | Short Description
------------- | -------------
[Spring Boot Starter Thymeleaf](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-thymeleaf)  | Starter for building MVC web applications using Thymeleaf views **Version: None**
[Spring Boot Starter Web](https://github.com/markfullmer/grammark](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web))  | Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container **Version: None**
[Spring Boot Starter Test](https://github.com/markfullmer/grammark/tree/No-SQL](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test))  | Starter for testing Spring Boot applications with libraries including JUnit Jupiter, Hamcrest and Mockito **Scope: Test**
[Spring Boot DevTools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)  | Spring Boot Developer Tools. **Scope: Runtime**
[JOpenId](https://mvnrepository.com/artifact/org.expressme/JOpenId)  | Java client library for OpenID, Steam uses this for user logins **Version: 1.08**
[Firebase Admin](https://github.com/markfullmer/grammark/tree/Version-1](https://mvnrepository.com/artifact/com.google.firebase/firebase-admin))  | This is the official Firebase Admin Java SDK. Build extraordinary native JVM apps in minutes with Firebase. The Firebase platform can power your app’s backend, user authentication, static hosting, and more. **Version: 9.2.0**
