package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FamilyTreeService implements Service {
    private final ReadWritable fileHandler;
    private FamilyTree<Human> familyTree;
    public void load(){
        familyTree = (FamilyTree<Human>) fileHandler.read();
    }

    public FamilyTreeService() {
        this.fileHandler = new FileHandler("familydata");
        load();
    }

    public String showAll(){
        return familyTree.getInfo();
    }

    public void save(){
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
        if(gender.equalsIgnoreCase("m")){
            enumGender = Gender.MALE;
        } else {
            enumGender = Gender.FEMALE;
        }
        Date birthDate = new Date(0);
        try {
            birthDate = new SimpleDateFormat("yyyy").parse(birthYear);
        } catch (ParseException e) {
            System.out.println("wrong birth year  passed to familyTreeService");
        }
        Human father = familyTree.getByName((fatherName));
        Human mother = familyTree.getByName(motherName);
        Human child = new Human(name, enumGender, birthDate, father, mother);
        return familyTree.add(child);
    }

}
