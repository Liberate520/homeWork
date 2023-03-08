package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TreeService implements Service {
    private final Writable fileHandler;
    private Tree<Human> familyTree;

    public void load() {
        familyTree = (Tree<Human>) fileHandler.read();
    }

    public TreeService() {
        this.fileHandler = new FileHandler("tree.out");
        familyTree = new Tree<>();
    }

    public String showAll() {
        return familyTree.getInfo();
    }

    public void save() {
        fileHandler.write(familyTree);
    }

    @Override
    public String showEntry(String name) {
        return familyTree.getByName(name).getInfo();
    }

    @Override
    public boolean addEntry(String name, String gender, String birthYear,
            String fatherName, String motherName) {
        Gender enumGender;
        if (gender.equalsIgnoreCase("м")) {
            enumGender = Gender.MALE;
        } else {
            enumGender = Gender.FEMALE;
        }
        Date birthDate = new Date(0);
        try {
            birthDate = new SimpleDateFormat("yyyy").parse(birthYear);
        } catch (ParseException e) {
            System.out.println("не корректный год рождения");
        }
        Human father = familyTree.getByName((fatherName));
        Human mother = familyTree.getByName(motherName);
        Human child = new Human(name, enumGender, birthDate, father, mother);
        return familyTree.add(child);
    }

    @Override
    public boolean deleteEntry(String name) {
        return familyTree.delete(familyTree.getByName(name));
    }

}
