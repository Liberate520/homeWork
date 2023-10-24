package family_tree;

import java.time.LocalDate;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = familyTree();
        System.out.println(tree);
    }
    public class CLS {
        public static void main(String... arg) throws IOException, InterruptedException {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }
    static FamilyTree familyTree(){
        FamilyTree tree = new FamilyTree();

        Human m1 = new Human("Ivan",Gender.male, LocalDate.of(1970,2,23));
        Human f1 = new Human("Svetlana", Gender.female,LocalDate.of(1975,5,16));
        tree.add(m1);
        tree.add(f1);

        Human m2 = new Human("Pavel",Gender.male, LocalDate.of(1990,7,13),m1,f1);
        Human f2 = new Human("Masha", Gender.female,LocalDate.of(1993,1,31),m1,f1);
        tree.add(m2);
        tree.add(f2);

        Human m3 = new Human("Georgiy",Gender.male, LocalDate.of(1941,4,3),LocalDate.of(1996,8,31),null,null);
        m3.addKid(f1);
        tree.add(m3);

        return tree;
    }

}