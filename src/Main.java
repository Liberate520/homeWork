

// Реализовать, с учетом ооп подхода, приложение.
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например:
// модель человека и дерева
// Под “проведением исследования” можно понимать например
// получение всех детей выбранного человека.

public class Main {
    public static void main(String[] args) {

        FamilyTree tree = new FamilyTree();




        tree.addNewHuman(new Human("Ирина", "Малинина", "21.08.1987"), null);
        tree.addNewHuman(new Human("Владимир", "Малинин", "10.02.1985"), null);

        tree.addNewHuman(new Human("Семен", "Малинин", "17.03.2017", tree.getByName("Владимир"), tree.getByName("Ирина")),
                null);
        tree.addNewHuman(new Human("Оля", "Малинина", "27.09.2016", tree.getByName("Владимир"), tree.getByName("Ирина")),
                null);

        tree.addNewHuman(new Human("Олег", "Титов", "10.07.1989"), null);
        tree.addNewHuman(new Human("Алексей", "Титов", "27.09.2019", tree.getByName("Олег"), tree.getByName(null)),
                null);




         System.out.println(tree.getInfo());




    }

}
