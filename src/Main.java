import home_work_class.FamilyTree;
import home_work_class.Gender;
import home_work_class.Human;

import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human human1 = new Human("Алексей", Gender.Male, null);
        familyTree.addHuman(human1);
        System.out.println(familyTree.showHumansList());
    }
}
