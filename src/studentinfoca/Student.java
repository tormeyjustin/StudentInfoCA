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
        
        int numclasses = this.numClasses;
        if (numClasses == 1) {
            workload = "Very Light";
        } else if (numClasses == 2){
            workload = "Light";
        } else if (numclasses >= 3 && numclasses <= 5) {
            workload = "Part Time";
        } else if (numclasses >= 6) {
            workload = "Full Time";
        } else {
            workload = "No workload";
        }
        this.workload = workload;
    }
    
}
