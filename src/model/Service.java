package model;

import java.util.List;

public class Service {
    private final FamilyTree <Human> familyTree;
//    private model.Writable data;

    public Service(FamilyTree <Human> familyTree) {
        this.familyTree = familyTree;
    }

    public void addHuman (String dateOfBirth, String dateOfDeath, String sex, String firstName, String lastName){
        Human newHuman = new Human(dateOfBirth, dateOfDeath, sex, firstName, lastName);
        familyTree.addElement(newHuman);
    }

    public String getFamilyTree(){
        return familyTree.toString();
    }

    public String findByName(String name) {
        for (Human human: familyTree.familyTree){
            if (human.getFirsName().equals(name)){
                return human.toString();
            }

        }
    return "Такого имени не найдено";
    }
}
