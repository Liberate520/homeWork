import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person defPerson = new Person("unknown", null, null, null, null);
        List<Person> defChildrenList = new ArrayList<>();
        Person p1 = new Person("Татьяна", LocalDate.of(1951, 1, 10), Gender.Female, defPerson, defPerson);
        Person p2 = new Person("Сергей", LocalDate.of(1951, 10, 23), Gender.Male, defPerson, defPerson);
        Person p3 = new Person("Алексей", LocalDate.of(1984, 7, 11), Gender.Male, defPerson, defPerson);
        Person p4 = new Person("Степан", LocalDate.of(2017, 4, 21), Gender.Male, defPerson, defPerson);
        Person p5 = new Person("Ирина", LocalDate.of(1987, 7, 1), Gender.Female, defPerson, defPerson);
        Person p6 = new Person("Петр", LocalDate.of(2018, 9, 30), Gender.Male, defPerson, defPerson);
        Person p7 = new Person("Маша", LocalDate.of(2021, 6, 14), Gender.Female, defPerson, defPerson);
        Person p8 = new Person("Вика", LocalDate.of(2021, 6, 14), Gender.Female, defPerson, defPerson);

        p1.addChild(p3);
        p2.addChild(p3);
        p3.addChild(p4);
        p5.addChild(p4);
        p3.addChild(p6);
        p3.addChild(p7);
        p3.addChild(p8);
        p5.addChild(p6);
        p5.addChild(p7);
        p5.addChild(p8);

        p3.setMother(p1);
        p3.setFather(p2);
        p4.setMother(p5);
        p4.setFather(p3);
        p6.setMother(p5);
        p6.setFather(p3);
        p7.setMother(p5);
        p7.setFather(p3);
        p8.setMother(p5);
        p8.setFather(p3);

        Tree familyTree = new Tree();
        familyTree.addPerson(p1);
        familyTree.addPerson(p2);
        familyTree.addPerson(p3);
        familyTree.addPerson(p4);
        familyTree.addPerson(p5);
        familyTree.addPerson(p6);
        familyTree.addPerson(p7);
        familyTree.addPerson(p8);

        System.out.println("\nЛица в генеалогическом дереве:");
        Lib.printList(familyTree.getPersonList());
        System.out.println();
        System.out.println("Папой для лица \"" + p4 + "\" является:\n" + p4.getFather());
        System.out.println();
        System.out.println("Мамой для лица \"" + familyTree.findPersonByName("Степан") + "\" является:\n" + p4.getMother());
        System.out.println();
        System.out.println("Родителями для лица \"" + p4 + "\" являются:");
        Lib.printList(p4.getParents());
        System.out.println();
        System.out.println("Детьми для лица \"" + p1 + "\" являются:");
        Lib.printList(p1.getChildren());
        System.out.println("Братьями и сетстрами для лица \"" + p4 + "\" являются:");
        Lib.printList(familyTree.findSiblings(p4));
    }

}
