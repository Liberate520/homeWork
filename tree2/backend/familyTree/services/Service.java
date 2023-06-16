package homeWork.tree2.backend.familyTree.services;

import homeWork.tree2.backend.familyTree.FamilyTree;
import homeWork.tree2.backend.fileHandler.FileHandler;
import homeWork.tree2.backend.human.Human;
import homeWork.tree2.backend.human.HumanObjectInterface;
import homeWork.tree2.views.MessageForUsers;

import java.io.IOException;
import java.time.LocalDate;

public class Service {

    private FamilyTree family;

    public Service(FamilyTree<HumanObjectInterface> family) {
        this.family = family;
    } // Изменил параметр класса


    public boolean addFamilyMember(String name, LocalDate date, String mother, String father) {
        try {
            Human member = new Human(name, date);
            HumanObjectInterface mom = family.findPersonByName(mother);
            HumanObjectInterface dad = family.findPersonByName(father);
            try {
                member.setMother((Human) mom);
                ((Human) mom).getChild(member);
            } catch (Exception e) {

            }
            try {
                member.setFather((Human) dad);
                ((Human) dad).getChild(member);
            } catch (Exception e) {

            }
            family.addPeople(member);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public String showAllFamilyMembers() {
        try {
            return family.getFamilies();
        } catch (Exception e) {
            return null;
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


    public boolean deletePersonByName(String name) {
        HumanObjectInterface deletedPerson = family.deleteByName(name);
        return deletedPerson != null;
    }


    public void testFamily() {
        TestGenerationFamilyTree generator = new TestGenerationFamilyTree();
        family = generator.testFamilyTree();
    }

    public boolean updatePersonByName(String oldName, String name, LocalDate birthdate) {
        try {
            Human person = (Human) family.findPersonByName(oldName);
            person.updatePersonParameters(name, birthdate);
            return true;
        } catch (Exception o) {
            return false;
        }
    }

    public void saveFamilyTree() throws IOException {
        family.save();
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