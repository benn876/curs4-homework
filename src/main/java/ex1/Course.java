package ex1;

import lombok.Builder;

@Builder
public record Course(String course, int semester) {
    @Override
    public String toString() {
        return """
                {
                    "course":"%s",
                    "semester":"%s"
                }
                """.formatted(course, semester);
    }
}
