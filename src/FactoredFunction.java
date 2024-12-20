import java.util.ArrayList;
public class FactoredFunction extends Function {
    private int degree;
    private ArrayList<Double> zeroes;
    private double aValue;
    /**
     * Instantiates a FactoredFunction object.
     * @param degree
     * @param aValue
     * @param zeroes
     * @author Mark Mikhail and Imran Zahid
     */
    public FactoredFunction(int degree, double aValue, ArrayList<Double> zeroes) {
        this.degree = degree;
        this.zeroes = zeroes;
        this.aValue = aValue;
    }
    public FactoredFunction(double aValue, ArrayList<Double> zeroes) {
        this.zeroes = zeroes;
        this.aValue = aValue;
        this.degree = zeroes.size();
    }

    private boolean isInteger(double x) {
        return Math.rint(x) == x;
    }

    /* Returns f(x) for a given x */
    public double f(double x) {
        double product = aValue;
        for (int i = 0; i < degree; i++) {
            double currentZero = zeroes.get(i);
            product *= (x - currentZero);
        }
        return product;
    }
    
    public String getEquation() {
        String out = "f(x) = ";
        if (isInteger(aValue)) {
            out += (int) Math.rint(aValue);
        } else {
            out += aValue;
        }
        for (int i = 0; i < degree; i++) {
            double currentZero = zeroes.get(i);
            String sign;
            if (currentZero < 0) {
                sign = "+";
            } else if (currentZero > 0) {
                sign = "-";
            } else {
                sign = "";
            }
            if (isInteger(currentZero)) {
                if (currentZero != 0) {
                    out += "(x " + sign + " " + ((int) Math.abs(currentZero)) + ")";
                } else {
                    out += "(x)";
                }
            } else {
                out += "(x " + sign + " (" + Math.abs(currentZero) + ")";
            }
        }
       
        return out;
    }
    public String info() {
        String str = "Function f(x) = " + getEquation();
        str += "\nDegree: " + degree;
        str += "\nZeroes: ";
        for (int i = 0; i < zeroes.size(); i++) {
            str += "(" + zeroes.get(i) + ", 0)";
            if (i < zeroes.size() - 1) {
                str += ", ";
            }
        }
        str += "\nY-intercept: " + f(0);
        return str;
    }

}