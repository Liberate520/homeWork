public class Main {
    public static void main(String[] args) {
        String filePath = "tree.txt";
        Writable writable = new FileHandler();

//        FamilyTree tree = (FamilyTree) writable.load(filePath);

        FamilyTree tree = new FamilyTree();
        Human mother = new Human("Ekaterina", "Ivanova", "04.11.1975");
        Human father = new Human("Serg", "Petrov", "05.12.1975");
        Human child1 = new Human("Olga", "Petrova", "06.01.1998", mother, father);
        Human child2 = new Human("Oleg", "Petrov", "07.03.2014", mother, father);
        Human child3 = new Human("Dmitry", "Petrov", "08.04.2020", mother, father);
        Human human6 = new Human("Ekaterina", "Ivanova", "04.11.1975");

        tree.addHuman(mother);
        tree.addHuman(father);
        tree.addHuman(child1);
        tree.addHuman(child2);
        tree.addHuman(child3);

        writable.save(tree, filePath);

        System.out.println(tree.getInfo());
    }
}
