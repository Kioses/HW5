package main;

public class Employee {
    private String name;
    private int employeeID;

    private Department department;

    public Employee(String name, int employeeID, Department department) {
        this.name = name;
        this.employeeID = employeeID;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void updateDepartment(Department department){
        this.department.removeEmployee(this);
        department.addEmployee(this);
        this.department = department;
    }

}
