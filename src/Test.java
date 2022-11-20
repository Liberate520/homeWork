import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Human root = new Human("Человек1");

        Human h2 = new Human("Человек2");
        Human h3 = new Human("Человек3");
        Human h4 = new Human("Человек4");
        Human h5 = new Human("Человек5");
        Human h6 = new Human("Человек6");
        Human h7 = new Human("Человек7");
        Human h8 = new Human("Человек8");
        Human h9 = new Human("Человек9");
        Human h10 = new Human("Человек10");
        Human h11 = new Human("Человек11");

        ArrayList<Human> temp_array_root = new ArrayList<Human>();
        temp_array_root.add(h2);
        temp_array_root.add(h3);
        root.son = temp_array_root;

        ArrayList<Human> temp_array_h2 = new ArrayList<Human>();
        temp_array_h2.add(h4);
        temp_array_h2.add(h5);
        h2.son = temp_array_h2;

        ArrayList<Human> temp_array_h3 = new ArrayList<Human>();
        temp_array_h3.add(h6);
        temp_array_h3.add(h7);
        h3.son = temp_array_h3;

        ArrayList<Human> temp_array_h4 = new ArrayList<Human>();
        temp_array_h4.add(h8);
        temp_array_h4.add(h9);
        temp_array_h4.add(h10);
        h4.son = temp_array_h4;

        ArrayList<Human> temp_array_h6 = new ArrayList<Human>();
        temp_array_h6.add(h11);
        h6.son = temp_array_h6;

        preOrder(root, "");
    }

    static void preOrder(Human tree, String space) {
        if (tree != null)
            System.out.println(space + tree.name);
        else {
            System.out.println(space + "nil");
            return;
        }

        for (int i = 0; i < tree.son.size(); i++){
            preOrder(tree.son.get(i), space + "  ");
        }
    }
}

class Human{
    String name;
    ArrayList<Human> son = new ArrayList<Human>();

    public Human(String name) {
        this.name = name;
    }
    public Human(String name, ArrayList son) {
        this.name = name;
        this.son = son;
    }

    public Human addSon(ArrayList<Human> son) {
        for (int i = 0; i < son.size(); i++){
            this.son.add(son.get(i));
        }
        return this;
    }
}