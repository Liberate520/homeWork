import tree.FamilyTree;

import java.time.LocalDate;

import person.Gender;
import person.Person;

public class Main {
    public static void main(String[] args) {
        FamilyTree FirstTree = new FamilyTree("Медведевы");
        Person FirstPerson = new Person(FirstTree, "Медведев", "Дмитрий", Gender.Male);
        FirstPerson.setBirthday(LocalDate.of(1996, 8, 26));
        Person SecondPerson = new Person(FirstTree, "Медведева", "Ольга", Gender.Female);
        SecondPerson.setBirthday(LocalDate.of(1989, 1, 13));
        Person FirstPersonDubl = new Person(FirstTree, "Медведев", "Дмитрий", Gender.Male);//попытка добавить уже существующего человека
        Person ThridPerson = new Person(FirstTree, "Медведева", "Наталья", Gender.Female);
        ThridPerson.setBirthday(LocalDate.of(1966, 4, 2));
        Person FourPerson = new Person(FirstTree, "Медведев", "Владислав", Gender.Male);
        FourPerson.setBirthday(LocalDate.of(1960, 10, 13));
        Person FifthPerson = new Person(FirstTree, "Кролевецкий", "Иван", Gender.Male);
        FifthPerson.setBirthday(LocalDate.of(1991, 6, 14));
        SecondPerson.setLastname("Кролевецкая");//фамилию меняет, потому что вышла замуж
        SecondPerson.setSpouse(FifthPerson);
        Person FirstChild = new Person(FirstTree, "Кролевецкая", "Екатерина", Gender.Female);
        FirstChild.setBirthday(LocalDate.of(2009, 2, 17));
        SecondPerson.setChild(FirstChild);
        FifthPerson.setChild(FirstChild);
        ThridPerson.setSpouse(FourPerson);
        ThridPerson.setChild(FirstPerson);
        ThridPerson.setChild(SecondPerson);
        FourPerson.setChild(FirstPerson);
        FourPerson.setChild(SecondPerson);
        FourPerson.setDeathday(LocalDate.of(2021, 5, 15));
        System.out.println(FirstTree.allMembers());
        System.out.println(FirstTree.allMembersMaxInfo());
    }
}
