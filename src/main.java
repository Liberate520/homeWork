package homeWork.src;

//Реализовать, с учетом ооп подхода, приложение
//Для проведения исследований с генеалогическим древом.
//Идея: описать некоторое количество компонент, например:
//
//модель человека и модель семейного дерева для хранения связей и отношений между людьми: родитель, ребёнок - классика,
// но можно подумать и про отношение, брат, свекровь, сестра и т. д.
//У дерева обязательно реализовать метод добавления нового человека в семейное дерево, поиск человека по имени и вывод всех людей из дерева.
//У человека можно реализовать методы вывода всех сестер или всех детей.
//
//Проект сдать либо в виде репозитория либо в виде PullRequest к проекту: https://github.com/Liberate520/homeWork
//Если делаете PR, то в качестве ответа укажите ссылку на конкретный PR
//Инструкция на то как сделать PR https://youtu.be/veMDnBt30pk
//По вопросам домашки писать @Liberate520
//Обязательно пробуем свои силы, в дальнейшем будем этот проект развивать



public class main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();
//        Сначала необходимо создать самых старших членов семьи, у которых родители неизвестны
        Human human1 = new Human("Vasiliy", "M");
        Human human2 = new Human("Maria", "W");
//        System.out.println(human1);
//        System.out.println(human2);
        familyTree.addNewMember(human1);
        familyTree.addNewMember(human2);
//        System.out.println(familyTree);
        Human human3 = new Human("Petr", "M", human1, human2);
        Human human4 = new Human("Tatyana", "W", human1, human2);
        Human human5 = new Human("Elena", "W", human1, human2);
        Human human6 = new Human("Mikhail", "M", human3, human4);
        Human human7 = new Human("Ivan", "M", human3, human4);

        familyTree.addNewMember(human3);
        familyTree.addNewMember(human4);
        familyTree.addNewMember(human5);
        familyTree.addNewMember(human6);
        familyTree.addNewMember(human7);

        System.out.println(familyTree);

        Human human = familyTree.getByName("petr");
        System.out.printf("Нашёл\n%s", human);

        System.out.println(human1.getAllChildren());
        System.out.printf("Сёстры %s - %s\n", human4.getName(), human4.getAllSisters());
        System.out.println(human7.getAllSisters());

    }
}
