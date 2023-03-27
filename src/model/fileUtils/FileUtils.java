package model.fileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс со статическими методами для работы с файлами
 */
public class FileUtils {

    public static List<String> read(String filePath) throws IOException {
        List<String> data = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line);
            }
        }
        return data;
    }

    public static void write(String filePath, List<String> content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            for (String line : content) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }

    public static void createFile(String filePath) throws IOException{
        File file = new File(filePath);

        if (file.exists()) {
            throw new IOException("ОШИБКА: Файл с таким именем уже существует.");
        }

        boolean created = file.createNewFile();

        if (!created) {
            throw new IOException("ОШИБКА: Не удалось создать файл.");
        }
    }

    public static void createFolder(String folderPath) throws IOException{
        File folder = new File(folderPath);

        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                throw new IOException("ОШИБКА: Не удалось создать папку.");
            }
        }
    }

    public static List<String> getAllFilesNames(String folderPath, String extension) {
        ArrayList<String> filesNames = new ArrayList<>();
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory() && folder.listFiles() != null) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(extension)) {
                        filesNames.add(file.getName());
                    }
                }
            }
        }

        return filesNames;
    }
}
