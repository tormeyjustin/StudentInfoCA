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
        String firstname;
        String lastname;
        String studentid;
        int classes;
        
        Scanner userInput = new Scanner(System.in);
        
        // Request first name
        do {
            System.out.println("Please enter student first name:");
            firstname = userInput.nextLine();
        } while (Student.validateFirstName(firstname) == false);
        
        // Request last name
        do {
            System.out.println("Please enter student last name:");
            lastname = userInput.nextLine();
        } while (Student.validateLastName(lastname) == false);
        
        // Request student ID
        do {
            System.out.println("Please enter student ID:");
            studentid = userInput.nextLine();
        } while (Student.validateStudentId(studentid) == false);
        
        // Request the number of classes    
        do {
            System.out.println("Please enter number of classes taken:");
            classes = userInput.nextInt();
        } while (Student.validateClassCount(classes) == false);
        
        Student inputStudent = new Student(firstname, lastname, classes, studentid);
        String formattedStatus = inputStudent.stringOutput();
        // Append to file
        FileIO fileWrite = new FileIO();
        fileWrite.appendToFile(formattedStatus, "status.txt");
            
    }

    public static void main(String[] args) {
        
        // Test read file
        //FileIO fileR = new FileIO();
        //String txt = fileR.readFile("students.txt");
        //System.out.println(txt);
        //fileR.appendToFile(txt, "status.txt");
        
        // Test Student class
        //Student test = new Student("Justin", "Tormey", 4, "sba23239");
        //System.out.println(test.firstName);
        //System.out.println(test.workload);
        
        inputStudentData();
        
        //System.out.println(test.stringOutput());
        
        // Test Student validator
        //Student.validateFirstName("Justin3");
        //Student.validateLastName("Justin3");
        
    }
    
}
