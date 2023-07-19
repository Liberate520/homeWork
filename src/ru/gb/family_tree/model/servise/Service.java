package ru.gb.family_tree.model.servise;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.tree.FamilyTree;

import java.time.LocalDate;

public class Service {
    private int idHuman;
    private FamilyTree familyTree;
    private FileHandler fileHandler;

    public Service() {
        familyTree = TestData.testData();
        fileHandler = new FileHandler();
    }

    public String getTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\tГенеалогическое дерево: \n");
        for (Object human : familyTree) {
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }

    public Object searchHuman(String value) {
        String result = String.valueOf(familyTree.searchHuman(value));
        return result;
    }

    public void addHuman(String numPassport, String surname, String name, Human.Gender gender, LocalDate birthday) {
        Human human = new Human(numPassport, surname, name, gender, birthday);
        human.setId(idHuman++);
        familyTree.addHuman(human);
    }

    //TODO доработать service.addToKids (addToParents), addToPartners
    public void addToKids(String numPassport, String surname, String name, Human.Gender gender, LocalDate birthday) {
        addHuman(numPassport, surname, name, gender, birthday);
    }

    public void addToParents(String name, Human.Gender gender, LocalDate birthday) {
    }

    public void addToPartners(String name, Human.Gender gender, LocalDate birthday) {
    }

    public void sortByName() {
        familyTree.sortByName();
    }

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

    public void saveInFile() {
        fileHandler.save(familyTree, "src/ru/gb/family_tree/tree.out");
        System.out.println("экспорт (tree.out) завершен успешно");
    }

    public void loadFromFile() {
        FamilyTree familyTree = (FamilyTree) fileHandler.loading("src/ru/gb/family_tree/tree.out");
        System.out.println("Импорт данных выполнен  >>>>>>  " + familyTree);
    }
}