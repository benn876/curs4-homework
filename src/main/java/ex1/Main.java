package ex1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService(
                List.of(
                        Student.of("Beni", 26, 10),
                        Student.of("Ion", 24, 10),
                        Student.of("George", 30, 10)),
                List.of(Course.builder()
                                .course("Course 1")
                                .semester(1)
                                .build(),
                        Course.builder()
                                .course("Course 2")
                                .semester(2)
                                .build(),
                        Course.builder()
                                .course("Course 3")
                                .semester(3)
                                .build()));
        System.out.println(studentService.averageGradeForTheStudents());
        System.out.println(studentService.allocateCourseToEachStudent());
        System.out.println(studentService.getStudentGrade(8));
    }
}
