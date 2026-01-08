package Third;

public class cosX extends trigonometricFunctions{
    @Override
    public double apply(double x) {
        double varr = Math.cos(x);
        return varr * varr;
    }

    public cosX(double l, double r){
        left = l;
        right = r;
    }
}
