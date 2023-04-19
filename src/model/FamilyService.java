package model;

import model.file.InterfaceFile;
import model.tree.FamilyTree;
import model.tree.Human;

import java.time.LocalDate;

public class FamilyService {
    private InterfaceFile interfaceFile;
    private String fileName = "family.txt";
    private FamilyTree<Human> familyTree;
    public FamilyService(FamilyTree<Human> familyTree){
        this.familyTree = familyTree;
    }
    public FamilyService(){
        familyTree = new FamilyTree<>();
    }
    public boolean save(){
        if (interfaceFile == null){
            return false;
        }
        return interfaceFile.saveToFile(familyTree, fileName);
    }

    public boolean read(){
        if (interfaceFile == null){
            return false;
        }
        familyTree = (FamilyTree<Human>) interfaceFile.readFromFile(fileName);
        return true;

    }

    public String addHuman(String name, String gender, String birthDate, String deathDate, String father, String mother){
        Human humanFather = null;
        Human humanMother = null;
        if (!familyTree.isEmpty()){
            if (!father.equals("")){
                humanFather = familyTree.getByName(father);
            }
            if (humanFather == null){
                return "отец не найден";
            }
            if (!mother.equals("")){
                humanMother = familyTree.getByName(mother);
            }
            if (humanMother == null){
                return "мать не найдена";
            }
        }
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        LocalDate humanDeathDate = LocalDate.parse(deathDate);
        Human.Gender humanGender = Human.Gender.valueOf(gender.toLowerCase());

        Human human = new Human(name, humanGender, humanBirthDate, humanDeathDate, humanFather, humanMother);
        familyTree.addHuman(human);
        return "Человек успешно добавлен в дерево";
    }

    public void setWritable(InterfaceFile interfaceFile) {
        this.interfaceFile = interfaceFile;
    }

    public String sortByName(){
        familyTree.sortByName();
        return null;
    }

    public String sortByBirthDate(){
        familyTree.sortByBirthDate();
        return null;
    }
    public String findHuman(String name){
        familyTree.findHuman(name);
        return name;
    }
    public String humanList() {
        return familyTree.toString();
    }
}
