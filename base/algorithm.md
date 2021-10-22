# Algorithm
## Goals
The goal of this "Bank On It" program is to create a basic ATM system with specific requirements. According to the instructions given, each user will have an account number and a PIN, a checking account and a savings account. The checking account has a balance, and the user can deposit money into the account, withdraw money from the account, and check the balance. The checking account does not have interest. The savings account is almost exactly like the checking account except that there is an interest rate associated with the account and it can be calculated by the standard basic interest formula: A=P(1+rt), where P = principle (balance before calculating interest), r is the interest rate, and t is the period (months)

The ATM will expect a user to log in using account number and PIN. If the user is an administrator, she will be taken to an admin menu. If the user is a known user, she will be taken to a user menu. If the user is unknown, the system will exit. The admin user will have an account number of 00000 and a pin 12345. The admin menu will have the following the options to add a user, delete a user (account must be empty), list all users, apply interest to all savings accounts, and exit. The user menu will have the options to get checking balance, deposit into checking, withdraw from checking, get savings balance, deposit into savings, withdraw from savings, and exit. Finally, the system will need to store the user and account information into some sort of file system.

For this bank program that I have created, I made 5 classes in seperate files, which include the *Bank class*, *Checking class*, *Saving class*, *User class*, and *Admin class*. The Bank class acts as the main class of the program, it functions to run the program and manage all the seperate classes created and make the whole bank program work. The Checking class is to manage the checking account and balance of the user. The 


## Input
For this bank program that I have created, I made 5 classes in seperate files, which include the *Bank class*, *Checking class*, *Saving class*, *User class*, and *Admin class*. 



opening an input file to read the data contained within it. It is not taking input from the user, but reading strings of student information from a given file obtained from the Canvas Assignment page. The input file has 50 lines of strings. Each line of string contains various information of a student, including a last name, a first name, an address, DOB, graduation date, GPA, and credit hours completed. I will extract these information, pass them to the string variables defined in the *Students class* and assign these strings to the appropriate attributes defined in all of my classes. Therefore, after carrying out a list of instructions given to my program, I will have a complete set of information for all students stored in the heap of 50 Student class instances. These information can be accessed anywhere in the program, ready to be extracted again and output them to a text file, which is what I will need to do after that.

## Output
The program is not outputting anything on the console, but the *main()* function is reading strings of data and outputting it to a few different file after the strings are tokenized and assigned to the attributes of the three classes defined. Then, I will open three text files to store different information extracted from the original file that I was originally given. The first output file that I will open is called the *"fullReport.txt"*. This text file will contain all the information for each student rearranged in a more formatted manner. Each of their last name, first name, address, DOB, graduation date, GPA, and credit hours completed are neatly outputted to this text file. Next, another text file is opened, called *"shortReport.txt"*. This text file is a simplified version of the fullReport text file as it only contains the last name and first name of each student outputted and stored in it. Finally, one last optional file that I will be doing is the *"alphaReport.txt"* file. This text file will contain the **first and last name** of all 50 students rearranged in **alphabetical order**. After having all of the output files filled with the intended information, I close the files before ending the program.

## Steps 
First, I created a UML diagram to have a clearer picture of how the three classes (*Students, Address, Dates*) are related to each other. Also, the UML diagram allows me to split the big and complex program into smaller parts, and it helped me to understand and comprehend the general structure of the program before starting to code. Then, I started by creating the *Address and Dates* classes first since they are not depending on any other classes and so these two classes are relatively easy to create. For the *Address class*, there are 5 attributes with string type created, they are the "line1, line2, city, state, and zip". For each of these attributes, a setter and a getter method is defined in order to handle and access these attibutes outside of the class itself. Next is the *Dates class*. This class has 3 string attributes defined, "day, month, year" and a setter and a getter method is defined for each of these attributes as well. For the two classes, a constructor and a destructor is defined for them as well. Also, each of these classes have a seperate header file and cpp file created specifically for them. The cpp file for each class contains the code implementation of the class, and it will include the class header file and any other headers and libraries needed. Finally, the **Students class** is created since it has dependencies on the two other classes. This class has 10 attributes of different types defined in it, they are "fName, lName, address, dob, grad, gpa, creditHrs, FullAddress, FullDOB, FullGrad". The "address" attribute has a data type of an Address pointer, while the "dob and grad" attributes have a Dates pointer data type since we wanna store them on the heap instead of the stack. The methods defined in this class include a setter and a getter for all of the attributes, as well as a setLine() method that is used to set all the information extracted from the input file to the attributes of this *Students class*. Also, a null parameter constructor, a constructor with parameter, and a destructor are also created in this class. 

