import java.util.ArrayList;
public class FactoredFunction {
    private int degree;
    private ArrayList<Double> zeroes;
    private double aValue;

    public FactoredFunction(int degree, double aValue, ArrayList<Double> zeroes) {
        this.degree = degree;
        this.zeroes = zeroes;
        this.aValue = aValue;
    }

    /* Returns f(x) for a given x */
    public double func(double x) {
        double product = aValue;
        for (int i = 0; i < zeroes.size(); i++) {
            double currentZero = zeroes.get(i);          // ex. 3x^2 + 7x + 5. Degree = 2. Coefficients = 3, 7, 5
            product *= (i - currentZero);
        }
        return product;
    }
    // TODO: add equation function
    public String getEquation() {
        String out = "";
        // add (x - zero) to the string out for each zero
        return out;
    }
}