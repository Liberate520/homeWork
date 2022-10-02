// *+Задано уравнение вида q + w = e, q, w, e >= 0. 
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
// Требуется восстановить выражение до верного равенства. 
// Предложить хотя бы одно решение или сообщить, что его нет.

//Предположу что на вход дается строка в формате, как указано в условии
/**
 * task_5
 */
import java.util.Scanner;
import java.util.Arrays;

public class task_5 {

    private static int[] num3s;

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Input equation");
        String eq = iScanner.nextLine();
        char[] equation = eq.toCharArray();
        int equat_len = equation.length;
        iScanner.close();
        int num1_len = 0;
        int num2_len = 0;
        int num3_len = 0;
        for (int i = 0; i < equat_len; i++) {
            if (equation[i] == '+') {
                num1_len = i - 1;
            } else if (equation[i] == '=') {
                num2_len = i - num1_len - 4;
                num3_len = equat_len - i - 2;
            }
        }
        int[] num3 = new int[] {};
        // тестирую строками ниже
        System.out.println(equation);
        System.out.println(equat_len - num3_len);
        System.out.println(num3);
        System.out.println(num3_len);
        System.arraycopy(equation, equat_len - num3_len, num3, 0, num3_len);
        // этим шагом я хочу скопировать "число" в отдельный массив, что-то идет не по
        // плану

        num3_len = num3.length;

        for (int i = 0; i < num3_len; i++) {

        }
        System.out.println(Arrays.toString(num3s));
        System.out.println(num3_len);
        // System.out.println(Arrays.toString(num1));
        // System.out.println(num1_len);
        // System.out.println(Arrays.toString(num2));
        // System.out.println(num2_len);
    }
}