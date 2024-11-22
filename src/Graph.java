import java.util.ArrayList;

public class Graph {
    private int size;

    /*
    * 20 x 20
     * ArrayList<String>
     * "--------------.----------------"
     * "--------------.----------------"
     * "-#------------.----------------"
     * "--------------.----------------"
     * "#-------------.----------------"
     * "--------------.----------------"
     * "--------------.----------------"
     * "--------------.----------------"
     * f(-10)
     * f(-9)
     * f(-8)
     * 
     * "
     * 
     * 
     * 
     * "
     * 
     * "
     * 
     * 
     * A[0] ""
     * A[1] ""
     * A[2] ""
     * "
     * 
     * For loop, int i = start, i <= end, i++
     * 1. Calculate f(i)
     * 2. Find the closest row in the array A string f(i) is in (call this m) (Math.round)
     * 3. For loop iterating over A
     * 4. If j = m, A[j] += '#'
     * else, A[j] += ' '
     * 
     */
    public Graph(int s) {
        size = s;
    }

    public void graphFunction(StandardFunction sf) {
        ArrayList<String> graphLines = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            graphLines.add("");
        }
        int offset = size / 2;

        for (int x = 0; x < size; x++) {
            
            int actualX = x - offset;
            int fx = (int) Math.round(sf.f(actualX));
            int lastFX = (int) Math.round(sf.f(actualX - 1));
            int nextFX = (int) Math.round(sf.f(actualX + 1));
            for (int y = 0; y < size; y++) {
                int actualY = y - offset;
                String chr = "";
                if (actualY == fx) {
                    if (actualY == 0) {
                        chr = "0";
                    } else if (actualX == 0) {
                        chr = "*";
                    } else {
                        chr = "#";
                    }
                } else if ((lastFX < actualY && actualY < nextFX) || (nextFX < actualY && actualY < lastFX)) {
                    System.out.println(actualX + ", graph x=" + x + ": " + lastFX + " < " + actualY + " < " + nextFX);
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
    public void graphFunction(FactoredFunction ff) {
        ArrayList<String> graphLines = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            graphLines.add("");
        }
        int offset = size / 2;

        for (int x = 0; x < size; x++) {
            
            int actualX = x - offset;
            int fx = (int) Math.round(ff.f(actualX));
            int lastFX = (int) Math.round(ff.f(actualX - 1));
            int nextFX = (int) Math.round(ff.f(actualX + 1));
            for (int y = 0; y < size; y++) {
                int actualY = y - offset;
                String chr = "";
                if (actualY == fx) {
                    if (actualY == 0) {
                        chr = "0";
                    } else if (actualX == 0) {
                        chr = "*";
                    } else {
                        chr = "#";
                    }
                } else if ((lastFX < actualY && actualY < nextFX) || (nextFX < actualY && actualY < lastFX)) {
                    System.out.println(actualX + ", graph x=" + x + ": " + lastFX + " < " + actualY + " < " + nextFX);
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
    public int getSize() {
        return size;
    }
    public void setSize(int s) {
        size = s;
    } 
        
}
