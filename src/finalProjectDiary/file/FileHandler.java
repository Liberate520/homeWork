package homeWork.src.finalProjectDiary.file;

import java.io.*;

public class FileHandler implements Writable, Serializable {

    private String filename;

    public FileHandler() {
//        имя файла по умолчанию. определяем в пустом конструкторе
        this.filename = "calendar.dat";
    }

    //    в будущем в клиентском коде можно определять другой файл
    public void setFilename(String filename) {
        this.filename = filename;
    }


    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            System.out.printf("Diary save in %s\n", filename);
            oos.writeObject(serializable);
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return ois.readObject();
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так");
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
