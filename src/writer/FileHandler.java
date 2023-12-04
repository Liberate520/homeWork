package writer;

import java.io.*;

public class FileHandler implements Writable {

    /**
     * Метод записи указанных данных в указанный файл
     * (с автоматическим закрытием файла)
     *
     * @param serializable данные для записи в файл
     * @param file         ссылка на файл
     */
    public void write(Serializable serializable, String file) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод чтения данных из указанного файла
     * (с автоматическим закрытием файла)
     *
     * @param file ссылка на файл
     * @return данные из файла
     */
    public Object read(String file) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
