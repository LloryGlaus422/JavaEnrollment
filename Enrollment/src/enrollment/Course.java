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
public class Course {

    private String subject;
    private String schedule;
    private int loadUnit;

    public Course(String subject, String schedule, int loadUnit) {
        this.subject = subject;
        this.schedule = schedule;
        this.loadUnit = loadUnit;
    }

    public Course() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getLoadUnit() {
        return loadUnit;
    }

    public void setLoadUnit(int loadUnit) {
        this.loadUnit = loadUnit;
    }

    @Override
    public String toString() {
        return String.format("subject= %s\tschedule= %s\tload unit= %d", subject, schedule, loadUnit);
    }
}
