package homeWork.tree2.middleware;

import homeWork.tree2.backend.familyTree.FamilyTree;
import homeWork.tree2.backend.familyTree.services.Service;
import homeWork.tree2.backend.human.Human;
import homeWork.tree2.backend.human.HumanObjectInterface;
import homeWork.tree2.views.MessageForUsers;


import java.time.LocalDate;

public class Presenter {

    Service service = new Service(new FamilyTree());

    public void addFamilyMember(String name, LocalDate date, String mother, String father) {
        if (!service.addFamilyMember(name, date, mother, father)) {
            MessageForUsers message = new MessageForUsers();
            message.setTextErrorMessage();
        } else {
            MessageForUsers message = new MessageForUsers("\nПользователь по имени " + name + " успешно добавлен!\n");
            message.setTextMessage();
        }

    }

    public void showFamilyMembers() {
        String result = service.showAllFamilyMembers();
        MessageForUsers message = new MessageForUsers(result);
        if (result != null) {
            message.setTextMessage();
        } else {
            message.setTextErrorMessage();
        }
    }


    public void fillFamilyTreeWithTestData() {
        service.testFamily();
    }


    public void sortByName() {
        service.sortByName();
    }

    public void sortByNameDesc() {
        service.sortByNameDesc();
    }

    public void sortById() {
        service.sortById();
    }

    public void sortByIdDesc() {
        service.sortByIdDesc();
    }

    public HumanObjectInterface<Human> findPerson(String name) {
        return service.findPersonByName(name);
    }

    public boolean deletePerson(String name) {
        boolean isSuccess = service.deletePersonByName(name);
        return isSuccess;
    }


    public void updatePerson(String oldName, String newName, LocalDate date) {
        if (!service.updatePersonByName(oldName, newName, date)) {
            MessageForUsers message = new MessageForUsers("Ошибка ввода данных!");
            message.setTextMessage();
        }
        ;
    }

    public void saveFile() {
        try {
            service.saveFamilyTree();
            MessageForUsers message = new MessageForUsers("Файл успешно сохранен в байт-формате");
            message.setTextMessage();
        } catch (Exception e) {
            MessageForUsers message = new MessageForUsers();
            message.setTextErrorMessage();

        }

    }

    public void loadFile() {
        try {
            service.loadFamilyTree();
            MessageForUsers message = new MessageForUsers("Файл загружен успешно");
            message.setTextMessage();

        } catch (Exception e) {
            MessageForUsers message = new MessageForUsers();
            message.setTextErrorMessage();
        }
    }

    public void deleteFamilyTree() {
        try {
            service.deleteFamilyTree();
        } catch (Exception e) {
            MessageForUsers message = new MessageForUsers();
            message.setTextErrorMessage();
        }

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