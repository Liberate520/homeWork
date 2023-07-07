package homeWork_OOP_family_tree.infoHuman;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable, Comparable<Node>{

    public Human people;
    Node mother;
    Node father;
    public List<Node> children = new ArrayList<>();

    public Node(Human people) {
        this.people = people;
    }

    public void addParent(Node parent) {
        parent.children.add(this);
        if (this.father == null && parent.people.getGender() == "male") {
            this.father = parent;
        } else if (this.mother == null && parent.people.getGender() == "female") {
            this.mother = parent;
        }
    }

    public void addChild(Node child, Node parent) {
        if (this.people.getGender() == "female") {
            child.mother = this;
            child.father = parent;
        } else {
            child.father = this;
            child.mother = parent;
        }
        this.children.add(child);
        parent.children.add(child);
    }

    public void printDescendants() {
        this.people.printHuman();
        System.out.println();
        if (this.children != null) {
            for (int i = 0; i < this.children.size(); i++) {
                this.children.get(i).printDescendants();
            }
            return;
        }
    }

    public void printChildren() {
        System.out.println("Дети: ");
        if (this.children != null) {
            for (int i = 0; i < this.children.size(); i++) {
                this.children.get(i).people.printHuman();
            }
        } else {
            System.out.println("нет");
        }
     }

    public void printParants() {
        if (this.father != null) {
            System.out.println("Отец :");
            this.father.people.printHuman();
            System.out.println();
        } else {
            System.out.println("отец не известен");
        }
        if (this.mother != null) {
            System.out.println("Мать :");
            this.mother.people.printHuman();
            System.out.println();
        } else {
            System.out.println("мать не известна");
        }
    }

    @Override
    public int compareTo(Node o){
        int result = this.people.getFirstName().compareTo(o.people.getFirstName());
        return result;
    }
}
