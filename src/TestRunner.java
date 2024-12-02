import java.util.ArrayList;

public class TestRunner {
    public static void main(String[] args) {
        ArrayList<Double> coefficients = new ArrayList<Double>();
        coefficients.add(Double.valueOf(-0.5));
        coefficients.add(Double.valueOf(5));
        coefficients.add(Double.valueOf(-10));
        StandardFunction f = new StandardFunction(coefficients);
        System.out.println(f.getEquation());
        Graph g = new Graph(50);
        g.graphFunction(f);
    }
}