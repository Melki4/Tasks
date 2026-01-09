package Fourteenth;

public enum Singleton {
    INSTANCE;
    private double value = 0.0;

    public double getValue(){
        return value;
    }

    public void setValue(double value){
        this.value = value;
    }

    public void add(double value){
        this.value+=value;
    }

    public void multiply(double value){
        this.value*=value;
    }

    public static void main(String[] args) {

        Singleton singleton = Singleton.INSTANCE;
        singleton.add(1);
        System.out.println(singleton);
        System.out.println(Singleton.INSTANCE);
        System.out.println(singleton.getValue());
    }
}
