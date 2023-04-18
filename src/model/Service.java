package model;

import java.io.IOException;
import java.io.Serializable;
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

    public void sortByName(){
        familyTree.sortByName();
    }
    public void sortBySex(){
        familyTree.sortBySex();
    }
    public void save(String path) throws IOException {
        FileHandler fh = new FileHandler();
        fh.save(familyTree, path);
    }
    public String load(String path) throws IOException, ClassNotFoundException {
        FileHandler fh = new FileHandler();
        return fh.load(path).toString();
    }
}
