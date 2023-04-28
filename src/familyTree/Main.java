package familyTree;

import familyTree.person.Person;
import familyTree.tree.Tree;


public class Main {
    public static void main(String[] args) {
        Tree<Person> tree = new Tree<>();
        Service service = new Service(tree);
        String filePath="src/familyTree.tree.txt";

//        Tree<Person> tree =(Tree) service.readFile(filePath);
        System.out.println(service.getInfoTree());

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

        service.addPerson(person1);
        service.addPerson(person2);
        service.addPerson(person3);
        service.addPerson(person4);
        service.addPerson(person5);
        service.addPerson(person6);
        service.addPerson(person7);
        service.addPerson(person8);
        service.addPerson(person9);
        service.addPerson(person10);


        System.out.println(service.getGrandParents(person9));
        System.out.println(service.getParents(person9));
        System.out.println(service.getChildren(person6));



        service.saveFile(tree,filePath);
        System.out.println(service.getInfoTree());

        service.sortName();
        System.out.println(service.getInfoTree());

        service.sortAge();
        System.out.println(service.getInfoTree());

        System.out.println(service.getInfoTree());







        






    }
}
