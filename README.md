# COMP2042_CW_CompSciWangYeeXuan

---

# Introduction

This is the README file for the coursework for COMP2042. A JavaFX project game called Frogger is provided to us. The coursework is about maintaining and extending the game.

---

# Maintenance

* **File restructure**
  - The original file structure has been changed, to seperated the java files and the images/resources. 
  - The files are also organised into different pakages. eg. controller, main, model, level.
  - With this change, it is easier to find specific file in the folder. This adhere to MVC pattern

* **Refactored java file**

  * **Main.java** 
    - It contains alot of codes of different functions. 
    - The display of the game is moved to other class. This supports the idea of single responsibility.
  * **Animal.java** 
    - Large method is broken. 
    - New method is created such as User_control, Frog_animation, Keep_frog_inbound, Object_intersection, Death_image and so on. 
    - Each method only handle its own specific function. This also enhanced the readability of the code.
  * **Platform.java** 
    - This classs is added to handle some function of some classes such as the Log, Turtle and Crocodile. 
    - This allow for shorter classes of those mentioned. Those model that the frog can ride in the water extends to this class.
  * **Digit.java**
    - Each digit images are stored in an array for easier accessibility.
  
* Unused method and imports and variable are deleted.

* Javadoc documentation is added to most of the classes and methods including Junit test cases. This is to enhanced the readability of the code. 

---

# Extension

* **New pages**

  * **Main menu**
    - Allows to user to choose between start game, info page and exit
    - "START" button will start the game when clicked.
    - "INFO" button will show info page when clicked. 
    - "EXIT" button will close the java application window. 
  * **Info page**
    - This page show the game instructions and rules of the game.
    - "BACK" button will show main menu when clicked.
  * **Info page**
    - This page appear when the user completed all the levels.
    - This page is for the user to enter their username. 
    - "NEXT" button will show leaderboard page when clicked. 
  * **Leaderboard page**
    - This page show the all time top 10 score and respective username.
    - "RETRY" button will restart the game when clicked. 
    - "EXIT" button will close the java application window when clicked.

* **New classes**
  
  * **Fast_car**
    - This class display a different image of car.
  * **Crocodile**
    - This class display crocodile in the first row of the game. 
  * **Higscore.java**
    - This class checks the score and write in the text file, the text file is connected to the display of the leaderboard.
  * **Scoreboard**
    - This class updates and display the current score of the user.
  * **Scene_controller**
    - This class controls the scenes 
  * **Game_controller**
    - This class controls the display of the game 
  * **Main_menu_controller**
    - This class handles the GUI of Main_menu.fxml
   * **Info_page_controller**
    - This class handles the GUI of Info_page.fxml
   * **Enter_name_page**
    - This class handles the GUI of Enter_name_page.fxml
   * **Leaderboard_page_controller**
    - This class handles the GUI of Leaderboard_page_controller.fxml
   
* **New level**

  * 5 levels are added, each with increasing difficulty. 
  * For example, the higher the level, there will be more vehicles. 

* Junit test are added to test if the code is working. 

* Maven build files are added so that the game can run on any computer

---

# How to run

1) Clone or download the project from github 
   https://github.com/WangYeeXuan/COMP2042_CW_CompSciWangYeeXuan.git   
2) Open your command prompt 
3) Change the directory folder to where you download the project
   cd C:\...(folder location)
4) In your command prompt, type mvnw.cmd clean install
5) After the installation, type mvnw.cmd exec:java