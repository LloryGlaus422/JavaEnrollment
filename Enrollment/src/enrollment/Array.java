/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 *
 * @author 2ndyrGroupC
 */
public class Array {
    private static ArrayList<ArrayList> accList = new ArrayList();
    private static ArrayList<ArrayList> infoList = new ArrayList();
    private static ArrayList<ArrayList> courseList = new ArrayList();
//constructors

    public Array() {
    }

    public Array(ArrayList<ArrayList> a, ArrayList<ArrayList> b, ArrayList<ArrayList> c) {
        accList = a;
        infoList = b;
        courseList = c;
    }
//setters and getters

    public static void setAccList(ArrayList list) {
        accList = list;
    }

    public static void setInfoList(ArrayList list) {
        infoList = list;
    }

    public static void setCourseList(ArrayList list) {
        courseList = list;
    }

    public static ArrayList<ArrayList> getAccList() {
        return accList;
    }

    public static ArrayList<ArrayList> getInfoList() {
        return infoList;
    }

    public static ArrayList<ArrayList> getCourseList() {
        return courseList;
    }
// adds list in account,information,course

    public static void addAccList(ArrayList list) {
        accList.add(list);
    }

    public static void addInfoList(ArrayList list) {
        infoList.add(list);
    }

    public static void addCourseList(ArrayList list) {
        courseList.add(list);
    }
//display account,information,course

    public static void displayAccList() {

        for (ArrayList x : accList) {
            System.out.printf("%s\t%10s\t%10s\n", x.get(0), x.get(1), x.get(2));
        }
    }

    public static void displayInfoList() {      
        for (ArrayList x : infoList) {
            System.out.printf("%s\t%10s\t%10s\t%10s\t%10s\n", x.get(0), x.get(1), x.get(2), x.get(3), x.get(4));

        }

    }

    public static void displayCourseList() {
        for (ArrayList x : courseList) {
            System.out.printf("%s\t%10s\t%10s\t%10s\t%10s\n", x.get(0), x.get(1), x.get(2), x.get(3), x.get(4));
        }
    }
//search accounts, information,and courses

    public static void searchAcc(int index) {
        for (ArrayList a : accList) {
            if (((String) a.get(0)).equals(String.valueOf(index))) {
                System.out.printf("%s\t%10s\t%10s\n", a.get(0), a.get(1), a.get(2));
            }

        }
    }

    public static void searchInfo(int index) {
        for (ArrayList a : infoList) {
            if (((String) a.get(1)).equals(String.valueOf(index))) {
                System.out.printf("%s\t%10s\t%10s\t%10s\t%10s\n", a.get(0), a.get(1), a.get(2), a.get(3), a.get(4));
            }

        }
    }

    public static void searchCourses(int index) {
        for (ArrayList a : courseList) {
            if (((String) a.get(1)).equals(String.valueOf(index))) {
                System.out.printf("%s\t%10s\t%10s\t%10s\t%10s\n", a.get(0), a.get(1), a.get(2), a.get(3), a.get(4));
            }

        }
    }
//delete information and course

    public static void deleteInfo(int index) {
        for (Iterator<ArrayList> iterator = infoList.iterator(); iterator.hasNext();) {
            ArrayList a = iterator.next();
            
            if (((String) a.get(1)).equals(String.valueOf(index))) {
                System.out.printf("%s\t%10s\t%10s\t%10s\t%10s\n", a.get(0), a.get(1), a.get(2), a.get(3), a.get(4));
                iterator.remove();

            }

        }
    }

    public static void deleteCourse(int index) {
        for (Iterator<ArrayList> iterator = courseList.iterator(); iterator.hasNext();) {
            ArrayList a = iterator.next();
            if (((String) a.get(1)).equals(String.valueOf(index))) {
                System.out.printf("%s\t%10s\t%10s\t%10s\t%10s\n", a.get(0), a.get(1), a.get(2), a.get(3), a.get(4));
                iterator.remove();

            }

        }
    }
//updates information and course

    public static void updateInfo(int index, ArrayList<String> list) {
        for (ArrayList a : infoList) {
            if (((String) a.get(0)).equals(String.valueOf(index))) {
              
                infoList.set(infoList.indexOf(a),new ArrayList<String>(Arrays.asList((String)a.get(0),(String)a.get(1),list.get(2), list.get(3), list.get(4))));
            }

        }
    }

    public static void updateCourse(int index, ArrayList<String> list) {
        for (ArrayList a : courseList) {
            System.out.println(a.get(0));
            if (((String) a.get(0)).equals(String.valueOf(index))) {
                courseList.set(courseList.indexOf(a),new ArrayList<String>(Arrays.asList((String)a.get(0),(String)a.get(1),list.get(2), list.get(3), list.get(4))));
            }

        }
    }
}
