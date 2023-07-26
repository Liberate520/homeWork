import java.util.ArrayList;
import java.util.LinkedList;

public class Family_tree {
    public static void main(String[] args) {
        Person me = new Person();
        Person myDad = new Person();
        Person myMom = new Person();
        me.lfm = "Musorin Grigory Mikhaylovich";
        me.age = 19;
        me.dad = myDad;
        me.mom = myMom;
        me.children = null;
        myDad.lfm = "Musorin Mikhail Vasilyevich";
        myDad.age = 47;
        myDad.children = new ArrayList<>();
        myMom.lfm = "Musorina Vera Sergeevna";
        myMom.age = 49;
        myMom.children = new ArrayList<>();
        LinkedList<Person> list = new LinkedList<>();
        FamilyList mytree = new FamilyList(list);
        mytree.add(myDad);
        mytree.add(myMom);
        mytree.add(me);
        mytree.reset();
        mytree.print();
    }
}

class FamilyList {
    private LinkedList<Person> tree = new LinkedList<>();

    public FamilyList(LinkedList<Person> linkedList){
        this.tree = linkedList;

    }
    public void reset(){
        for(Person human:tree){
            if (human.dad == null) {
                human.dad = new Person();
                human.dad.lfm = null;
            }
            if (human.mom == null) {
                human.mom = new Person();
                human.mom.lfm = null;
            }
        }
    }
    public boolean add(Person human){
        if (tree.contains(human.dad) && tree.contains(human.mom)){
            tree.add(tree.indexOf(human.mom)+1, human);
            human.dad.children.add(human.lfm);
            human.mom.children.add(human.lfm);
        }
        else if (tree.contains(human.dad)){
            tree.add(tree.indexOf(human.dad)+1, human);
            human.dad.children.add(human.lfm);
        }
        else if (tree.contains(human.mom)){
            tree.add(tree.indexOf(human.mom)+1, human);
            human.mom.children.add(human.lfm);
        }
        else {
            tree.add(human);
        }
        return true;
    }
    
    public void print(){
        System.out.println("\nПолученное дерево: ");
        for(Person human:tree){
            System.out.println("ФИО: " + human.lfm + ", Возраст: " + human.age + ", Отец: " + human.dad.lfm + ", Мать: " + human.mom.lfm + ", Дети: " + human.children);
        }
    }
}
class Person{
        public String lfm;
        public Person mom;
        public Person dad;
        public Integer age;
        public ArrayList<String> children;
    }