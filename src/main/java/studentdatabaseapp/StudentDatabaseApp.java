package studentdatabaseapp;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args) {
        List<StudentOld> studentOldList = new ArrayList<>();
        System.out.println("How many students do you want to add?");
        Scanner in = new Scanner(System.in);
        int countStudents = in.nextInt();
        for (int i = 0; i < countStudents; i++){
            in.nextLine();
            System.out.println("StudentOld number " + (i+1) + " firstname is:");
            String firstName = in.nextLine();
            System.out.println("Lastname is: ");
            String lastName = in.nextLine();
            System.out.println("Gradelevel is: ");
            int gradeLevel = in.nextInt();
            StudentOld studentOld = new StudentOld(firstName,lastName,gradeLevel);
            studentOldList.add(studentOld);
        }
        studentOldList.forEach(System.out::println);
    }
}
