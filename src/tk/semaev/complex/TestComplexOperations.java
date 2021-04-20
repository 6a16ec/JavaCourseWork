package tk.semaev.complex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestComplexOperations {
    @Test
    @DisplayName("Addition to an existing object")
    public void test002() {
        Complex num1 = new Complex(22, -22);
        Complex num2 = new Complex(2, -222);
        String num2_str = num2.toString();
        num1.addition(num2);
        assertEquals("24 - 244i", num1.toString());
        // Checking that the num2 object has not been corrupted
        assertEquals(num2_str, num2.toString());
    }

    @Test
    @DisplayName("Subtract from an existing object")
    public void test004() {
        Complex num1 = new Complex(400, -4);
        Complex num2 = new Complex(44, 4);
        String num2_str = num2.toString();
        num1.subtraction(num2);
        assertEquals("356 - 8i", num1.toString());
        // Checking that the num2 object has not been corrupted
        assertEquals(num2_str, num2.toString());
    }

    @Test
    @DisplayName("Multiplying an existing object")
    public void test006() {
        Complex num1 = new Complex(60, -6);
        Complex num2 = new Complex(6, 66);
        String num2_str = num2.toString();
        num1.multiplication(num2);
        assertEquals("756 + 3924i", num1.toString());
        // Checking that the num2 object has not been corrupted
        assertEquals(num2_str, num2.toString());
    }

    @Test
    @DisplayName("Getting associated object (a - b)")
    public void test007() {
        Complex num1 = new Complex(70, -7);
        Complex num2 = num1.getAssociated();
        num1.multiplication(num2);
//        assertEquals("4949", num1.toString());
        assertTrue(num1.isReal());
    }

    @Test
    @DisplayName("Getting associated object (a + b)")
    public void test008() {
        Complex num1 = new Complex(8, 80);
        Complex num2 = num1.getAssociated();
        num1.multiplication(num2);
//        assertEquals("6464", num1.toString());
        assertTrue(num1.isReal());
    }

    @Test
    @DisplayName("Getting associated object (-a + b)")
    public void test009() {
        Complex num1 = new Complex(-9, 9);
        Complex num2 = num1.getAssociated();
        num1.multiplication(num2);
//        assertEquals("162", num1.toString());
        assertTrue(num1.isReal());
    }

    @Test
    @DisplayName("Getting associated object (-a - b)")
    public void test010() {
        Complex num1 = new Complex(-10, 100);
        Complex num2 = num1.getAssociated();
        num1.multiplication(num2);
//        assertEquals("10100", num1.toString());
        assertTrue(num1.isReal());
    }

    @Test
    @DisplayName("Subdivision of an existing object")
    public void test011() throws Exception {
        Complex num1 = new Complex(110, -11);
        Complex num2 = new Complex(11, -11);
//        String num2_str = num2.toString();


        num1.division(num2);

        assertEquals("5.5 + 4.5i", num1.toString());
    }

    @Test
    @DisplayName("Checking the method divisionByReal throw, when divader is complex")
    public void test012() {
        Complex num1 = new Complex(12, 12);
        Complex num2 = new Complex(12, 12);

        Exception exception = assertThrows(Exception.class, () -> num1.divisionByReal(num2));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains("The divider is not a real number"));
    }

    @Test
    @DisplayName("Checking the method divisionByReal throw, when divide by 0")
    public void test013() {
        Complex num1 = new Complex(12, 12);
        Complex num2 = new Complex(0, 0);

        Exception exception = assertThrows(Exception.class, () -> num1.divisionByReal(num2));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains("Division by zero"));
    }

}