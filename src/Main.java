/*
В проекте с гениалогическим древом подумайте и используйте интерфейсы.
Дополнить проект методами записи в файл и чтения из файла. Для этого создать отдельный класс
и реализовать в нем нужные методы. Для данного класса сделайте интерфейс, который и используйте
в своей программе. Например в классе дерева в качестве аргумента метода save передавайте
не конкретный класс, а объект интерфейса, с помощью которого и будет происходить запись.
 */

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();

        tree.add(new Person("Михаил Федорович", Gender.MALE, "1613-1645", null, null, "Евдокия Лукьяновна Стрешнева"));
        tree.add(new Person("Евдокия Лукьяновна Стрешнева", Gender.FEMALE, null, null, null, "Михаил Федорович"));
        tree.add(new Person("Алексей Михайлович", Gender.MALE, "1645-1676", tree.getByName("Михаил Федорович"), tree.getByName("Евдокия Лукьяновна Стрешнева"), "Мария Ильинична Милославская, Наталья Кирилловна Нарышкина"));
        tree.add(new Person("Мария Ильинична Милославская", Gender.FEMALE, null, null, null, "Алексей Михайлович"));
        tree.add(new Person("Наталья Кирилловна Нарышкина", Gender.FEMALE, null, null, null, "Алексей Михайлович"));
        tree.add(new Person("Софья Алексеевна", Gender.FEMALE, null, tree.getByName("Алексей Михайлович"), tree.getByName("Мария Ильинична Милославская"), null));
        tree.add(new Person("Феодор Алексеевич", Gender.MALE, "1676-1682", tree.getByName("Алексей Михайлович"), tree.getByName("Мария Ильинична Милославская"), "Марфа Матвеевна Апраксина"));
        tree.add(new Person("Марфа Матвеевна Апраксина", Gender.FEMALE, null, null, null, "Феодор Алексеевич"));
        tree.add(new Person("Иоанн V Алексеевич", Gender.MALE, "1682-1696", tree.getByName("Алексей Михайлович"), tree.getByName("Мария Ильинична Милославская"), "Прасковья Федоровна Салтыкова"));
        tree.add(new Person("Прасковья Федоровна Салтыкова", Gender.FEMALE, null, null, null, "Иоанн V Алексеевич"));
        tree.add(new Person("Петр I Алексеевич", Gender.MALE, "1682-1725", tree.getByName("Алексей Михайлович"), tree.getByName("Наталья Кирилловна Нарышкина"), "Евдокия Федоровна Лопухина, Екатерина I Алексеевна"));
        tree.add(new Person("Евдокия Федоровна Лопухина", Gender.FEMALE, null, null, null, "Петр I Алексеевич"));
        tree.add(new Person("Екатерина I Алексеевна", Gender.FEMALE, "1725-1727", null, null, "Петр I Алексеевич"));
        tree.add(new Person("Екатерина Иоановна", Gender.FEMALE, null, tree.getByName("Иоанн V Алексеевич"), tree.getByName("Прасковья Федоровна Салтыкова"), "Карл Леопольд Мекленбург-Шверинский"));
        tree.add(new Person("Карл Леопольд Мекленбург-Шверинский", Gender.MALE, null, null, null, "Екатерина Иоановна"));
        tree.add(new Person("Анна Иоановна", Gender.FEMALE, "1730-1740", tree.getByName("Иоанн V Алексеевич"), tree.getByName("Прасковья Федоровна Салтыкова"), "Фридрих Вильгельм Курляндский"));
        tree.add(new Person("Фридрих Вильгельм Курляндский", Gender.MALE, null, null, null, "Анна Иоановна"));
        tree.add(new Person("Алексей Петрович", Gender.MALE, null, tree.getByName("Петр I Алексеевич"), tree.getByName("Евдокия Федоровна Лопухина"), "Наталья Алексеевна"));
        tree.add(new Person("Наталья Алексеевна", Gender.FEMALE, null, null, null, "Алексей Петрович"));
        tree.add(new Person("Анна Петровна", Gender.FEMALE, null, tree.getByName("Петр I Алексеевич"), tree.getByName("Екатерина I Алексеевна"), "Карл Фридрих"));
        tree.add(new Person("Карл Фридрих", Gender.MALE, null, null, null, "Анна Петровна"));
        tree.add(new Person("Елизавета Петровна", Gender.FEMALE, "1741-1761", tree.getByName("Петр I Алексеевич"), tree.getByName("Екатерина I Алексеевна"), null));
        tree.add(new Person("Петр II Алексеевич", Gender.MALE, "1727-1730", tree.getByName("Алексей Петрович"), tree.getByName("Наталья Алексеевна"), null));
        tree.add(new Person("Петр III Федорович", Gender.MALE, "1761-1762", tree.getByName("Карл Фридрих"), tree.getByName("Анна Петровна"), "Екатерина II Алексеевна"));
        tree.add(new Person("Екатерина II Алексеевна", Gender.FEMALE, "1762-1796", null, null, "Петр III Федорович"));
        tree.add(new Person("Анна Леопольдовна", Gender.FEMALE, null, tree.getByName("Карл Леопольд Мекленбург-Шверинский"), tree.getByName("Екатерина Иоановна"), "Антон Ульрих Брауншвейг-Вольфенбюттельский"));
        tree.add(new Person("Антон Ульрих Брауншвейг-Вольфенбюттельский", Gender.MALE, null, null, null, "Анна Леопольдовна"));
        tree.add(new Person("Иоанн VI Анатольевич", Gender.MALE, "1740-1741", tree.getByName("Антон Ульрих Брауншвейг-Вольфенбюттельский"), tree.getByName("Анна Леопольдовна"), null));
        tree.add(new Person("Павел I Петрович", Gender.MALE, "1796-1801", tree.getByName("Петр III Федорович"), tree.getByName("Екатерина II Алексеевна"), "Наталья Алексеевна, Мария Федоровна"));
        tree.add(new Person("Наталья Алексеевна", Gender.FEMALE, null, null, null, "Павел I Петрович"));
        tree.add(new Person("Мария Федоровна", Gender.FEMALE, null, null, null, "Павел I Петрович"));
        tree.add(new Person("Александр I Павлович", Gender.MALE, "1801-1825", tree.getByName("Павел I Петрович"), tree.getByName("Мария Федоровна"), "Елизавета Алексеевна"));
        tree.add(new Person("Елизавета Алексеевна", Gender.FEMALE, null, null, null, "Александр I Павлович"));
        tree.add(new Person("Николай I Павлович", Gender.MALE, "1825-1855", tree.getByName("Павел I Петрович"), tree.getByName("Мария Федоровна"), "Александра Федоровна"));
        tree.add(new Person("Александра Федоровна", Gender.FEMALE, null, null, null, "Николай I Павлович"));
        tree.add(new Person("Александр II Николаевич", Gender.MALE, "1855-1881", tree.getByName("Николай I Павлович"), tree.getByName("Александра Федоровна"), "Мария Александровна Гессенская"));
        tree.add(new Person("Мария Александровна Гессенская", Gender.FEMALE, null, null, null, "Александр II Николаевич"));
        tree.add(new Person("Александр III Александрович", Gender.MALE, "1881-1894", tree.getByName("Александр II Николаевич"), tree.getByName("Мария Александровна Гессенская"), "Мария Федоровна Датская"));
        tree.add(new Person("Мария Федоровна Датская", Gender.FEMALE, null, null, null, "Александр III Александрович"));
        tree.add(new Person("Николай II Александрович", Gender.MALE, "1894-1917", tree.getByName("Александр III Александрович"), tree.getByName("Мария Федоровна Датская"), "Александра Федоровна Гессенская"));
        tree.add(new Person("Александра Федоровна Гессенская", Gender.FEMALE, null, null, null, "Николай II Александрович"));
        tree.getInfo();

    }
}