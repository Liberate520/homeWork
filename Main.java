package homeWork_OOP_family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human gen = new Human("иван", "иванов", "иванович", LocalDate.of(1999, 10, 5), LocalDate.of(3000, 12, 19),
                "male");
        // System.out.println(gen.getGender());
        Node per = new Node(gen);
        // per.printTree();

        Human g1 = new Human("иван1", "иванов", "иванович", LocalDate.of(1999, 10, 5), LocalDate.of(3000, 12, 19),
                "male");
        Node p1 = new Node(g1);
        Human g2 = new Human("иван2ж", "иванов", "иванович", LocalDate.of(1999, 10, 5), LocalDate.of(3000, 12, 19),
                "female");
        Node p2 = new Node(g2);
        Human g3 = new Human("иван3", "иванов", "иванович", LocalDate.of(1999, 10, 5), LocalDate.of(3000, 12, 19),
                "male");
        Node p3 = new Node(g3);
        Human g4 = new Human("иван4ж", "иванов", "иванович", LocalDate.of(1999, 10, 5), LocalDate.of(3000, 12, 19),
                "female");
        Node p4 = new Node(g4);
        Human g5 = new Human("иван5", "иванов", "иванович", LocalDate.of(1999, 10, 5), LocalDate.of(3000, 12, 19),
                "male");
        Node p5 = new Node(g5);
        Human g6 = new Human("иван6ж", "иванов", "иванович", LocalDate.of(1999, 10, 5), LocalDate.of(3000, 12, 19),
                "female");
        Node p6 = new Node(g6);
        Human g7 = new Human("иван7", "иванов", "иванович", LocalDate.of(1999, 10, 5), LocalDate.of(3000, 12, 19),
                "male");
        Node p7 = new Node(g7);
        

        p3.addParent(p4);
        p3.addParent(p5);


        
 
        p3.addChild(p7, p2);
        p7.printParants();
        p3.addChild(p1, p2);

        System.out.println("--------------");

        p5.printTree();
    }

}