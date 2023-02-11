
A task manager web application with spring mvc, spring security and mysql DB along with. For front end Bootstrap and Jquery is used.

Tasks and users are managed by spring data jpa over mysql db. Fuctionality the api offers are the following:

 - Once Owner is manually inserted to DB api can be used. (Look at the text file in "docs" folder to perform that)
 - Admin or Owner can add  any number of users but only Owner can delete users.
 - User can only see and manage his own tasks but cannot see or manages oher user's tasks or cannot see or manage other users.
 - Task are ordered by target date.
 - When any owner deletes any user, tasks of deleted user are automatically removed from DB.

<p align="center">
  <img src="task-manager-app/docs/How%20does%20it%20look%20like.jpg" width="350" alt="accessibility text">
  <img src="task-manager-app/docs/add%20or%20update%20task.jpg" width="350" alt="accessibility text">
  <img src="task-manager-app/docs/Admins%20page%20for%20user%20management.jpg" width="350" alt="accessibility text">
</p>
