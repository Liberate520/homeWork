package oop.familyTree.mvp.presenter;

import oop.familyTree.mvp.model.Service;
import oop.familyTree.mvp.view.desktop.DesktopController;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private final Service service;

    /**
     * Конструктор
     */
    public Presenter() {
        this.service = new Service();
        new DesktopController();
    }

    // # Методы для работы с FamilyTree

    /**
     * Получение списка сохранённых древ
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
     * Сортировка древа по имени
     * @param treeName имя древа
     */
    public void sortByName(String treeName){
        service.sortByName(treeName);
    }

    /**
     * Сортировка древа по возрасту
     * @param treeName имя древа
     */
    public void sortByAge(String treeName){
        service.sortByAge(treeName);
    }

    // #Конец

    // # Методы для работы с Human

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

    /**
     * Удаление человека из древа
     * @param treeName имя древа
     * @param fullName имя человека
     */
    public void deletingHuman(String treeName, String fullName){
        service.deletingHuman(treeName, fullName);
    }

    /**
     * Получение информации по конкретному человеку
     * @param treeName имя древа
     * @param fullName имя человека
     */
    public void fullInfoHuman(String treeName, String fullName){
        service.fullInfoHuman(treeName, fullName);
    }

    /**
     * Изменение значения поля
     * @param treeName имя древа
     * @param fullName имя человека
     * @param numField номер поля
     * @param newValue новое значение
     */
    public void changeField(String treeName, String fullName, int numField, String newValue){
        service.changeField(treeName, fullName, numField, newValue);
    }

    // #Конец
}
