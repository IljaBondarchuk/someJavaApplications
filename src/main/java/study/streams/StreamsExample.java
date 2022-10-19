package study.streams;

import studentdatabaseapp.Student;
import studentdatabaseapp.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        Map<String,List<String>> nameAndActivities = new HashMap<>();
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            nameAndActivities.put(student.getName(), student.getActivities());
        });
        System.out.println(nameAndActivities);

        Map<String,List<String>> studentMapStream = StudentDataBase.getAllStudents().stream()
                .filter((student -> student.getGradeLevel()>=3))
                .collect(Collectors.toMap(Student::getName,Student::getActivities));
        System.out.println(studentMapStream);
    }
}
