package First;

import Second.MatrixT;

import java.util.ArrayList;
import java.util.Scanner;

public class souts {
    public static void main(String[] args){
        if (args.length == 0){
            System.out.println("Не было введено ни одного значения");
            return;
        }
        try{
            ArrayList<Double> arrayList = new ArrayList<>();
            double sum = 0.0;
            for (var el: args){
                double boof;
                boof = Double.parseDouble(el);
                arrayList.add(boof);
                sum+= boof;
            }
            System.out.println(sum/=arrayList.size());
            System.out.println(arrayList.stream().min(Double::compare));
            System.out.println(arrayList.stream().max(Double::compare));
        } catch(Exception e){
            System.out.println("Произошла ошибка при попытке обработать введённые числа");
            e.printStackTrace();
        }
    }
}


