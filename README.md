# SpringMVCSample
A task manager application with spring mvc, spring security and mysql DB along with...

Tasks and users are managed by spring data jpa over mysql db. Fuctionality the api offers are the following:

 - Once Admin is manually inserted to DB api can be used.
 - Admin can add any numbers of users with desired roles or authorities or delete any user.
 - User can only see and manage his own tasks but cannot see or manages oher user's tasks or cannot see or manage other users.
 - When any admin deletes any user, tasks of deleted user are automatically removed from DB.
