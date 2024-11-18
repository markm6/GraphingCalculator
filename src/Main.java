import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> coeffs = new ArrayList<Double>();
        coeffs.add(Double.valueOf(3));
        coeffs.add(Double.valueOf(-23));
        coeffs.add(Double.valueOf(4));
        StandardFunction f = new StandardFunction(2, coeffs);
        System.out.println(f.func(8));
    }
}