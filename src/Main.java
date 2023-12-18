import model.file_handler.FileHandler;
import model.family_tree.FamilyTree;
import model.human.Human;
import view.Console;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args){
        //FamilyTree tree = load();
        FamilyTree<Human> tree = testTree();
        System.out.println(tree);
    }

    public void save(FamilyTree familyTree){
        String filePath = "src/model/file_handler/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree,filePath);
    }

    public FamilyTree load(){
        String filePath = "src/model/file_handler/tree.txt";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }



    static FamilyTree<Human> testTree(){
        FamilyTree<Human> familyTree = new FamilyTree<>();
        Console console = new Console();
        console.start();
        return familyTree;




    }


}
