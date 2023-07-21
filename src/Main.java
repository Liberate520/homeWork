import family_tree.FamilyStatus;
import family_tree.FamilyTree;
import family_tree.Gender;
import family_tree.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree(20);

        Human human1 = new Human("Иванов Иван Иванович", Gender.Male, LocalDate.of(1996,04,06), LocalDate.now(), FamilyStatus.NoMarried);

        System.out.println(human1.getAge());
    }
}
