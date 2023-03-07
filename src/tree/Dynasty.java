package tree;

public class Dynasty {
    public static void dynasty(FamilyTree tree) {
        tree.add(new Person("Михаил Федорович", Gender.MALE, 1613, null, null));
        tree.add(new Person("Евдокия Лукьяновна Стрешнева", Gender.FEMALE, 1608, null, null));
        tree.add(new Person("Алексей Михайлович", Gender.MALE, 1645, tree.getByName("Михаил Федорович"), tree.getByName("Евдокия Лукьяновна Стрешнева")));

    }


}
