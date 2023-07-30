package model.service;

import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class FamilyTreeService {
    private int idHuman;
    private FamilyTree<Human> workTree;

    public FamilyTreeService(FamilyTree<Human> workTree) {
        this.workTree = workTree;
    }
    public FamilyTreeService(){
        workTree = new FamilyTree<>();
    }

    public String addHuman(String surname, String name, String patronymic, String genderString, String birthDate,
                           String deathDate, long idFather, long idMother){
        Human human;
        Human father = workTree.getById(idFather);
        Human mother = workTree.getById(idMother);
        Gender gender = Gender.valueOf(genderString);
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        if(deathDate.equalsIgnoreCase(null)) {
            LocalDate humanDeathDate = LocalDate.parse(deathDate);
            human = new Human(surname, name, patronymic, gender, humanBirthDate, humanDeathDate, father, mother, idHuman++);
        } else {
            human = new Human(surname, name, patronymic, gender, humanBirthDate, father, mother);
        }
        workTree.add(human);
        return "Человек успешно добавлен в дерево";
    }

    public String getHumanList() {
        return workTree.getFamilyTreeInfo();
    }

    public void sortByFullName() {
        workTree.sortByFullName();
    }

    public void sortByBirthDate() {
        workTree.sortByBirthDate();
    }

    public void sortByAge() {
        workTree.sortByAge();
    }

}
