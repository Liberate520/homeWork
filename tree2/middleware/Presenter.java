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

    public void saveFile(){
        try {
            service.saveFamilyTree();
            MessageForUsers message = new MessageForUsers("Файл успешно сохранен в байт-формате");
            message.setTextMessage();
        }
        catch (Exception e) {
            MessageForUsers message = new MessageForUsers("Произошла непредвиденная ошибка");
            message.setTextMessage();

        }

    }
    public void loadFile() {
        try {
            service.loadFamilyTree();
            MessageForUsers message = new MessageForUsers("Файл загружен успешно");
            message.setTextMessage();

        }
        catch (Exception e){
            MessageForUsers message = new MessageForUsers("Произошла непредвиденная ошибка");
            message.setTextMessage();
        }
    }

    public void deleteFamilyTree() {
        service.deleteFamilyTree();
    }
}

/*
Аналогично сервису убрал принты и не понял как избавится от ретерна. Тут точно ошибка, но не вижу,
как сделать правильно.

У меня все начинается в UserConnector, оттуда идет запрос в Presenter, оттуда уже в Service и
уже из Сервиса в FamilyTree. В древе возвращается искомый человек, дальше его передает сервис,
дальше презентер и уже на выходе возвращает коннектор. Это точно не то что нужно, потому что
ни презентер, ни сервис не должны возвращать ничего. Они должны только давать команды.

Самое обидно, что я должен именно возвращать экземпляр класса из древа, чтобы можно было дальше
с ним выполнять различные манипуляции.
 */