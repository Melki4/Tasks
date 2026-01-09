package Twelve;

import java.io.Serial;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Massive implements Serializable, Iterable<Double> {
    @Serial
    private static final long serialVersionUID = -7131329050405082864L;

    private double[] array;

    public Massive(int size){
        array = new double[size];
    }

    public double get(int number){
        return array[number-1];
    }

    public void set(int number, double value){
        array[number - 1] = value;
    }

    public int size(){
        return array.length;
    }

    @Override
    public Iterator<Double> iterator() {
        return new Iterator<>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < array.length;
            }

            @Override
            public Double next() {
                if (!hasNext()){
                    throw new NoSuchElementException("Элементов не осталось");}
                return array[i++];
            }
        };
    }

    public static void main(String[] args) {
        // Создание массива
        Massive massive = new Massive(3);

        // Заполнение значений
        massive.set(1, 10.5);
        massive.set(2, 20.7);
        massive.set(3, 30.9);

        // Проверка get()
        System.out.println("Элемент 2: " + massive.get(2)); // 20.7

        // Проверка size()
        System.out.println("Длина: " + massive.size()); // 3

        // Проверка for-each (основное требование)
        System.out.println("\nВсе элементы через for-each:");
        for (var value : massive) {
            System.out.println(value);
        }
        // Выведет: 10.5, 20.7, 30.9
    }
}
