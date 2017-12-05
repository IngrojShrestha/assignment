

1.Run Main.java in com.employee package to get to get a menu of six options as shown below 

	========== Employee Record Keeping System =========
	0.Exit
	1.Add Employee
	2.Update Employee
	3.Delete Employee
	4.Display all Employee
	5.Search Employee
	Please select the menu (0 - 5) : 


2.Enter any options from the given menu (0-5) 
   
	2.1 If menu = 0 the user exits from the system 

	2.2 Else if menu = 1 the user can add an employee in the system 
		
		2.2.1 To add an employee the user needs to select the Employee type (manager or scientist)

		2.2.2 Then the user is asked to fill in employee details based on the type

			Manager : employee ID , employee first name, employee last name, salary and reward

			Scientist : employee ID , employee first name, employee last name, salary and perks

			Employee ID: An unique ID should be given to each employee

			If the ID conflicts, Record already exists message is shown to user.

			After user enters all the details, the detail is stored in a text file (employee.txt).

	2.3 Else if menu = 2 the user can update details for existing employees 

	    2.3.1 The user needs to enter Employee ID of the employee whose details needs to be updated
		  
				If the ID exists, the record is shown, else the Record not found message is shown

				After the employee ID has been entered, the employee details is shown and the user can now update the employee details.
		
	2.4 Else if menu =3 the user can delete records for existing employees 
	    
	   2.4.1 The user needs to enter Employee ID of the employee whose details needs to be deleted
	         
                 If the ID exists, the record is deleted, else the Record not found message is shown 

	2.5 Else if menu = 4 the user can display records for existing employees 
            
	    If the record(s) does not exist, Record not found message is shown.

	2.6 Else if menu = 4 the user can display records for an existing employees 

	    2.6.1 The user needs to enter employee ID to search the employee 
		
	        If the record with the given ID exists, the record is shown. Otherwise, record not found message is shown.
	

Note:


Executing the Employee Record Keeping System from jar 

1.Run assignment_oop.jar to get menu of six options as shown below:
	
$ java -jar assignment_oop.jar

	========== Employee Record Keeping System =========
	0.Exit
	1.Add Employee
	2.Update Employee
	3.Delete Employee
	4.Display all Employee
	5.Search Employee
	Please select the menu (0 - 5) : 

2.The remaining process is same as (2) above.
	   	
