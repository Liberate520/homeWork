package com.javacourse.Family_tree;
import java.util.*;

public class FamilyList<T> implements Iterable<Person> {
    private ArrayList<Person> tree = new ArrayList<>();

    public FamilyList(ArrayList<Person> arrList){
        this.tree = arrList;
    }
    T animal;
    public T addAnimal(){
        return animal;
        /*Тут можно поподробнее описать работу с энимал,
         и ,наверное, нужно создавать отдельный класс типа FamilyList<Animal>.
         Либо я неправильно понял тз, и нужно переделывать класс Person в класс Person<T>,
         иначе функция add не будет работать, тк там методы класса Person.
         Поправьте, к след дз сделаю что необходимо
         */
    }
    public boolean add(Person human){
        if (tree.contains(human.getDad()) && tree.contains(human.getMom())){
            tree.add(tree.indexOf(human.getMom())+1, human);
            human.getDad().children.add(human.getName());
            human.getMom().children.add(human.getName());
        }
        else if (tree.contains(human.getDad())){
            tree.add(tree.indexOf(human.getDad())+1, human);
            human.getDad().children.add(human.getName());
        }
        else if (tree.contains(human.getMom())){
            tree.add(tree.indexOf(human.getMom())+1, human);
            human.getMom().children.add(human.getName());
        }
        else {
            tree.add(human);
        }
        return true;
    }
    public void sort_by_name(){
        int len = tree.size();
        Person temp;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++){
                 if (tree.get(j-1).getName().compareTo(tree.get(j).getName()) > 0){
                    temp = tree.get(j-1);
                    tree.set(j-1, tree.get(j));
                    tree.set(j, temp);
                 }
            }
            len--;
        }
    }
    public void sort_by_age(){
        int len = tree.size();
        Person temp;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++){
                 if (tree.get(j-1).getAge().compareTo(tree.get(j).getAge()) > 0){
                    temp = tree.get(j-1);
                    tree.set(j-1, tree.get(j));
                    tree.set(j, temp);
                 }
            }
            len--;
        }
    }
    
    public void print(){
        System.out.println("\nПолученное дерево: ");
        for(Person human:tree){
            System.out.println("");
            System.out.println("ФИО: " + human.getName() + ", Возраст: " + human.getAge() + ", Отец: " + human.getDad().getName() + ", Мать: " + human.getMom().getName() + ", Дети: " + human.children);
        }
    }


    @Override
    public Iterator<Person> iterator()
    {
        return new Iterator<Person>()
        {
            private int i = 0;
 
            /**
            * Возвращает true, если в массиве больше элементов.
            */
            public boolean hasNext() {
                return (i < tree.size() && tree.get(i) != null);
            }
 
            /**
            * Возвращает следующий элемент в итерации.
            * @throws NoSuchElementException, если итерация не имеет
            * больше элементов
            */
            @Override
            public Person next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return tree.get(i++);
            }
        };
    }
    
}

    


