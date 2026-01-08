package Third;

public class sinX extends trigonometricFunctions {
    @Override
    public double apply(double x) {
        double varr = Math.sin(x);
        return varr * varr;
    }

    public sinX(double l, double r){
        left = l;
        right = r;
    }
}
