import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Oleg", Gender.Male, LocalDate.of(2001,
                11, 7), null, null,
                null);
        Human human2 = new Human("Sveta", Gender.Female, LocalDate.of(1983,
                3, 24), LocalDate.of(2016, 6, 3),
                null, null);
        Human human3 = new Human("Dima", Gender.Male, LocalDate.of(2019,
                1, 18), null, human1,
                human2);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        human3.addChildren(human3);

        System.out.println(familyTree.getHumansInfo());
        System.out.println(human3.getChildrenInfo());

    }
}