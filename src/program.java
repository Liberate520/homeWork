// Реализовать, с учетом ооп подхода, приложение
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например:
// модель человека и модель семейного дерева для хранения связей и отношений между людьми: родитель, ребёнок - классика, но можно подумать и про отношение, брат, свекровь, сестра и т. д.
// У дерева обязательно реализовать метод добавления нового человека в семейное дерево, поиск человека по имени и вывод всех людей из дерева.
// У человека можно реализовать методы вывода всех сестер или всех детей.
// Проект сдать либо в виде репозитория либо в виде PullRequest к проекту: https://github.com/Liberate520/homeWork
// Если делаете PR, то в качестве ответа укажите ссылку на конкретный PR
// Инструкция на то как сделать PR https://youtu.be/veMDnBt30pk

package ForkDZ.OOP_homeWork_1.src;

import java.util.*;

public class program {
    public static void main(String[] args) {

        int flagOutofMainLoop = 0;

        FamilyTree familyTree = new FamilyTree();
        familyTree.add(new Human("Иван", "м"));
        familyTree.add(new Human("Мария", "ж"));
        // Тут изначально просится сделать автоматическое добавление братьев и сестер,
        // если совпадает хотя бы один из родителей, но пока не реализовал, потому пока
        // добавляем при создании руками
        // Наверное, нужно вынести отдельный метод, который будет пробегать по всем
        // членам семейного дерева и выявлять братьев и сестер
        familyTree
                .add(new Human("Василий", "м", familyTree.getHumanByName("Иван"), familyTree.getHumanByName("Мария")));
        // System.out.println(familyTree.getHumanByName("Василий"));
        familyTree
                .add(new Human("Дарья", "м", familyTree.getHumanByName("Иван"), familyTree.getHumanByName("Мария"),
                        familyTree.getHumanByName("Василий")));
        familyTree.add(new Human("Галина", "м"));
        familyTree
                .add(new Human("Сергей", "м", familyTree.getHumanByName("Василий"),
                        familyTree.getHumanByName("Галина")));

        // не знаю, в чем проблема, но в моем случае работает только с такой кодировкой
        // - Cp866
        Scanner scanner = new Scanner(System.in, "Cp866");

        while (flagOutofMainLoop == 0) {

            System.out.println(
                    "\n1 - Вывести всех людей из дерева\n2 - Поиск по имени\n3 - Выход\nВведите цифру, соответствующую необходимому критерию:");

            int userChoiceStartMenu = scanner.nextInt();

            switch (userChoiceStartMenu) {
                case 1:
                    scanner.nextLine();
                    System.out.println(familyTree.getAllHumans());
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Введите имя: ");
                    String userInputName = scanner.nextLine();
                    System.out.println(familyTree.gethumanByNameAndRelatives(userInputName));
                    break;
                case 3:
                    flagOutofMainLoop = 1;
                    break;
                default:
                    System.out.println("Некорректный ввод ");
                    break;
            }
        }

    }
}
