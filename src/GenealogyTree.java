import java.util.List;

public class GenealogyTree {
    private Person root;

    public GenealogyTree(Person root) {
        this.root = root;
    }

    public List<Person> getChildrenOfPerson(Person person) {
        return person.getChildren();
    }

    private FileIO fileIO;

    public GenealogyTree() {
        // Инициализируем fileIO соответствующим объектом, например, GenealogyFileIO
        this.fileIO = new GenealogyFileIO();
    }

    // Метод для сохранения дерева в файл
    public void saveToFile(String filePath) {
        fileIO.saveToFile(filePath, this);
    }

    // Метод для загрузки дерева из файла
    public static GenealogyTree loadFromFile(String filePath) {
        GenealogyFileIO genealogyFileIO = new GenealogyFileIO();
        return genealogyFileIO.loadFromFile(filePath);
    }
}
