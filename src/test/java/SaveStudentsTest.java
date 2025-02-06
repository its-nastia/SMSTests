import SMS.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveStudentsTest {
    @ParameterizedTest
    @CsvSource({
            "1, 'John', 'Doe', 25, 'MATH', 3.5",
            "2, 'Jane', 'Smith', 20, 'ART', 3.0",
            "3, 'Alice', 'Wonderland', 22, 'ECONOMICS', 2.5",
            "4, 'Bob', 'Builder', 21, 'ART', 3.0",
            "5, 'Charlie', 'Brown', 23, 'MATH', 2.0"
    })

    public void testSavingStudentsToAFile(int id, String firstName, String lastName, int age, Major major) throws IOException {
        UndergradStudent student = new UndergradStudent(id, firstName, lastName, age, major);
        List<UndergradStudent> students = Arrays.asList(
                new UndergradStudent(1, "John", "Doe", 25, Major.MATH),
                new UndergradStudent(2, "Jane", "Smith", 20, Major.ART),
                new UndergradStudent(3, "Alice", "Wonderland", 22, Major.ECONOMICS),
                new UndergradStudent(4, "Bob", "Builder", 21, Major.ART),
                new UndergradStudent(5, "Charlie", "Brown", 23, Major.MATH)
        );

        File file = new File("students.csv");
        try (PrintWriter writer = new PrintWriter(file)) {
            for (UndergradStudent s : students) {
                writer.println(s.getId() + "," + s.getFirstName() + "," + s.getLastName() + "," + s.getAge() + "," + s.getMajor());
            }
        }

        List<String> lines = Files.readAllLines(file.toPath());
        assertEquals(5, lines.size());
        assertEquals("1,John,Doe,25,MATH", lines.get(0));
        assertEquals("2,Jane,Smith,20,ART", lines.get(1));
        assertEquals("3,Alice,Wonderland,22,ECONOMICS", lines.get(2));
        assertEquals("4,Bob,Builder,21,ART", lines.get(3));
        assertEquals("5,Charlie,Brown,23,MATH", lines.get(4));
    }

    @Test
    public void testLoadingStudentsFromAFile() {
        File file = new File("students.csv");
        List<String> lines = Arrays.asList(
                "1,John,Doe,25,MATH",
                "2,Jane,Smith,20,ART",
                "3,Alice,Wonderland,22,ECONOMICS",
                "4,Bob,Builder,21,ART",
                "5,Charlie,Brown,23,MATH"
        );

        try (PrintWriter writer = new PrintWriter(file)) {
            for (String line : lines) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
