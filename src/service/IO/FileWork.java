package service.IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWork implements IO {
    @Override
    public <E> void toFile(E element, String path) {
        File saveFile = new File(path);
        if (saveFile.canRead()) {
            System.out.println("File exists");
            try {
                FileWriter writer = new FileWriter(saveFile);
                writer.write(element.toString());
                writer.flush();
                writer.close();
                System.out.println("Saved successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found! Can`t write");
        }
    }

    @Override
    public Object fromFile(String path) {
        StringBuilder results = new StringBuilder();
        File loadFile = new File(path);
        if (loadFile.canRead()) {
            try {
                FileReader reader = new FileReader(loadFile);
                Scanner scan = new Scanner(reader);
                while (scan.hasNext()) {
                    results.append(scan.nextLine()).append("\n");
                }
                return results;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found!");
        }
        return null;
    }
}
