package model;

import java.util.ArrayList;
import java.util.List;

public class HumanList {
    private List<Human> list;

    public HumanList(){
        this.list = new ArrayList<Human>();
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

    public String addHuman(String name, int age){
        Human humanToAdd = new Human(list, name, age);
        this.list.add(humanToAdd);
        return "добавлен: " + humanToAdd.humanToString(humanToAdd);
    }

    public String removeHuman(int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                Human removedHuman = list.get(i);
                list.remove(i);
                return "удален: " + removedHuman.humanToString(removedHuman);
            } 
        }
        return "Совпадений нет";
    }      

    public String printChildrens(int idForMenu){
        for (Human human : list){
            if (human.getId() == idForMenu){
                return "Дети: " + human.childrensToString(human);
            }
        }
        return "Совпадений нет";
    }

    public String addReletionToHuman(int idForMenu, int reletionId, int reletionToHumanId ){
        for (Human human : list){
            if (human.getId() == idForMenu){
                Relationship relationship = new Relationship(reletionId, reletionToHumanId);
                human.setRelationship(human,relationship);
                return "связь добавлена";
            }
        }
        return "Совпадений нет";
    }
}
