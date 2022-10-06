package studentdatabaseapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class Student  {
    private String firstName;
    private String lastName;
    private int studentId;
    private static int id = 1000;
    private int gradeLevel;
    public static HashMap<Integer,String> coursesList = new HashMap<>();
    private final BiConsumer<Integer,String> biConsumer = (k,v) -> System.out.println("Code " + k + " for " + v);
    private ArrayList<String> courses = new ArrayList<>();
    private int balance = 0;
    private int costTuition;
    private final int price = 600;
    static {
        coursesList.put(101, "History");
        coursesList.put(102, "Mathematics");
        coursesList.put(103, "English");
        coursesList.put(104, "Chemistry");
        coursesList.put(105, "Computer Science");
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
        coursesList.forEach((k,v) -> biConsumer.accept(k,v));
        this.courses = getCourses();
        countingTuition();
        enterBalance();
        payTuition();
    }
    private int getStudentID(){
        id++;
        return this.gradeLevel * 10000 + id;
    }

    private ArrayList<String> getCourses() {
        System.out.println("Promt the number of course which you want to add:");
        putCourse();
        for (int i = 0; i < coursesList.size() - 1; i++) {
            System.out.println("Do you want another course? Y/N");
            Scanner in = new Scanner(System.in);
            String answer = in.nextLine();
            if (Objects.equals(answer.toUpperCase(), "Y")) {
                System.out.println("Promt the number of course which you want to add:");
                putCourse();
            } else {
                break;
            }
        }
        System.out.println("You have been added: " + courses.toString());
        return courses;
    }
    private void showCoursesList(){
        coursesList.forEach((k,v) -> System.out.println("Code " + k + " for " + v) );
    }
    private void putCourse(){
            Scanner in = new Scanner(System.in);
            int numberCourse = in.nextInt();
            AtomicInteger counter = new AtomicInteger();
            coursesList.forEach((k,v) -> {
                if (k == numberCourse && !courses.contains(v)) {
                            courses.add(v);
                            System.out.println("You successful added course: "  + v);
                 counter.set(1);
                }
       });
        if (counter.compareAndSet(0,1)) {
            System.out.println("You enter wrong course code, please try again");
            putCourse();
        }
    }
    private void countingTuition() {
        costTuition = courses.size() * price;
    }
    private void enterBalance(){
        System.out.println("How much would you like to put on your balance:");
        Scanner in = new Scanner(System.in);
        int moneyToBalance = in.nextInt();
        balance = balance + moneyToBalance;
    }

    public int getBalance() {
        return balance;
    }

    public int getCostTuition() {
        return costTuition;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId=" + studentId +
                ", courses=" + courses +
                ", balance=" + balance +
                '}';
    }

    private void payTuition(){
        System.out.println("Would you like to pay your tuition now? Y/n:");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        if (Objects.equals(answer.toUpperCase(),"Y")){
            if (costTuition > balance) {
                System.out.println("You have less balance than cost all of your chosen courses. You balance is " + balance +
                                   "\nCost of all courses is " + costTuition + "\nWould you like to put money on your balance? Y/n");
                answer = in.nextLine();
                if (Objects.equals(answer.toUpperCase(),"Y")){
                    enterBalance();
                }
            }
            balance = balance - costTuition;
            System.out.println("You successful paid for your courses. Now your balance is " + balance);
        }
        if (balance < 0) {
            System.out.println("You have no access to studying until you pay your tuition\nYour balance is " + balance);
;
        }
    }
}
