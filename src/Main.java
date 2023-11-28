import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Создаем объекты класса Person для представления людей
        Person person1 = new Person("Ян", 30);
        Person person2 = new Person("Света", 25);
        Person person3 = new Person("Илья", 5);
        Person person4 = new Person("Катерина", 10);

        // Связываем людей в древо генеалогии
        person1.addChild(person2);
        person1.addChild(person3);
        person2.addChild(person4);

        // Создаем объект класса FamilyTree с корневым человеком
        FamilyTree familyTree = new FamilyTree(person1);

        // Получаем всех детей выбранного человека
        List<Person> allChildren = familyTree.getAllChildren(person1);

        // Выводим всех детей выбранного человека
        System.out.println("Children of " + person1.getName() + ":");
        for (Person child : allChildren) {
            System.out.println(child.getName());
        }
    }
}
