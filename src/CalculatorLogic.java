import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorLogic {
    private int degree = 0;
    private double x = 0;
    private double a = 0;
    private Graph grapher = new Graph(50);
    private boolean again = true;
    private String answer = "";
    String dimension = "";
    Scanner scan = new Scanner(System.in);

    public CalculatorLogic() { }

    /**
     * Utility function to return a specific double in a String at an index. 
     * <p>
     * PRECONDITION: <code>str</code> has variables in the format <code>n1,n2,n3...</code> 
     * and index does not exceed c-1 where c is the number of commas in the string
     * @param str String to parse doubles from
     * @param num Index of double
     * @return Double in the String
     */
    private double parseDouble(String str, int index) {
        String currStr = str;
        int i = 0;
        // stub method
        return 0;
    }
    public void start() {

        System.out.println("Welcome to Polynomial Grapher!");
        System.out.println("Would you like to input a standard function or a factored function? (s/f)");

        if (scan.nextLine().equals("s")){

            System.out.print("Input the degree of the polynomial you would like to use: ");
            degree = scan.nextInt();

            System.out.println("Input the coefficients of the function from x^" + degree + " to x^0: ");
            ArrayList<Double> coefficients = new ArrayList<Double>();

            for (int i = 0; i <= degree; i++) {
                coefficients.add(scan.nextDouble());
            }
            
            StandardFunction standardFunc = new StandardFunction(degree, coefficients);
            System.out.println("Your equation is " + standardFunc.getEquation());
            System.out.print("What dimension should your square graph be(Enter one INTEGER from 20-50): ");
            //ASSUME THAT THE USER INPUTS AN INTEGER

            Graph graph = new Graph(scan.nextInt());
            graph.graphFunction(standardFunc);
            System.out.print("Enter a value of x as a double: ");
            x = scan.nextDouble();
            System.out.println("At " + x + ", " + standardFunc.getEquation() + " is " + standardFunc.f(x));
            
            while (again != false){
                System.out.println("Would you like to input another value of x as a double? (y/n)");
                scan.nextLine();
                answer = scan.nextLine();
                if (answer.equals("n")){
                    again = false;
                    break;
                } else {
                    System.out.println("");
                    System.out.println("Enter a value of x as a double: ");
                    x = scan.nextDouble();
                    System.out.println("At " + x + ", " + standardFunc.getEquation() + " is " + standardFunc.f(x));
                }
            }
            System.out.println("Thanks for using the Polynomial Grapher! Run again for another polynomial.");

        } else {
            System.out.print("Enter the 'a' value in a(x-h)(x-k): ");
            a = scan.nextDouble();

            System.out.print("Input the degree of the polynomial you would like to use: ");
            degree = scan.nextInt();

            System.out.print("Enter the zeroes of your factored function...(ex: (x-6). The zero is 6. Or (x+4). The zero is -4): ");
            ArrayList<Double> zeroes = new ArrayList<Double>();

            for (int i = 0; i < degree; i++){
                zeroes.add(scan.nextDouble());
            }

            FactoredFunction factoredFunc = new FactoredFunction(degree, a, zeroes);
            System.out.println("Your equation is " + factoredFunc.getEquation());
            System.out.println("What dimension should your square graph be(Enter one INTEGER from 20-50): ");


            Graph graph = new Graph(scan.nextInt());
            graph.graphFunction(factoredFunc);
            System.out.print("Enter a value of x as a double: ");
            x = scan.nextDouble();
            System.out.println("At " + x + ", " + factoredFunc.getEquation() + " is " + factoredFunc.f(x));
            while (again != false){
                System.out.println("Would you like to input another value of x as a double? (y/n)");
                scan.nextLine();
                answer = scan.nextLine();
                if (answer.equals("n")){
                    System.out.println("");                    
                    again = false;
                    break;
                } else {
                    System.out.println("Enter a value of x as a double: ");
                    x = scan.nextDouble();
                    System.out.println("At " + x + ", " + factoredFunc.getEquation() + " is " + factoredFunc.f(x));
                }
            }
        }

    }
}