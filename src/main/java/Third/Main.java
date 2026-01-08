package Third;

public class Main {
    public static void main(String[] args){
        sinX sinX = new sinX(0, 2*Math.PI);
        cosX cosX = new cosX(0, 2*Math.PI);

        Function function = new Sum(sinX, cosX);

        for (double i = 0; i < 2*Math.PI; i+=0.1){
            System.out.println(function.apply(i));
        }
    }
}
