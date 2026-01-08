package Second;

import java.util.Scanner;

public class souts {
    public static void main(String[] args){
        MatrixT matrixT = new MatrixT(4, 4);
        Scanner scaner = new Scanner(System.in);
        for (int i =1; i<= 4; i++){
            for (int j=1; j<= 4; ++j){
                Object boof = scaner.next();
                matrixT.set(i, j, boof);
            }
        }
        MatrixT matrix = MatrixT.transpose(matrixT);

        for (int i = 1; i<= 4; i++){
            for (int j = 1; j<= 4; ++j){
                System.out.print((String)matrixT.get(i, j) + ' ');
            }
            System.out.print("\n");
        }
        for (int i =1; i<= 4; i++){
            for (int j=1; j<= 4; ++j){
                System.out.print((String)matrix.get(i, j) + ' ');
            }
            System.out.print("\n");
        }
    }
}


