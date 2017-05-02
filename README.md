simple REST api with php

This is a simple RESTful api developed with php, and also a demo app for Android to test the api.
To use this api you should install an apache php server such as XAMPP.
https://www.apachefriends.org/download.html

Once you've installed the server you can clone the project to the server htdocs directory.

The api uses a local repository of students data, the repository may be replaced by a database for persistent storage of the data.

API main components:
1. ApiEntry.php
All the requests are routed to this script which creates an instance of the API kernel class and forward the request to it. 

2. ApiKernel.php
An abstract class which holds the functionality of the api

3. ApiEngin.php
A concrete class of the ApiKernel class, this class will handle the api requests enpoints.
Each endpoint shall have a method with the enpoint name. 

4. Repository.php
This class creates a mock local repository for data which returns for the api requests. 


To test the api from the browser:
http://localhost/studentsApi/student          //Will get all students data in json format
http://ocalhost/studentsApi/student?id=1      //Will get student 1 data in json format3


Android Demo App:
This app can be used to test the api on an Android device or Emulator. 
To use the app, it is required to set the server api ip::port in the ApiClinet.java class in the BASE_URL constant:
BASE_URL = "http://10.0.0.7:80/studentApi"



