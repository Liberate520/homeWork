package homeWork.Shop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
    public static void toFileExtraction(ArrayList<Constructor> myQueue) {
        String data = "Все элементы\n" + "--------------------------------" + "\n\n";

        for (Constructor item : myQueue) {
            data += item;
            data += "\n";
        }

        try {
            FileWriter fileWriter = new FileWriter("shop.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(data);

            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
