

public class main {
    public static void main(String [] args) {

        FamilyTree tree = new FamilyTree();

        Human h1 = new Human("Иванов Иван", 22);
        tree.treeHuman.add(h1);
        Human h2 = new Human("Иванова Ирина", 5);
        tree.treeHuman.add(h2);
        Human h3 = new Human("Иванов Святослав", 50);
        tree.treeHuman.add(h3);
        Human h4 = new Human("Иванова Иванна", 20);
        tree.treeHuman.add(h4);
        Human h5 = new Human("Иванова Светлана", 49);
        tree.treeHuman.add(h5);



        h1.addCommunications(h2, 1, 1);
        h1.addCommunications(h3, 1, 1);
        h1.addCommunications(h5, 1, 1);
        h2.addCommunications(h4, 1, 1);
        h2.addCommunications(h5, 1, 2);
        h2.addCommunications(h3, 1, 2);


        h1.printRelatives(1);

        tree.PreOreder(h1,"");
    }
}