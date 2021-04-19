package tk.semaev.complex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestComplexOperations {
    @Test
    @DisplayName("Addition and creating a new object")
    public void test001() {
        Complex num1 = new Complex(1, 10);
        String num1_str = num1.toString();
        Complex num2 = new Complex(-10, -1);
        String num2_str = num2.toString();
        Complex result = Complex.addition(num1, num2);
        assertEquals("-9 + 9i", result.toString());
        // Check that the objects themselves are not corrupted
        assertEquals(num1_str, num1.toString());
        assertEquals(num2_str, num2.toString());
    }

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
    @DisplayName("Subtraction and creating a new object")
    public void test003() {
        Complex num1 = new Complex(30, -33);
        String num1_str = num1.toString();
        Complex num2 = new Complex(-3, -3);
        String num2_str = num2.toString();
        Complex result = Complex.subtraction(num1, num2);
        assertEquals("33 - 30i", result.toString());
        // Check that the objects themselves are not corrupted
        assertEquals(num1_str, num1.toString());
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
    @DisplayName("Multiplication and creating a new object")
    public void test005() {
        Complex num1 = new Complex(55, -5);
        String num1_str = num1.toString();
        Complex num2 = new Complex(-5, 5);
        String num2_str = num2.toString();
        Complex result = Complex.multiplication(num1, num2);
        assertEquals("-250 + 300i", result.toString());
        // Check that the objects themselves are not corrupted
        assertEquals(num1_str, num1.toString());
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
    public void test011() {
        Complex num1 = new Complex(110, -11);
        Complex num2 = new Complex(11, -11);
//        String num2_str = num2.toString();


        num1.division(num2);

        assertEquals("5.5 + 4.5i", num1.toString());
        // Checking that the num2 object has not been corrupted
//        assertEquals(num2_str, num2.toString());
    }

    @Test
    @DisplayName("Subdivision of an existing object")
    public void test012() throws Exception {
        Complex num1 = new Complex(110, -11);
        Complex num2 = new Complex(11, -11);
//        String num2_str = num2.toString();


//        num1.division(num2);


        assertEquals("5.5 + 4.5i", Complex.division(num1, num2).toString());
        // Checking that the num2 object has not been corrupted
//        assertEquals(num2_str, num2.toString());
    }

}