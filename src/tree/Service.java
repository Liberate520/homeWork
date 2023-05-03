package tree;

import tree.human.Cat;
import tree.human.Gender;
import tree.human.Human;
import tree.fileHandler.FileHandler;
import tree.fileHandler.Writable;

public class Service {
    private FamilyTree<Human> humanFamilyTree;
    private FamilyTree<Cat> catFamilyTree;
    private String filePath = "src/tree/familyTreeFile.txt";
    private Writable writable = new FileHandler();

    public Service() {
        try {
            humanFamilyTree = (FamilyTree<Human>) writable.read(filePath);
            System.out.println("Семейное дерево загружено");
        } catch (Exception e) {
            humanFamilyTree = new FamilyTree<>();
            writable.save(humanFamilyTree, filePath);
            System.out.println("Семейное дерево создано");
        }
    }

    public void addHuman(Gender gender, String name, Integer age) {
        Human human = new Human(gender, name, age);
        humanFamilyTree.addHuman(human);
    }

    public void addChild(Human human1, Human human2){
        human1.addChild(human2);
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
