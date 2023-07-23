public class Main {
    public static void main(String[] args) {
        // Создаем объекты для представления генеалогического древа
        Parent misha = new Parent("misha");
        Parent ivan = new Parent("ivan");
        Parent stas = new Parent("stas");
        Parent masha = new Parent("masha");
        Parent lena = new Parent("lena");
        Parent vika = new Parent("vika");
        Single gendalf = new Single("gendalf");
        Single anna = new Single("anna");
        Single dima = new Single("dima");
        Single vova = new Single("vova");
        Single olga = new Single("olga");

        // Создаем генеалогическое дерево
        FamilyTree familyTree = new FamilyTree();

        // Добавляем родителей в древо
        familyTree.addParent(misha);
        familyTree.addParent(ivan);
        familyTree.addParent(stas);
        familyTree.addParent(masha);
        familyTree.addParent(lena);
        familyTree.addParent(vika);
        familyTree.addParent(vova);
        familyTree.addParent(gendalf);

        // Добавляем детей в древо
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
    }
}