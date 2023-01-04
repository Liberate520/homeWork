// Задание 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        inPut();
    }

    public static void inPut(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите число: ");
        try{
            float fNumber = Float.parseFloat(reader.readLine().replace(",", "."));
            System.out.printf("Вы ввели число %f\n", fNumber);
        } catch (IOException | NumberFormatException e) {
            inPut();
        }
    }
}
