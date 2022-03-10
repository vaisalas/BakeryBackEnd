Coverage: 97%
# Bakery-List Project
## Backend

[FrontEnd](https://github.com/vaisalas/BakeryFront-End) repository.

### Introduction 

The aim of this project was to create a CRUD application with all the technology and methodoligies I learnt in the past weeks.
The tools used for the project were:
*	A Jira board for project management
*	Git & GitHub for version control
*	MySQL relational database for persisting data
*	Java SE & Spring Boot for creating a RESTful API to link the database to the front-end
*	MockMVC for Integration Testing
*	Standard HTML, CSS and JS front-end

### Project management & planning
Once I have received the specifications for this project I created a Jira scrum board([ Jira Board ](https://vaisala-sivanesakumar.atlassian.net/jira/software/projects/CCP/boards/4/roadmap)) to plan out all the tasks and userstories for this project. 
I created the project with 3 epics, this allowed me to work sepearetly on my Front-End and Back-End. I linked some of my userstories by blocking them off. Below you can see a example of my Jira backlog. 

![Jira Roadmap](https://github.com/vaisalas/BakeryBackEnd/blob/Feature4-Documentation-and-ReadMe/Documentation/Jira-Roadmap.png)
![Jira Backlog](https://github.com/vaisalas/BakeryBackEnd/blob/Feature4-Documentation-and-ReadMe/Documentation/Jira.png)

### Version Control
I made 2 repository on Github, one for Backend and one for [FrontEnd](https://github.com/vaisalas/BakeryFront-End). I used Feature branch model for both repository, only merging it to dev branch. the Final merge to my main is at the end of the project once I have verfied it all.
(git)

### Database
The two database which was used for this project were H2 and MySQL. The H2 database was used for testing the Spring API, MySQL relatonal database was the main database used for storing persistent data from the application.
Below is the ERD for the Bakery database which shows the datatype and name of each column.

![ERD](https://github.com/vaisalas/BakeryBackEnd/blob/Feature4-Documentation-and-ReadMe/Documentation/Bakery-ERD.png)

### Back-end & Testing

The back-end was writte in Java using Spring Boot. @Mapping was used to create all the CRUD functionality

![Controller](https://github.com/vaisalas/BakeryBackEnd/blob/Feature4-Documentation-and-ReadMe/Documentation/Controller.png)

For Testing I wrote Integration test using JUnit to test all the method in my Controller. Below you can see how all test passed with a coverage of 97.6% in the src/main/java folder.

![Integration test](https://github.com/vaisalas/BakeryBackEnd/blob/Feature4-Documentation-and-ReadMe/Documentation/Integrationtest.png)
![Coverage](https://github.com/vaisalas/BakeryBackEnd/blob/Feature4-Documentation-and-ReadMe/Documentation/Test-coverage.png)

## Frontend





