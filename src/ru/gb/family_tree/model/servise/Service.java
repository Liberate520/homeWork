package ru.gb.family_tree.model.servise;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.tree.FamilyTree;

import java.time.LocalDate;

public class Service {
    private int idHuman;
    private FamilyTree familyTree;
    public Service() {familyTree = TestData.testData();}

    public String getTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\tГенеалогическое дерево: \n");
        for (Object human : familyTree) {
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }

    // TODO доработать связь с presenter
    public void searchHuman(String value){
        familyTree.searchHuman(value);
    }

    public void addHuman(String numPassport, String surname, String name, Human.Gender gender, LocalDate birthday){
        Human human = new Human(numPassport, surname,name, gender, birthday);
            human.setId(idHuman++);
        familyTree.addHuman(human);
        }

    private void addHuman(String name, Human.Gender gender, LocalDate birthday) {   // перегрузка для addToKids, addToParents, addToPartners
        Human human = new Human(name, gender, birthday);
        familyTree.addHuman(human);
    }


    //TODO доработать service.addToKids (addToParents), addToPartners
    public void addToKids(String name, Human.Gender gender, LocalDate birthday) {
        addHuman(name, gender, birthday);


    }


    public void addToParents(String name, Human.Gender gender, LocalDate birthday) {


    }

    public void addToPartners(String name, Human.Gender gender, LocalDate birthday) {


    }

    public void sortByName() {familyTree.sortByName();}
    public void sortByAge() {
        familyTree.sortByAge();
    }
    public void sortByBirthday() {
        familyTree.sortByBirthday();
    }
    @Override
    public String toString() {
        return getTreeInfo();
    }
}