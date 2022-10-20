package lesson1;

public class home4 {
    // Вычислить n-ое треугольное число
    public static void reorder(int n)
    {
        int tr = 0;
        for(int i = 0; i < n+1; i++) tr = (int)(Math.pow(i, 2) + i)/2;
        System.out.println(tr);
    }

    public static void main(String[] args) {
        int n = 4;
        reorder(n);
    }
}
