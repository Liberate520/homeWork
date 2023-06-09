package homeWork.tree2.middleware;

import homeWork.tree2.backend.familyTree.FamilyTree;
import homeWork.tree2.backend.familyTree.services.Service;


import java.time.LocalDate;

public class Presenter {

    Service service = new Service(new FamilyTree());
    public void addFamilyMember(String name, LocalDate date){
        System.out.println("\n=======================Добавление члена семьи================================\n");
            service.addFamilyMember(name, date);
        System.out.println("\nПользователь под именем " + name + ", год рождения " + date+ " успешно добавлен!\n");
    }

    public void showFamilyMembers(){
        System.out.println("\n=============================Все семья================================\n");
            service.showAllFamilyMembers();
        System.out.println("\n");
    }

    public void fillFamilyTreeWithTestData() {
        System.out.println("\n==================Заполнили семейное древо тестовыми данными=================\n");
            service.testFamily();
        System.out.println("\n");
    }


    public void sortByName(){
        System.out.println("\n=============================Сортировка по имени================================\n");
        service.sortByName();
    }

    public void sortByNameDesc(){
        System.out.println("\n=====================Обратная сортировка по имени=============================\n");
        service.sortByNameDesc();
    }

    public void sortById(){
        System.out.println("\n=============================Сортировка по ID================================\n");
        service.sortById();
    }

    public void sortByIdDesc(){
        System.out.println("\n===========================Обратная сортировка по ID============================\n");
        service.sortByIdDesc();
    }

    public void findPerson(String name){
        System.out.println("\n===========================Поиск человека по имени============================\n");
        System.out.println(service.findPersonByName(name));
    }

    public void deletePeson(String name){
        System.out.println("\n===========================Удаление пользователя============================\n");
        service.deletePersonByName(name);
    }

    public void updatePerson(String oldName, String newName, LocalDate date){
        System.out.println("\n===========================Изменение пользователя============================\n");
        service.updatePersonByName(oldName, newName, date);
    }

    public void saveFile(){
        try {
            service.saveFamilyTree();
            System.out.println("Файл успешно сохранен в байт-формате");
        }
        catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка");
        }

    }
    public void loadFile() {
        try {
            service.loadFamilyTree();
            System.out.println("Файл загружен успешно");
        }
        catch (Exception e){
            System.out.println("Произошла непредвиденная ошибка");
        }
    }

    public void deleteFamilyTree() {
        service.deleteFamilyTree();
    }
}
