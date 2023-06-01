import tree.FamilyTree;
import tree.Human;

/*
Реализовать, с учетом ооп подхода, приложение.
Для проведения исследований с генеалогическим древом.
Идея: описать некоторое количество компонент, например:
модель человека и дерева Под “проведением исследования”
можно понимать например получение всех детей выбранного человека.
* */
public class Main {
    public static void main(String[] args) {
        FamilyTree family = new FamilyTree();

        family.add(new Human("Вова", 30));
        family.add(new Human("Алла", 30));

        family.add(new Human("Василий", 12, family.findPerson("Вова"), family.findPerson("Алла")));

        System.out.println(family.findHuman());
    }
}
