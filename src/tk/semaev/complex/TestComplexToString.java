package tk.semaev.complex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestComplexToString {
    private Complex complex;

    @Test
    @DisplayName("Zero")
    public void test001() {
        complex = new Complex(0, 0);
        assertEquals("0", complex.toString(),
                "The zero output should work as properly");
    }
    @Test
    @DisplayName("Zero with default constructor")
    public void test002() {
        complex = new Complex();
        assertEquals("0", complex.toString(),
                "The zero output should work as properly with default constructor");
    }

    @Test
    @DisplayName("Only positive real part")
    public void test003() {
        complex = new Complex(30, 0);
        assertEquals("30", complex.toString());
    }

    @Test
    @DisplayName("Only negative real part")
    public void test004() {
        complex = new Complex(-40, 0);
        assertEquals("-40", complex.toString());
    }

    @Test
    @DisplayName("Only positive imaginary part")
    public void test005() {
        complex = new Complex(0, 50);
        assertEquals("50i", complex.toString());
    }

    @Test
    @DisplayName("Only negative imaginary part")
    public void test006() {
        complex = new Complex(0, -60);
        assertEquals("-60i", complex.toString());
    }

    @Test
    @DisplayName("Positive real part and positive imaginary part")
    public void test007() {
        complex = new Complex(70, 70);
        assertEquals("70 + 70i", complex.toString());
    }

    @Test
    @DisplayName("Positive real part and negative imaginary part")
    public void test008() {
        complex = new Complex(80, -80);
        assertEquals("80 - 80i", complex.toString());
    }

    @Test
    @DisplayName("Negative real part and positive imaginary part")
    public void test009() {
        complex = new Complex(-90, 90);
        assertEquals("-90 + 90i", complex.toString());
    }

    @Test
    @DisplayName("Negative real part and negative imaginary part")
    public void test010() {
        complex = new Complex(-100, -100);
        assertEquals("-100 - 100i", complex.toString());
    }

}
