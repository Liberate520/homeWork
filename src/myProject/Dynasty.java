package myProject;

public class Dynasty {
    public static void dynasty(FamilyTree tree) {
        tree.add(new Person(1, "Михаил", "Федорович", 1596, Gender.MALE, "1613-1645", null, null, "Евдокия Лукьяновна Стрешнева"));
        tree.add(new Person(2, "Евдокия", "Лукьяновна (Стрешнева)", 1608, Gender.FEMALE, null, null, null, "Михаил Федорович"));
        tree.add(new Person(3, "Алексей", "Михайлович", 1629, Gender.MALE, "1645-1676", tree.getByName(1), tree.getByName(2), "Мария Ильинична Милославская, Наталья Кирилловна Нарышкина"));
        tree.add(new Person(4, "Мария", "Ильинична (Милославская)", 1625, Gender.FEMALE, null, null, null, "Алексей Михайлович"));
        tree.add(new Person(5, "Наталья", "Кирилловна (Нарышкина)", 1651, Gender.FEMALE, null, null, null, "Алексей Михайлович"));
        tree.add(new Person(6, "Софья", "Алексеевна", 1657, Gender.FEMALE, null, tree.getByName(3), tree.getByName(4), null));
        tree.add(new Person(7, "Феодор", "Алексеевич", 1661, Gender.MALE, "1676-1682", tree.getByName(3), tree.getByName(4), "Марфа Матвеевна Апраксина"));
        tree.add(new Person(8, "Марфа", "Матвеевна (Апраксина)", 1664, Gender.FEMALE, null, null, null, "Феодор Алексеевич"));
        tree.add(new Person(9, "Иоанн V", "Алексеевич", 1666, Gender.MALE, "1682-1696", tree.getByName(3), tree.getByName(4), "Прасковья Федоровна Салтыкова"));
        tree.add(new Person(10, "Прасковья", "Федоровна Салтыкова", 1664, Gender.FEMALE, null, null, null, "Иоанн V Алексеевич"));
        tree.add(new Person(11, "Петр I", "Алексеевич", 1672, Gender.MALE, "1682-1725", tree.getByName(3), tree.getByName(5), "Евдокия Федоровна Лопухина, Екатерина I Алексеевна"));
        tree.add(new Person(12, "Евдокия", "Федоровна Лопухина", 1669, Gender.FEMALE, null, null, null, "Петр I Алексеевич"));
        tree.add(new Person(13, "Екатерина I", "Алексеевна", 1684, Gender.FEMALE, "1725-1727", null, null, "Петр I Алексеевич"));
        tree.add(new Person(14, "Екатерина", " Иоановна", 1691, Gender.FEMALE, null, tree.getByName(9), tree.getByName(10), "Карл Леопольд Мекленбург-Шверинский"));
        tree.add(new Person(15, "Карл", "Леопольд Мекленбург-Шверинский", 1678, Gender.MALE, null, null, null, "Екатерина Иоановна"));
        tree.add(new Person(16, "Анна", "Иоановна", 1693, Gender.FEMALE, "1730-1740", tree.getByName(9), tree.getByName(10), "Фридрих Вильгельм Курляндский"));
        tree.add(new Person(17, "Фридрих", "Вильгельм Курляндский", 1692, Gender.MALE, null, null, null, "Анна Иоановна"));
        tree.add(new Person(18, "Алексей", "Петрович", 1690, Gender.MALE, null, tree.getByName(11), tree.getByName(12), "Наталья Алексеевна"));
        tree.add(new Person(19, "Наталья", "Алексеевна", 1715, Gender.FEMALE, null, null, null, "Алексей Петрович"));
        tree.add(new Person(20, "Анна", "Петровна", 1708, Gender.FEMALE, null, tree.getByName(11), tree.getByName(13), "Карл Фридрих"));
        tree.add(new Person(21, "Карл", "Фридрих Гольштейн-Готторпский", 1700, Gender.MALE, null, null, null, "Анна Петровна"));
        tree.add(new Person(22, "Елизавета", "Петровна", 1709, Gender.FEMALE, "1741-1761", tree.getByName(11), tree.getByName(13), null));
        tree.add(new Person(23, "Петр II", "Алексеевич", 1715, Gender.MALE, "1727-1730", tree.getByName(18), tree.getByName(19), null));
        tree.add(new Person(24, "Петр III", "Федорович", 1728, Gender.MALE, "1761-1762", tree.getByName(21), tree.getByName(20), "Екатерина II Алексеевна"));
        tree.add(new Person(25, "Екатерина II", "Алексеевна", 1729, Gender.FEMALE, "1762-1796", null, null, "Петр III Федорович"));
        tree.add(new Person(26, "Анна", "Леопольдовна", 1718, Gender.FEMALE, null, tree.getByName(15), tree.getByName(14), "Антон Ульрих Брауншвейг-Вольфенбюттельский"));
        tree.add(new Person(27, "Антон", "Ульрих Брауншвейг-Вольфенбюттельский", 1714, Gender.MALE, null, null, null, "Анна Леопольдовна"));
        tree.add(new Person(28, "Иоанн VI", "Анатольевич", 1740, Gender.MALE, "1740-1741", tree.getByName(27), tree.getByName(26), null));
        tree.add(new Person(29, "Павел I", "Петрович", 1754, Gender.MALE, "1796-1801", tree.getByName(24), tree.getByName(25), "Наталья Алексеевна, Мария Федоровна"));
        tree.add(new Person(30, "Наталья", "Алексеевна", 1755, Gender.FEMALE, null, null, null, "Павел I Петрович"));
        tree.add(new Person(31, "Мария", "Федоровна", 1759, Gender.FEMALE, null, null, null, "Павел I Петрович"));
        tree.add(new Person(32, "Александр I", "Павлович", 1777, Gender.MALE, "1801-1825", tree.getByName(29), tree.getByName(31), "Елизавета Алексеевна"));
        tree.add(new Person(33, "Елизавета", "Алексеевна", 1779, Gender.FEMALE, null, null, null, "Александр I Павлович"));
        tree.add(new Person(34, "Николай I", "Павлович", 1796, Gender.MALE, "1825-1855", tree.getByName(29), tree.getByName(31), "Александра Федоровна"));
        tree.add(new Person(35, "Александра", "Федоровна", 1798, Gender.FEMALE, null, null, null, "Николай I Павлович"));
        tree.add(new Person(36, "Александр II", "Николаевич", 1818, Gender.MALE, "1855-1881", tree.getByName(34), tree.getByName(35), "Мария Александровна Гессенская"));
        tree.add(new Person(37, "Мария", "Александровна (Гессенская)", 1824, Gender.FEMALE, null, null, null, "Александр II Николаевич"));
        tree.add(new Person(38, "Александр III", "Александрович", 1845, Gender.MALE, "1881-1894", tree.getByName(36), tree.getByName(37), "Мария Федоровна Датская"));
        tree.add(new Person(39, "Мария", "Федоровна Датская", 1847, Gender.FEMALE, null, null, null, "Александр III Александрович"));
        tree.add(new Person(40, "Николай II", "Александрович", 1868, Gender.MALE, "1894-1917", tree.getByName(38), tree.getByName(39), "Александра Федоровна Гессенская"));
        tree.add(new Person(41, "Александра", "Федоровна Гессенская", 1872, Gender.FEMALE, null, null, null, "Николай II Александрович"));
    }
}
