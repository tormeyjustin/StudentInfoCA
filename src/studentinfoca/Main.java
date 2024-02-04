/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentinfoca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Justin
 * 
 */

public class Main {
    
    public static ArrayList<Student> processStudentsText(String str) {
        // Accepts a string 'str' and processes it in blocks of 3 lines
        // Returns an ArrayList containing all valid students
        String firstName = "";
        String lastName = "";
        int skipped = 0;
        
        // Create an arraylist to hold valid student instances
        ArrayList<Student> students = new ArrayList<Student>();
                
        Scanner scanner = new Scanner(str);
        
        // Read 'str' lines in blocks of 3 lines
        while (scanner.hasNextLine()) {
            // Read first line, check for a single space, and split to firstName lastName
            String line1 = scanner.nextLine();
            String regex = "(\\w+)\\s(\\w+)"; // Two words separated by a single space 
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line1);
            if(matcher.find()) {
                firstName = matcher.group(1);
                lastName = matcher.group(2);
            } else {
                System.out.println("First name and last name must be separated by a single space");
                System.out.println("^ Skipped: " + line1);
            };
                     
            // Read second line
            String line2 = scanner.nextLine();
            
            // Read third line
            String line3 = scanner.nextLine();
            
            // Check if all lines are valid
            if (
                    Student.isValidFirstName(firstName) &&
                    Student.isValidLastName(lastName) &&
                    Student.isValidClassCount(line2) &&
                    Student.isValidStudentId(line3)
                ) {
                
                // If valid, create a Student instance and add to the ArrayList
                Student s = new Student(firstName, lastName, line2, line3);
                students.add(s);
            } else {
                // Keep count of skipped blocks and print skipped names
                skipped++;
                System.out.println("^ Skipped: " + line1);
            }
        }
        
        // Print a summary and return the ArrayList
        System.out.println("\nSummary: validated " + students.size()+ " student(s) and skipped " + skipped + ".");
        return students;
    }
       
    public static Student inputStudentData(){
        // User input returns a valid instance of Student
        // Variables
        String firstname;
        String lastname;
        String studentid;
        String classes;
        
        Scanner userInput = new Scanner(System.in);
        
        // Request and validate first name 
        do {
            System.out.println("Please enter student first name:");
            firstname = userInput.nextLine();
        } while (Student.isValidFirstName(firstname) == false);
        
        // Request and validate last name
        do {
            System.out.println("Please enter student last name:");
            lastname = userInput.nextLine();
        } while (Student.isValidLastName(lastname) == false);
        
        // Request and validate student ID
        do {
            System.out.println("Please enter student ID:");
            studentid = userInput.nextLine();
        } while (Student.isValidStudentId(studentid) == false);
        
        // Request and validate the number of classes    
        do {
            System.out.println("Please enter number of classes taken:");
            classes = userInput.nextLine();
            // If input is not an iteger ask again
        } while (Student.isValidClassCount(classes) == false);
        
        Student inputStudent = new Student(firstname, lastname, classes, studentid);
                
        return inputStudent;
   
    }

    public static void main(String[] args) {
        // Input txt file
        String inputTxtFile = "studentsTest.txt";
        // Output txt file
        String outputTxtFile = "status.txt";
        
        // User choice - read file or manual input
        Scanner menuOption = new Scanner(System.in);
        System.out.println("Choose method for adding student statuses:");
        System.out.println("1) Read from a .txt file in bulk.\n2) Enter details manually.");
        
        boolean invalidOption = true;
        FileIO txtfile = new FileIO();
        do {
            String selected = menuOption.nextLine();
            switch (selected) {
                case "1": 
                // User selected bulk file input
                    invalidOption = false;                  
                    String studentstxt = txtfile.readFile(inputTxtFile);
                    ArrayList<Student> processedStudents = processStudentsText(studentstxt);
                    
                    // Ask to write to file y/n
                    System.out.println("Write to file? y/n");
                    selected = menuOption.nextLine();
                    switch (selected) {
                        case "y":
                            // Loop over processedStudents ArrayList and write each one to the output file
                            for(Student student : processedStudents) {
                                txtfile.appendToFile(student.getStatus(), outputTxtFile);
                            }
                            System.exit(0);
                            break;
                        case "n":
                            System.out.println("Nothing added to file.");
                            System.exit(0);
                            break;    
                        default:
                            System.out.println("Operation cancelled.");
                            System.exit(0);
                    }                    
                    
                case "2":
                // User selected manual input
                    invalidOption = false;
                    // Start user input
                    Student student = inputStudentData();
                    // Apend to output txt file
                    txtfile.appendToFile(student.getStatus(), outputTxtFile);
                    break;
                default:
                // Invalid option selected
                    System.out.println("Please choose option 1 or 2");
            }
        } while (invalidOption);
        
    }
    
}
