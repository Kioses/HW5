package main;

import java.util.ArrayList;

public class TA extends Employee{

    private ArrayList<Course> courses = new ArrayList<Course>();

    //1...* relationship with Course => No Obj(TA) declaration without assigning it to an Obj(Course)
    public TA(String name, int employeeID, Department department, Course course) {
        super(name, employeeID, department);
        addCourse(course);
    }

    //Changed output to ArrayList<Course>(cf. UML diagramme)
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course){
        if (courses.size() < 2)
            System.out.println("Removing this course will conflict with TA-Course relation constraint");
        else courses.remove(course);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void extendContract(Course course){}

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
