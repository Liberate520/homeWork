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

        Parent vika = new Parent("Вика", Gender.MALE, 60, "01.01.1983");
        Parent masha = new Parent("Маша", Gender.MALE, 45, "01.01.1983");
        Parent borya = new Parent("Боря", Gender.MALE, 23, "01.01.1983");
        Parent lena = new Parent("Лена", Gender.FEMALE, 40, "01.01.1983");
        // Parent gendalf = new Parent("gendalf", Gender.MALE, "1000", "01.01.1000", "01.01.2000");
        // Parent anna = new Parent("anna", Gender.FEMALE, "20", "01.01.2023");
        // Parent dima = new Parent("dima", Gender.MALE, "20", "01.01.2023");
        // Parent vova = new Parent("vova", Gender.MALE, "20", "01.01.2023");
        // Parent olga = new Parent("olga", Gender.FEMALE, "20", "01.01.2023");

        // Добавляем родителей в древо
        familyTree.addParent(vika);
        familyTree.addParent(masha);
        familyTree.addParent(borya);
        familyTree.addParent(lena);
        // familyTree.addParent(vova);
        // familyTree.addParent(gendalf);

        // Добавляем детей к родителям
        // familyTree.addChild(misha, ivan);
        // familyTree.addChild(masha, ivan);
        // familyTree.addChild(misha, vova);
        // familyTree.addChild(masha, vova);
        // familyTree.addChild(masha, ivan);
        // familyTree.addChild(stas, dima);
        // familyTree.addChild(vika, dima);
        // familyTree.addChild(ivan, olga);
        // familyTree.addChild(ivan, vika);
        // familyTree.addChild(ivan, anna);

        // Запрашиваем сколько есть детей у конкретного человека
        // familyTree.getFamily(ivan);
        // familyTree.getFamily(stas);
        // familyTree.getFamily(gendalf);

        // Вика женит людей
        vika.marry(borya, lena);
        vika.marry(borya, lena); // Проверка, что пара уже жената

        familyTree.getFamilyInfo();
        familyTree.sortMapWithComparatorByName();
        familyTree.getFamilyInfo();
        familyTree.sortMapWithComparatorByAge();
        familyTree.getFamilyInfo();

        // Печатаем список женатых пар
        List<List<Parent>> married = vika.getPairs();
        for (List<Parent> pair : married) {
            System.out.println(pair);
        }
    }
}