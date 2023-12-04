package my_family_tree.model.service;

import my_family_tree.model.builder.HumanBuilder;
import my_family_tree.model.human.Gender;
import my_family_tree.model.human.Human;
import my_family_tree.model.tree.FamilyTree;
import my_family_tree.model.writer.FileHandler;


import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> tree;
    private HumanBuilder builder;


    public Service(){
        tree = new FamilyTree<>();
        builder = new HumanBuilder();
    }

    public Human addHumanToTheFamily(String name, Gender gender, LocalDate birthDay){
        Human human = builder.build(name, gender, birthDay);
        tree.addToTheTree(human);
        return human;
    }

    public String getTreeInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Члены семьи: ").append("\n");
        for (Human human : tree) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getTreeInfo();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    public void sortByYear(){
        tree.sortByYear();
    }

    public void addParents(int par, int chil){
            Human child = tree.findById(chil);
            Human parent = tree.findById(par);
            child.addParents(parent);
            parent.addChildren(child);

    }

    public void wedding(int spouse1, int spouse2){
        tree.wedding(spouse1, spouse2);
    }

    public void load(){
        String filePath = "src/my_family_tree/model/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        tree = (FamilyTree) fileHandler.read(filePath);
    }

    public void save() {
        String filePath = "src/my_family_tree/model/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
    }

    public void setDeathDate(int iD, LocalDate deathday) {
        Human human = tree.findById(iD);
        human.setDeathDay(deathday);
    }

    public boolean checkId(int id) {
       return tree.checkId(id);
    }
}
