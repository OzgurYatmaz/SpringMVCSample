 
A task manager application with spring mvc, spring security and mysql DB along with. For front end Bootstrap and Jquery is used.

Tasks and users are managed by spring data jpa over mysql db. Fuctionality the api offers are the following:

 - Once Admin is manually inserted to DB api can be used. (Look at the text file in "docs" folder to perform that)
 - Admin can add or delete any number of users with desired roles or authorities.
 - User can only see and manage his own tasks but cannot see or manages oher user's tasks or cannot see or manage other users.
 - When any admin deletes any user, tasks of deleted user are automatically removed from DB.

<p align="center">
  
  <img src="task-manager-app/docs/add%20or%20update%20task.jpg" width="350" alt="accessibility text">
</p>
