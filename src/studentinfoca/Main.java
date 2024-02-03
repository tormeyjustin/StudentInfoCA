/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentinfoca;

import java.util.Scanner;

/**
 *
 * @author Justin
 * 
 */

public class Main {
    
    public static void readStringLines(String str) {
        
    }
    
    public static void inputStudentData(){
        // Variables
        String firstname;
        String lastname;
        String studentid;
        int classes;
        
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
            // If input is not an iteger ask again
            while(!userInput.hasNextInt()) {
                System.out.println("Please enter a number");
                userInput.next();
            }
            
            classes = userInput.nextInt();
        } while (Student.isValidClassCount(classes) == false);
        
        Student inputStudent = new Student(firstname, lastname, classes, studentid);
        String formattedStatus = inputStudent.getStatus();
        
        // Append to file
        FileIO fileWrite = new FileIO();
        fileWrite.appendToFile(formattedStatus, "status.txt");
            
    }

    public static void main(String[] args) {
        
        
        inputStudentData();
        
        
    }
    
}
