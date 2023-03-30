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
*/

package oop_1;

public class Main {
    public static void main(String[] args) {

        // десериализация файлов
        SaveLoad data = new SaveLoad();
        System.out.println(data.load("connect.data"));
        System.out.println(data.load("person.data"));

        Person p = new Person();
        GeoTree gt = new GeoTree();

        Person iIvanova = new Person("Ирина Иванова", "1945", "Ж");
        p.addPerson(iIvanova);
        Person iIvanov = new Person("Иван Иванов", "1940", "M");
        p.addPerson(iIvanov);
        Person aPetrova = new Person("Анфиса Петрова", "1944", "Ж");
        p.addPerson(aPetrova);
        Person sPetrov = new Person("Сергей Петров", "1943", "M");
        p.addPerson(sPetrov);
        Person oPetrova = new Person("Оксана Петрова", "1973", "Ж");
        p.addPerson(oPetrova);
        Person nPetrov = new Person("Николай Петров", "1972", "M");
        p.addPerson(nPetrov);
        Person yPetrova = new Person("Юлия Петрова", "1983", "Ж");
        p.addPerson(yPetrova);
        Person vPupkin = new Person("Вася Пупкин", "1977", "M");
        p.addPerson(vPupkin);
        Person iPupkina = new Person("Ирина Пупкина", "2003", "Ж");
        p.addPerson(iPupkina);
        Person niPetrov = new Person("Никита Петров", "1998", "M");
        p.addPerson(niPetrov);
        Person lPetrova = new Person("Людмила Петрова", "2002", "Ж");
        p.addPerson(lPetrova);
        Person gPetrov = new Person("Георгий Петров", "2008", "M");
        p.addPerson(gPetrov);

        gt.addParentChildren(iIvanova, oPetrova);
        gt.addParentChildren(iIvanov, oPetrova);
        gt.addParentChildren(aPetrova, nPetrov);
        gt.addParentChildren(aPetrova, yPetrova);
        gt.addParentChildren(sPetrov, nPetrov);
        gt.addParentChildren(sPetrov, yPetrova);
        gt.addParentChildren(oPetrova, niPetrov);
        gt.addParentChildren(oPetrova, lPetrova);
        gt.addParentChildren(oPetrova, gPetrov);
        gt.addParentChildren(nPetrov, niPetrov);
        gt.addParentChildren(nPetrov, lPetrova);
        gt.addParentChildren(nPetrov, gPetrov);
        gt.addParentChildren(vPupkin, iPupkina);
        gt.addParentChildren(yPetrova, iPupkina);

        gt.addGrandparentGrandchildren(iIvanova, niPetrov);
        gt.addGrandparentGrandchildren(iIvanova, lPetrova);
        gt.addGrandparentGrandchildren(iIvanova, gPetrov);
        gt.addGrandparentGrandchildren(iIvanov, niPetrov);
        gt.addGrandparentGrandchildren(iIvanov, lPetrova);
        gt.addGrandparentGrandchildren(iIvanov, gPetrov);
        gt.addGrandparentGrandchildren(aPetrova, iPupkina);
        gt.addGrandparentGrandchildren(aPetrova, niPetrov);
        gt.addGrandparentGrandchildren(aPetrova, lPetrova);
        gt.addGrandparentGrandchildren(aPetrova, gPetrov);
        gt.addGrandparentGrandchildren(sPetrov, iPupkina);
        gt.addGrandparentGrandchildren(sPetrov, niPetrov);
        gt.addGrandparentGrandchildren(sPetrov, lPetrova);
        gt.addGrandparentGrandchildren(sPetrov, gPetrov);

        gt.addHusbandWife(iIvanov, iIvanova);
        gt.addHusbandWife(sPetrov, aPetrova);
        gt.addHusbandWife(nPetrov, oPetrova);
        gt.addHusbandWife(vPupkin, yPetrova);

        gt.addBrotherSister(nPetrov, yPetrova);
        gt.addBrotherSister(niPetrov, lPetrova);
        gt.addBrotherBrother(niPetrov, gPetrov);
        gt.addBrotherSister(gPetrov, lPetrova);

        System.out.println("Список имен, внесенных в семейное дерево: ");
        for (Person p1 : p.getPerson()) {
            System.out.println(p1);
        }

        // вызов функции пользовательского ввода имени
        String userInput = p.userInputStr("Для получения полной информации о человеке " +
                "и его \nродственных связях введите имя и фамилию через пробел: ");
        // вызов функции поиска по деоеву
        gt.searchForConnections(userInput);

        // сериализация файлов
        data.save("connect.data", gt.getConnect());
        data.save("person.data",p.getPerson());
    }
}
