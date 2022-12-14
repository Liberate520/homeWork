package model;


import java.util.ArrayList;

public class PersonList {
    private final java.util.List<Itemable> list;

    public PersonList(){
        this.list = new ArrayList<>();
        // тестовые персоны
        // Василий
        Person vassal = new Person();
        vassal.setId(100);
        vassal.setName("Василий");
        vassal.setAge(82);
        list.add(vassal);
        System.out.println(vassal.getRelations());

        // Елена
        Person lena = new Person();
        lena.setId(101);
        lena.setName("Елена");
        lena.setAge(79);
        list.add(lena);

        // Андрей
        Person andrei = new Person();
        andrei.setId(102);
        andrei.setName("Андрей");
        andrei.setAge(50);
        list.add(andrei);

        //Томара
        Person toma = new Person();
        toma.setId(103);
        toma.setName("Томара");
        toma.setAge(56);
        list.add(toma);

        // Андрей сын Васи
        Relation relation = new Relation(2,100);
        vassal.setRelationship(relation);

        // Андрей сын Елены
        Relation relation1 = new Relation(2,101);
        lena.setRelationship(relation1);
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

    public String addRelationToItem(int idForMenu, int reletionId, int reletionToitemId ){
        for (Itemable item : list){
            if (item.getId() == idForMenu){
                Relation relationship = new Relation(reletionId, reletionToitemId);
                item.setRelationship(relationship);
                return "связь добавлена";
            }
        }
        return "Совпадений нет";
    }
}
