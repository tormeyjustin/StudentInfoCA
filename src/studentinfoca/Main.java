/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentinfoca;

/**
 *
 * @author Justin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Test read file
        FileIO fileR = new FileIO();
        String txt = fileR.readFile("students.txt");
        System.out.println(txt);
        fileR.appendToFile(txt, "status.txt");
        
    }
    
}
