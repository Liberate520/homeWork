package homeWork.Homeworke3;

public class Main{
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        // FileHandler fileHandler = new FileHandler();

        tree.add(new Human("Sergey Petrov", 1965));    // Имя: Sergey Petrov, date birth: 1965, мать: неизвестна, отец: неизвестен, дети: Anfisa Ivanova
        tree.add(new Human("Lidiya Petrova", 1966));   // Имя: Lidiya Petrova, date birth: 1966, мать: неизвестна, отец: неизвестен, дети: Anfisa Ivanova
        tree.add(new Human("Evgeniy Ivanov", 1967));   // Имя: Evgeniy Ivanov, date birth: 1967, мать: неизвестна, отец: неизвестен, дети: Grigoriy Ivanov
        tree.add(new Human("Nina Ivanova", 1968));     // Имя: Nina Ivanova, date birth: 1968, мать: неизвестна, отец: неизвестен, дети: Grigoriy Ivanov
        tree.add(new Human("Anfisa Ivanova", 1990, tree.getByName("Sergey Petrov"), tree.getByName("Lidiya Petrova")));  // Имя: Anfisa Ivanova, date birth: 1990, мать: Lidiya Petrova, отец: Sergey Petrov, дети: Ivan Ivanov, Semen Ivanov
        tree.add(new Human("Grigoriy Ivanov", 1991, tree.getByName("Evgeniy Ivanov"), tree.getByName("Nina Ivanova")));  // Имя: Grigoriy Ivanov, date birth: 1991, мать: Nina Ivanova, отец: Evgeniy Ivanov, дети: Ivan Ivanov, Semen Ivanov
        tree.add(new Human("Ivan Ivanov", 1992, tree.getByName("Grigoriy Ivanov"), tree.getByName("Anfisa Ivanova")));   // Имя: Ivan Ivanov, date birth: 1992, мать: Anfisa Ivanova, отец: Grigoriy Ivanov, дети: отсутствуют
        tree.add(new Human("Semen Ivanov", 1993, tree.getByName("Grigoriy Ivanov"), tree.getByName("Anfisa Ivanova")));  // Имя: Semen Ivanov, date birth: 1993, мать: Anfisa Ivanova, отец: Grigoriy Ivanov, дети: отсутствуют

        System.out.println(tree.toString());

        // fileHandler.save(tree);

        // System.out.println(fileHandler.read());

        for (Human human : tree) {
            System.out.println(human);
        }

        tree.sortByName();

        System.out.println(tree.toString());

        tree.sortByAge();

        System.out.println(tree.toString());
    }
}