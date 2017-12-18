## Running Application

1.Export students.csv in mysql database.

2.Run Main.java in com.assignment package. 
     The user is asked to enter database credentials (database name, username and password) to access the database.

3.The user will be displayed with the two options menu as shown below

	************** Menu **************
	1. Perform Query without index
	2. Perform Query with index
	Select option (1/2)
3.1 If, menu =1, the user will be provided with a non-indexed query result. The user will also be displayed with the query execution time.

	After the operation in step (3.1) is complete, the user is asked whether to exit from the system (y or n).

 	If the user enters 'y', then the user exits from the system.Else the step (3) is repeated.

3.2 Else If, menu = 2, the user will be provided with an indexed query result (indexed on field : first_name). The user will also be displayed with the query execution time.

	After the operation in step (3.2) is complete, the user is asked whether to exit from the system (y or n).

 	If the user enters 'y', then the user exits from the system.Else the step (3) is repeated.
 	
 3.3 .Else, user is shown with "Please provide appropriate option (1/2)" message.
 
 
## Executing the Algorithm from jar

1.Export students.csv in mysql database.

2.Run assignment_mysql.jar. The user is asked to enter database credentials (database name, username and password) to access the database.

```bash
$ java -jar assignment_mysql.jar
```

3.The remaining process is same as step 3  above.

