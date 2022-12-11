package model;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
    private List<Item> list;

    public ItemList(){
        this.list = new ArrayList<Item>();
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
        vasya.setRelationship(vasyapetya);
    }

    public Item get(int index){
        return this.list.get(index);
    }

    public int size(){
        return this.list.size();
    }

    public String itemListToString(){
        String result = "";
        for (int i = 0; i < this.list.size(); i++){
            result = result + list.get(i).itemToString() + "\n";
        }
        return result;
    }

    public String addHuman(String name, int age){
        Item itemToAdd = new Human(list, name, age);
        this.list.add(itemToAdd);
        return "добавлен: " + itemToAdd.itemToString();
    }

    public String removeItem(int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                Item removedItem = list.get(i);
                list.remove(i);
                return "удален: " + removedItem.itemToString();
            } 
        }
        return "Совпадений нет";
    }      

    public String printChildrens(int idForMenu){
        for (Item item : list){
            if (item.getId() == idForMenu){
                return "Дети: " + item.childrensToString();
            }
        }
        return "Совпадений нет";
    }

    public String addReletionToItem(int idForMenu, int reletionId, int reletionToitemId ){
        for (Item item : list){
            if (item.getId() == idForMenu){
                Relationship relationship = new Relationship(reletionId, reletionToitemId);
                item.setRelationship(relationship);
                return "связь добавлена";
            }
        }
        return "Совпадений нет";
    }
}
