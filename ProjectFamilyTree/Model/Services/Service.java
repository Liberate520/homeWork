package homeWork.ProjectFamilyTree.Model.Services;

import homeWork.ProjectFamilyTree.Model.Family_tree;
import homeWork.ProjectFamilyTree.Model.FileHandler;
import homeWork.ProjectFamilyTree.Model.Gender;
import homeWork.ProjectFamilyTree.Model.Human;

import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private int idHuman;
    private Family_tree<Human> familyTree;
    public Service(){familyTree = new Family_tree<>();}
    public void addHuman(String name, LocalDate localDateOfBirth, LocalDate localDateofDeath, Gender gender){
        Human human = new Human(idHuman++, name, localDateOfBirth, localDateofDeath, gender);
        familyTree.addHuman(human);
    }
}
