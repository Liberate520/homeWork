
public class Main {
    public static void main(String[] args) {

        Human Anna = new Human("Анна", "Кошак", 36);
        Human Vika = new Human("Вика", "Макарова", 10);
        Human Stepan = new Human("Степан", "Макаров", 3);
        Human Ilya = new Human("Илья", "Макаров", 65);
        Human Yriy = new Human("Юрий", "Савич", 40);
        Human Kirill = new Human("Кирилл", "Савич", 15);
        Human Vera = new Human("Вера", "Савич", 39);
        Human Liza = new Human("Лиза", "Кошак", 6);
        Human Alena = new Human("Алена", "Макарова", 30);
        Human Sergey = new Human("Сергей", "Макаров", 35);

        GeoTree familyTree = new GeoTree();

        familyTree.appendPerentChild(Anna, Liza);/* Анна мама Лизы, семья Кошак */
        familyTree.appendPerentChild(Ilya, Sergey);/* Илья отец Сергея, Макаровы */
        familyTree.appendPerentChild(Alena, Vika);/* Алена мама Вики , Макаровы */
        familyTree.appendPerentChild(Alena, Stepan);/* Алена мама Степана , Макаровы */
        familyTree.appendPerentChild(Sergey, Vika);/* Сергей отец Вики , Макаровы */
        familyTree.appendPerentChild(Sergey, Stepan);/* Сергей отец Степана , Макаровы */
        familyTree.appendPerentChild(Yriy, Kirill);/* Юрий отец Кирилла , Савич */
        familyTree.appendPerentChild(Vera, Kirill);/* Вера мама Кирилла , Савич */
        familyTree.appendVifeHusbent(Sergey, Alena);/* Сергей муж Алены , Макаровы */
        familyTree.appendVifeHusbent(Yriy, Vera);/* Юрий муж Веры , Савич */

        // Ищем детей Анны
        System.out.println("Дети " + Anna);
        System.out.println(new Research(familyTree).spend(Anna, Relationship.parent));
        // Ищем детей Алены
        System.out.println("Дети " + Alena);
        System.out.println(new Research(familyTree).spend(Alena, Relationship.parent));

        // Ищем мужа Ирины (Чей муж Сергей?)
        System.out.println(Sergey + " Муж");
        System.out.println(new Research(familyTree).spend(Sergey, Relationship.husbent));

        // Ищем людей определенного возраста
        System.out.println(new Research(familyTree).searchAge());
    }
}