package tk.semaev.complex;

public class Complex {
    private double real_part;
    private double imaginary_part;
    final private double eps = 1e-6;

    public Complex(){
        this.real_part = 0.0;
        this.imaginary_part = 0.0;
    }

    public Complex(double real_part, double imaginary_part) {
        this.real_part = real_part;
        this.imaginary_part = imaginary_part;
    }

    boolean isReal() {
        return isZero(imaginary_part);
    }

    private String toString(double number) {
        String string;
        if (Math.abs(number - (int) number) < eps) {
            string = Integer.toString((int) number);
        } else {
            string = Double.toString(number);
        }
        return string;
    }

    private Boolean isZero(double number) {
        return Math.abs(number) < eps;
    }

    private Boolean notZero(double number) {
        return !isZero(number);
    }

    @Override
    public String toString() {
        String result = "";
        if (notZero(real_part) || isZero(imaginary_part)) {
            result += toString(real_part);
        }
        if (notZero(imaginary_part)) {
            if (imaginary_part > 0) {
                if (notZero(real_part)) {
                    result += " + ";
                }
            } else {
                if (notZero(real_part)) {
                    result += " - ";
                } else {
                    result += "-";
                }
            }
            result += toString(Math.abs(imaginary_part)) + "i";
        }
        return result;
    }

    public void addition(Complex another) {
        this.real_part += another.real_part;
        this.imaginary_part += another.imaginary_part;
    }

    static public Complex addition(Complex first, Complex second) {
        return new Complex(
                first.real_part + second.real_part,
                first.imaginary_part + second.imaginary_part
        );
    }

    public void subtraction(Complex another) {
        this.real_part -= another.real_part;
        this.imaginary_part -= another.imaginary_part;
    }

    static public Complex subtraction(Complex first, Complex second) {
        return new Complex(
                first.real_part - second.real_part,
                first.imaginary_part - second.imaginary_part
        );
    }

    /*
        * MULTIPLICATION *
        a = r1 + i1 * i
        b = r2 + i2 * i
        result = a * b = (r1 + i1 * i) * (r2 + i2 * i)
        result = (r1 * r2 - i1 * i2) + (r1 * i2 + i1 * r2) * i
     */
    public void multiplication(Complex another) {
        double r1 = this.real_part, i1 = this.imaginary_part;
        double r2 = another.real_part, i2 = another.imaginary_part;
        this.real_part = r1 * r2 - i1 * i2;
        this.imaginary_part = r1 * i2 + i1 * r2;
    }

    static public Complex multiplication(Complex first, Complex second) {
        double r1 = first.real_part, i1 = first.imaginary_part;
        double r2 = second.real_part, i2 = second.imaginary_part;
        return new Complex(
                r1 * r2 - i1 * i2,
                r1 * i2 + i1 * r2
        );
    }

    public Complex getAssociated() {
        return new Complex(
                real_part,
                -imaginary_part
        );
    }

    public void division(Complex divider) {
        Complex associated = divider.getAssociated();
        this.multiplication(associated);
        divider.multiplication(associated);
        // divide by zero!!
        this.real_part /= divider.real_part;
        this.imaginary_part /= divider.real_part;
    }


    static public Complex divisionByReal(Complex dividend, Complex divider) throws Exception {
        if (!divider.isReal()) {
            throw new Exception("The divisor is not a real number");
        }
        return new Complex(
                dividend.real_part / divider.real_part,
                dividend.imaginary_part / divider.real_part
        );
    }

    static public Complex division(Complex dividend, Complex divider) throws Exception {
        Complex associated = divider.getAssociated();
        return Complex.divisionByReal(
                Complex.multiplication(dividend, associated),
                Complex.multiplication(divider, associated)
        );
    }

//    private Complex getConjugate() {
//        Complex complex = new Complex();
//    }

//    public void division(Complex another) {
//        // a = r1 + i1*i // b = r2 + i2*i
//        // result = a * b = (r1 + i1*i) * (r2 + i2*i)
//        // result = (r1 * r2 - i1 * i2) + (r1 * i2 + i1 * r2)*i
//        double r1 = this.real_part, i1 = this.imaginary_part;
//        double r2 = another.real_part, i2 = another.imaginary_part;
//        Complex conjugate = new Complex(r2, -i2);
//    }

    //    private Complex(Complex another){
//        System.out.println("hello");
//    }

//    public String toString()

}
