package main;

import java.util.ArrayList;

public class Project {

    private String name;
    private int projectID;
    private ArrayList<Student> members = new ArrayList<Student>();
    private Course course;

    //A project must be assigned to a course(cf. UML diagramme
    public Project(String name, int projectID, Course course) {
        this.name = name;
        this.projectID = projectID;
        this.course = course;
        course.addProject(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void addMember(Student student){
        members.add(student);
        student.setProject(this);
    }

    //I changed the output to ArrayList<Student> in case there is more than one member
    public ArrayList<Student> getMembers(){
        return members;
    }
}
