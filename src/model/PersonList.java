package model;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private final List<Person> list;

    public PersonList(){
        this.list = new ArrayList<>();
        // тестовые персоны
        // Василий
        Person vassal = new Person();
        vassal.setId(100);
        vassal.setName("Василий");
        vassal.setAge(82);
        list.add(vassal);
        System.out.println(vassal.getRelationships());

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

        Person person = new Person();
        person.getAge();
        list.add(person);

        // Андрей сын Васи
        Relation relation = new Relation(2,100);
        vassal.setRelationship(vassal,relation);

        // Андрей сын Елены
        Relation relation1 = new Relation(2,101);
        lena.setRelationship(lena,relation1);
    }

    public Person get(int index){
        return this.list.get(index);
    }

    public int size(){
        return this.list.size();
    }

    @SuppressWarnings("unused")
    public String personListToString(){
        StringBuilder result = new StringBuilder();
        for (Person person : this.list) {
            result.append(person.personToString(person)).append("\n");
        }
        return result.toString();
    }

    @SuppressWarnings("unused")
    public String addPereson(String name, int age){
        Person personToAdd = new Person(list, name, age);
        this.list.add(personToAdd);
        return "добавлен: " + personToAdd.personToString(personToAdd);
    }

    @SuppressWarnings("unused")
    public String removePerson(int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                Person removedPerson = list.get(i);
                list.remove(i);
                return "удален: " + removedPerson.personToString(removedPerson);
            } 
        }
        return "Совпадений нет";
    }      

    @SuppressWarnings("unused")
    public String printChildren(int idForMenu){
        for (Person person : list){
            if (person.getId() == idForMenu){
                return "Дети: " + person.childrensToString(person);
            }
        }
        return "Совпадений нет";
    }

    @SuppressWarnings("unused")
    public String addReletionToPerson(int idForMenu, int relationId, int relationToPersonId ){
        for (Person human : list){
            if (human.getId() == idForMenu){
                Relation relationship = new Relation(relationId, relationToPersonId);
                human.setRelationship(human,relationship);
                return "связь добавлена";
            }
        }
        return "Совпадений нет";
    }
}
