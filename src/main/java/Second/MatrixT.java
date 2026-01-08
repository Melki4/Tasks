package Second;

public class MatrixT {
    private Object[] array;
    private final int h;
    private final int w;

    public MatrixT(int h, int w){
        if (h<=0 || w <=0) throw new IllegalArgumentException();
        array = new Object[h*w];
        this.h = h;
        this.w = w;
    }

    public int getHeight(){
        return h;
    }

    public int getWidth(){
        return w;
    }

    public Object get(int x, int y){
        return array[w * (x-1) + (y - 1)];
    }

    public void set(int x, int y, Object var){
        array[w * (x-1) + (y - 1)] = var;
    }

    static public MatrixT transpose(MatrixT matrixT){
        MatrixT boofed = new MatrixT(matrixT.h, matrixT.w);
        for (int i =1; i<= matrixT.h; i++){
            for (int j=1; j<= matrixT.w; ++j){
                Object boof = matrixT.get(i, j);
                boofed.set(j, i, boof);
            }
        }
        return boofed;
    }
}
