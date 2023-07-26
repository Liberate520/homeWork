import java.util.List;

import writer.FileHandler;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/tree.out";
        FamilyTree familyTree = new FamilyTree();

        // Сохраняем результат работы методов с объектами классов
        // FileHandler fileHandler = new FileHandler();
        // fileHandler.save(familyTree, filePath);

        // Не запуская методы классов, выводим результат того, что было сделано ранее
        // FileHandler fileHandler = new FileHandler();
        // FamilyTree familyTree = (FamilyTree)fileHandler.read(filePath);

        Parent misha = new Parent("misha", Gender.MALE, "40", "01.01.1983");
        Person ivan = new Parent("ivan", Gender.MALE, "40", "01.01.1983");
        Person stas = new Parent("stas", Gender.MALE, "40", "01.01.1983");
        Person masha = new Parent("masha", Gender.FEMALE, "40", "01.01.1983");
        Person lena = new Parent("lena", Gender.FEMALE, "40", "01.01.1983");
        Person vika = new Parent("vika", Gender.FEMALE, "40", "01.01.1983");
        Person gendalf = new Parent("gendalf", Gender.MALE, "1000", "01.01.1000", "01.01.2000");
        Person anna = new Parent("anna", Gender.FEMALE, "20", "01.01.2023");
        Person dima = new Parent("dima", Gender.MALE, "20", "01.01.2023");
        Person vova = new Parent("vova", Gender.MALE, "20", "01.01.2023");
        Person olga = new Parent("olga", Gender.FEMALE, "20", "01.01.2023");

        // Добавляем родителей в древо
        familyTree.addParent(misha);
        familyTree.addParent(ivan);
        familyTree.addParent(stas);
        familyTree.addParent(masha);
        familyTree.addParent(lena);
        familyTree.addParent(vika);
        familyTree.addParent(vova);
        familyTree.addParent(gendalf);

        // Добавляем детей к родителям
        familyTree.addChild(misha, ivan);
        familyTree.addChild(masha, ivan);
        familyTree.addChild(misha, vova);
        familyTree.addChild(masha, vova);
        familyTree.addChild(masha, ivan);
        familyTree.addChild(stas, dima);
        familyTree.addChild(vika, dima);
        familyTree.addChild(ivan, olga);
        familyTree.addChild(ivan, vika);
        familyTree.addChild(ivan, anna);

        // Запрашиваем сколько есть детей у конкретного человека
        familyTree.getFamily(ivan);
        familyTree.getFamily(stas);
        familyTree.getFamily(gendalf);

        // Миша женит людей
        misha.marry(stas, lena);
        misha.marry(stas, lena); // Проверка, что пара уже жената
        misha.marry(vika, dima);
        misha.marry(ivan, anna);

        // Печатаем список женатых пар
        List<List<Person>> married = misha.getPairs();
        for (List<Person> pair : married) {
            System.out.println(pair);
        }
    }
}