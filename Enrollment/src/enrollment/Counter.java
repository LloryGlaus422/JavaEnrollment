/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 2ndyrGroupC
 */
public class Counter {
   public static int count(BufferedReader file) throws IOException {
        int lines = 0;
        BufferedReader reader = null;
        try {
            reader =file;

            while (reader.readLine() != null) {
                lines++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("Error on connecting with file");
        } finally {
//            System.out.println("initial number of lines in Personal Information file " + lines);
            reader.close();
        }
        return lines;

    }  
}
