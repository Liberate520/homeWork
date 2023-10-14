// нарушен принцип единственной ответственности, класс занимается как добавлением Human, так и сортировкой, так и сохранением в файл 

package model.service;
//import java.util.logging.FileHandler;

import model.service.FileHandler;
import model.family.Family;
import model.human.Human;

public class Service {
    private int idHuman;
    private Family<Human> family;
    

    public Service() {
        family = new Family<>();
        

    }
    
    String filepath = "Familytree.txt";
    FileHandler fileHandler = new FileHandler();
    FamilyTree tree = (FamilyTree) fileHandler.read(filepath);
    //fileHandler.save(tree, filepath);

    
    //
    public void addHuman(String name, String gender, String father, String mother, int birthdate){
        Human human = new Human(idHuman++, name, gender, father, mother, birthdate);
        family.addHuman(human);
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Human list:\n");


        for (Human human: family){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        family.sortByName();
    }

    public void SortByBirthdate(){
        family.SortByBirthdate();
    }
}
