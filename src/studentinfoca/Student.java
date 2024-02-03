/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfoca;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Justin
 * 
 */

public class Student {
    // variables
    public String firstName;
    public String lastName;
    public int numClasses;
    public String studentID;
    public String workload;
    
    // Constructor
    public Student(String firstName, String lastName, String classes, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numClasses = Integer.parseInt(classes);
        this.studentID = id;
        
        if (this.numClasses == 1) {
            this.workload = "Very Light";
        } else if (this.numClasses == 2){
            this.workload = "Light";
        } else if (this.numClasses >= 3 && this.numClasses <= 5) {
            this.workload = "Part Time";
        } else if (this.numClasses >= 6) {
            this.workload = "Full Time";
        } else {
            this.workload = "No classes";
        }
    }
    
    // Input validation
    
    public static boolean isValidFirstName(String str) {
        // Check first name 
        if (str.matches("[a-zA-Z]+")) {
            return true;
        } else {
            System.out.println("Name must contain characters a-z only.");
            return false;
        }
    }
    
    public static boolean isValidLastName(String str) {
        if (str.matches("[a-zA-Z0-9]+")) {
            return true;
        } else {
            System.out.println("Name must contain characters a-z or digits only.");
            return false;
        }
    }
    
    public static boolean isValidClassCount(String classes) {
        int numClasses = 0;
        try {
            numClasses = Integer.parseInt(classes);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        }
        if (numClasses >= 1 && numClasses <= 8) {
            return true;
        } else {
            System.out.println("Class count must be a number between 1 and 8.");
            return false;
        }
    }
    
    public static boolean isValidStudentId(String id){
        boolean isValid = true;

        // The student “number” must be a minimum of 6 characters with the first 2 characters being numbers,
        if (id.length() < 6) {
            System.out.println("Student ID must be a minimum of 6 characters.");
            return false;         
        }
        
        // the 3rd  and 4th characters (and possibly 5th ) being a letter,
        if (id.matches("[0-9]{2}[a-zA-Z]{2,3}[0-9]*")) {
        } else {
            System.out.println("The first 2 characters must be digits and the 3rd and 4th characters (and possibly 5th) must be a letter.");
            isValid = false;
            return false;
        }
        
        // Ensure that the student number year is at least 2020 (i.e. that the number starts with 20 or higher)
        if (Integer.parseInt(id.substring(0,2)) < 20) {
            System.out.println("First two digits reperesenting year must be 20 or higher");
            isValid = false;
        }
        
        // and everything after the last letter character being a number.
        if (!id.matches("[0-9]{2}[a-zA-Z]*\\d*")) {
            System.out.println("ID Must have only numbers after the letters");
            isValid = false;
        }
        
        // Ensure that the number after the letter(s) is reasonable – i.e. that it is between 1 and 200
        // Get the digits after the letters
        String regex = "\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);
        if(matcher.find()) {
            // Parse to integer for checking
            Integer idNumber = Integer.parseInt(matcher.group(0));
            // Check if number is outside the range 1 to 200
            if(idNumber < 1 || idNumber > 200) {
                System.out.println("ID number must be between 1 and 200.");
                return false;
            }
        }
        
        // If all tests pass, return true
        //System.out.println("User ID " + id + " is valid.");
        return isValid; 
    }
    
    public String getStatus() {
        // Prepare a formatted 'status' output string 
        StringBuilder sb = new StringBuilder();
        sb.append(this.studentID);
        sb.append('-');
        sb.append(this.lastName);
        sb.append('\n');
        sb.append(this.workload);
        return sb.toString();
    }   
}