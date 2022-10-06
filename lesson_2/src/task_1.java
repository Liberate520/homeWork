import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Напишите метод, который вернет содержимое текущей папки в виде массива строк.
// Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
// Обработайте ошибки с помощью try-catch конструкции. В случае возникновения исключения, 
// оно должно записаться в лог-файл. (используйте метод list класса File)

public class task_1 {
    public static void main(String[] args) {
        writeDataToFile(getFilesOfCurrentWorkingDirectory());

    }

    public static String[] getFilesOfCurrentWorkingDirectory() {
        try {
            File f = new File(System.getProperty("user.dir"));
            String[] files = f.list();
            return files;
        } catch (Exception e) {
            writeLogToFile(e.getMessage());
            return null;
        }
    }

    private static void writeDataToFile(String[] data) {
        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/file.txt");
            File file = new File(pathFile);
            if (file.createNewFile()) {
                System.out.println("file.created");
            } else {
                System.out.println("file.existed");
            }
            FileWriter writer = new FileWriter(file);
            int size = data.length;
            for (int i = 0; i < size; i++) {
                String str = data[i];
                writer.write(str);
                if (i < size - 1) {
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (IOException ex) {
            writeLogToFile(ex.getMessage());
        }
    }

    private static void writeLogToFile(String log) {
        try {
            String pathFile = System.getProperty("user.dir").concat("/logs.txt");
            File logs = new File(pathFile);
            if (logs.createNewFile()) {
                System.out.println("logs.created");
            } else {
                System.out.println("logs.existed");
            }
            try (FileWriter fw = new FileWriter(pathFile, false)) {
                fw.write(log);
                fw.flush();
            }
        } catch (Exception e) {
            System.out.println("catch");
        }
    }
}
