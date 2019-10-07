/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;

import static enrollment.Chioce.transaction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Enroll {

    static int counter = 0;
    static int infoCount = 0;
    static int courCount = 0;

    public static void main(String[] args) throws IOException {
        boolean endAll = true;
        while (endAll) {
            File file = new File(new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Desktop\\Accounts.txt", true)),
                    new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Desktop\\Info.txt", true)),
                    new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Desktop\\Course.txt", true)));
            counter = Counter.count(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Accounts.txt")));
            courCount = Counter.count(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Course.txt")));
            infoCount = Counter.count(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Info.txt")));
            File file1 = new File();
            file1.sendArray(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Info.txt")));
            Array.setInfoList(file1.getList());
            file.sendArray(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Accounts.txt")));
            Array.setAccList(file.getList());
            File file2 = new File();
            file2.sendArray(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Course.txt")));
            Array.setCourseList(file2.getList());
            Scanner write = new Scanner(System.in);
            boolean end = true;
            while (end) {
                //instantiates here
//scanner        
//instantiating account,course,name classes
                Account acc = new Account();
                Course course = new Course();
                Name name = new Name();
                Chioce.transaction();
                int transactionChoice = Chioce.ans(write);
                switch (transactionChoice) {
                    case 1:
                        boolean endRetrieve = true;
                        while (endRetrieve) {
                            transaction("retrieve");
                            System.out.print("Input your choice: ");
                            int choiceRetrieve = Chioce.ans(write);
                            switch (choiceRetrieve) {
                                case 1:
                                    System.out.println("---Display All");
                                    System.out.println("---Display Accounts");
//                                    System.out.println(Array.getAccList());
                                    Array.displayAccList();
                                    System.out.println("---Display Personal Information");
                                    System.out.println("All Personal Informttion");
//                                    System.out.println(Array.getInfoList());
                                    Array.displayInfoList();
                                    System.out.println("---Display Personal Course");
                                    System.out.println("All Personal Course");
//                                    System.out.println(Array.getCourseList());
                                    Array.displayCourseList();
                                    break;

                                case 2:
                                    // System.out.println(Array.getAccList());
                                    Array.displayAccList();
                                    break;
                                case 3:
//                                    System.out.println(Array.getInfoList());
                                    Array.displayInfoList();
                                    break;
                                case 4:
                                    Array.displayCourseList();
                                    break;
                                default:
                                    System.out.println(Array.getCourseList());
                                    System.out.println("Invalid Input!");
                                    break;
                            }
                            endRetrieve = Chioce.endChoice(write, "retrieve");
                        }
                        break;

//adding info in files
                    case 2:
                        boolean endAdd = true;
                        while (endAdd) {
                            //level one
                            String user = "";
                            String password = "";
                            String verify = "";
                            System.out.print("Username: ");
                            user = write.next();
                            System.out.print("Password: ");
                            password = write.next();
                            System.out.print("Confirm Password: ");
                            verify = write.next();
                            try {
                                if (ExceptionHandler.level_One(user, password, verify)) {
                                    counter++;
                                    ArrayList<String> list = new ArrayList();
                                    list.add(String.valueOf(counter));
                                    list.add(user);
                                    list.add(password);
                                    Array.addAccList(list);
                                } else {
                                    continue;
                                }
                            } catch (ArithmeticException e) {
                                System.out.println(e);
                                continue;
                            }

                            //level two
                            boolean endPersonalInfoAdd = true;
                            while (endPersonalInfoAdd) {
                                String fname = "";
                                String lname = "";
                                int age = 0;
                                System.out.print("Firstname: ");
                                fname = write.next();
                                System.out.print("Lastname: ");
                                lname = write.next();
                                System.out.print("Age: ");
                                try {
                                    age = write.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.print("Your age must be number!\nAge: ");
                                    write.next();
                                    continue;
                                }
                                try {
                                    if (ExceptionHandler.level_two(fname, lname, age)) {
                                        infoCount++;
                                        ArrayList<String> list = new ArrayList();
                                        list.add(String.valueOf(infoCount));
                                        list.add(String.valueOf(counter));
                                        list.add(fname);
                                        Array.addInfoList(list);
                                        endPersonalInfoAdd = Chioce.endChoice(write, "Personal Information Add");
                                        list.add(lname);
                                        list.add(String.valueOf(age));
                                    }
                                } catch (Exception e) {
                                    System.out.println(e);
                                    continue;
                                }
                            }
                            boolean endCourseAdd = true;
                            while (endCourseAdd) {
                                String subject = "";
                                String sched = "";
                                int unit = 0;
                                System.out.print("Subject: ");
                                subject = write.next();
                                System.out.print("Schedule: ");
                                sched = write.next();
                                System.out.print("Units: ");
                                try {
                                    unit = write.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("unit must be numbers\nUnits: ");
                                    write.next();
                                    continue;
                                }
                                try {

                                    if (ExceptionHandler.level_Three(subject, sched, unit)) {
                                        courCount++;
                                        ArrayList<String> list = new ArrayList();
                                        list.add(String.valueOf(courCount));
                                        list.add(String.valueOf(counter));
                                        list.add(subject);
                                        list.add(sched);
                                        list.add(String.valueOf(unit));
                                        Array.addCourseList(list);
                                        endCourseAdd = Chioce.endChoice(write, "Course Information Add");
                                    }
                                } catch (Exception e) {
                                    System.out.println(e);
                                    continue;
                                }
                            }
                            endAdd = Chioce.endChoice(write, "add");
                        }
                        break;
//deleting
                    case 3:
                        if (Array.getAccList().size() != 0 && Array.getInfoList().size() != 0 && Array.getCourseList().size() != 0) {
                            boolean endDelete = true;
                            while (endDelete) {
                                int choiceDelete = 0;
                                System.out.print("1. Personal Info\n2. Delete Courses\n ");
                                System.out.print("Input choice: ");
                                try {
                                    choiceDelete = Chioce.ans(write);
                                } catch (Exception e) {
                                    System.out.println(e);
                                    continue;
                                }
                                switch (choiceDelete) {
                                    case 1:
                                        System.out.print("Deleting id Number: ");
                                        try {
                                            Array.deleteInfo(write.nextInt());
                                        } catch (InputMismatchException e) {
                                            System.out.println("Invalid Input");
                                        }
                                        break;

                                    case 2:
                                        System.out.print("Deleting id Number:");
                                        try {
                                            Array.deleteCourse(write.nextInt());
                                        } catch (InputMismatchException e) {
                                            System.out.println("Invalid Input");
                                        }
                                        break;
                                    default:
                                        System.out.println("Invalid Choice");
                                        break;
                                }
                                endDelete = Chioce.endChoice(write, "delete");
                            }
                        }
                        break;
                    case 4:

                        boolean endUpdate = true;
                        while (endUpdate) {

                            System.out.print("1. Personal Info\n2. Courses\nInput your choice: ");
                            int choiceUpdate = Chioce.ans(write);
                            switch (choiceUpdate) {
                                case 1:
                                    if (Array.getInfoList().size() != 0) {
                                        System.out.print("Input id from Personal Information to update values \nInput id: ");
                                        int updateHolder = 0;
                                        try {
                                            updateHolder = write.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.println("Input id from Course Information to update values \nInput id:");
                                            continue;
                                        }
                                        Array.searchInfo(updateHolder);
                                        String fname = "";
                                        String lname = "";
                                        int age = 0;
                                        System.out.print("Update Firstname To: ");
                                        fname = write.next();
                                        System.out.print("Update Lastname To: ");
                                        lname = write.next();
                                        System.out.print("Update Age To: ");
                                        try {
                                            age = write.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.print("Invalid Choice: ");
                                            write.next();
                                            continue;
                                        }
                                        try {
                                            if (ExceptionHandler.level_two(fname, lname, age)) {
                                                infoCount++;
                                                ArrayList<String> list = new ArrayList();
                                                list.add(String.valueOf(infoCount));
                                                list.add(String.valueOf(counter));
                                                list.add(fname);
                                                list.add(lname);
                                                list.add(String.valueOf(age));
                                                Array.updateInfo(updateHolder, list);
                                            }
                                        } catch (Exception e) {
                                            System.out.println(e);
                                            continue;
                                        }

                                    }
                                    break;

                                case 2:
                                    if (Array.getCourseList().size() != 0) {
                                        System.out.print("Input id: ");
                                        int updateHolder2 = write.nextInt();
                                        Array.searchCourses(updateHolder2);
                                        String subject = "";
                                        String sched = "";
                                        int unit = 0;
                                        System.out.print("Update Subject To: ");
                                        subject = write.next();
                                        System.out.print("Update Schedule To: ");
                                        sched = write.next();
                                        System.out.println("Update Units To: ");
                                        try {
                                            unit = write.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.print("Invalid Input: ");
                                            write.next();
                                            continue;
                                        }
                                        try {

                                            if (ExceptionHandler.level_Three(subject, sched, unit)) {
                                                ArrayList<String> list = new ArrayList();
                                                list.add(String.valueOf(courCount));
                                                list.add(String.valueOf(counter));
                                                list.add(subject);
                                                list.add(sched);
                                                list.add(String.valueOf(unit));
                                                Array.updateCourse(updateHolder2, list);
                                            }
                                        } catch (Exception e) {
                                            System.out.println(e);
                                            continue;
                                        }
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid Iput");
                                    break;
                            }
                            endUpdate = Chioce.endChoice(write, "update");
                        }
                        break;
                    case 5:
                        if (Array.getAccList().size() != 0 && Array.getInfoList().size() != 0 && Array.getCourseList().size() != 0) {
                            boolean endSearch = true;
                            while (endSearch) {

                                System.out.println("1. Account\n2. Personal Info\n3 Courses\nInput Choice: ");
                                int choiceSearch = Chioce.ans(write);
                                if (transactionChoice == 0) {
                                    continue;
                                }
                                switch (choiceSearch) {
                                    case 1:
                                        System.out.println("Input id: ");
                                        Array.searchAcc(write.nextInt());
                                        break;

                                    case 2:
                                        System.out.println("Input id: ");
                                        Array.searchInfo(write.nextInt());
                                        break;
                                    case 3:
                                        System.out.println("Input id: ");
                                        Array.searchCourses(write.nextInt());
                                        break;

                                    default:
                                        System.out.println("Invalid Input");
                                        break;
                                }
                                endSearch = Chioce.endChoice(write, "search");

                            }
                        }
                        break;
                    case 6:
                        System.out.println("Save successfully");
                        file.sendAccount(Array.getAccList());
                        file.sendPersonalInfo(Array.getInfoList());
                        file.sendCourse(Array.getCourseList());
                        end = false;
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            }
            endAll = Chioce.endChoice(write, "transaction");
        }
    }
}
