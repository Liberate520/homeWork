package Home;

import Home.human.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main  {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Service service = new Service();
        service.addHuman("Max",18);
        service.getHuman("Max").setMother(service.addHuman("Nataliya",45));
        service.getHuman("Max").setFather(service.addHuman("Igor",46));
        service.sortByAge();
        System.out.println(service.getInfo());
        service.sortByName();
        System.out.println(service.getInfo());


    }


}
