import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human humanKrivenkoP = new Human("Кривенко","Павел");
        Human humanKrivenkoS = new Human("Кривенко","Светлана");
        Human humanKrivenkoAy = new Human("Кривенко","Андрей",humanKrivenkoS,humanKrivenkoP);
        Human humanKrivenkoAt = new Human("Кривенко","Антон",humanKrivenkoS,humanKrivenkoP);
        Human humanKrivenkoO = new Human("Кривенко","Ольга");
        FamilyTree familyKrivenko = new FamilyTree();
        FamilyTree familyKrivenko2 = new FamilyTree();

        humanKrivenkoP.addChildren(humanKrivenkoAy);
        humanKrivenkoP.addChildren(humanKrivenkoAt);
        humanKrivenkoS.addChildren(humanKrivenkoAy);
        humanKrivenkoS.addChildren(humanKrivenkoAt);

        familyKrivenko.AddFamilyTree(humanKrivenkoP);
        familyKrivenko.AddFamilyTree(humanKrivenkoS);
        familyKrivenko.AddFamilyTree(humanKrivenkoAy);
        familyKrivenko.AddFamilyTree(humanKrivenkoAt);

        familyKrivenko2.AddFamilyTree(humanKrivenkoAy);
        familyKrivenko2.AddFamilyTree(humanKrivenkoO);


        List<Human> children = humanKrivenkoAy.getMother().getChildren();
        children.remove(humanKrivenkoAy);
        System.out.println(children);

    }

}