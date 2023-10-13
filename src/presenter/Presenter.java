package presenter;

import model.family_tree.CustomFamilyTree;
import model.family_tree.FamilyTree;
import model.person.Gender;
import model.person.Person;
import model.serialization.SerializationService;
import view.View;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private FamilyTree<Person> familyTree;
    public Presenter(View view) {
        this.view = view;
        familyTree = new FamilyTree<>("");
    }
    public void getFamilyInfo() {
        String info = familyTree.getFamilyInfo();
        view.printAnswer(info);
    }
    public void createFamilyTree(String familyName) {
        familyTree = new FamilyTree<>(familyName);
//        getFamilyInfo();
    }

    public void createCustomTree() {
        familyTree = new CustomFamilyTree().getCustomFamilyTree();
        getFamilyInfo();
    }

    public void addInFamily(String name, int birthDay, int birthMonth, int birthYear, String strGender) {
        LocalDate birthDate = LocalDate.of(birthDay, birthMonth, birthYear);
        Gender gender;
        switch (strGender) {
            case "м": {
                gender = Gender.Male;
                break;
            }
            case "ж": {
                gender = Gender.Female;
                break;
            }
            default: {
                gender = Gender.NonBinary;
                break;
            }
        }
        Person person = new Person(name, birthDate, gender);
        familyTree.addInFamily(person);
        getFamilyInfo();
    }

    public void addDeathDate(int id, LocalDate deathDate) {
        Person person = findByID(id);
        person.setDeathDate(deathDate);
        getFamilyInfo();
    }
    public void getMarried(int husbandID, int wifeID) {
        Person husband = findByID(husbandID);
        Person wife = findByID(wifeID);
        familyTree.isHusbands(husband, wife);
    }
    public void getChild(int childID, int fatherID, int motherID) {
        Person child = findByID(childID);
        Person father = findByID(fatherID);
        Person mother = findByID(motherID);
        familyTree.isChildren(child, father, mother);
    }

    public void getPersonInfo(int id) {
        String info = familyTree.getPersonInfo(findByID(id));
        System.out.println(info);
    }
    public void saveFamilyTree() {
        SerializationService ser = new SerializationService();
        ser.serializationFamilyTree(familyTree);
    }
    public void downloadFamilyTree(String name) {
        SerializationService ser = new SerializationService();
        try {
            familyTree = ser.deserializationFamilyTree(name);
            getFamilyInfo();
        } catch (Exception e) {
            System.out.println("увы");
        }
    }
    public int getTreeSize() {
        return familyTree.size();
    }
    private Person findByID(int id) {
        Person findPerson = null;
        for (Person person : familyTree) {
            if (id == person.getId()) {
                findPerson = person;
            }
        }
        return findPerson;
    }

}

