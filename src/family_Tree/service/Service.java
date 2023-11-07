package family_Tree.service;

import family_Tree.familyTree.FamilyTree;
import family_Tree.builder.TreeBuilder;
import family_Tree.human.Gender;
import family_Tree.human.Human;
import family_Tree.writer.FileHandler;

import java.time.LocalDate;

public class Service {

    public FamilyTree tree;
    public TreeBuilder builder;
    public Service() {
        tree = new FamilyTree();
        builder = new TreeBuilder();
    }

    public void save(){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/family_Tree/writer/tree.txt";
        fileHandler.save(tree, filePath);
    }

    public static FamilyTree load(){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/family_Tree/writer/tree.txt";
        return (FamilyTree) fileHandler.read(filePath);
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

    public void addHumanWithParents(String name, LocalDate dateOfBirth, Gender gender, Human mother, Human father){
        Human human = builder.buildHumanWithParents(name, dateOfBirth, gender, mother, father);
        tree.addHuman(human);
    }

    public void generateTree(){
        tree = builder.generateTree();
    }

    public void toPrint() {
        System.out.println(FamilyTree.getInfo());
    }
}