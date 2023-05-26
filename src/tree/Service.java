package tree;

import tree.human.Gender;
import tree.human.Human;
import tree.fileHandler.Writable;

public class Service {
    private FamilyTree<Human> humanFamilyTree;
    private String filePath;
    private Writable writable;

    public Service(Writable writable) {
        filePath = "src/tree/familyTreeFile.txt";
        this.writable = writable;
        try {
            humanFamilyTree = (FamilyTree<Human>) writable.read(filePath);
        } catch (Exception e) {
            humanFamilyTree = new FamilyTree<>();
            writable.save(humanFamilyTree, filePath);
        }
    }

    public void addHuman(String gender, String name, Integer age) {
        Human human = new Human(Gender.valueOf(gender), name, age);
        humanFamilyTree.addHuman(human);
    }

    public void addChild(String human1, String human2){
        getHumanByName(human1).addChild(getHumanByName(human2));
    }

    public String getHumanList() {
        return humanFamilyTree.getInfo();
    }

    public void saveChanges() {
        writable.save(humanFamilyTree, filePath);
    }

    public Human getHumanByName(String name){
        for (Human human: humanFamilyTree){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }
}
