
import family_tree.FamilyTree;
import family_tree.Gender;
import family_tree.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree(100);

        Human ivan = new Human("Иван", Gender.Male, LocalDate.of(1900,6,23), LocalDate.of(1985,8,12));
        familyTree.addHuman(ivan);
        Human varvara = new Human("Варвара" , Gender.Female, LocalDate.of(1902,07,23), LocalDate.of(1990,8,12));
        familyTree.addHuman(varvara);
        familyTree.setWedding(ivan.getId(),varvara.getId());
        Human chritina =new Human("Кристина", Gender.Female, LocalDate.of(1988,7,5),LocalDate.now(), ivan, varvara);
        Human semyon =new Human("Семен", Gender.Male, LocalDate.of(1991,1,25),LocalDate.now(), ivan, varvara);
        familyTree.addHuman(chritina);
        familyTree.addHuman(semyon);
        System.out.println(familyTree);
    }
}
