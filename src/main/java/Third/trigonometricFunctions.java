package Third;

public abstract class trigonometricFunctions implements Function {
    protected double left;
    protected double right;

    @Override
    public double getLeftBoarder() {
        return left;
    }

    @Override
    public double getRightBoarder() {
        return right;
    }
}
