package service.IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
Класс для записи в .txt файл строки
 */
public class FileWork implements IO {
    @Override
    public <E> void toFile(E element, String path) throws IOException {
        System.out.println("File exists");
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(element.toString());
            writer.flush();
            writer.close();
            System.out.println("Saved successfully");
        }
    }

    @Override
    public Object fromFile(String path) throws IOException {
        StringBuilder results = new StringBuilder();
        try (FileReader reader = new FileReader(path)) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNext()) {
                results.append(scan.nextLine()).append("\n");
            }
            return results;
        }
    }
}
