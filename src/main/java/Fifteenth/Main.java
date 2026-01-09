package Fifteenth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class Main {
    public static void main(String[] args) throws Exception {
        // Минимальная проверка аргументов
        if (args.length == 0) {
            throw new IllegalArgumentException("Укажите URL как параметр");
        }

        // Используем try-with-resources
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(URI.create(args[0]).toURL().openStream()))) {

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
