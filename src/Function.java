class Function {
    public double f(double x) {
        return x;
    }
    public String coordinateInfo(double x, double y) {
        if (f(x) == y){
            return "The coordinate is on the graph!";
        } else {
            return "The coordinate is NOT on the graph!";
        }
    }
}