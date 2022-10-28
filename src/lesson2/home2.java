package lesson2;

import java.io.File;

public class home2 {

// Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида:
// 1 Расширение файла: txt
// 2 Расширение файла: pdf
// 3 Расширение файла:
// 4 Расширение файла: jpg

    public static void main(String[] args) {
        for (int j = 0; j < getFilesDirectory().length; j++) {
            System.out.printf("%d Расширение файла: %s\n", j + 1, getExtHandling(getFilesDirectory()[j]));
        }
    }

    public static String[] getFilesDirectory() {
        try {
            File f = new File(System.getProperty("user.dir"));
            String[] files = f.list();
            return files;
        } catch (Exception e) {
            return null;
        }
    }

    public static String getExtHandling(String filename) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < filename.toCharArray().length-1; i++) {
            if (filename.charAt(i) == '.' || count != 0) {
                count++;
                result.append(filename.charAt(i+1));
            }
        }
        return result.toString();
    }
}
