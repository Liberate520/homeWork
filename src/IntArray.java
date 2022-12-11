import java.util.Random;

public class IntArray {
    private int size;
    private Integer [] array;

    public Integer [] getArray() {
        return array;
    }

    public IntArray(int size) {
        this.size = size;
        this.array = new Integer [size];
    }

    public void fill(){
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(10,250);
        }
    }


    @Override
    public String toString() {
        String res = "";
        for (int i : array) {
            res = res + i + ", ";
        }
        return res;
    }


}
