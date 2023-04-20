import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;

public class Main {
    public static void main(String[] args) throws IOException{
        FamilyTree familyTree = new FamilyTree();

        familyTree.addHuman(new Human("Сабина", 1965, "f"));
        familyTree.addHuman(new Human("Сергей", 1959, "m"));
        familyTree.addHuman(new Human("Диана", 1989, "f"));
        familyTree.addHuman(new Human("Тимур", 1994, "m"));
        familyTree.addHuman(new Human("Томирис", 1987, "f"));

        System.out.println(familyTree.getHumanByName("Тимур"));
        System.out.println(familyTree.getAllHuman());

        // Сохраняем в файл
        FileHandlerWrapper fileHandlerWrapper = new FileHandlerWrapper(new FileHandler());
        try {
            fileHandlerWrapper.saveToFile(familyTree.getAllHuman(), "familyTree.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Загружаем из файла
        try {
            List<Human> loadedList = fileHandlerWrapper.loadFromFile("familyTree.dat");
            System.out.println(loadedList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}