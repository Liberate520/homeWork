package HW1;

public class Tree {

    /**
     * Tree of Rurik dynasty
     */
    public static FamilyTree ruriks = new FamilyTree() {
        {
            addPersonInFamilyTree(new Human("Рюрик", 879));
            addPersonInFamilyTree(new Human("Игорь", 945), "Рюрик");
            addPersonInFamilyTree(new Human("Ольга", 969));
            addPersonInFamilyTree(new Human("Святослав", 972), "Игорь", "Ольга");
            addPersonInFamilyTree(new Human("Олег", 977), "Святослав");
            addPersonInFamilyTree(new Human("Владимир", 1015), "Святослав");
            addPersonInFamilyTree(new Human("Ярополк", 980), "Святослав");
        }
    };
}
