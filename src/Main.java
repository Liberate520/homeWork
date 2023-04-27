import human.Gender;

import java.io.Serializable;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();
        service.addHuman("Petr", 1962, Gender.Male);
        service.addHuman("Nina", 1952, Gender.Female);
        service.addChild("Ivan", 2008, Gender.Female, "Petr", "Nina");
        service.addChild("Sara", 2016, Gender.Female, "Petr", "Nina");
        System.out.println(service.getInfo());
        service.sortByAge();
        System.out.println(service.getInfo());
        service.sortByName();
        System.out.println(service.getInfo());


    }
}


