package fam_tree.valet;

import fam_tree.family_tree.FamilyTree;
import fam_tree.human.Gender;
import fam_tree.human.Human;
import fam_tree.human.HumanBuilder;

import java.time.LocalDate;

public class Valet {

    private FamilyTree<Human> tree;
    private HumanBuilder builder;

    public Valet(){
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


    public void addHumanToTheFamily() {
    }
}

