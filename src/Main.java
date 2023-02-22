import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        ReadWritable fileHandler = new FileHandler("data.out");
        tree = (FamilyTree) fileHandler.read();

        tree.add(new Person("Михаил Федорович", Gender.MALE, 1613, null, null));
        tree.add(new Person("Евдокия Лукьяновна Стрешнева", Gender.FEMALE, 1608, null, null));
        tree.add(new Person("Алексей Михайлович", Gender.MALE, 1645, tree.getByName("Михаил Федорович"), tree.getByName("Евдокия Лукьяновна Стрешнева")));

        System.out.println(tree.getInfo());
        fileHandler.write(tree);
        tree.sortByName();
        System.out.println(tree.getInfo());
        tree.sortByBirthDate();
        System.out.println(tree.getInfo());
    }
}
