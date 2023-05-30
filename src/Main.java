import tree.Human;

import java.util.List;

/*
Реализовать, с учетом ооп подхода, приложение.
Для проведения исследований с генеалогическим древом.
Идея: описать некоторое количество компонент, например:
модель человека и дерева Под “проведением исследования”
можно понимать например получение всех детей выбранного человека.
* */
public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Vova V Sidorov", 30, "m", "Viktor K Sidorov", "Elena M Sidorova");
        Human human2 = new Human("Kola K Ivanov", 35, "m");
        System.out.println(human1);
        System.out.println(human2);
        human1.getInfo();
    }
}
