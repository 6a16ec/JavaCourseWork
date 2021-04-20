package tk.semaev.complex;

public class Complex {
    private double real_part;
    private double imaginary_part;
    final static private double eps = 1e-6;

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

    static private Boolean isZero(double number) {
        return Math.abs(number) < eps;
    }

    @Override
    public String toString() {
        String result = "";
        if (!isZero(real_part) || isZero(imaginary_part)) {
            result += toString(real_part);
        }
        if (!isZero(imaginary_part)) {
            if (imaginary_part > 0) {
                if (!isZero(real_part)) {
                    result += " + ";
                }
            } else {
                if (!isZero(real_part)) {
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

    public void subtraction(Complex another) {
        this.real_part -= another.real_part;
        this.imaginary_part -= another.imaginary_part;
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

    public Complex getAssociated() {
        return new Complex(
                real_part,
                -imaginary_part
        );
    }


    public void divisionByReal(Complex divider) throws Exception {
        if (divider.isReal()) {
            if (!isZero(divider.real_part)) {
                this.real_part /= divider.real_part;
                this.imaginary_part /= divider.real_part;
            } else {
                throw new Exception("Division by zero");
            }
        } else {
            throw new Exception("The divider is not a real number");
        }
    }

    public void division(Complex divider) throws Exception {
        Complex associated = divider.getAssociated();
        this.multiplication(associated);
        divider.multiplication(associated);
        this.divisionByReal(divider);
    }

}
