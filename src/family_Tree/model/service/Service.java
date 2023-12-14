package family_Tree.model.service;

import family_Tree.model.familyTree.FamilyTree;
import family_Tree.model.builder.TreeBuilder;
import family_Tree.model.human.Gender;
import family_Tree.model.human.Human;
import family_Tree.model.writer.Writable;

import java.time.LocalDate;

public class Service {

    private FamilyTree<Human> tree;
    private TreeBuilder builder;
    Writable writable;

    public Service() {
        tree = new FamilyTree<>();
        builder = new TreeBuilder();
    }

    public void save(){
        writable.save(tree);
    }

    public void load(){
        tree = (FamilyTree) writable.read();
    }
    public void setWritable(Writable writable) {
        this.writable = writable;
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

    public String printFullInfo() {
        return tree.getInfo();
    }

    public String printHumanInfo(int id) {
        return tree.getHumanInfo(id);
    }

    public void addChild(int parentId, int childId){
        tree.addChild(parentId, childId);
    }

    public void addParent(int humanId, int parentId){
        tree.addParent(humanId, parentId);
    }

    public boolean findById(int id){
        return tree.findById(id) != null;
    }

    public void setDeathDate(int id, LocalDate date){
        tree.setDeathDate(id, date);
    }
}
