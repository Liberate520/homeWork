import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = myTree();
        System.out.println(tree);
    }
    static  FamilyTree myTree(){
        FamilyTree tree = new FamilyTree();

        Human ivan = new Human("Иван", LocalDate.of(1963,12,10),
                Gender.Male);
        Human olga = new Human("Ольга", LocalDate.of(1967, 10, 3),
                Gender.Female);
        tree.add(ivan);
        tree.add(olga);

        Human petr = new Human("Пётр", LocalDate.of(1985, 6,12),
                Gender.Male, olga, ivan);
        Human anna = new Human("Анна", LocalDate.of(1989, 4,4),
                Gender.Female, olga, ivan);
        tree.add(petr);
        tree.add(anna);


        return tree;
    }
}
