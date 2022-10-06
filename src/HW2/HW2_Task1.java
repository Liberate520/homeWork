package HW2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class HW2_Task1 {

    private static String[] dirScanner(String dirPath){
        String [] subsArray;
        var Dir = new File(dirPath);
        return subsArray = Dir.list();
    }

    private static void stringArrayToFile(String[] array){
        try {
            String path = "C:\\Users\\carna\\IdeaProjects\\GB_Java_homeWork\\src\\HW2\\test.txt";

            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(path));
            for (String str : array) {
                outputWriter.write(str);
                outputWriter.newLine();
            }
            outputWriter.flush();
            outputWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
    String[] list = dirScanner("E:\\переводы");
    stringArrayToFile(list);
    }
}
