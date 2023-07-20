

import java.util.List;

import familyTree.FamilyTree;
import person.Person;



public class Main {
    public static void main(String[] args) {
        // Создаем несколько человек
        Person person1 = new Person("Иван", 1950);
        Person person2 = new Person("Мария", 1960);
        Person person3 = new Person("Алексей", 1985);

        // Связываем их в генеалогическое древо
        FamilyTree familyTree = new FamilyTree(person2);
        person1.addChild(person2);
        person1.addChild(person3);

        // Пример получения всех детей выбранного человека
        Person selectedPerson = person1;
        List<Person> children = selectedPerson.getChildren();
        if (children.isEmpty()) {
            System.out.println(selectedPerson.getName() + " не имеет детей.");
        } else {
            System.out.println("Дети " + selectedPerson.getName() + ":");
            for (Person child : children) {
                System.out.println("- " + child);
            }
        }
    }
}
