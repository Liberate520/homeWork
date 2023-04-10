import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human James = new Human("James", "Potter", 27, 3, 1960, "Male");
        Human Lily = new Human("Lily", "Potter", 30, 1, 1960, "Female");

        Human Harry = new Human("Harry", "Potter", 31, 7, 1980, "Male", James, Lily);
        Human Ginevra = new Human("Ginevra", "Potter", 11, 8, 1981, "Female");

        Human Albus_Severus = new Human("Albus Severus", "Potter", 1, 9, 2005, "Male", Harry, Ginevra);
        Human James_Sirius = new Human("James Sirius", "Potter", 1, 9, 2003, "Male", Harry, Ginevra);
        Human Lily_Luna = new Human("Lily Luna", "Potter", 1, 9, 2007, "Female", Harry, Ginevra);
        
        James.addChildren(Harry);
        Lily.addChildren(Harry);

        Harry.addChildren(Albus_Severus);
        Harry.addChildren(James_Sirius);
        Harry.addChildren(Lily_Luna);

        Ginevra.addChildren(Albus_Severus);
        Ginevra.addChildren(James_Sirius);
        Ginevra.addChildren(Lily_Luna);
    
        FamilyTree potterTree = new FamilyTree();

        potterTree.add(James);
        potterTree.add(Lily);
        potterTree.add(Harry);
        potterTree.add(Ginevra);
        potterTree.add(Albus_Severus);
        potterTree.add(James_Sirius);
        potterTree.add(Lily_Luna);


        System.out.println(potterTree);

        LoadFile load = new LoadFile();
        load.save(potterTree, "treeOut.out");
        load.read("treeOut.out");
    }
}
