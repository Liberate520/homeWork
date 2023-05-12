public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        tree.add(new Human("Сергей", Gender.Male));
        tree.add(new Human("Маша", Gender.Female));
        tree.add(new Human("Дима", Gender.Male, tree.getByName("Сергей"), tree.getByName("Маша")));
        tree.add(new Human("Наташа", Gender.Female, tree.getByName("Сергей"), tree.getByName("Маша")));
        tree.add(new Human("Паша", Gender.Male, tree.getByName("Сергей"), tree.getByName("Маша")));
        
        System.out.println(tree.getInfo());
    }
}
