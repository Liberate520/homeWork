package HW2;

import com.sun.tools.javac.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class HW2_Task1 {

    private static String[] dirScanner(String dirPath) {

        Logger logger = Logger.getLogger(Main.class.getName());
        FileHandler handler = null;
        try {
            handler = new FileHandler("log.txt",true);
        }catch (IOException exception){
            exception.printStackTrace();
        }
        var formatter = new SimpleFormatter();
        handler.setLevel(Level.INFO);
        handler.setFormatter(formatter);
        logger.addHandler(handler);

        String[] subsArray = new String[0];
        try {
            var Dir = new File(dirPath);
            subsArray = Dir.list();
        } catch (Exception e) {
            e.printStackTrace();
            logger.warning(e.getMessage());
        }

        return subsArray;
    }

    private static void stringArrayToFile(String[] array){
        Logger logger = Logger.getLogger(Main.class.getName());
        FileHandler handler = null;
        try {
            handler = new FileHandler("log.txt", true);
        }catch (IOException exception){
            exception.printStackTrace();
        }
        var formatter = new SimpleFormatter();
        handler.setLevel(Level.INFO);
        handler.setFormatter(formatter);
        logger.addHandler(handler);

        try {
            String path = "test.txt";

            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(path));
            for (String str : array) {
                outputWriter.write(str);
                outputWriter.newLine();
            }
            outputWriter.flush();
            outputWriter.close();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
    String[] list = dirScanner("E:\\переводы");
    stringArrayToFile(list);
    }
}
