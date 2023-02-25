package Java_OOP.homeWork;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FamilyTree fTree = new FamilyTree("Королевская семья Великобритании", new ArrayList<Human>());
        
        Human h1 = new Human("Елизавета II", 1920, "female");
        Human h2 = new Human("Филипп", 1921, "male");
        Human h3 = new Human("Карл III", 1948, "male", h2, h1);
        Human h4 = new Human("Анна Элизабет Элис Луиза", 1955, "female", h2, h1);
        Human h5 = new Human("Диана", 1961, "female");
        Human h6 = new Human("Эндрю", 1960, "male", h2, h1);
        Human h7 = new Human("Сара", 1959, "female");
        Human h8 = new Human("Эдвард", 1964, "male", h2, h1);
        Human h9 = new Human("Софи", 1965, "female");
        Human h10 = new Human("Евгения", 1990, "female", h6, h7);
        Human h11 = new Human("Джек Бруксбэнк", 1986, "male");
        Human h12 = new Human("Филипп", 2021, "male", h11, h10);

        fTree.includeInFamily(h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12);

        System.out.println("\u001B[31m-----------Все члены семьи-----------\u001B[0m");

        for (Human h : fTree.getFamily()){
            System.out.println(h);
        }

        System.out.println("\u001B[31m-----------Найти члена семьи по имени-----------\u001B[0m");

        for (Human h : fTree.searchHuman("Филипп")){
            System.out.println(h);
        }

        System.out.println("\u001B[31m-----------Показать детей-----------\u001B[0m");

        for (Human child : h1.getChildren()){
            System.out.println(child);
        }
    }
}
