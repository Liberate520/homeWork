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
    public void wedding(long idHusband, long idWife){
        tree.setWedding(idHusband,idWife);
    }
    public void addChildren(long idChildren, long idFather, long idMother){

        Human child = tree.getById(idChildren);
        Human father = tree.getById(idFather);
        Human mother = tree.getById(idMother);
        //TODO ошибка если нет одного родителя
        father.addChild(child);
        mother.addChild(child);
        child.addParent(father);
        child.addParent(mother);
    }
    public void addParent(long idChildren, long idFather, long idMother){
        Human child = tree.getById(idChildren);
        Human father = tree.getById(idFather);
        Human mother = tree.getById(idMother);
        child.addParent(father);
        child.addParent(mother);
    }

    public void setTree(FamilyTree<Human> tree) {
        this.tree = tree;

    }

    public FamilyTree<Human> getTree() {
        return tree;
    }

}
