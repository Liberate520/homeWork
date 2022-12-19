package model;


import java.util.ArrayList;

public class PersonList extends Person {
    private final java.util.List<Itemable> list;
    public PersonList(){
        this.list = new ArrayList<>();
        // тестовые персоны

//        Person Pa = new Person("Сергей", "Сопов", 40);
//        Pa.setId(50);
//        list.add(Pa);
//        System.out.println(Pa.getRelations());
        Person serg = new Person();
        serg.setId(1);
        serg.setSurname("Сопов");
        serg.setName("Сергей");
        serg.setPatronymic("Николаевич");
        serg.setAge(40);
        list.add(serg);
        System.out.println(serg.getRelations());


        Person leka = new Person();
        leka.setId(2);
        leka.setSurname("Бейзель");
        leka.setName("Ольга");
        leka.setPatronymic("Владимировна");
        leka.setAge(38);
        list.add(leka);
        System.out.println(leka.getRelations());


        Person evgen = new Person();
        evgen.setId(3);
        evgen.setSurname("Гайдамака");
        evgen.setName("Евгений");
        evgen.setPatronymic("Романович");
        evgen.setAge(19);
        list.add(evgen);
        System.out.println(evgen.getRelations());


        Person julia = new Person();
        julia.setId(4);
        julia.setSurname("Сопова");
        julia.setName("Юлия");
        julia.setPatronymic("Николаевна");
        julia.setAge(33);
        list.add(julia);
        System.out.println(julia.getRelations());


        Relation relation = new Relation(1,2);
        serg.setRelationship(relation);
        Relation relation1 = new Relation(2,3);
        serg.setRelationship(relation1);
        Relation relation4 = new Relation(3,4);
        serg.setRelationship(relation4);

        Relation relation2 = new Relation(1,1);
        leka.setRelationship(relation2);
        Relation relation3 = new Relation(2,3);
        leka.setRelationship(relation3);

        Relation relation5 = new Relation(3,1);
        julia.setRelationship(relation5);

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

    public String addPerson(String surname, String name, String patronymic, int age){
        Itemable itemToAdd = new Person(list, surname, name, patronymic, age);
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
