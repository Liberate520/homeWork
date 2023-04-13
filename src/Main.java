import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human James = new Human("James", "Potter", LocalDate.of(1960, 2, 27), "Male");
        Human Lily = new Human("Lily", "Potter", LocalDate.of(1960, 1, 30), "Female");

        Human Harry = new Human("Harry", "Potter", LocalDate.of(1980, 7, 31), "Male", James, Lily);
        Human Ginevra = new Human("Ginevra", "Potter", LocalDate.of(1981, 8, 11), "Female");

        Human Albus_Severus = new Human("Albus Severus", "Potter", LocalDate.of(2005 , 9, 1), "Male", Harry, Ginevra);
        Human James_Sirius = new Human("James Sirius", "Potter", LocalDate.of(2003 , 9, 1), "Male", Harry, Ginevra);
        Human Lily_Luna = new Human("Lily Luna", "Potter", LocalDate.of(2007 , 9, 1), "Female", Harry, Ginevra);
        
        James.addChildren(Harry);
        Lily.addChildren(Harry);

        Harry.addChildren(Albus_Severus);
        Harry.addChildren(James_Sirius);
        Harry.addChildren(Lily_Luna);

        Ginevra.addChildren(Albus_Severus);
        Ginevra.addChildren(James_Sirius);
        Ginevra.addChildren(Lily_Luna);
    
        FamilyTree potterTree = new FamilyTree();

        potterTree.addHuman(James);
        potterTree.addHuman(Lily);
        potterTree.addHuman(Harry);
        potterTree.addHuman(Ginevra);
        potterTree.addHuman(Albus_Severus);
        potterTree.addHuman(James_Sirius);
        potterTree.addHuman(Lily_Luna);


        // System.out.println(potterTree);

        LoadFile load = new LoadFile();
        load.save(potterTree, "treeOut.out");
        System.out.println(load.read("treeOut.out"));

        System.out.println("-----\n");
        potterTree.printTree();

        System.out.println("-----\nсортирорвка по имени:\n");
        potterTree.sortByName();
        potterTree.printTree();

        System.out.println("-----\nсортирорвка по дате:\n");
        potterTree.sortByBirthDate();
        potterTree.printTree();

        System.out.println();
        System.out.println();

    }
}
