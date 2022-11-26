package HW2;

import java.io.File;
import static HW2.HW2_Task1.dirScanner;//использую метод получения списка файлов в папке из прошлого задания.

public class HW2_Task2 {
    public static String fileGetExt (String fileName){
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }
    public static void main(String[] args) {
        String[] list = dirScanner("E:\\переводы");
        for (int i = 0; i < list.length; i++) {
            System.out.println("Расширение файла:" + fileGetExt(list[i]));
        }


    }
}
