package my_family_tree.service;

import my_family_tree.builder.HumanBuilder;
import my_family_tree.human.Gender;
import my_family_tree.human.Human;
import my_family_tree.tree.FamilyTree;

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
}
