package ru.geekbrains.family_tree.model;

import java.time.LocalDate;

import ru.geekbrains.family_tree.model.database.FileReader;
import ru.geekbrains.family_tree.model.database.FileWriter;
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

    /**
     * Чтение семейного древа из файла.
     */
    private FileReader fileReader;

    /**
     * Запись семейного древа в файл.
     */
    private FileWriter fileWriter;

    public Service() {
        humanIdentifier = 1;
        familyTree = new FamilyTree<>();
        fileReader = new FileReader("src\\ru\\geekbrains\\family_tree\\model" +
                                    "\\database\\database.txt");
        fileWriter = new FileWriter("src\\ru\\geekbrains\\family_tree\\model" +
                                    "\\database\\database.txt");
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
        Human familyMember = new Human(humanIdentifier++, name, surname, sex,
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

    /**
     * Читает семейное древо из файла и возвращает true или возвращает false,
     * если произошла ошибка при чтении данных из файла.
     */
    public boolean readFamilyTreeFromFile() {
        try {
            familyTree = (FamilyTree<Human>) fileReader.read();
            humanIdentifier = familyTree.getSize() + 1;
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    /**
     * Записывает семейное древо в файл и возвращает true или возвращает false,
     * если произошла ошибка при записи данных в файл.
     */
    public boolean writeFamilyTreeToFile() {
        try {
            fileWriter.write(familyTree);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

}
