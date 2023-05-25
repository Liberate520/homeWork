package oop.familyTree.MVP.presenter;

import oop.familyTree.MVP.model.ServiceHuman;
import oop.familyTree.MVP.view.desktop.DesktopController;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private final ServiceHuman service;

    /**
     * Конструктор
     */
    public Presenter() {
        this.service = new ServiceHuman();
        new DesktopController();
    }

    /**
     * Получение списка имён всех древ
     * @return List
     */
    public List<String> getNameFamilyTree(){
        return service.getNameFamilyTree();
    }

    /**
     * Получение содержимого конкретного древа
     * @param treeName имя древа
     * @return List
     */
    public List<String> showFamilyTree(String treeName){
        return service.showFamilyTree(treeName);
    }

    /**
     * Создание нового древа
     * @param treeName имя древа
     */
    public void createNewTree(String treeName){
        service.createNewTree(treeName);
    }

    /**
     * Добавление нового человека в древо
     * @param treeName имя древа
     * @param fullName имя человека
     * @param gender пол
     * @param dateOfBirth дата рождения
     * @param dateOfDeath дата смерти
     * @param mother имя матери
     * @param father имя отца
     * @param spouse имя супруга
     * @param children имена детей
     */
    public void addNewHuman(String treeName, String fullName, String gender,
                            LocalDate dateOfBirth, LocalDate dateOfDeath,
                            String mother, String father,
                            String spouse, String children){
        service.addNewHuman(treeName, fullName, gender,
                dateOfBirth, dateOfDeath, mother, father,spouse, children);
    }
}
