package family_tree;
import family_tree.model.file_handler.FileHandler;
import family_tree.view.Console;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Console console = new Console();
        FileHandler fileHandler = new FileHandler();
        console.loadFamilyTreeFromFile(fileHandler, "src/family_tree/model/saves/FamilyTree.txt");
        console.start();
    }
}
