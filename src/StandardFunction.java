import java.util.ArrayList;
public class StandardFunction {
    private int degree;
    private ArrayList<Double> coefficients;

    public StandardFunction(int degree, ArrayList<Double> coefficients) {
        this.degree = degree;
        this.coefficients = coefficients;
    }
// testing
    /* Returns f(x) for a given x */
    public double func(double x) {
        double sum = 0.0;
        for (int i = 0; i < coefficients.size(); i++) {
            double currentCoeff = coefficients.get(i);          // ex. 3x^2 + 7x + 5. Degree = 2. Coefficients = 3, 7, 5
            sum += currentCoeff * Math.pow(x, degree - i);
        }
        return sum;
    }

    // TODO: add equation function


}
