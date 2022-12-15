package model;

import java.util.ArrayList;

public class PersonList extends Person {
    private final java.util.List<Itemable> list;

    public PersonList(){
        this.list = new ArrayList<>();
        // тестовые персоны
        // Марат
        Person vassal = new Person();
        vassal.setId(100);
        vassal.setName("Марат");
        vassal.setAge(60);
        list.add(vassal);
        System.out.println(vassal.getRelations());

        // Светлана
        Person lena = new Person();
        lena.setId(101);
        lena.setName("Светлана");
        lena.setAge(55);
        list.add(lena);
        System.out.println(lena.getRelations());

        // Артур
        Person andrei = new Person();
        andrei.setId(102);
        andrei.setName("Артур");
        andrei.setAge(28);
        list.add(andrei);
        System.out.println(andrei.getRelations());

        //Наиля
        Person toma = new Person();
        toma.setId(103);
        toma.setName("Наиля");
        toma.setAge(25);
        list.add(toma);
        System.out.println(toma.getRelations());

        // Артур сын Марата
        Relation relation = new Relation(2,102);
        vassal.setRelationship(relation);

        Relation relation3 = new Relation(1,101);
        vassal.setRelationship(relation3);

        // Артур сын Светланы
        Relation relation1 = new Relation(2,102);
        lena.setRelationship(relation1);

        Relation relation2 = new Relation(1,100);
        lena.setRelationship(relation2);
    }


    public Itemable get(int index){
        return this.list.get(index);
    }

    public int size(){
        return this.list.size();
    }

    public String itemListToString(){
        StringBuilder result = new StringBuilder();
        for (Itemable item : this.list) {
            result.append(item.itemToString()).append("\n");
        }
        return result.toString();
    }

    public String addPerson(String name, int age){
        Itemable itemToAdd = new Person(list, name, age);
        this.list.add(itemToAdd);
        return "добавлен: " + itemToAdd.itemToString();
    }

    public String removeItem(int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                Itemable removedItem = list.get(i);
                list.remove(i);
                return "удален: " + removedItem.itemToString();
            } 
        }
        return "Совпадений нет";
    }      

    public String printChildren(int idForMenu){
        for (Itemable item : list){
            if (item.getId() == idForMenu){
                return "Дети: " + item.childrensToString();
            }
        }
        return "Совпадений нет";
    }

    public String addRelationToItem(int idForMenu, int relationId, int relationTotemId ){
        for (Itemable item : list){
            if (item.getId() == idForMenu){
                Relation relationship = new Relation(relationId, relationTotemId);
                item.setRelationship(relationship);
                return "связь добавлена";
            }
        }
        return "Совпадений нет";
    }
}
