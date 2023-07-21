import familyTree.FamilyTree;
import familyTree.FamilyTreeSerializer;
import human.Gender;
import human.Human;

import java.io.*;
import java.util.GregorianCalendar;


public class Main {
        public static void main(String[] args) {
            FamilyTree tree = new FamilyTree();
            tree.add(new Human("Василий", Gender.Male, new GregorianCalendar(1973, 03, 21)));
            tree.add(new Human("Мария", Gender.Female, new GregorianCalendar(1977, 04, 23)));
            tree.add(new Human("Кристина", Gender.Female, new GregorianCalendar(2000, 05, 10),
                    tree.getByName("Василий"), tree.getByName("Мария")));
            tree.add(new Human("Семен", Gender.Male, new GregorianCalendar(2002, 9, 5),
                    tree.getByName("Василий"), tree.getByName("Мария")));
            tree.add(new Human("Семен", Gender.Male, new GregorianCalendar(2003, 11, 6),
                    tree.getByName("Семен"), new Human("Ольга", Gender.Female)));
            tree.add(new Human("Семен", Gender.Male, new GregorianCalendar(2004, 10, 8),
                    new Human("Владимир", Gender.Male), new Human("Евгения", Gender.Female)));
            tree.add(new Human("Семен", Gender.Male, new GregorianCalendar(2005, 8, 11),
                    tree.getByName("Александр"), new Human("Юлия", Gender.Female)));

            System.out.println(tree.getInfo());

            tree.sortByName();
            System.out.println("Отсортированно по имени: "+tree.getInfo());

            tree.sortByBirthDate();
            System.out.println("Отсортированно по дате рождения: "+tree.getInfo());



            FamilyTreeSerializer serializer = new FamilyTreeSerializer();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("familyTree.txt"))){
                oos.writeObject(tree);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("familyTree.txt"))){
                FamilyTree loadedTree = (FamilyTree) ois.readObject();
                //System.out.println(loadedTree.getInfo()+"555");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    package human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private Gender gender;
    private Calendar birthDate;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, Gender gender, Calendar birthDate, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }
    public Human(String name, Gender gender, Calendar birthDate) {
        this(name , gender, birthDate,null, null);
    }

    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public boolean addChild(Human child){

        if (child != null && !children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }
    public String getName() {return name;}
    public Calendar getBirthDate() {return birthDate;}
    public int getAge(){Calendar currentDate = new GregorianCalendar();
        return currentDate.get(Calendar.YEAR) - this.getBirthDate().get(Calendar.YEAR);
    }
    //public Calendar getbirthDate(){return birthDate;}
    public Human getFather() {return father;}
    public Human getMother() {return mother;}
    public Gender getGender() {return gender;}
    public List<Human> getChildren() {return children;}
    //public void setBirthDate(Calendar birthDate) {this.birthDate = birthDate;}
    public void setFather(Human father) {this.father = father;}
    public void setMother(Human mother) {this.mother = mother;}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append("дата рождения: ");
        //sb.append(setBirthDate()+" 555 ");
        sb.append(birthDate.get(Calendar.DAY_OF_MONTH)+".");
        sb.append(birthDate.get(Calendar.MONTH)+".");
        sb.append(birthDate.get(Calendar.YEAR));
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }


    public String getMotherInfo(){
        String res = "мать: ";
        if(mother != null){
            res +=mother.getName();
        }else{
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "отец: ";
        if (father != null) {
            res+=father.getName();
        }else {
            res+="неизвестен";
        }
        return res;
    }
    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if(children.size() != 0){
            res.append(children.get(0).getName());
            for(int i = 0; i< children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }else{
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + Calendar.DAY_OF_MONTH + "541254125"+Calendar.MONTH+Calendar.YEAR+
                ", father=" + father +
                ", mother=" + mother +
                ", children=" + children +
                '}';
    }
}

package familyTree;

import human.Human;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humanList;
    //private Human root;

    public FamilyTree(){
        this(new ArrayList<>());
       // this.root = null;
    }
    public boolean add(Human human){
        if(human == null){
            return false;
        }
//        if(root == null){
//            root = human;
//            return true;
//        }
        if(!humanList.contains(human)){
            humanList.add(human);
            if(human.getFather() != null){
                human.getFather().addChild(human);
            }
            if(human.getMother() != null){
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }
    public Human getByName(String name){
        if (name == null){
            return null;
        }
        Iterator<Human> it = iterator();
        while (it.hasNext()){
            Human human = it.next();
            if(name.equals(human.getName())){
                return human;
            }
        }
        return null;
    }

    public  String getInfo(){
        StringBuilder sb = new StringBuilder();
        Iterator<Human> it = iterator();
        while (it.hasNext()){
            sb.append(it.next().getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        List<Human> list = new ArrayList<>();
        Iterator<Human> it = iterator();
        while (it.hasNext()){
            list.add(it.next());
        }
        Collections.sort(list, Comparator.comparing(Human::getName));
        root = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            Human parent = list.get(i);
            List<Human> children = new ArrayList<>();
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(j).getFather() == parent || list.get(j).getMother() == parent){
                    children.add(list.get(j));
                }
            }
            parent.setChildren(children);
        }
    }

    public void sortByBirthDate(){
        List<Human> list = new ArrayList<>();
        Iterator<Human> it = iterator();
        while (it.hasNext()){
            list.add(it.next());
        }
        Collections.sort(list, Comparator.comparing(Human::getBirthDate));
        root = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            Human parent = list.get(i);
            List<Human> children = new ArrayList<>();
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(j).getFather() == parent || list.get(j).getMother() == parent){
                    children.add(list.get(j));
                }
            }
            parent.setChildren(children);
        }
    }
    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(root);
    }
}

package familyTree;

import human.Human;

import java.util.Iterator;
import java.util.Stack;

public class FamilyTreeIterator implements Iterator<Human> {
    private Stack<Human> stack;

    public  FamilyTreeIterator(Human root){
        stack = new Stack<>();
        if(root != null){
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Human next() {
        Human node = stack.pop();
        if(node.getChildren() != null){
            for (Human child: node.getChildren() ) {
                stack.push(child);
            }
        }
        return node;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

package familyTree;

import java.io.*;

public class FamilyTreeSerializer implements SerializableReader, SerializableWriter{
    @Override
    public <T> T readObject(String filename) throws IOException, ClassNotFoundException {
        T object;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            object = (T) ois.readObject();
        }
        return object;
    }

    @Override
    public <T> void writeObject(T object, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(object);
        }
    }
    public void saveFamilyTree(FamilyTree tree, String filename) throws IOException{
        writeObject(tree, filename);
    }
    public FamilyTree loadFamilyTree(String filename) throws IOException, ClassNotFoundException{
        return readObject(filename);
    }
}

package familyTree;

import java.io.IOException;

public interface SerializableReader {
    <T> T readObject(String filename) throws IOException, ClassNotFoundException;
}

package familyTree;


import java.io.IOException;

public interface SerializableWriter {
    <T> void writeObject(T object, String filename) throws IOException;
}

package human;

public enum Gender {
    Male, Female
}