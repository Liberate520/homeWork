package model;

import model.famyilyTree.FamilyTree;
import model.human.*;
import model.makeFiles.MakeFiles;
import model.makeFiles.Serial;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private MakeFiles makeFiles;
    String filename = "data.txt";
    Serial serial = new Serial();
    private int id;
    private FamilyTree tree;

    public boolean saveToFile() {
        if(serial == null) {
            return false;
        }
        return serial.saveToFile(tree, filename);
    }
    public boolean readFromFile() {
        if (serial == null) {
            return false;
        }
        tree = serial.readFromFile(filename);
        return true;
    }

    List<FamilyTree> list;

    //---------- Конструктор ----------------------------------------------------
    public Service(FamilyTree<Human> familyGroup) { this.tree = familyGroup; }

    public Service() { tree = new FamilyTree<>(); }

    public FamilyTree getFamilyGroup() {
        return tree;
    }
    //------------------------------------------------------------------------------------------------------------------
    public void addHuman(String firstName, String lastName, Gender gender,
                         LocalDate dateBirth, Human father, Human mother) {
        id++;
        tree.add(new Human(id, firstName, lastName, gender, dateBirth, father, mother));
    }

    public void addHuman(String firstName, String lastName, Gender gender,
                         LocalDate dateBirth) {
        id++;
        tree.add(new Human(id, firstName, lastName, gender, dateBirth));
    }

    public String addHuman(String firstName, String lastName, Gender gender) {
        id++;
        tree.add(new Human(id, firstName, lastName, gender));
        Human human = tree.getById(id);
        if(human != null) {
            return "Добавлен " + human.getInfo();
        }
        else {
            return "Добавить не удалось! ";
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public void sortByFirstName() { tree.getFamilyTree().sort(new HumanComparatorByFirstName());}
    public void sortByLastName() {
        tree.getFamilyTree().sort(new HumanComparatorByLastName());
    }
    public void sortByID() { tree.getFamilyTree().sort(new HumanComparatorByID());}

    public void setMakeFiles(MakeFiles makefiles) { this.makeFiles = makefiles; }

    public String getHumanList() {
        return tree.getInfo();
    }

    //---- Сериализация
        //mfiles.saveToFile(someFamily, filename);

//
//        //---- Десериализация
//        FamilyTree tree2 = serial.loadFromFile(filename);
}
