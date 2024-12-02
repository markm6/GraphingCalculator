import java.util.ArrayList;

public class Graph {
    private int size;
    public Graph(int size) {
        this.size = size;
    }

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
                String chr = "";
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
    public int getSize() {
        return size;
    }
    public void setSize(int s) {
        size = s;
    } 
        
}
