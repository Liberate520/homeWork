package Family_Tree.model.Service;

import Family_Tree.model.Writer.FileHandler;
import Family_Tree.model.Human.Human;
import Family_Tree.model.Human.Gender;
import Family_Tree.model.Tree.FamilyTree;
import Family_Tree.model.Writer.Save;
import Family_Tree.model.Writer.Writable;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> tree;
    private Writable<FamilyTree<Human>> storage;
    private int id;

    public boolean add(String name, LocalDate birthday, Gender gender) {
        Human human = new Human(name, birthday, gender);
        tree.add(human);
        return true;
    }


    public void sortByName(){
        tree.sortByName();
    }

    public void sortByBirthday(){
        tree.sortByBirthday();
    }
    public boolean read(String filePath){
        FamilyTree<Human> tmpTree = storage.read(filePath);
        if (tmpTree.equals(null)){
            return false;
        }
        tree = tmpTree;
        return true;
    }

    public boolean save(String fileName){
        return storage.write(tree, fileName);

    }

    public boolean checkId(int id){
        return tree.checkId(id);
    }

    public void addToParents(int humanId, int parentId) {
        Human human = tree.getId(id);
        human.getParents();
    }

}
