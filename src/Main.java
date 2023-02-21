/*
Реализовать интерфейс Iterable для дерева.
Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения
 */

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        tree.add(new Person(1, "Михаил", "Федорович", Gender.MALE, "1613-1645", null, null, "Евдокия Лукьяновна Стрешнева"));
        tree.add(new Person(2, "Евдокия", "Лукьяновна (Стрешнева)", Gender.FEMALE, null, null, null, "Михаил Федорович"));
        tree.add(new Person(3, "Алексей", "Михайлович", Gender.MALE, "1645-1676", tree.getByName(1), tree.getByName(2), "Мария Ильинична Милославская, Наталья Кирилловна Нарышкина"));
        tree.add(new Person(4, "Мария", "Ильинична (Милославская)", Gender.FEMALE, null, null, null, "Алексей Михайлович"));
        tree.add(new Person(5, "Наталья", "Кирилловна (Нарышкина)", Gender.FEMALE, null, null, null, "Алексей Михайлович"));
        tree.add(new Person(6, "Софья", "Алексеевна", Gender.FEMALE, null, tree.getByName(3), tree.getByName(4), null));
        tree.add(new Person(7, "Феодор", "Алексеевич", Gender.MALE, "1676-1682", tree.getByName(3), tree.getByName(4), "Марфа Матвеевна Апраксина"));
        tree.add(new Person(8, "Марфа", "Матвеевна (Апраксина)", Gender.FEMALE, null, null, null, "Феодор Алексеевич"));
        tree.add(new Person(9, "Иоанн V", "Алексеевич", Gender.MALE, "1682-1696", tree.getByName(3), tree.getByName(4), "Прасковья Федоровна Салтыкова"));
        tree.add(new Person(10, "Прасковья", "Федоровна Салтыкова", Gender.FEMALE, null, null, null, "Иоанн V Алексеевич"));
        tree.add(new Person(11, "Петр I", "Алексеевич", Gender.MALE, "1682-1725", tree.getByName(3), tree.getByName(5), "Евдокия Федоровна Лопухина, Екатерина I Алексеевна"));
        tree.add(new Person(12, "Евдокия", "Федоровна Лопухина", Gender.FEMALE, null, null, null, "Петр I Алексеевич"));
        tree.add(new Person(13, "Екатерина I", "Алексеевна", Gender.FEMALE, "1725-1727", null, null, "Петр I Алексеевич"));
        tree.add(new Person(14, "Екатерина", " Иоановна", Gender.FEMALE, null, tree.getByName(9), tree.getByName(10), "Карл Леопольд Мекленбург-Шверинский"));
        tree.add(new Person(15, "Карл", "Леопольд Мекленбург-Шверинский", Gender.MALE, null, null, null, "Екатерина Иоановна"));
        tree.add(new Person(16, "Анна", "Иоановна", Gender.FEMALE, "1730-1740", tree.getByName(9), tree.getByName(10), "Фридрих Вильгельм Курляндский"));
        tree.add(new Person(17, "Фридрих", "Вильгельм Курляндский", Gender.MALE, null, null, null, "Анна Иоановна"));
        tree.add(new Person(18, "Алексей", "Петрович", Gender.MALE, null, tree.getByName(11), tree.getByName(12), "Наталья Алексеевна"));
        tree.add(new Person(19, "Наталья", "Алексеевна", Gender.FEMALE, null, null, null, "Алексей Петрович"));
        tree.add(new Person(20, "Анна", "Петровна", Gender.FEMALE, null, tree.getByName(11), tree.getByName(13), "Карл Фридрих"));
        tree.add(new Person(21, "Карл", "Фридрих", Gender.MALE, null, null, null, "Анна Петровна"));
        tree.add(new Person(22, "Елизавета", "Петровна", Gender.FEMALE, "1741-1761", tree.getByName(11), tree.getByName(13), null));
        tree.add(new Person(23, "Петр II", "Алексеевич", Gender.MALE, "1727-1730", tree.getByName(18), tree.getByName(19), null));
        tree.add(new Person(24, "Петр III", "Федорович", Gender.MALE, "1761-1762", tree.getByName(21), tree.getByName(20), "Екатерина II Алексеевна"));
        tree.add(new Person(25, "Екатерина II", "Алексеевна", Gender.FEMALE, "1762-1796", null, null, "Петр III Федорович"));
        tree.add(new Person(26, "Анна", "Леопольдовна", Gender.FEMALE, null, tree.getByName(15), tree.getByName(14), "Антон Ульрих Брауншвейг-Вольфенбюттельский"));
        tree.add(new Person(27, "Антон", "Ульрих Брауншвейг-Вольфенбюттельский", Gender.MALE, null, null, null, "Анна Леопольдовна"));
        tree.add(new Person(28, "Иоанн VI", "Анатольевич", Gender.MALE, "1740-1741", tree.getByName(27), tree.getByName(26), null));
        tree.add(new Person(29, "Павел I", "Петрович", Gender.MALE, "1796-1801", tree.getByName(24), tree.getByName(25), "Наталья Алексеевна, Мария Федоровна"));
        tree.add(new Person(30, "Наталья", "Алексеевна", Gender.FEMALE, null, null, null, "Павел I Петрович"));
        tree.add(new Person(31, "Мария", "Федоровна", Gender.FEMALE, null, null, null, "Павел I Петрович"));
        tree.add(new Person(32, "Александр I", "Павлович", Gender.MALE, "1801-1825", tree.getByName(29), tree.getByName(31), "Елизавета Алексеевна"));
        tree.add(new Person(33, "Елизавета", "Алексеевна", Gender.FEMALE, null, null, null, "Александр I Павлович"));
        tree.add(new Person(34, "Николай I", "Павлович", Gender.MALE, "1825-1855", tree.getByName(29), tree.getByName(31), "Александра Федоровна"));
        tree.add(new Person(35, "Александра", "Федоровна", Gender.FEMALE, null, null, null, "Николай I Павлович"));
        tree.add(new Person(36, "Александр II", "Николаевич", Gender.MALE, "1855-1881", tree.getByName(34), tree.getByName(35), "Мария Александровна Гессенская"));
        tree.add(new Person(37, "Мария", "Александровна (Гессенская)", Gender.FEMALE, null, null, null, "Александр II Николаевич"));
        tree.add(new Person(38, "Александр III", "Александрович", Gender.MALE, "1881-1894", tree.getByName(36), tree.getByName(37), "Мария Федоровна Датская"));
        tree.add(new Person(39, "Мария", "Федоровна Датская", Gender.FEMALE, null, null, null, "Александр III Александрович"));
        tree.add(new Person(40, "Николай II", "Александрович", Gender.MALE, "1894-1917", tree.getByName(38), tree.getByName(39), "Александра Федоровна Гессенская"));
        tree.add(new Person(41, "Александра", "Федоровна Гессенская", Gender.FEMALE, null, null, null, "Николай II Александрович"));

        while (true) {
            Scanner iScanner = new Scanner(System.in);
            System.out.println("Поиск(1), Весь список(2), Сортировка по имени(3) Сохранить(4), Востановить(5), Выход(6): ");
            int choice = iScanner.nextInt();
            if (choice == 1) {
                Scanner Scanner = new Scanner(System.in);
                System.out.println("Поиск по династии: ");
                String search = Scanner.nextLine();
                tree.Search(search);

            }else if (choice == 2) {
                tree.List();
            }else if (choice == 3) {
                tree.sort();
                tree.List();
            }else if (choice == 4) {
                tree.save();
            }else if (choice == 5) {
                tree.read();
            }else if (choice == 6) {
                return;
            }
        }

    }
}