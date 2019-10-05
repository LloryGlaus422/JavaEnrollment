/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;
import java.util.InputMismatchException;
/**
 *
 * @author 2ndyrGroupC
 */
public class ExceptionHandler {
    public static boolean charIsDigit(String word) {
        boolean ans = false;
        for (int x = 0; x < word.length(); x++) {
            char y = word.charAt(x);
            if (Character.isDigit(y)) {
                ans = true;
            }
        }
        return ans;
    }

    public static boolean charIsNotString(String word) {
        boolean ans = false;
        for (int x = 0; x < word.length(); x++) {
            char y = word.charAt(x);
            if (Character.isLetter(y) == false) {
                ans = true;
            }
        }
        return ans;

    }

    public static void charShouldNotBeNumber(String word) {
        if (charIsNotString(word) || charIsDigit(word)) {
            throw new ArithmeticException("Invalid Input it must be a number");
        }
    }
//level one Checker

    public static boolean level_One(String user, String password, String verifyPass) {
        boolean ans = false;
        charShouldNotBeNumber(user);
        if (password.length() < 8) {
            throw new ArithmeticException("password must be more than 8 characters in length");
        } else {
            if (password.equals(verifyPass)) {
                ans = true;

            } else {
                throw new ArithmeticException("Invalid Password");
            }
        }
        return ans;
    }
//level two

    public static boolean level_two(String fname, String lname, int age) throws Exception {
        boolean ans = false;
        String name = fname + lname;
        charShouldNotBeNumber(name);
        try {
            int x = age;
        } catch (Exception e) {
            throw new Exception("Invalid Input it must be a number");
        }
        if (age <=0) {
            throw new ArithmeticException("Invalid Age Input");
        } else {
            ans = true;

        }
        return ans;

    }
//level three

    public static boolean level_Three(String course, String sched, int unit) {
        boolean ans = false;
        charShouldNotBeNumber(course);
        charShouldNotBeNumber(sched);
        int units = Integer.valueOf(unit);
        if (unit <0) {
            ans = false;
            throw new ArithmeticException("Invalid Number");

        } else {
            ans = true;

        }

        return ans;
    }

}
