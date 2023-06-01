package trees;


import java.io.*;

/**
 * Класс, реализующий интерфейс Conservation для сохранения и загрузки семейного древа в файл.
 */
public class FamilyTreeRepository implements Conservation {

    private String filePath;

    /**
     * Конструктор класса FamilyTreeRepository.
     *
     * @param path путь к файлу для сохранения и загрузки семейного древа
     */
    public FamilyTreeRepository(String path) {
        this.filePath = path;
    }

    /**
     * Сохраняет семейное древо в файл.
     *
     * @param tree семейное древо для сохранения
     */
    @Override
    public void saveFile(FamilyTree tree) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(tree);
        } catch (IOException e) {
            System.out.println("Export error");
        }
    }

    /**
     * Загружает семейное древо из файла.
     *
     * @return загруженное семейное древо
     */
    @Override
    public FamilyTree loadFile() {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (FamilyTree) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error uploading file");
        }
        return null;
    }
}
