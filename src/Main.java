public class Main {
    public static void main(String[] args) {
        Human mother = new Human("Ekaterina", "Ivanova", "04.11.1975");
        Human father = new Human("Serg", "Petrov", "05.12.1975");
        Human child1 = new Human("Olga", "Petrova", "06.01.1998");
        Human child2 = new Human("Oleg", "Petrov", "07.03.2014");
        Human child3 = new Human("Dmitry", "Petrov", "08.04.2020");
        Human human6 = new Human("Ekaterina", "Ivanova", "04.11.1975");

        mother.addChildren(child1);
        father.addChildren(child1);
        mother.addChildren(child2);
        father.addChildren(child2);
        mother.addChildren(child3);
        father.addChildren(child3);

        child1.setFather(father);
        child1.setMother(mother);

        child2.setFather(father);
        child2.setMother(mother);

        child3.setFather(father);
        child3.setMother(mother);

        FamilyTree.searchFamily(child2);

//        System.out.println(mother.equals(human6));
    }
}
