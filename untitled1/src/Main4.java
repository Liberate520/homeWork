//Задание4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите текст: ");
        try {
            String result = reader.readLine();
            if(result.replace("\t", "").replace(" ", "").equals("")) throw new RuntimeException("Пустую строку вводить нельзя!");
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
