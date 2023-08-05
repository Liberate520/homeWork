package ru.geekbrains.family_tree.model;

import java.time.LocalDate;

import ru.geekbrains.family_tree.model.family_tree.FamilyTree;
import ru.geekbrains.family_tree.model.human.Human;
import ru.geekbrains.family_tree.model.human.Sex;

/**
 * Сервис, позволяющий создавать, выводить и сортировать семейное древо и
 * добавлять в него людей.
 */
public class Service {
    
    /**
     * Числовой идентификатор человека.
     */
    private long humanIdentifier;

    /**
     * Семейное древо людей.
     */
    private FamilyTree<Human> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    /**
     * Возвращает строковое представление семейного древа, где информация о
     * каждом человеке начинается с новой строки, или информационную строку,
     * если семейное древо пустое.
     */
    public String printFamilyTree() {
        if (familyTree.isEmpty()) {
            return "Семейное древо пустое.\n";
        }
        StringBuilder familyMembers = new StringBuilder();
        for (Human familyMember : familyTree) {
            familyMembers.append(String.format("%s\n", familyMember));
        }
        return familyMembers.toString();
    }

    /**
     * Добавляет человека в семейное древо и возвращает true или возвращает
     * false, если человек уже существует в семейном древе.
     */
    public boolean addFamilyMember(String name, String surname, Sex sex,
                                   LocalDate birthDate) {
        Human familyMember = new Human(humanIdentifier, name, surname, sex,
                                       birthDate);
        if (familyTree.add(familyMember)) {
            return true;
        }
        return false;
    }

    /**
     * Сортирует семейное древо по имени в порядке возрастания.
     */
    public void sortFamilyTreeByName() {
        familyTree.sortByName();
    }

    /**
     * Сортирует семейное древо по дате рождения в порядке возрастания.
     */
    public void sortFamilyTreeByBirthDate() {
        familyTree.sortByBirthDate();
    }

}
