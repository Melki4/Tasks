package Fourth;

import java.io.File;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args){
        if (args.length<2){
            System.out.println("Было передано недостаточно аргументов");
            return;
        } else if(args[0].length() > 1){
            System.out.println("Был передан не символ");
            return;
        }
        try (Scanner scanner = new Scanner(new File(args[1]))){
            char symb = args[0].charAt(0);
            int amount = 0;
            while (scanner.hasNextLine()){
                String boof = scanner.nextLine();
                amount+= (int) boof.chars().filter(c -> c == symb).count();
            }
            System.out.println(amount);
        } catch (Exception e) {
            System.out.println("Произошла ошибка чтения файла");
            e.printStackTrace();
        }
    }
}
