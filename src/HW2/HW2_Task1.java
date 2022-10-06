package HW2;

import java.io.File;

public class HW2_Task1 {
    private static String[] dirScanner(String dirPath){
        String [] subsArray;
        var Dir = new File(dirPath);
        return subsArray = Dir.list();
    }
    public static void main(String[] args) {
    String[] list = dirScanner("E:\\переводы");
    }
}
