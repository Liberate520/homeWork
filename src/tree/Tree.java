package tree;

import person.ComparatorAge;
import person.ComparatorGender;
import person.ComparatorName;
import person.Person;

import java.io.*;
import java.util.*;

public class Tree implements Serializable, Iterable<Person> {
    private List<Person> family;
    public Tree() {
        family= new ArrayList<>();
    }
    public void addPerson(Person person){
        family.add(person);
        if(person.getMother()!=null){
            person.getMother().addChild(person);
        }
        if(person.getFather()!=null){
            person.getFather().addChild(person);
        }
    }

    public  String getParents(Person person){
        String mother=new String();
        String father=new String();

        for (Person relative:family) {
            try {
                if (relative.hashCode() == person.getMother().hashCode()) {
                    mother = relative.getName();
                }
                if (relative.hashCode() == person.getFather().hashCode()) {
                    father = relative.getName();
                }
            } catch (NullPointerException e) {

            }
        }
        return "mother: "+ mother + " father: "+ father;
    }

    public  String getChildren(Person person) {
        StringBuilder children = new StringBuilder();

        for (Person relative : family) {
            try {
                if (person.hashCode() == relative.getMother().hashCode() || person.hashCode() == relative.getFather().hashCode()) {
                    children.append(relative.getName()+"\n");
                }
            } catch (NullPointerException e) {
            }
        }
        String res = children.toString();
        return "children: \n" + res;
    }

    public  String getGrandParents(Person person){
        StringBuilder grandparents=new StringBuilder();

        for (Person relative:family) {
            try {
                if (relative.hashCode() == person.getMother().hashCode()) {
                    grandparents.append(relative.getMother().getName() + "\n").append(relative.getFather().getName() + "\n");
                }
                if (relative.hashCode() == person.getFather().hashCode()) {
                    grandparents.append(relative.getMother().getName() + "\n").append(relative.getFather().getName() + "\n");
                }
            } catch (NullPointerException e) {
            }
        }
        String res=grandparents.toString();
        return "grandparents: \n"+res;

    }

    public String getInfoTree(){
        StringBuilder info=new StringBuilder();
        info.append("В дереве: ");
        info.append(family.size());
        info.append("объектов: \n");
        for (Person person:family){
            info.append(person.getInfo());
            info.append("\n");
        }
        return info.toString();
    }

    @Override
    public Iterator<Person> iterator(){
        return new TreeIterator(family);
    }

    public void sortName(){
        family.sort(new ComparatorName());
    }

    public void sortAge(){
        family.sort(new ComparatorAge());
    }

    public void sortGender(){
        family.sort(new ComparatorGender());
    }






}



