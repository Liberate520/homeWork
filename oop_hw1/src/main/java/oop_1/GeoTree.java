package oop_1;

import java.io.Serializable;
import java.util.ArrayList;

public class GeoTree implements Serializable {
    private ArrayList<Connection> connect = new ArrayList<>(); // коллекция родственных связей

    public ArrayList<Connection> getConnect() {
        return connect;
    }

    public void setConnect(ArrayList<Connection> connect) {
        this.connect = connect;
    }

    public void addParentChildren(Person parent, Person children) {
        connect.add(new Connection(parent, Status.parrent, children));
        connect.add(new Connection(children, Status.children, parent));
    }

    public void addGrandparentGrandchildren(Person grandparent, Person grandchildren) {
        connect.add(new Connection(grandparent, Status.grandparent, grandchildren));
        connect.add(new Connection(grandchildren, Status.grandchildren, grandparent));
    }

    public void addHusbandWife(Person husband, Person wife) {
        connect.add(new Connection(husband, Status.husband, wife));
        connect.add(new Connection(wife, Status.wife, husband));
    }

    public void addBrotherSister(Person brother, Person sister) {
        connect.add(new Connection(brother, Status.brother, sister));
        connect.add(new Connection(sister, Status.sister, brother));
    }

    public void addBrotherBrother(Person brother1, Person brother2) {
        connect.add(new Connection(brother1, Status.brother, brother2));
        connect.add(new Connection(brother2, Status.brother, brother1));
    }

    public void addBSisterSister(Person sister1, Person sister2) {
        connect.add(new Connection(sister1, Status.sister, sister2));
        connect.add(new Connection(sister2, Status.sister, sister1));
    }
    // метод поиска связей по полному имени
    public void searchForConnections(String userInput) {
        boolean flag = false;
        for (Connection t : connect) {
            if (t.getP1().getFull_name().equalsIgnoreCase(userInput)) {
                System.out.println(t);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Человек не найден!");
        }
    }

}
