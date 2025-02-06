import SMS.GraduateStudent;
import SMS.IllegalGpaException;
import SMS.Major;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraduateStudentTest {
    private GraduateStudent graduateStudent;

    @BeforeEach
    public void setUp() {
        graduateStudent = new GraduateStudent(1, "John", "Doe", 25, Major.MATH);
    }

    @Test
    public void testSetGPA() {
        assertDoesNotThrow(() -> graduateStudent.setGPA(3.5));
        assertEquals(3.5, graduateStudent.getGPA());
    }

    @Test
    public void testSetGPAInvalid() {
        Exception exception = assertThrows(IllegalGpaException.class, () -> graduateStudent.setGPA(-1.0));
        assertEquals("GPA must be between 0.0 and 4.0", exception.getMessage());
    }

    @Test
    public void testSetGPA_Invalid_High() {
        Exception exception = assertThrows(IllegalGpaException.class, () -> graduateStudent.setGPA(4.5));
        assertEquals("GPA must be between 0.0 and 4.0", exception.getMessage());
    }
}
