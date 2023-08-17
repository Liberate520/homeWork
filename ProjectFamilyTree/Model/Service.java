package homeWork.ProjectFamilyTree.Model;

import homeWork.ProjectFamilyTree.Model.Family_tree;
import homeWork.ProjectFamilyTree.Model.FileHandler;
import homeWork.ProjectFamilyTree.Model.Gender;
import homeWork.ProjectFamilyTree.Model.Human;

import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private int idHuman;
    private Family_tree<Human> familyTree;
    private static FileHandler fileHandler = new FileHandler();
    public Service(){familyTree = new Family_tree<>();}
    public void addHuman(String name, LocalDate localDateOfBirth, LocalDate localDateofDeath, Gender gender){
/*        if(idHuman == getIdHuman() && idHuman > getIdHuman()){
            idHuman++;
        }*/
        if(idHuman < getIdHuman()){
            idHuman = getIdHuman() + 1;
        }
        else {idHuman++;}
        Human human = new Human(idHuman, name, localDateOfBirth, localDateofDeath, gender);
        familyTree.addHuman(human);
    }
    public int getIdHuman() {
        return idHuman;
    }
    public void setParentsAndChilds(int childId, int parent1Id, int parent2Id) {
        Human child = familyTree.findHuman(childId);
        Human parent1 = familyTree.findHuman(parent1Id);
        Human parent2 = familyTree.findHuman(parent2Id);
        if(child.getFather() == null && parent1.getGender().equals(Gender.Male)){
            child.setFather(parent1);
            child.setMother(parent2);
            parent1.getChildren().add(child);
            parent2.getChildren().add(child);
        } else if (child.getFather() == null && parent2.getGender().equals(Gender.Male)) {
            child.setFather(parent2);
            child.setMother(parent1);
            parent1.getChildren().add(child);
            parent2.getChildren().add(child);
        }
        else if((child.getFather().equals(parent1) || child.getFather().equals(parent2)) ||
                (child.getMother().equals(parent1) || child.getMother().equals(parent2))){
            parent1.getChildren().add(child);
            parent2.getChildren().add(child);
        }
    }

    public void siblings(int human1Id, int human2Id){
        Human human1 = familyTree.findHuman(human1Id);
        Human human2 = familyTree.findHuman(human2Id);
        human1.getSibling().add(human2);
        human2.getSibling().add(human1);
    }
    public String getFamilyTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дерево:\n");
        for (Human human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByAge(){familyTree.sortByAge();}
    public void sortByName(){familyTree.sortByName();}
    public void Save() throws IOException {fileHandler.Save(familyTree);}
    public Family_tree Load() throws IOException, ClassNotFoundException {
        familyTree = (Family_tree) fileHandler.Load();
        return familyTree;
    }
}
