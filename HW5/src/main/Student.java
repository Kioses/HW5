package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private int id;
    private String name;
    private ArrayList<Exam> exams = new ArrayList<Exam>();
    private ArrayList<Course> courses = new ArrayList<Course>();
    private Project project;

    //Changed Student-Course relationship from 1..* to * (Student without courses possible)
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project){
        this.project = project;
    }

    public boolean isRegisteredE(Exam exam) {
        if (isRegisteredC(exam.getCourse())) {
            for (Exam value : exams) {
                if (value.getExamID() == exam.getExamID())
                    return true;
            }
        }
        return false;
    }

    public void registerExam(Exam exam) {
        if (this.isRegisteredC(exam.getCourse())){
            exam.registerStudent(this);
            exams.add(exam);
        }
    }

    public void registerCourse(Course course) {
        course.enroll(this);
    }

    private boolean isRegisteredC(Course course) {
        for (Course pCourse : courses) {
            if (pCourse.getId() == course.getId())
                return true;
        }
        return false;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

}
