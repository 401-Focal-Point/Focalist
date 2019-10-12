# Project Requirements

## Vision

###### What is the vision of this product?

Our Focal List app should allow users to create their own list of tasks that are scheduled to be sent to their phone at the specified time via SMS. Users should be able reliably and securely create and log into their account that will keep track of their todos. 

###### What pain point does this project solve?



###### Why should we care about your product?



## Scope (In/Out)
#### IN - What will your product do
###### Describe the individual features that your product will do.

- Focal List will allow users to create and store their list of future tasks
- Focal List will have server that automatically send reminder for tasks to users via text message at the specified time. 
- Focal List allows users to view previous completed tasks and future tasks on a list. 
- Focal List can allow users to configure if they want a big block of text that list all tasks to do for the day at the start of the day or have reminders be sent 1 hour before the task is due.  


#### OUT - What will your product not do.
###### Describe the individual features that your product will not do.

 - The app will not account for time zone difference when delivering reminder at the specified time.


## MVP
###### What will your MVP be. What is your expected minimum end product?

 - User can sign up and log in to their personal account 
 - User can add new future tasks that can be display as a list 
 - User can receive reminder via SMS at the time that they specified

## Stretch
###### What stretch goals are you going to aim for?

- Users can edit and delete certain tasks in their list
- Add more appealing UI components to the app
- Users can integrate other services like Canvas or Trello or Google Calender into their task lists. 
- Users can have other users that they approve to add tasks to their list. 
- Allow user to select a location for a task via google maps
- Show a calendar on front end for user to select the date of the task
- Allow user to add attachments to task such as file link
- Allow user to configure time delay that they want before a task is due for the reminder to be sent. 
- Have user verify their phone number perhaps by sending back a verification code to server. 

## Functional Requirements
###### List the functionality of your product. This will consist of tasks such as the following:

- A user can create and log in to their account
- A user can create a future task with a notification time
- A user can view all their tasks as a list
- A user can recieve reminder of their task via text message at the specified time

## Non-Functional Requirements (301 & 401 only)
Non-functional requirements are requirements that are not directly related to the functionality of the application but still important to the app.

- `Security` - Our app needs account security in order to prevent other people from accessing sensitive information as well as modify the tasks. We need to prevent access for users not sign up yet to access the dashboard until they signed up with their information. We also need to prevent other users from accessing our own account by verifying if the current logged in user is the same as the user that they are trying to view.

- `Usability` - Our app needs to have a simple and intuitive UI so that people from all ages and technical backgrounds can use the app with ease. Our app should make adding tasks be a quick and easy process to improve the user experience. The reminders sent should be reliable in that users should receive their reminders at the time that they specified every time.  

## Data Flow

When the user first enter the site, they will be greeted with a splash page that provide a quick description of what the app do. On this page, user will have the option to sign up or log into their account. Choosing to sign up will redirect the user to the sign up page where they input their profile information like name, phone number, password, etc.. Once they signed up, they will be redirected to the main page where they have access to the functionality of the app. On this page, user can see a list of future tasks as a side bar while also have a detail div that show the detail of a specific task. User can also add a task by putting the title of the task, notes about it, time to be reminded, and an optional location of the task. The task list will automatically be updated to contain the added task. This would be MVP of what user can interact with on our app.

For the backend, when the user signed up, their profile information will be sent to the Postgresql database in a user table. For the task that the user created will be sent to a route that would take in the form information and also be added to the psql database in a task table. User and tasks will have a one-to-many relationship. When the user access the main page, the database will be queried to get all the tasks information for the current user. This information will be added to the Thymeleaf model so that it can render the view for the browser to display page. Then in order for text reminders to be sent at the right time, Heroku scheduler will have to query the database every 10 minutes for all the tasks ordered by the time. Then a controller will check the current time and the tasks in the list to see if a task need to be sent in the next 10 minutes. If not, then nothing else will be done. If there are, get the tasks that have the time be in the next 10 minutes. Now query the database again to query the user that the tasks are for to get the user info. Package both user and tasks info as a JSON and send to Twilio API for them to do their magic and send the user their reminder message.  

