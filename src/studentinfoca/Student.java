/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfoca;

/**
 *
 * @author Justin
 * 
 */

public class Student {
    // variables
    String firstName;
    String lastName;
    int numClasses;
    String studentID;
    String workload;
    
    // Constructor
    public Student(String firstName, String lastName, int classes, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numClasses = classes;
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
            this.workload = "No workload";
        }
    }
    
    public String stringOutput() {
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
