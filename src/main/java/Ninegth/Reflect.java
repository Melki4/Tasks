package Ninegth;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflect {
    static public String[] getMethods(Object o){

        Class<?> clazz = o.getClass();

        Method[] str = clazz.getDeclaredMethods();

        String[] s = new String[str.length];

        int i = 0;
        for (var el : str) s[i++] = el.getName();

        return s;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Arrays.stream(Reflect.getMethods(new Student())).forEach(System.out::println);
    }
}
