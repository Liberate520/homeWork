package family_Tree.service;

import family_Tree.familyTree.FamilyTree;
import family_Tree.builder.TreeBuilder;
import family_Tree.human.Gender;
import family_Tree.human.Human;
import family_Tree.writer.FileHandler;

import java.time.LocalDate;

public class Service {

    public FamilyTree<Human> tree;
    public TreeBuilder builder;

    public Service() {
        tree = new FamilyTree<>();
        builder = new TreeBuilder();
    }

    public void save(){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/family_Tree/writer/tree.txt";
        fileHandler.save(tree, filePath);
    }

    public void load(){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/family_Tree/writer/tree.txt";
        tree = (FamilyTree) fileHandler.read(filePath);
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    public void sortById(){
        tree.sortById();
    }

    public void addHuman(String name, LocalDate dateOfBirth, Gender gender){
        Human human = builder.buildHuman(name, dateOfBirth, gender);
        tree.addHuman(human);
    }

    public void generateTree(){
        tree = builder.generateTree();
    }

    public void printFullInfo() {
        System.out.println(tree.getInfo());
    }

    public void printHumanInfo(int id) {
        System.out.println(tree.getHumanInfo(id));
    }

    public void addChild(int parentId, int childId){
        tree.addChild(parentId, childId);
    }

    public void addParent(int humanId, int parentId){
        tree.addParent(humanId, parentId);
    }

    public Human findById(int id){
        return tree.findById(id);
    }

    public void setDeathDate(int id, LocalDate date){
        tree.setDeathDate(id, date);
    }
}
