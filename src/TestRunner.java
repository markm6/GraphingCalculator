import java.util.ArrayList;

public class TestRunner {
    public static void main(String[] args) {
        ArrayList<Double> factors = new ArrayList<Double>();
        factors.add(Double.valueOf(-2));
        factors.add(Double.valueOf(17));
        factors.add(Double.valueOf(-10));
        FactoredFunction f = new FactoredFunction(0.01, factors);
        Graph g = new Graph(50);
        g.graphFunction(f);
    }
}