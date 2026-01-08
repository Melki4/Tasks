package Third;

public class Sum implements Function {
    Function function1;
    Function function2;

    public Sum(Function first, Function second){
        if(first.getLeftBoarder()!=second.getLeftBoarder() ||
        first.getRightBoarder()!=second.getRightBoarder()) throw new IllegalArgumentException("У функций разные" +
                " области определения");

        function1 = first;
        function2 = second;
    }

    @Override
    public double getLeftBoarder() {
        return function1.getLeftBoarder();
    }

    @Override
    public double getRightBoarder() {
        return function2.getRightBoarder();
    }

    public double apply(double x){
        return function1.apply(x) + function2.apply(x);
    }
}
