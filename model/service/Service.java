// нарушен принцип единственной ответственности, класс занимается как добавлением Human, так и сортировкой, так и сохранением в файл 
// нарушен принцип инверсии зависимостей

package model.service;
import model.family.Family;
import model.human.Human;

public class Service {
    private int idHuman;
    private Family<Human> family;
    FileHandler fileHandler = new FileHandler();

    public Service() {
        family = new Family<>();
        

    }
    String filepath = "Familytree.txt";
    public void read(){
        family = (Family) fileHandler.read(filepath);
    }
    public void save(){
    fileHandler.save(family, filepath);
    }
        
    public void addHuman(String name, String gender, String father, String mother, int birthdate, String alive_status, String children){
        Human human = new Human(idHuman++, name, gender, father, mother, birthdate, alive_status, children);
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
