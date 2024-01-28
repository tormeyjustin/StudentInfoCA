/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentinfoca;

/**
 *
 * @author Justin
 * 
 */

public class Main {

    public static void main(String[] args) {
        
        // Test read file
        //FileIO fileR = new FileIO();
        //String txt = fileR.readFile("students.txt");
        //System.out.println(txt);
        //fileR.appendToFile(txt, "status.txt");
        
        // Test Student class
        Student test = new Student("Justin", "Tormey", 4, "sba23239");
        System.out.println(test.firstName);
        System.out.println(test.workload);
        
        System.out.println(test.stringOutput());
        
    }
    
}