Then, I will create a make file to control the compilation process and a main program that imports all the needed classes and tests them with just some simple strings to determine if the program executes everything as intended. I then modify this program and make file based on my progress. In the main.cpp file, I started off by including all the necessary libraries and header files that I will need to open an input and output file, use stringstreams to handle strings from and to files, as well as to use the classes that I have defined in different files. Also, I defined the necessary instances of the classes stored in the heap (**using the "new" keyword"**), with an array of 50 Students class instances. After, I open an input file called "students.dat" that contains all the information of 50 students. There are 50 lines of strings stored in this file, and each line represents the information of a student. Therefore, I utilized the stringstream, strings, and getline() function to extract strings from the file. In a while loop, a line of string is extracted for every loop, and this line of string will be passed to the setLine() method defined in the *Students class*. Through this method, the information of each student will be tokenized and assigned to its appropriate attributes on the *Students class* itself in order for me to access them easily. 

Next step is to open some output files to store different information extracted from the original file that I was originally given. The first output file that I will open is called the *"fullReport.txt"*. This text file will contain all the information for each student rearranged in a more formatted manner. To achieve this result, I passed the tokens of information of one student to a string together with the format I wanted the output file to have using the *+ operator*. Then, I did a for loop to allow the program to repeat the process for all 50 students, and pass this string to the file within the for loop. This will output each of their last name, first name, address, DOB, graduation date, GPA, and credit hours completed neatly to the text file. Next, another text file is opened, called *"shortReport.txt"*. This text file is a simplified version of the fullReport text file as it only contains the last name and first name of each student outputted and stored in it. Therefore, I did the exact same thing as before, but the only tokens of information included this time are their first and last name. Finally, one last optional file that I will be doing is the *"alphaReport.txt"* file. This text file will contain the **first and last name** of all 50 students rearranged in **alphabetical order**. In order to sort the array of *Students class* instances, I declared another function in main, called the sortName() function. This function will take in a string array as its parameter containing 50 strings. Each of the string element contains the full name of a student (first and last name). Then, this function will run a for loop to compare the alphabets of each student name in the array. If the former string element has an alphabet greater than the latter string, a process of swapping their position will take place and this process is repeated for every string element in the array. In the main() function instead, I have declared a string array of 50 elements, passing the Full name of each student as one string element to this array. Then, I called the sortName() function to get a sorted list of names of the student array. Finally, I opened the *"alphaReport.txt"* and passed the list of sorted student names to the file using a for loop. After having all of the output files filled with the intended information, I close all the files that I have opened for this program, and deleted the *Student class array pointer* to prevent memory leak in my program. 

For the make file, I have also added the valgrind and debug commands so that I can test for memory leaks and errors in my program. Also, all instances of my classes are stored separately on the heap, and my program is tested using the Valgrind tool to ensure that I have responsibly deallocated memory when your are done with it. 

Below is the format that I got from the given input text file for a line of student data:

```
Surname,GivenName,StreetAddress,Address2,City,State,ZipCode,Birthday,Graduation,GPA,Credit Hours Complete<end of line>

Fry,Lock,123 Hillside Drive,,North Brunswick,NJ,57237,08/22/1970,05/15/2012,4.00,90
```
Lastly, I compiled and ran the program to check for any errors. After finalizing the codes, I did a git add ., git commit -m, and a git push -u origin master to upload the .c file to GitHub, located in a directory that I have created. 