import java.util.List;

public class GenealogyTree {
    public static void main(String[] args) {
        // Создание объектов для представления персон
        Person grandfather1 = new Person("Bob");
        Person grandmother1 = new Person("Alice");
        Person grandfather2 = new Person("Tom");
        Person grandmother2 = new Person("Ann");
        Person father = new Person("Jack");
        Person mother = new Person("Kate");
        Person son = new Person("John");
        Person daughter = new Person("Jane");

        // Установка связей между персонами
        grandfather1.addChild(father);
        grandmother1.addChild(father);
        grandfather2.addChild(mother);
        grandmother2.addChild(mother);
        father.addChild(son);
        mother.addChild(son);
        father.addChild(daughter);
        mother.addChild(daughter);

        // Вывод генеалогического дерева
        printGenealogyTree(grandfather1, 0);
        printGenealogyTree(grandmother1, 0);
        printGenealogyTree(grandfather2, 0);
        printGenealogyTree(grandmother2, 0);
    }

    public static void printGenealogyTree(Person person, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println("-" + person.getName());

        List<Person> children = person.getChildren();
        for (Person child : children) {
            printGenealogyTree(child, level + 1);
        }
    }
}