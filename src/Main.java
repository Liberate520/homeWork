/*
Реализовать, с учетом ооп подхода, приложение.
Для проведения исследований с генеалогическим древом.
Идея: описать некоторое количество компонент, например:
модель человека и дерева
Под “проведением исследования” можно понимать получение всех детей выбранного человека.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Генеалогическое древо Романовых:");
        Person romanov1 = new Person("Михаил Федорович", "1613-1645", null, null);
        Person romanov2 = new Person("Евдокия Лукьяновна Стрешнева", "-", null, null);
        Person romanov3 = new Person("Алексей Михайлович", "1645-1676", null, null);
        Person romanov4 = new Person("Мария Ильинична Милославская", "-", null, null);
        Person romanov5 = new Person("Наталья Кирилловна Нарышкина", "-", null, null);
        Person romanov6 = new Person("Софья Алексеевна", "-", null, null);
        Person romanov7 = new Person("Феодор Алексеевич", "1676-1682", null, null);
        Person romanov25 = new Person("Марфа Матвеевна Апраксина", "-", null, null);
        Person romanov8 = new Person("Иоанн V Алексеевич", "1682-1696", null, null);
        Person romanov26 = new Person("Прасковья Федоровна Салтыкова", "-", null, null);
        Person romanov9 = new Person("Петр I Алексеевич", "1682-1725", null, null);
        Person romanov27 = new Person("Евдокия Федоровна Лопухина", "-", null, null);
        Person romanov28 = new Person("Екатерина I Алексеевна", "1725-1727", null, null);
        Person romanov10 = new Person("Екатерина Иоановна", "-", null, null);
        Person romanov29 = new Person("Карл Леопольд Мекленбург-Шверинский", "-", null, null);
        Person romanov11 = new Person("Анна Иоановна", "1730-1740", null, null);
        Person romanov33 = new Person("Фридрих Вильгельм Курляндский", "-", null, null);
        Person romanov12 = new Person("Алексей Петрович", "-", null, null);
        Person romanov31 = new Person("Наталья Алексеевна", "-", null, null);
        Person romanov13 = new Person("Анна Петровна", "-", null, null);
        Person romanov32 = new Person("Карл Фридрих", "-", null, null);
        Person romanov14 = new Person("Елизавета Петровна", "1741-1761", null, null);
        Person romanov15 = new Person("Петр II Алексеевич", "1727-1730", null, null);
        Person romanov16 = new Person("Петр III Федорович", "1761-1762", null, null);
        Person romanov34 = new Person("Екатерина II Алексеевна", "1762-1796", null, null);
        Person romanov17 = new Person("Анна Леопольдовна", "-", null, null);
        Person romanov30 = new Person("Антон Ульрих Брауншвейг-Вольфенбюттельский", "-", null, null);
        Person romanov18 = new Person("Иоанн VI Анатольевич", "1740-1741", null, null);
        Person romanov19 = new Person("Павел I Петрович", "1796-1801", null, null);
        Person romanov35 = new Person("Наталья Алексеевна", "-", null, null);
        Person romanov36 = new Person("Мария Федоровна", "-", null, null);
        Person romanov20 = new Person("Александр I Павлович", "1801-1825", null, null);
        Person romanov37 = new Person("Елизавета Алексеевна", "-", null, null);
        Person romanov21 = new Person("Николай I Павлович", "1825-1855", null, null);
        Person romanov38 = new Person("Александра Федоровна", "-", null, null);
        Person romanov22 = new Person("Александр II Николаевич", "1855-1881", null, null);
        Person romanov39 = new Person("Мария Александровна Гессенская", "-", null, null);
        Person romanov23 = new Person("Александр III Александрович", "1881-1894", null, null);
        Person romanov40 = new Person("Мария Федоровна Датская", "-", null, null);
        Person romanov24 = new Person("Николай II Александрович", "1894-1917", null, null);
        Person romanov41 = new Person("Александра Федоровна Гессенская", "-", null, null);

        romanov1.addChild(romanov3);
        romanov1.addSpou(romanov2);
        romanov3.addSpou(romanov4);
        romanov3.addSpou(romanov5);
        romanov3.addChild(romanov6);
        romanov3.addChild(romanov7);
        romanov3.addChild(romanov8);
        romanov3.addChild(romanov9);
        romanov7.addSpou(romanov25);
        romanov8.addSpou(romanov26);
        romanov8.addChild(romanov10);
        romanov8.addChild(romanov11);
        romanov9.addSpou(romanov27);
        romanov9.addSpou(romanov28);
        romanov9.addChild(romanov12);
        romanov9.addChild(romanov13);
        romanov9.addChild(romanov14);
        romanov11.addSpou(romanov33);
        romanov10.addSpou(romanov29);
        romanov10.addChild(romanov17);
        romanov12.addSpou(romanov31);
        romanov12.addChild(romanov15);
        romanov13.addSpou(romanov32);
        romanov13.addChild(romanov16);
        romanov16.addSpou(romanov34);
        romanov16.addChild(romanov19);
        romanov17.addSpou(romanov30);
        romanov17.addChild(romanov18);
        romanov19.addSpou(romanov35);
        romanov19.addSpou(romanov36);
        romanov19.addChild(romanov20);
        romanov19.addChild(romanov21);
        romanov20.addSpou(romanov37);
        romanov21.addSpou(romanov38);
        romanov21.addChild(romanov22);
        romanov22.addSpou(romanov39);
        romanov22.addChild(romanov23);
        romanov23.addSpou(romanov40);
        romanov23.addChild(romanov24);
        romanov24.addSpou(romanov41);

        listChildren(romanov3, "");
    }

    private static void listChildren(Person person, String prefix) {
        System.out.println(prefix + person);
        for (Person spou : person.getSpouse()) {
            listChildren(spou, prefix + "Супруг(а): ");
        }
        for (Person child : person.getChildren()) {
            listChildren(child, prefix + "\t");
        }
    }
}