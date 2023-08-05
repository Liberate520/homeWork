package ru.geekbrains.family_tree.presenter;

import java.time.LocalDate;

import ru.geekbrains.family_tree.model.Service;
import ru.geekbrains.family_tree.model.human.Sex;
import ru.geekbrains.family_tree.view.UserInterface;

/**
 * Посредник между моделью и пользовательским интерфейсом, создающий сервис.
 */
public class Presenter {

    /**
     * Пользовательский интерфейс.
     */
    private UserInterface userInterface;

    /**
     * Сервис.
     */
    private Service service;

    public Presenter(UserInterface userInterface) {
        this.userInterface = userInterface;
        service = new Service();
    }

    /**
     * Выводит семейное древо через пользовательский интерфейс.
     */
    public void printFamilyTree() {
        String familyTree = service.printFamilyTree();
        userInterface.print(familyTree);
    }

    /**
     * Добавляет человека в семейное древо и возвращает true или возвращает
     * false, если человек уже существует в семейном древе.
     */
    public void addFamilyMember(String name, String surname, Sex sex,
                                LocalDate birthDate) {
        if (service.addFamilyMember(name, surname, sex, birthDate)) {
            userInterface.print("Человек добавлен в семейное древо.\n");
        }
        else {
            userInterface.print("Человек уже существует в семейном древе.\n");
        }
    }

    /**
     * Сортирует семейное древо по имени в порядке возрастания.
     */
    public void sortFamilyTreeByName() {
        service.sortFamilyTreeByName();
    }

    /**
     * Сортирует семейное древо по дате рождения в порядке возрастания.
     */
    public void sortFamilyTreeByBirthDate() {
        service.sortFamilyTreeByBirthDate();
    }
    
}
