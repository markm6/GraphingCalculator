import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> coeffs = new ArrayList<Double>();
        coeffs.add(Double.valueOf(1));
        coeffs.add(Double.valueOf(-5));
        coeffs.add(Double.valueOf(-1));
        StandardFunction f = new StandardFunction(2, coeffs);
        Graph g = new Graph(20);
        g.graphFunction(f);
    }
}