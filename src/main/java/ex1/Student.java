package ex1;

import lombok.Builder;
import lombok.With;

import java.time.LocalDate;
import java.util.Random;

import static java.time.Period.between;

@Builder
public record Student(String name, LocalDate birthDate, Integer grade) {

    public int getAge() {
        return between(birthDate, LocalDate.now()).getYears();
    }

    static Student of(String name, int age, Integer grade) {
        Random random = new Random();
        int year = LocalDate.now().getYear() - age;
        int month = random.ints(1, 12)
                .findFirst()
                .getAsInt();
        int day = getRandomDay(year, month);
        LocalDate randomBirthDate = LocalDate.of(year, month, day);
        return new Student(name, randomBirthDate, grade);
    }

    private static int getRandomDay(int year, int month) {
        Random randomDay = new Random();
        if (month == 2) {
            if (year % 4 == 0) {
                return randomDay.ints(1, 29)
                        .findFirst()
                        .getAsInt();
            } else {
                return randomDay.ints(1, 28)
                        .findFirst()
                        .getAsInt();
            }
        } else {
            if (month % 2 == 0) {
                return randomDay.ints(1, 30)
                        .findFirst()
                        .getAsInt();
            } else {
                return randomDay.ints(1, 31)
                        .findFirst()
                        .getAsInt();
            }
        }
    }
}
