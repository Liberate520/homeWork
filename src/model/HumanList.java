package model;

import java.util.ArrayList;
import java.util.List;

public class HumanList {
    private List<Human> list;
    private Output output;

    public HumanList(){
        this.list = new ArrayList<Human>();
        this.output = new Output();
        // тестовые ребята
        // Вася
        Human vasya = new Human();
        vasya.setId(11); 
        vasya.setName("Василий");
        vasya.setAge(40);
        list.add(vasya);
        System.out.println(vasya.getRelationships());

        // Марина
        Human marina = new Human();
        marina.setId(22); 
        marina.setName("Марина");
        marina.setAge(50);
        list.add(marina);

        // Петя
        Human petya = new Human();
        petya.setId(33); 
        petya.setName("Петр");
        petya.setAge(10);
        list.add(petya);

        // Петя сын Васи
        Relationship vasyapetya = new Relationship(2,33);
        vasya.setRelationship(vasya,vasyapetya);
    }

    public Human get(int index){
        return this.list.get(index);
    }

    public int size(){
        return this.list.size();
    }

    public String humanListToString(){
        String result = "";
        for (int i = 0; i < this.list.size(); i++){
            result = result + list.get(i).humanToString(list.get(i)) + "\n";
        }
        return result;
    }

    public void addHuman(String name, int age){
        Human humanToAdd = new Human(list, name, age);
        this.list.add(humanToAdd);
        output.outputToConsole("добавлен: " + humanToAdd.humanToString(humanToAdd) + "\n");
    }

    public void removeHuman(int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                Human removedHuman = list.get(i);
                list.remove(i);
                output.outputToConsole("удален: " + removedHuman.humanToString(removedHuman) + "\n");
            } 
        }
    }      

    public void printChildrens(int idForMenu){
        for (Human human : list){
            if (human.getId() == idForMenu){
                output.outputToConsole("Дети: " + human.childrensToString(human) + "\n");
            }
        }
    }

    public void addReletionToHuman(int idForMenu, int reletionId, int reletionToHumanId ){
        for (Human human : list){
            if (human.getId() == idForMenu){
                Relationship relationship = new Relationship(reletionId, reletionToHumanId);
                human.setRelationship(human,relationship);
            }
        }
        output.outputToConsole("связь добавлена" + "\n");
    }
}
