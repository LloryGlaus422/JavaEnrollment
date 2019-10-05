/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author 2ndyrGroupC
 */
public class Chioce {
   public static void transaction(String done) {
        String[] file = new String[]{" All", " Accounts", " Personal Info", "Course"};
        int elemCount = 1;
        for (String fileElem : file) {
            System.out.println("Press -- " + elemCount + " to " + done + fileElem);
            elemCount++;
        }
    }

    public static void transaction() {
        System.out.println("***Select from the Choices***");
        String[] file = new String[]{" \tRetrieve", " \tAdd", "\tDelete", " \tUpdate", " \tSearch"," \tSave"};
        int elemCount = 1;
        for (String fileElem : file) {
            System.out.println("Press -- " + elemCount + " " + fileElem);
            elemCount++;
        
        }
        System.out.print("Enter Your Choice: ");

    }

    public static boolean endChoice(Scanner write, String end) {
        boolean ans = true;
        System.out.print("\nDo you want to Continue??\n"+ end+"\n1. Yes\n2. No \nEnter your choice: ");
        String endChoice = write.next();
        if (endChoice.equals("2")) {
            ans = false;
        }
        return ans;
    }

    public static int ans(Scanner write) {
        int transactionChoice = 0;
        try {
            transactionChoice = write.nextInt();
        } catch (InputMismatchException e) {
            transactionChoice = 0;
            System.out.println("Input must be Number: ");
            write.next();

        }
        return transactionChoice;
    }
     
}
