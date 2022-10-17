package study.methodreference;

import studentdatabaseapp.Student;
import studentdatabaseapp.StudentDataBase;

import java.util.function.Predicate;

public class RefactorMethodReferenceExample {

    static Predicate<Student> p1 = (s) -> s.getGpa()>=3;

    static Predicate<Student> p2 = RefactorMethodReferenceExample::greaterThanGpa;
    public static boolean greaterThanGpa(Student s) {
        return s.getGpa()>=3;
    }

    public static void main(String[] args) {
        System.out.println(p1.test(StudentDataBase.studentSupplier.get()));

        System.out.println(p2.test(StudentDataBase.studentSupplier.get()));
    }
}
