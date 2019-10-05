/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;

/**
 *
 * @author 2ndyrGroupC
 */
public class Student {
    private Name name;
    private Course course;
    private Account account;

    public Student(String fname, String lname, int age, String sub, String sched, int unit, String acc, String pass) {
        this.name = new Name(fname, lname, age);
        this.course = new Course(sub, sched, unit);
        this.account = new Account(acc, pass);
    }

    public Student() {
    }

// //name getters
    public Name getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    public Account getAccount() {
        return account;
    }
}
