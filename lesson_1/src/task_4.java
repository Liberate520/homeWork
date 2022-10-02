// Вычислить n-ое треугольное число
public class task_4 {
    public static void main(String[] args) {
        int n = 1000;
        System.out.println(triangle(n));
    }

    static int triangle(int n) {
        if (n == 1) {
            return 1;
        }
        return triangle(n - 1) + n;
    }
}
