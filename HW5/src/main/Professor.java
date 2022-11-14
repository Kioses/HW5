package main;

public class Professor extends Employee{

	   private Course[] courses = new Course[3];

	    public Professor(String name, int employeeID, Department department) {
	        super(name, employeeID, department);
	    }

	    public void publicCourse(){}

	    public void assignTA(){}

	    public void addCourse(Course course){
	        try{
	            for(int i = 0; i < 3; i++){
	                if(courses[i] == null)
	                    courses[i] = course;
	            }
	        }
	        catch (IndexOutOfBoundsException e){
	            System.out.println(getName() + " cannot take on any more courses!");
	        }
	    }

	    public boolean hasCourse(Course course){
	        for(int i = 0; i< 3; i++){
	            if(courses[i].getId() == course.getId())
	                return true;
	        }
	        return false;
	    }
	}
