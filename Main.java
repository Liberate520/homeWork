import java.time.LocalDate;

public class Main {
        public static void main(String[] args) {
                Human cat = new Human("Cat", "Smith",
                                null, null, null,
                                Gender.Female, LocalDate.of(1970, 7, 28), LocalDate.of(1993, 4, 21));
                Human tom = new Human("Tom", "Smith",
                                null, null, null,
                                Gender.Male, LocalDate.of(1973, 4, 21), LocalDate.of(1999, 4, 21));
                Human sam = new Human("Sam", "Smith",
                                null, null, null,
                                Gender.Male, LocalDate.of(1990, 4, 23));
                cat.addChildren(sam);
                tom.addChildren(sam);
                sam.setMather(cat);
                sam.setFather(tom);
                FamilyTree f = new FamilyTree<>();
                f.add(sam);
                f.add(cat);
                f.add(tom);

                HumanPrint.printHumanFLA(f.findMather(sam));
                HumanPrint.printHumanFLA(f.findFather(sam));

                FamilyTreeGUI.getChildren(f, cat);
                FamilyTreeGUI.getParrents(f, sam);
                System.out.println("До сериализации:");
                FamilyTreeGUI.PrintAll(f);
                FamilyTreeGUI.SaveObject("test.dat", f);
                FamilyTree ff = FamilyTreeGUI.LoadObject("test.dat");
                System.out.println("После сериализации:");
                FamilyTreeGUI.PrintAll(ff);

        }
}
