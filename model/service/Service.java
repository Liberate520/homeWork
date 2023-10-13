package model.service;
import model.family.Family;
import model.human.Human;

public class Service {
    private int idHuman;
    private Family<Human> family;

    public Service() {
        family = new Family<>();
    }

    public void addHuman(String name, int age){
        Human human = new Human(idHuman++, name, age);
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

    public void sortByAge(){
        family.sortByAge();
    }
}
