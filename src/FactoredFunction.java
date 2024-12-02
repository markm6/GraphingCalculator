import java.util.ArrayList;
public class FactoredFunction extends Function {
    private int degree;
    private ArrayList<Double> zeroes;
    private double aValue;

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
        String out = "";
        for (int i = 0; i < degree; i++) {
            out += "(x - )" + zeroes.get(i);
        }
       
        return out;
    }
}