package ru.medved_sa.tree_family.model;

import ru.medved_sa.tree_family.model.familyTree.FamilyTree;
import ru.medved_sa.tree_family.model.human.Gender;
import ru.medved_sa.tree_family.model.human.Human;
import ru.medved_sa.tree_family.model.save.Writable;

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

    public void saveFile(){
        if (writable == null){
            return;
        }
        writable.saveFile(activeTree);
    }

    public void readFile(){
        if (writable == null){
            return;
        }
        activeTree = (FamilyTree<Human>) writable.readFile();
    }

    public String addHuman(String name, String genderString, String birthDate){
        Gender gender = Gender.valueOf(genderString);
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        Human human = new Human(name, gender, humanBirthDate);
        activeTree.addHuman(human);
        return "Человек успешно добавлен в дерево";
    }

    public FamilyTreeService(Writable writable) {
        this.writable = writable;
    }

    public void sortByFirstName(){
        activeTree.sortByFirstName();
    }

    public void sortByAge(){
        activeTree.sortByAge();
    }

    public String getHumanList() {
        return activeTree.getInfo();
    }
}
