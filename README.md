# Calendar-App
Calendar App

The file dbConnection is used to connect the program with the MySQL code. You need three things to connect to the database the url of the databese, the username and the password.
If you want to connect this code to different database you just need to change the url, username and password in the code i.e. you need to connect it to your database.

In the file LoginModel we have method isLogin which checks if the username and the password are correct i.e. it checks whether they exist in the database.

In the Main file the user is first asked for his username and password, if they are correct then the user is loged in and if they are not the user is asked to Sign up for an account and it asks for a few data. If the user is successfully logged in then is asks if he wants to add, edit or delete some event in his calendar. Here we use the method addUpdateDeleteElement which is connedted to the database. 
We use here one more method getId to get the id of the usrer by knowing his username.
