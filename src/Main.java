import java.io.File;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree tree1 = new FamilyTree();
        tree1.add(new Human("Василий", "Иванов", Gender.Male, LocalDate.of(1991, 12, 25),null,null,null));
        tree1.add(new Human("Кристина", "Иванова", Gender.Female, LocalDate.of(1988, 1, 2),null,null,null));
        tree1.add(new Human("Ольга", "Иванова",Gender.Female, LocalDate.of(2010, 1, 2),
                null, tree1.getByFirstLastName("Василий","Иванов"),tree1.getByFirstLastName("Кристина","Иванова")));
        tree1.add(new Human("Иван", "Иванов",Gender.Male, LocalDate.of(2011, 5, 6),
                null, tree1.getByFirstLastName("Василий","Иванов"),tree1.getByFirstLastName("Кристина","Иванова")));

        FamilyTree tree2 = new FamilyTree();
        tree2.add(new Human("Игорь", "Крылатов", Gender.Male, LocalDate.of(1970, 11, 20)));
        tree2.add(new Human("Галина", "Крылатова", Gender.Female, LocalDate.of(1969, 11, 20)));
        tree2.add(new Human("Нина", "Крылатова",Gender.Female, LocalDate.of(2005, 5, 9),
                null, tree2.getByFirstLastName("Игорь","Крылатов"),tree2.getByFirstLastName("Галина","Крылатова")));


        System.out.println("Дерево 1: " + tree1.getInfo());
        System.out.println("Дерево 2: " + tree2.getInfo());
        System.out.println("\r");
        
        Serializer serializer = new TreeSerializer();
        String filePath1 = "tree1.dat";
        String filePath2 = "tree2.dat";
        File f1 = new File(filePath1);
        FamilyTree loadedtree1;
        if(f1.exists() && !f1.isDirectory()) {
            loadedtree1 = (FamilyTree)serializer.load(filePath1);
            System.out.println("Загруженное дерево 1: " + loadedtree1.getInfo());
        } else {
            serializer.save(tree1, filePath1);
        }
        File f2 = new File(filePath2);
        FamilyTree loadedtree2;
        if(f2.exists() && !f2.isDirectory()) {
            loadedtree2 = (FamilyTree)serializer.load(filePath2);
            System.out.println("Загруженное дерево 2: " + loadedtree2.getInfo());
        } else {
            serializer.save(tree2, filePath2);
        }
    }

}
