import families.Family;
import human.Gender;
import human.Human;
import service.Service;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Family Romanovs = new Family();
        Human Nikolai_II = new Human("Nikolai_II", 18, 5, 1868, Gender.Male);
        Human Aleksandra = new Human("Aleksandra Fedorovna", 6, 6, 1872, Gender.Female);
        Human Olga = new Human("Olga", 15, 11, 1895, Gender.Female);
        Human Aleksei = new Human("Aleksei", 12, 8, 1904, Gender.Male);
        Human Maria = new Human("Maria", 26, 6, 1899, Gender.Female);
        Human Tatyana = new Human("Tatyana", 10, 6, 1897, Gender.Female);
        Human Anastasia = new Human("Anastasia", 18, 6, 1901, Gender.Female);

        Romanovs.addMember(Nikolai_II);
        Romanovs.addMember(Aleksandra);
        Romanovs.setMarriage(Nikolai_II, Aleksandra);
        Romanovs.setChildren(Nikolai_II, Olga);
        Romanovs.setChildren(Nikolai_II, Tatyana);
        Romanovs.setChildren(Nikolai_II, Anastasia);
        Romanovs.setChildren(Nikolai_II, Aleksei);
        Romanovs.setChildren(Nikolai_II, Maria);
        System.out.println(Nikolai_II);
        System.out.println("_______________________");

        List<Human> children = Romanovs.getChildren(Aleksandra);
        System.out.println("мать: " + Aleksandra);
        for (Human child : children) {
            System.out.println("\tдети: " + child.toString());
        }
        System.out.println("_______________________");

        List<Human> childList = Romanovs.getChildren(Nikolai_II);
        for (Human child : childList) {
            System.out.println(child.toString());
        }
        System.out.println("_______________________");

        List<Human> descendants = Romanovs.getDescendants(Aleksandra);
        for (Human descendant : descendants) {
            System.out.println(descendant.toString());
        }
        System.out.println("_______________________");

        List<Human> relatives = Romanovs.getRelatives(Aleksei);
        for (Human relative : relatives) {
            System.out.println(relative.toString());
        }
        System.out.println("_______________________");

        List<Human> searchResult = Romanovs.searchByName("Aleksei");
        for (Human human : searchResult)
            System.out.println(human.toString());
        System.out.println("_______________________");
        Romanovs.getInfo();
        System.out.println("_______________________!!!");
        Service service = new Service(Romanovs);
        service.save(Romanovs);
        Family restored = (Family) service.loadFamily();
        restored.getInfo();
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        for (Human human : Romanovs) System.out.println(human.getName());
        System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
        service.sortByName();
        for (Human human : Romanovs) System.out.println(human.getName());
        System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
        service.sortByDate();
        for (Human human : Romanovs) System.out.println(human.getName());



    }
}
