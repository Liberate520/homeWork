package tree;

import human.Human;
import relative.Relative;


import java.util.ArrayList;


public class Compilation {
    ArrayList<Node> tree;

    public Compilation(Node geoTree) {
        tree = geoTree.getTree();
    }

    private ArrayList<Human> search(Human p, Relative rel) {
        ArrayList<Human> result = new ArrayList<>();
        result.add(p);
        for (Node node : tree) {
            if (node.person1 == p && node.getRe() == rel) {
                result.add(node.person2);
            }
        }
        return result;
    }

    public void printSearch(Human p, Relative rel) {
        ArrayList<Human> source = search(p, rel);
        System.out.println(source.remove(0).getInfo() + " " + rel + ":");
        if (source.isEmpty()) {
            System.out.println("Нет информации ");
        }
        for (Human person : source) {
            if (rel == Relative.children)
                System.out.println(Relative.parent + " " + person.getFullName());
            else {
                System.out.println(Relative.children + " " + person.getFullName());
            }

        }
    }
}