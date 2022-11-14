package main;

import java.util.ArrayList;

public class Exam {

    private int maxValue;
    private int examID;
    private Course course;
    private ArrayList<Question> questions = new ArrayList<Question>();
    private ArrayList<Student> students = new ArrayList<Student>();

    public Exam(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public int getMaxValue() {
        return maxValue;
    }
    /*
    Changed the method parameter to make sure maxvalue is in accordance with sum of all values in ArrayList questions.
    Added override method, so maxValue can be overridden in special circumstances.
     */
    public void setMaxValue() {
        int valueSum = 0;
        for (Question question : questions){
            valueSum += question.getMaxValue();
        }
        this.maxValue = valueSum;
    }

    public void overrideMaxValue(int maxValue){
        this.maxValue = maxValue;
    }

    /*
    I assume the method is used to determine whether a certain student
    is registered to this exam
    */
    public boolean register(Student student){
        return student.isRegisteredE(this);
    }

    public void addQuestion(String task, int value, int id){
        questions.add(new Question(task, value, id));
        setMaxValue();
    }

    //IMPROVEMENT: Changed method output to ArrayList<Student> to return ALL registered students.
    public ArrayList<Student> getRegisteredStudents(){
        return students;
    }

    public void registerStudent(Student student){
        students.add(student);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
