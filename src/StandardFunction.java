import java.util.ArrayList;
import java.util.Scanner;
public class StandardFunction extends Function {
    private int degree;
    private ArrayList<Double> coefficients;

    public StandardFunction(int degree, ArrayList<Double> coefficients) {
        this.degree = degree;
        this.coefficients = coefficients;
    }
    public StandardFunction(ArrayList<Double> coefficients) {
        this.degree = coefficients.size() - 1;
        this.coefficients = coefficients;
    }


    /* Returns f(x) for a given x */
    public double f(double x) {
        double sum = 0.0;
        for (int i = 0; i < coefficients.size(); i++) {
            double currentCoeff = coefficients.get(i);          // ex. 3x^2 + 7x + 5. Degree = 2. Coefficients = 3, 7, 5
            sum += currentCoeff * Math.pow(x, degree - i);
        }
        return sum;
    }

    public String getEquation() {
        String equation = "f(x) = ";
        for (int i = 0; i < coefficients.size(); i++) {
            double currentCoeff = Math.round(coefficients.get(i) * 100) / 100.0;
            double absCoeff = Math.abs(currentCoeff);
            boolean positive = coefficients.get(i) > 0;
            int exponent = degree - i;
            if (currentCoeff != 0) {
                String sign;
                if (positive) {
                    sign = "+";
                } else {
                    sign = "-";
                }

                // display as int if coefficient is an integer
                String strCoeff;
                if (absCoeff == Math.rint(absCoeff) && absCoeff == 1 && exponent > 0) {
                    strCoeff = "";
                } else if (absCoeff == Math.rint(absCoeff)) {
                    strCoeff = "" + ((int) absCoeff);
                } else {
                    strCoeff = "" + absCoeff;
                }

                if (exponent == 0) {
                    equation += sign + " " + strCoeff;
                } else if (exponent == 1) {
                    equation += sign + " " + strCoeff + "x" + " ";
                } else if (exponent == degree) {
                    equation += strCoeff + "x^" + degree + " ";
                } else {
                    equation += sign + " " + strCoeff + "x^" + exponent + " ";
                }
            }
        }
        return equation;
    }

    public String info() {
        String str = "Function f(x) = " + getEquation();
        str += "\nDegree: " + degree;
        // The y-intercept of a polynomial function is simply the constant, or, the last coefficient
        // Therefore, no calculation using f(x) is needed.
        str += "\nY-intercept: " + coefficients.get(coefficients.size() - 1);
        return str;
    }
}
