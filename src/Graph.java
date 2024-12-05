import java.util.ArrayList;
/**
 * Prints graphs of functions.
 * @author Mark Mikhail
 * @author Imran Zahid
 */
public class Graph {
    /** Size of each side of the graph */
    private int size;

    /**
     * Instantiates a Graph.
     * @param size Size of each side of the graph
     */
    public Graph(int size) {
        this.size = size;
    }

    /**
     *
     * Prints a graph of function <code>func</code>.
     * <p>
     * PRECONDITION: <code>func</code> is defined at all input values/x-values within the printed graph's boundaries.
     * @param func Function to graph
     */
    public void graphFunction(Function func) {
        ArrayList<String> graphLines = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            graphLines.add("");
        }
        int offset = size / 2;

        for (int x = 0; x < size; x++) {

            int actualX = x - offset;
            int fx = (int) Math.round(func.f(actualX));
            int lastFX = (int) Math.round(func.f(actualX - 1));
            int nextFX = (int) Math.round(func.f(actualX + 1));
            for (int y = 0; y < size; y++) {
                int actualY = y - offset;
                String chr;
                if (actualY == fx) {
                    if (actualY == 0) {
                        chr = "0";
                    } else if (actualX == 0) {
                        chr = "*";
                    } else {
                        chr = "#";
                    }
                } else if ((lastFX < actualY && actualY < nextFX)
                        || (nextFX < actualY && actualY < lastFX)) {
                    chr = "#";
                } else {
                    if (actualY == 0) {
                        chr = "-";
                    } else if (actualX == 0) {
                        chr = "|";
                    } else {
                        chr = " ";
                    }
                }
                graphLines.set(y, graphLines.get(y) + chr);
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println(graphLines.get(i));
        }

    }
    /**
     * Gets the size instance variable of the Graph object.
     * @return Size of each side of the graph
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size instance variable of the Graph object.
     * @param s Integer size to set
     */
    public void setSize(int s) {
        size = s;
    }

    /**
     * Sets the size instance variable of the Graph object.
     * @param s Double size to set that will be rounded to the nearest integer
     */
    public void setSize(double s) {
        size = (int) Math.round(s);
    }

}
