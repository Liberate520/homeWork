import human.Gender;

import java.io.Serializable;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Human person1 = new Human("Petr", Gender.Male);
//        Human person2 = new Human( "Nina", Gender.Female);
//        Human person3 = new Human("Serg", Gender.Male, person2, person1);
//        Human person4 = new Human("Sara", Gender.Female);
//        person3.setFather(person1);
//        person4.setFather(person1);
//        person3.setMother(person2);
//        person4.setMother(person2);
//        person1.addChild(person3);
//        person1.addChild(person4);
        Service service = new Service();
        service.addHuman("Petr", 1962, Gender.Male);
        service.addHuman("Nina", 1952, Gender.Female);
        service.addHuman("Ivan", 2008, Gender.Female);
        service.addHuman("Sara", 2016, Gender.Female);
        System.out.println(service.getInfo());
        service.sortByAge();
        System.out.println(service.getInfo());

    }
}


