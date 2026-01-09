package Tength;

import java.util.Arrays;

public class Generic<T extends Number> {
    T[] array;

    public Generic(T[] array){
        this.array = array;
    }

    double max(){
        return  Arrays.stream(array)
                .mapToDouble(Number::doubleValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Массив пустой"));
    }

    double min(){
        return  Arrays.stream(array)
                .mapToDouble(Number::doubleValue)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("Массив пустой"));
    }

    public static void main(String[] args){
        Byte[] array = {12, 11, 9, 1, 2 ,3 ,4 ,5};
        Generic<Byte> arat = new Generic<>(array);
        System.out.println(arat.max());
        System.out.println(arat.min());
    }
}
