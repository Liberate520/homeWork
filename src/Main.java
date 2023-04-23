import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        GenealogyTree tree = new GenealogyTree();
        String filePath = "src/tree.txt";
        Writable writable = new FileHandler();
//
//        tree.addHuman(new Human("Иван", "Петров"));
//        tree.addHuman(new Human("Мария", "Петрова"));
//        tree.addHuman(new Human("Татьяна", "Петрова",
//                "01.01.1994",tree.getByName("Иван", "Петров"), tree.getByName("Мария", "Петрова")));
//        tree.addHuman(new Human("Екатерина", "Петрова",
//                "01.01.1995", tree.getByName("Иван", "Петров"), tree.getByName("Мария", "Петрова")));
//        tree.addHuman(new Human("Егор", "Петров",
//                "01.01.2000", tree.getByName("Иван", "Петров"), tree.getByName("Мария", "Петрова")));
//
//        writable.save(tree,filePath);
        GenealogyTree tree = (GenealogyTree) writable.read(filePath);
//        tree.printTree("", tree.getByName("Иван", "Петров"));
        System.out.println(tree.getInfo());
    }
}