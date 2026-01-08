package Sixth;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        double left = Double.parseDouble(args[2]);
        double right = Double.parseDouble(args[3]);

        try( FileOutputStream fileWriter = new FileOutputStream(args[4])){
            DataOutputStream dataOutputStream = new DataOutputStream(fileWriter);

            dataOutputStream.writeInt(height);
            dataOutputStream.writeInt(width);

            Random random = new Random();
            for (int i = 0; i < height; ++i){
                for (int j = 0; j < width; ++j){
                    dataOutputStream.writeDouble(random.nextDouble() * (right - left) + left);
                }
            }
        }
        /* try (DataInputStream dis = new DataInputStream(new FileInputStream("output.bin"))) {
            int rows = dis.readInt();
            int cols = dis.readInt();
            System.out.println("Rows: " + rows + ", Cols: " + cols);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    double value = dis.readDouble();
                    System.out.printf("%.3f ", value);
                }
                System.out.println();
            }
        }*/
    }
}
