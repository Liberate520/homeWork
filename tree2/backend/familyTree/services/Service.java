package homeWork.tree2.backend.familyTree.services;

import homeWork.tree2.backend.familyTree.FamilyTree;
import homeWork.tree2.backend.fileHandler.FileHandler;
import homeWork.tree2.backend.human.Human;
import homeWork.tree2.backend.human.HumanObjectInterface;

import java.io.IOException;
import java.time.LocalDate;

public class Service<E> {

    private FamilyTree family;

    public Service(FamilyTree family) {
        this.family = family;
    }

    public void addFamilyMember(String name, LocalDate date) {
        Human member = new Human(name, date);
        family.addPeople(member);
    }

    public void showAllFamilyMembers() {
        try {
            System.out.println(family.getFamilies());
        }
        catch (Exception e) {
            System.out.println("Древо пусто");
        }
    }


    public void sortByName() {
        family.sortByName();
    }

    public void sortByNameDesc() {
        family.byNamereverse();
    }

    public void sortById() {
        family.sortById();
    }

    public void sortByIdDesc() {
        family.byIdreverse();
    }

    public HumanObjectInterface findPersonByName(String name) {
        return family.findPersonByName(family, name);
    }


    public void deletePersonByName(String name) {
        family.deleteByName(family, name);
    }

    public FamilyTree testFamily() {
        TestGenerationFamilyTree generator = new TestGenerationFamilyTree();
        family = generator.testFamilyTree();
        return family;
    }

    public void updatePersonByName(String oldName, String name, LocalDate birthdate) {
        Human person = (Human) family.findPersonByName(family, oldName);
        person.updatePersonParameters(name, birthdate);
    }

    public void saveFamilyTree() throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(family);
    }

    public FamilyTree loadFamilyTree() throws IOException, ClassNotFoundException {
        FileHandler fileHandler = new FileHandler();
        this.family = fileHandler.load();
        return this.family;
    }
}
