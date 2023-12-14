import model.file_handler.FileHandler;
import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.service.Service;
import view.Console;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args){
        //FamilyTree tree = load();
        FamilyTree<Human> tree = testTree();
        System.out.println(tree);
        save(tree);
    }

    private static void save(FamilyTree tree){
        String filePath = "src/model/file_handler/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree,filePath);
    }

    private static FamilyTree<Human> load(){
        String filePath = "src/model/file_handler/tree.txt";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }



    static FamilyTree<Human> testTree(){
        FamilyTree<Human> familyTree = new FamilyTree<>();
        Service service = new Service();
        Console console = new Console();
        console.start();
        return familyTree;




    }


}
