// Реализовать, с учетом ооп подхода, приложение
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например:
// модель человека и модель семейного дерева для хранения связей и отношений между людьми: родитель, ребёнок - классика, но можно подумать и про отношение, брат, свекровь, сестра и т. д.
// У дерева обязательно реализовать метод добавления нового человека в семейное дерево, поиск человека по имени и вывод всех людей из дерева.
// У человека можно реализовать методы вывода всех сестер или всех детей.
// Проект сдать либо в виде репозитория либо в виде PullRequest к проекту: https://github.com/Liberate520/homeWork
// Если делаете PR, то в качестве ответа укажите ссылку на конкретный PR
// Инструкция на то как сделать PR https://youtu.be/veMDnBt30pk

// В проекте с гениалогическим древом подумайте и используйте интерфейсы.
// Дополнить проект методами записи в файл и чтения из файла. Для этого создать отдельный класс и реализовать в нем нужные методы. Для данного класса сделайте интерфейс, 
// который и используйте в своей программе. Например в классе дерева в качестве аргумента метода save передавайте не конкретный класс, а объект интерфейса, 
// с помощью которого и будет происходить запись. Пример работы с интерфейсом Serialazable можно найти в материалах к уроку

// В проекте с деревом реализовать интерфейс Iterable для дерева.
// Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения
// Сделать итератор и компараторы

// Продолжаем грейдить наш проект с гениологическим древом. Изменить древо, сделать класс параметизированным. 
// Продумать класс общения с пользователем, сделать набор команд, для операций над деревом

// Продолжаем работать с проектом дерева. Попытаться структурировать список команд. Если не создан отдельный класс 
// под общение с пользователем, то создать. Все процессы связанные с выводом на консоль или чтением с консоли необходимо делать 
// только в одном специализированном классе (например View). Сам этот класс может общаться со многими классами позволяющих ему реализовать эти две задачи.
// Можно также разбить команды на отдельные классы, связанные интерфейсом (смотри пример в конце семинара). Если все и так уже реализовано в таком виде, то просто сдаем работу)

// Рефакторинг и\или оптимизация проекта предыдущего дз с учетом теоретических основ SOLID’а

package DZ1.app;

import java.io.IOException;
import java.io.Serializable;

import DZ1.Model.FamilyTree;
import DZ1.Model.FamilyTreeOperator;
import DZ1.Model.Human;
import DZ1.UI.FamilyTreeUI;
import DZ1.UI.View;

public class program implements Serializable {
        public static void main(String[] args) throws IOException, ClassNotFoundException {

                View view = new FamilyTreeUI();
                FamilyTree<Human> familyTree = new FamilyTree<>();
                FamilyTreeOperator familyTreeOperator = new FamilyTreeOperator(familyTree);
                Presenter presenter = new Presenter(view, familyTree, familyTreeOperator);

                Human human1 = new Human("Иван", "м");
                familyTreeOperator.add(human1);
                Human human2 = new Human("Мария", "ж");
                familyTreeOperator.add(human2);
                Human human3 = new Human("Василий", "м", familyTree.getHumanByName("Иван"),
                                familyTree.getHumanByName("Мария"));
                familyTreeOperator.add(human3);
                Human human4 = new Human("Дарья", "ж", familyTree.getHumanByName("Иван"),
                                familyTree.getHumanByName("Мария"));
                familyTreeOperator.add(human4);
                Human human5 = new Human("Галина", "ж");
                familyTreeOperator.add(human5);
                Human human6 = new Human("Сергей", "м", familyTree.getHumanByName("Василий"),
                                familyTree.getHumanByName("Галина"));
                familyTreeOperator.add(human6);

                view.start();

        }
}
