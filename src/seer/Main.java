package seer;

import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Создаем несколько человек
        Person father = new Person("Сергей", 40, null, null);
        Person mother = new Person("Маша", 35, null, null);
        Person son1 = new Person("Василий", 20, father, mother);
        Person son2 = new Person("Саша", 15, father, mother);
        Person daughter1 = new Person("Наталья", 21, father, mother);
        Person daughter2 = new Person("Юля", 17, father, mother);
        Person father3 = new Person("Юрий", 35, null, null);
        Person mother3 = new Person("Наташа", 33, null, null);
        Person son3 = new Person("Петя", 13, father, mother);
        Person son4 = new Person("Вася", 14, father, mother);
        Person daughter3 = new Person("Катя", 12, father, mother);
        Person daughter4 = new Person("Ира", 17, father, mother);
        Person father5 = new Person("Константин", 80, null, null);
        Person mother5 = new Person("Клава", 70, null, null);
        Person son5 = new Person("Сергей", 40, father, mother);
        Person son6 = new Person("Иван", 35, father, mother);
        Person daughter5 = new Person("Юля", 37, father, mother);
        Person daughter6 = new Person("София", 33, father, mother);
        // Связываем их в дерево генеалогии
        father.addChild(son1);
        father.addChild(son2);
        father.addChild(daughter1);
        father.addChild(daughter2);
        mother.addChild(son1);
        mother.addChild(son2);
        mother.addChild(daughter1);
        mother.addChild(daughter2);
        FamilyTree tree = new FamilyTree(father);
        FamilyTree tree1 = new FamilyTree(mother);
        // Получаем всех детей выбранного человека
        Person selectedPerson = father;
        Person selectedPerson1 = mother;
        ArrayList<Person> allChildren = tree.getAllChildren(selectedPerson);
        ArrayList<Person> allChildren1 = tree.getAllChildren(selectedPerson1);

        // Выводим всех детей выбранного человека
        System.out.println("Дети отца " + selectedPerson.getName() + ":");
        for (Person child : allChildren) {
            System.out.println("Имя: " + child.getName() + ", Возраст: " + child.getAge() + " лет");
        }
        System.out.println();
        System.out.println("Дети матери " + selectedPerson1.getName() + ":");
        for (Person child1 : allChildren1) {
            System.out.println("Имя: " + child1.getName() + ", Возраст: " + child1.getAge() + " лет");
        }
        System.out.println();
        father3.addChild(son3);
        father3.addChild(son4);
        father3.addChild(daughter3);
        father3.addChild(daughter4);
        mother3.addChild(son3);
        mother3.addChild(son4);
        mother3.addChild(daughter3);
        mother3.addChild(daughter4);
        FamilyTree tree3 = new FamilyTree(father3);
        FamilyTree tree4 = new FamilyTree(mother3);
        // Получаем всех детей выбранного человека
        Person selectedPerson3 = father3;
        Person selectedPerson4 = mother3;
        ArrayList<Person> allChildren3 = tree.getAllChildren(selectedPerson3);
        ArrayList<Person> allChildren4 = tree.getAllChildren(selectedPerson4);

        // Выводим всех детей выбранного человека
        System.out.println("Дети отца " + selectedPerson3.getName() + ":");
        for (Person child3 : allChildren3) {
            System.out.println("Имя: " + child3.getName() + ", Возраст: " + child3.getAge() + " лет");
        }
        System.out.println();
        System.out.println("Дети матери " + selectedPerson4.getName() + ":");
        for (Person child4 : allChildren4) {
            System.out.println("Имя: " + child4.getName() + ", Возраст: " + child4.getAge() + " лет");
        }
        System.out.println();
        father5.addChild(son5);
        father5.addChild(son6);
        father5.addChild(daughter5);
        father5.addChild(daughter6);
        mother5.addChild(son5);
        mother5.addChild(son6);
        mother5.addChild(daughter5);
        mother5.addChild(daughter6);
        FamilyTree tree5 = new FamilyTree(father5);
        FamilyTree tree6 = new FamilyTree(mother5);
        // Получаем всех детей выбранного человека
        Person selectedPerson5 = father5;
        Person selectedPerson6 = mother5;
        ArrayList<Person> allChildren5 = tree.getAllChildren(selectedPerson5);
        ArrayList<Person> allChildren6 = tree.getAllChildren(selectedPerson6);

        // Выводим всех детей выбранного человека
        System.out.println("Дети отца " + selectedPerson5.getName() + ":");
        for (Person child5 : allChildren5) {
            System.out.println("Имя: " + child5.getName() + ", Возраст: " + child5.getAge() + " лет");
        }
        System.out.println();
        System.out.println("Дети матери " + selectedPerson6.getName() + ":");
        for (Person child6 : allChildren6) {
            System.out.println("Имя: " + child6.getName() + ", Возраст: " + child6.getAge() + " лет");
        }
    }
}
