public class Main {
    public static void main(String[] args) {
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

//        System.out.println(human6.equals(human6));

        System.out.println(child1.getInfo());
    }
}
