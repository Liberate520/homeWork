package Model;

import Model.home_work_class.FamilyTree.FamilyTree;
import Model.home_work_class.FamilyTree.FileWriter;
import Model.home_work_class.Human.Gender;
import Model.home_work_class.Human.Human;

import java.time.LocalDate;
import java.util.ArrayList;

public class Model {
    private FamilyTree<Human> familyTree;

    public Model(){
        this.familyTree = new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate bornDate, LocalDate diedDate){
        Human human = new Human(name, gender, bornDate, diedDate);
        familyTree.addHuman(human);
    }

    public String getHumansListInfo(){
        return familyTree.showHumansList();
    }

    public boolean fileWriter(String path){
        FileWriter handler = new FileWriter();
        String filePath = handler.getDefaultPath();
        if (!path.isEmpty()) {filePath = path;}
        if (familyTree.sizeTree() > 0){
            handler.write(familyTree, filePath);
            return true;
        }
        return false;
    }

    public boolean fileReader(String path){
        FileWriter handler = new FileWriter();
        String filePath = handler.getDefaultPath();
        if (!path.isEmpty()) {filePath = path;}
        FamilyTree<Human> tree = handler.read(filePath);
        if (tree.sizeTree() > 0){
            familyTree = tree;
            return true;
        }
        return false;
    }

    public void sortByName(){familyTree.sortByName();}

    public void sortByAge(){familyTree.sortByAge();}

    public void sortById(){familyTree.sortById();}
}
