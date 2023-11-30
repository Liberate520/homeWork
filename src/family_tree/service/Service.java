package family_tree.service;

import family_tree.model.tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.writer.FileHandler;

import java.time.LocalDate;

public class Service{
    private FamilyTree<Human> tree;
    private FileHandler fileHandler;
    private FileExists fileExist;
    private String filePath = "src/family_tree/model/writer/tree.txt";

    public Service() {
        tree = new FamilyTree<>();
        fileHandler = new FileHandler();
        fileExist = new FileExists();
    }

    public String printFamilyTree(){
        return tree.getData();
    }

    public void addHuman(String name,Gender gender, LocalDate birth, LocalDate death, Object parentM, Object parentF){
        Human human = new Human(name,gender, birth,death,null,null);
        tree.add(human);
    }
    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    public FamilyTree<Human> loadFamilyTree() {
          if (fileExist.isFileExists(filePath)) {
            return tree = (FamilyTree) fileHandler.read(filePath);
        } else {
            return null;
        }
    }

    public void saveFamilyTree() {
        fileHandler.save(tree,filePath);
    }

    public void addParentGlobal(long human_id, long parent_id) {
        Human human = tree.getById(human_id);
        Human parent = tree.getById(parent_id);
        human.addParent(parent);
        parent.addKid(human);
    }
}
