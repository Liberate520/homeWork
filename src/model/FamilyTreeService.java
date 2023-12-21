package model;

import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writer.Writable;

import java.time.LocalDate;

public class FamilyTreeService {
    private Writable writable;
    private FamilyTree<Human> activeTree;

    public FamilyTreeService(FamilyTree<Human> activeTree) {
        this.activeTree = activeTree;
    }

    public FamilyTreeService(){
        activeTree = new FamilyTree<>();
    }

    public boolean save(){
        if (writable == null){
            return false;
        }
        return writable.save(activeTree);
    }

    public boolean load(){
        if (writable == null){
            return false;
        }
        activeTree = writable.read();
        return true;
    }

    public String addHuman(String name, String genderString, String birthDate,
                           long idFather, long idMother){
        Human father = activeTree.getById(idFather);
        Human mother = activeTree.getById(idMother);
        Gender gender = Gender.valueOf(genderString);
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        Human human = new Human(name, gender, humanBirthDate, father, mother);
        activeTree.add(human);
        return "Человек успешно добавлен в дерево";
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void sortByName(){
        activeTree.sortByName();
    }

    public void sortByDeathDate(){
        activeTree.sortByDeathDate();
    }

    public String getHumanList() {
        return activeTree.getInfo();
    }
}
