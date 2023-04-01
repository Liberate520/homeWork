import geotree.GeoTree;
import person.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class Research {
    private ArrayList<String> result = new ArrayList<>();
    private ArrayList<Person> tree;
    private ArrayList<String> resultAge = new ArrayList<>();

    public Research(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    // метод поиска связи
    public ArrayList<String> spend(Person person, String re) {
        for (Person p : tree) {
            if (p == person && re.equals("mother")) {
                result.add(p.getMother().getInfo());
            } else {
                if (p == person && re.equals("father")) {
                    result.add(p.getFather().getInfo());
                } else {
                    if (p == person && re.equals("child")) {
                        result.add(p.getChildrenInfo());
                    }
                }
            }
        }
        return result;
    }

    // метод поиска по возрасту
    public ArrayList<String> searchAge() {
        System.out.print("Введите ограничение по возрасту: ");
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();
        System.out.println("Люди, младше: " + age + ":");

        for (Person p : tree) {
            if (p.getAge() <= age && !resultAge.contains(p.getInfo())) {
                resultAge.add(p.getInfo());
            }
        }
        return resultAge;
    }
}