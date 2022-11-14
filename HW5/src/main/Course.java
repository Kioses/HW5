package main;

import java.util.ArrayList;

public class Course {

    private int id, maxCapacity;
    private String name;
    private boolean isFull;
    private Professor professor;
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Exam> exams = new ArrayList<Exam>();
    private ArrayList<Project> projects = new ArrayList<Project>();
    private TA ta;
    private Department department;

    public Course(int id, int maxCapacity, String name, Professor professor, Department department, Exam exam) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.name = name;
        setProfessor(professor);
        this.isFull = false;
        this.department = department;
        this.department.addCourse(this);
        exams.add(exam);
        exam.setCourse(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Department getDepartment() {
        return department;
    }

    public void setProfessor(Professor professor) {
        professor.addCourse(this);
        if(professor.hasCourse(this))
            this.professor = professor;
    }

    public TA getTA() {
        return ta;
    }

    public void setTA(TA ta) {
        this.ta = ta;
        ta.addCourse(this);
    }

    public void enroll(Student student){
        if(!isFull) {
            students.add(student);
            updateFull();
            student.addCourse(this);
        }
        else System.out.println("Course already at maximum capacity!");
    }

    public void apply(TA ta){
        setTA(ta);
    }

    private void updateFull(){
        setFull(students.size() >= getMaxCapacity());
    }

    public void addProject(Project project) {
        projects.add(project);
    }
}