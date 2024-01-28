/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfoca;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Justin
 */
public class FileIO {
        
        // Read file and return a string
        public static String readFile(String inputFile) {
            StringBuilder sb = new StringBuilder();
            try {
                Scanner myReader = new Scanner(new FileReader(inputFile));
                while (myReader.hasNextLine()) {
                    String myReadLine = myReader.nextLine();
                    sb.append(myReadLine).append("\n");
                }
                myReader.close();
            } catch(Exception e) {
                System.out.println("Error: " + e);
            }
            return sb.toString();
        }
        
        // Accepts text and a filename and appends text to file
        public static void appendToFile(String text, String filename) {
            BufferedWriter bw = null;
            try {
                // Open the file in append mode.
                bw = new BufferedWriter(new FileWriter(filename, true));
                // Write the text to the file.
                bw.write(text);
                bw.write("\n");
                System.out.println("Text added to file successfully");
                // Close the BufferSamedWriter.
                bw.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            } finally {
                if (bw != null) {
                    try {     
                        // Close the BufferedWriter.
                        bw.close();
                    } catch (IOException e) {
                        System.out.println("Error: " + e);
                    }
                }
            }
        }    
}
