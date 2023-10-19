import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human(1, "Masha", Gender.female, LocalDate.of(1960, 10, 5));
        Human human2 = new Human(2, "Sveta", Gender.female, LocalDate.of(1985, 5, 15));
        Human human3 = new Human(3, "Misha", Gender.male, LocalDate.of(1958, 10, 26));
        Human human4 = new Human(4, "Petr", Gender.male, LocalDate.of(1935, 1, 7));
        Human human5 = new Human(5, "Ivan", Gender.male, LocalDate.of(1990, 7, 4));
        human2.setParentDad(human3, human2);
        human2.setParentMom(human1, human2);
        human1.setParentDad(human4, human1);
        human5.setParentDad(human3, human5);
        human5.setParentMom(human1, human5);
        human4.setDeathday(LocalDate.of(2000, 12, 4));

        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.getAllHuman();

        familyTree.getHuman(1);
    }
}
