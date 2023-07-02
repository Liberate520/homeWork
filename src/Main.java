import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human ivan = new Human("Иван", LocalDate.of(1996, 5, 9), LocalDate.of(2051, 6, 17), Gender.Male);
        Human vasya = new Human("Вася", LocalDate.of(2015, 8, 12), LocalDate.of(2073, 7, 1), Gender.Male);
        Human sasha = new Human("Саша", LocalDate.of(1965, 3, 25), LocalDate.of(2025, 2, 22), Gender.Male);
        Human svetlana = new Human("Светлана", LocalDate.of(1997, 2, 28), LocalDate.of(2055, 1, 3), Gender.Female);
        Human galina = new Human("Галина", LocalDate.of(1967, 6, 13), LocalDate.of(2028, 7, 11), Gender.Female);
        HumanTree ht = new HumanTree();
        ht.appendParentChild(ivan, vasya);
        ht.appendParentChild(svetlana, vasya);
        ht.appendParentChild(sasha, ivan);
        ht.appendParentChild(galina, ivan);

        var finder = galina;

        System.out.println("Имя: " + finder.getFullName());
        System.out.println("Пол: " + finder.getGender());
        System.out.println("Дата рождения: " + finder.getDateOfBirth());
        System.out.println("Дата смерти: " + finder.getDateOfDeath());
        System.out.println("Родители: " + new Find(ht).spend(finder, Communication.children));
        System.out.println("Дети: " + new Find(ht).spend(finder, Communication.parent));
    }
}