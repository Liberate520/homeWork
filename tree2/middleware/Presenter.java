package homeWork.tree2.middleware;

import homeWork.tree2.backend.familyTree.FamilyTree;
import homeWork.tree2.backend.familyTree.services.Service;
import homeWork.tree2.backend.human.Human;
import homeWork.tree2.backend.human.HumanObjectInterface;


import java.time.LocalDate;

public class Presenter {

    Service service = new Service(new FamilyTree());
    public void addFamilyMember(String name, LocalDate date){
            service.addFamilyMember(name, date);
    }

    public void showFamilyMembers(){
            service.showAllFamilyMembers();
    }

    public void fillFamilyTreeWithTestData() {
            service.testFamily();
    }


    public void sortByName(){
        service.sortByName();
    }

    public void sortByNameDesc(){
        service.sortByNameDesc();
    }

    public void sortById(){
        service.sortById();
    }

    public void sortByIdDesc(){
        service.sortByIdDesc();
    }

    public HumanObjectInterface<Human> findPerson(String name){
        return service.findPersonByName(name);
    }

    public void deletePeson(String name){
        service.deletePersonByName(name);
    }

    public void updatePerson(String oldName, String newName, LocalDate date){
        service.updatePersonByName(oldName, newName, date);
    }

    public String saveFile(){
        try {
            service.saveFamilyTree();
            String message = "Файл успешно сохранен в байт-формате";
            return message;
        }
        catch (Exception e) {
            String message = "Произошла непредвиденная ошибка";
            return message;

        }

    }
    public String loadFile() {
        try {
            service.loadFamilyTree();
            String message = "Файл загружен успешно";
            return message;
        }
        catch (Exception e){
            String message = "Произошла непредвиденная ошибка";
            return message;
        }
    }

    public void deleteFamilyTree() {
        service.deleteFamilyTree();
    }
}
