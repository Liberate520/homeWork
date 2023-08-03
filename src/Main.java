public class Main {
    public static void main(String[] args) {
        Human vasya = new Human("Вася", 23);
        Human sanya = new Human("Александр", 28);
        Human anya = new Human("Аня", 30);
        Human lera = new Human("Лера", 22);
        Human tanya = new Human("Таня", 9);
        Human kirill = new Human("Кирилл", 2);
        Human andatra = new Human("Андатра", 40);
        Human jenya = new Human("Женя", 45);
        Family_Tree ft = new Family_Tree();
        ft.appendParentChild(jenya, vasya);
        ft.appendParentChild(andatra, vasya);
        ft.appendParentChild(vasya, kirill);
        ft.appendParentChild(lera, kirill);
        ft.appendParentChild(jenya, anya);
        ft.appendParentChild(andatra, anya);
        ft.appendParentChild(anya, tanya);
        ft.appendParentChild(sanya, tanya);
        ft.appendWifeHusband(jenya, andatra);
        ft.appendWifeHusband(anya, sanya);
        ft.appendWifeHusband(lera, vasya);

        System.out.println("Дети Жени");
        System.out.println(new Reserch(ft).spend(jenya, Relationship.parent));

        System.out.println("Дети Васи");
        System.out.println(new Reserch(ft).spend(vasya, Relationship.parent));

        System.out.println("Жена Александра");
        System.out.println(new Reserch(ft).spend(sanya, Relationship.husband));
    }
}
