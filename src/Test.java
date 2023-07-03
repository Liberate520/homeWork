import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Human anna = new Human("Анна", "Иванова", LocalDate.of(1970, 1, 1), Gender.FEMALE);
        Human petr = new Human("Петр", "Иванов", LocalDate.of(1969, 5, 20), Gender.MALE);
        Human irina = new Human("Ирина", "Петрова", LocalDate.of(1990, 10, 10), Gender.FEMALE, anna, petr, null, null,
                null, null);
        Human aleksey = new Human("Алексей", "Иванов", LocalDate.of(1995, 3, 15), Gender.MALE, anna, petr, null, null,
                null, null);
        Human mariya = new Human("Мария", "Иванова", LocalDate.of(1998, 12, 31), Gender.FEMALE, anna, petr, null, null,
                null, null);

        List<Human> children = new ArrayList<>();
        children.add(irina);
        children.add(aleksey);
        children.add(mariya);

        List<Human> brothers = new ArrayList<>();
        brothers.add(aleksey);

        List<Human> sisters = new ArrayList<>();
        sisters.add(mariya);

        anna.setChildren(children);
        anna.setSisters(sisters);
        petr.setChildren(children);
        petr.setBrothers(brothers);

        System.out.println(anna);
        System.out.println(petr);
        System.out.println(irina);
        System.out.println(aleksey);
        System.out.println(mariya);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(anna);
        familyTree.addHuman(petr);
        familyTree.addHuman(irina);
        familyTree.addHuman(aleksey);
        familyTree.addHuman(mariya);

        List<Human> irinaParents = familyTree.getParents(irina);
        System.out.println("Ирины родители: " + irinaParents);

        List<Human> alekseySiblings = familyTree.getSiblings(aleksey);
        System.out.println("Братья и сестры Алексея: " + alekseySiblings);

        List<Human> annaChildren = familyTree.getChildren(anna);
        System.out.println("Дети Анны: " + annaChildren);
    }
}