package Fifth;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) throws IOException {
        double[] array = {1, 2, 4, 6, 7, 8, 9, 0};
        try (FileInputStream fileInputStream = new FileInputStream(new File(args[0]))){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            array = (double[]) objectInputStream.readObject();
            System.out.println(Arrays.toString(array));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try(FileOutputStream fileOutputStream = new FileOutputStream(new File(args[1]))){
            Arrays.sort(array);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(array);
        }
    }
}
