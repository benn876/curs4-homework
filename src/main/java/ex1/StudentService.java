package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.*;

public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    public StudentService(List<Student> students, List<Course> courses) {
        this.students.addAll(students);
        this.courses.addAll(courses);
    }

    public String averageGradeForTheStudents() {
        return students.stream()
                .collect(teeing(
                        mapping(Student::name, toList()),
                        averagingDouble(student -> new Double(student.grade())),
                        (names, avg) -> names + " have an average grade of " + avg
                ));
    }

    public List<String> allocateCourseToEachStudent() {
        return students.stream()
                .map(student -> {
                    int randomIndex = new Random().ints(0, courses.size())
                            .findFirst()
                            .getAsInt();
                    Course randomCourse = courses.get(randomIndex);
                    return """
                             %s will participate to course
                             %s
                            """.formatted(student.name(), randomCourse.toString());
                }).toList();
    }

    public String getStudentGrade(int index) {
        return switch (index) {
            case 0, 1, 2:
                yield "1st grade";
            case 3:
                yield "5th grade";
            default:
                yield "7th grade";
        };
    }
}
