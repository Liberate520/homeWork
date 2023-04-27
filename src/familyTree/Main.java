package familyTree;

import familyTree.fileWorkers.FileWorkable;
import familyTree.fileWorkers.FileWorker;
import familyTree.person.Person;

public class Main {
    public static void main(String[] args) {
        familyTree.tree.Tree tree=new familyTree.tree.Tree();
        String filePath="src/familyTree.tree.txt";
        FileWorkable fileWorkable = new FileWorker();

        //Tree familyTree.tree =(Tree) fileWorkable.readFile(filePath);
        System.out.println(tree.getInfoTree());

        Person person1=new Person(80,"Female","Иванова Наталья");
        Person person2=new Person(90,"Male","Иванов Василий");
        Person person3=new Person(50,"Female","Петрова Лилия",person1,person2);
        Person person4=new Person(50,"Male","Петров Владимир");
        Person person11=new Person(55,"Female","Кузнецова Полина");
        Person person12=new Person(60,"Male","Кузнецов Дмитрий");
        Person person5=new Person(30,"Male","Петров Иван",person3,person4);
        Person person6=new Person(30,"Female","Петрова Галина",person11,person12);
        Person person7=new Person(10,"Male","Петров Геннадий",person6,person5);
        Person person8=new Person(10,"Female","Петрова Ольга",person6,person5);
        Person person9=new Person(10,"Male","Петров Максим",person6,person5);
        Person person10=new Person(40,"Female","Иванова Нина",person1,person2);

        tree.addPerson(person1);
        tree.addPerson(person2);
        tree.addPerson(person3);
        tree.addPerson(person4);
        tree.addPerson(person5);
        tree.addPerson(person6);
        tree.addPerson(person7);
        tree.addPerson(person8);
        tree.addPerson(person9);
        tree.addPerson(person10);

        //System.out.println(person3);
        System.out.println(tree.getGrandParents(person9));
        System.out.println(tree.getParents(person9));
        System.out.println(tree.getChildren(person6));
        System.out.println(person5.getGender());


        fileWorkable.saveFile(tree,filePath);
        System.out.println(tree.getInfoTree());

        tree.sortName();
        System.out.println(tree.getInfoTree());

        tree.sortAge();
        System.out.println(tree.getInfoTree());

        tree.sortGender();
        System.out.println(tree.getInfoTree());





        






    }
}
