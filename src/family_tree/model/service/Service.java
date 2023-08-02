package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;

import java.time.LocalDate;

public class Service {
    private int idHuman;
    private FamilyTree<Human> tree;

    public Service() {
        tree = new FamilyTree<>();
    }
    public void addHuman(String name, Gender gender, LocalDate birthData){
        Human human=new Human(name,gender,birthData);
        tree.add(human);
    }
    public String getHumanInfo(){
        return tree.getInfo();
    }

    public void setTree(FamilyTree<Human> tree) {
        this.tree = tree;

    }
}
