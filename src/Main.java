public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.add(new Human("Valet", "male"));
        tree.add(new Human("Valentina", "female"));

        tree.add(new Human("Macheto", "male", "Valet", "Valentina"));
        tree.add(new Human("Vitamin", "female", "Valet", "Valentina"));
        tree.add(new Human("Protein", "male", "Valet", "Valentina"));

        tree.add(new Human("Creatin", "male", "Macheto", "Pinacheto"));
        tree.add(new Human("Qwerty", "female", "Franchesko", "Zima"));

        System.out.println(tree.getTree());
        System.out.println(tree.getInfoHumanChildren("valet"));
    }
}