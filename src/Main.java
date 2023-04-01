public class Main {
    public static void main(String[] args) {
        Human James = new Parent("James", "Potter", 27, 3, 1960, "Male");
        Human Lily = new Parent("Lily", "Potter", 30, 1, 1960, "Female");

        Human Harry = new Parent("Harry", "Potter", 31, 7, 1980, "Male");
        Human Ginevra = new Parent("Ginevra", "Potter", 11, 8, 1981, "Female");

        Human Albus_Severus = new Human("Albus Severus", "Potter", 1, 9, 2005, "Male");
        Human James_Sirius = new Human("James Sirius", "Potter", 1, 9, 2003, "Male");
        Human Lily_Luna = new Human("Lily Luna", "Potter", 1, 9, 2007, "Female");

        
        FamilyTree potterTree = new FamilyTree();

        potterTree.put(James, Lily, Harry);
        potterTree.put(Harry, Ginevra, Albus_Severus);
        potterTree.put(Harry, Ginevra, James_Sirius);
        potterTree.put(Harry, Ginevra, Lily_Luna);

        System.out.println(potterTree);

    }
}
