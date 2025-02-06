import SMS.Major;
import SMS.UndergradStudent;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UndergraduateStudentTest {

    @ParameterizedTest
    @CsvSource({
        "1, 'John', 'Doe', 25, 'MATH', 3.5",
        "2, 'Jane', 'Smith', 20, 'CS', 3.0",
        "3, 'Alice', 'Wonderland', 22, 'BIO', 2.5",
        "4, 'Bob', 'Builder', 21, 'ENG', 3.0",
        "5, 'Charlie', 'Brown', 23, 'HIST', 2.0"
    })
    public void testUndergradStudents(int id, String firstName, String lastName, int age, Major major) {
        UndergradStudent student = new UndergradStudent(id, firstName, lastName, age, major);

        assertEquals(id, student.getId());
        assertEquals(firstName, student.getFirstName());
        assertEquals(lastName, student.getLastName());
        assertEquals(age, student.getAge());
        assertEquals(major, student.getMajor());
    }
}

