package studentdatabaseapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Student  {
    private String firstName;
    private String lastName;
    private int studentId;
    private int gradeLevel;
    private ArrayList<String> courses;
    private int balance;
    private final int price = 600;
    public static HashMap<Integer,String> coursesList;
    static {
        //init hash map static
    }

    public Student (String firstName, String lastName, int gradeLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (gradeLevel < 1) {
            System.out.println("Minimal grade level is 1");
            this.gradeLevel = 1;
        } else if (gradeLevel > 5) {
            System.out.println("Maximum grade level is 5");
            this.gradeLevel = 5;
        } else {
            this.gradeLevel = gradeLevel;
        }
        this.studentId = getStudentID();
    }

    private int getStudentID(){
        int rand = (int) (Math.random() * 9000) + 1000;
        return this.gradeLevel * 10000 + rand;
    }

    public static HashMap<Integer,String> fillCourses(){
        HashMap<Integer,String> coursesList = new HashMap<>();
        coursesList.put(101, "History");
        coursesList.put(102, "Mathematics");
        coursesList.put(103, "English");
        coursesList.put(104, "Chemistry");
        coursesList.put(105, "Computer Science");
        return coursesList;
}
    private void getCourses(){
        System.out.println("Promt the number of course which you want to add:");
        Scanner in = new Scanner(System.in);
        int numberCourse = in.nextInt();

        //this.courses.add()
    }


}
