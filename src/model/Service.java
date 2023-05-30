package model;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import files.Writable;
import model.human.Gender;
import model.human.Human;
import model.tree.FamilyTree;


public class Service implements Serializable {    
    private FamilyTree<Human> activeTree;
    private List<FamilyTree<Human>> familyTreeList;
    public int id;        
    Writable writable;



    public Service(FamilyTree<Human> tree) {
        this.activeTree = tree;
        familyTreeList = new ArrayList<>();
        familyTreeList.add(tree);
    }
    public Service(){
        this(new FamilyTree<Human>());
    }

    public void addFamilyTree(FamilyTree<Human> familyTree){
        familyTreeList.add(familyTree);
    }

    public void addHuman(int id, String name, String surname, String dateOfBirth, Gender gender) {
        activeTree.addHuman(new Human(id++, name, surname, dateOfBirth, gender));
    }
    
    public void sortByName() {
        activeTree.sortByName();
    }

    public void sortById() {
        activeTree.sortById();
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Human human : activeTree) {
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }
    
    public String getTree() {
        return activeTree.toString();
    }
    
    public void save() {
        writable.save(activeTree);
    }

    public void read() {
        writable.read();
        // FileHandler fileHandler = new FileHandler();
        // fileHandler.read(filePath);
    }

    
    

}