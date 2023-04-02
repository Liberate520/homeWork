/*
ДЗ_1. Реализовать, с учетом ооп подхода, приложение.
Для проведения исследований с генеалогическим древом.
Идея: описать некоторое количество компонент, например:
модель человека и дерева
Под “проведением исследования” можно понимать например
получение всех детей выбранного человека.
ДЗ_2, В проекте с гениалогическим древом подумайте и используйте интерфейсы.
Дополнить проект методами записи в файл и чтения из файла. Для этого создать
отдельный класс и реализовать в нем нужные методы. Для данного класса сделайте
интерфейс, который и используйте в своей программе. НАПРИМЕР в классе дерева
в качестве аргумента метода save передавайте не конкретный класс, а объект
интерфейса, с помощью которого и будет происходить запись.
ДЗ_3. Реализовать интерфейс Iterable для дерева.
Создать методы сортировки списка людей перед выводом, например по имени или
по дате рождения (не менее 2)
*/

package oop_1;

public class Main {
    public static void main(String[] args) {
        GeoTree gt = new GeoTree();

        gt.addPerson(new Person("Ирина Иванова", 1945, Gender.female));  // создаем верхний узел начала дерева
        gt.addPerson(new Person("Иван Иванов", 1940, Gender.male));      //
        gt.addPerson(new Person("Анфиса Петрова", 1944, Gender.female)); //
        gt.addPerson(new Person("Сергей Петров", 1943, Gender.male));    //
        gt.addPerson(new Person("Оксана Петрова", 1973, Gender.female, gt.getByName("Ирина Иванова"), gt.getByName("Иван Иванов")));
        gt.addPerson(new Person("Николай Петров", 1972, Gender.male, gt.getByName("Анфиса Петрова"), gt.getByName("Сергей Петров")));
        gt.addPerson(new Person("Юлия Петрова", 1983, Gender.female, gt.getByName("Анфиса Петрова"), gt.getByName("Сергей Петров")));
        gt.addPerson(new Person("Вася Пупкин", 1977, Gender.male, gt.getByName("Алла Кулакова"), gt.getByName("Иван Пупкин")));
        gt.addPerson(new Person("Ирина Пупкина", 2003, Gender.female, gt.getByName("Юлия Петрова"), gt.getByName("Вася Пупкин")));
        gt.addPerson(new Person("Никита Петров", 1998, Gender.male, gt.getByName("Оксана Петрова"), gt.getByName("Николай Петров")));
        gt.addPerson(new Person("Людмила Петрова", 2002, Gender.female, gt.getByName("Оксана Петрова"), gt.getByName("Николай Петров")));
        gt.addPerson(new Person("Георгий Петров", 2008, Gender.male, gt.getByName("Оксана Петрова"), gt.getByName("Николай Петров")));

        FileHandler fileHandler = new FileHandler();
        // сериализация
        fileHandler.save(gt);
        // десериализация
        System.out.println(fileHandler.read());
        // итератор forech по объектам класса Person
        for (Person person : gt) {
            System.out.print(person);
        }
        System.out.println();
        // сортировка дерева по имени
        gt.sortByNamePerson();
        System.out.println(gt);
        // сортировка дерева по дате рождения
        gt.sortByAgePerson();
        System.out.println(gt);
    }
}
