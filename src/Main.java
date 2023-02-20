import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        ReadWritable fileHandler = new FileHandler("data.out");
        tree = (FamilyTree) fileHandler.read();

        tree.add(new Person("Михаил Федорович", Gender.MALE));
        tree.add(new Person("Евдокия Лукьяновна Стрешнева", Gender.FEMALE));
        tree.add(new Person("Алексей Михайлович", Gender.MALE, tree.getByName("Михаил Федорович"), tree.getByName("Евдокия Лукьяновна Стрешнева")));
        fileHandler.write(tree);
        System.out.println(tree. getInfo());
    }
}
