package homeWork.tree2.backend.familyTree.services;

import homeWork.tree2.backend.familyTree.FamilyTree;
import homeWork.tree2.backend.fileHandler.FileHandler;
import homeWork.tree2.backend.human.Human;
import homeWork.tree2.backend.human.HumanObjectInterface;
import homeWork.tree2.middleware.MessageForUsers;

import java.io.IOException;
import java.time.LocalDate;

public class Service {

    private FamilyTree family;

    public Service(FamilyTree<HumanObjectInterface> family) {
        this.family = family;
    } // Изменил параметр класса

    public void addFamilyMember(String name, LocalDate date) {
        try {
            Human member = new Human(name, date);
            // В данном методе, мы работаем с классмо Человек
            // принципы не нарушаются, т.к. Человек - вполне может стать родительским классом для новых классов
            // (сын, дочь, женщина, мужчина и т.д.)

            family.addPeople(member);
        } catch (Exception e) {
            MessageForUsers message =  new MessageForUsers("Ошибка ввода данных!");
            message.setTextMessage();

        }
    }

    public void showAllFamilyMembers() {
        try {
                MessageForUsers message = new MessageForUsers(family.getFamilies());
                message.setTextMessage();
            }
        catch (Exception e) {
            MessageForUsers message =  new MessageForUsers("Дерево пусто!");
            message.setTextMessage();
        }

    }


    public void sortByName() {
        family.sortByName();
    }

    public void sortByNameDesc() {
        family.byNameReverse();
    }

    public void sortById() {
        family.sortById();
    }

    public void sortByIdDesc() {
        family.byIdReverse();
    }

    public HumanObjectInterface findPersonByName(String name) {
        return family.findPersonByName(name);
    }


    public void deletePersonByName(String name) {
        family.deleteByName(name);
    }

    public void testFamily() {
        TestGenerationFamilyTree generator = new TestGenerationFamilyTree();
        family = generator.testFamilyTree();
    }

    public void updatePersonByName(String oldName, String name, LocalDate birthdate) {
        try {
            Human person = (Human) family.findPersonByName(oldName);
            person.updatePersonParameters(name, birthdate);
        } catch (Exception o) {
            MessageForUsers message =  new MessageForUsers("Ошибка ввода данных!");
            message.setTextMessage();
        }
    }

    public void saveFamilyTree() throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(family);
    }

    public void loadFamilyTree() throws IOException, ClassNotFoundException {
        FileHandler fileHandler = new FileHandler();
        this.family = fileHandler.load();

    }

    public void deleteFamilyTree() {
        family.delete();
    }
}

/*
В данном классе решил убрать печать. Для печати системных сообщений использовал сторонний класс MessageForUsers
Есть предположение, что заниматься ретерном этот класс также не должен. Поэтому убрал и ретерны.
Не убрал return только в методе findPersonByName, т.к. там нужно именно возвращать экземпляр.
 */