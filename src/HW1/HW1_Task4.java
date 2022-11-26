package HW1;

import java.util.Scanner;

public class HW1_Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input n: ");
        int n = in.nextInt();
        double tiangleNum = 0.5  * n * (n+1);
        System.out.print("Треугольное число "+n+" порядка: "+tiangleNum);
        in.close();
    }
}
