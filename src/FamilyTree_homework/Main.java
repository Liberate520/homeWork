package FamilyTree_homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human();
        human1.setBirthDate(LocalDate.of(1963,1,1));
        human1.setGender(gender.Male);
        human1.setName("Vasiliy");
        human1.setFather("Petr");
        human1.setMother("Anna");
        List<Human> human1ChildrenList = new ArrayList<>();

        Human human2 = new Human();
        human2.setBirthDate(LocalDate.of(1980,2,4));
        human2.setGender(gender.Female);
        human2.setName("Olga");
        human2.setFather(human1.name);
        human2.setMother("Natalia");
        human1ChildrenList.add(human2);
        human1.setChildren(human1ChildrenList);
        List<Human> human2ChildrenList = new ArrayList<>();

        Human human3 = new Human();
        human3.setBirthDate(LocalDate.of(1983,5,20));
        human3.setGender(gender.Male);
        human3.setName("Oleg");
        human3.setFather(human1.name);
        human3.setMother("Natalia");
        human1ChildrenList.add(human3);
        human1.setChildren(human1ChildrenList);

        Human human4 = new Human();
        human4.setBirthDate(LocalDate.of(2010,4,5));
        human4.setGender(gender.Male);
        human4.setName("Vasiliy");
        human4.setFather("Ignat");
        human4.setMother(human2.name);
        human2ChildrenList.add(human4);
        human2.setChildren(human2ChildrenList);

        Human human5 = new Human();
        human5.setBirthDate(LocalDate.of(2001,10,9));
        human5.setGender(gender.Male);
        human5.setName("Andrey");
        human5.setFather("Ostap");
        human5.setMother(human2.name);
        human2ChildrenList.add(human5);
        human2.setChildren(human2ChildrenList);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        System.out.println(familyTree);

    }
}
