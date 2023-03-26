/*
Реализовать, с учетом ооп подхода, приложение.
Для проведения исследований с генеалогическим древом.
Идея: описать некоторое количество компонент, например:
модель человека и дерева
Под “проведением исследования” можно понимать например
получение всех детей выбранного человека.
*/
package oop_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flag = false;
        ArrayList<Connection> connect = new ArrayList<>();
        ArrayList<Person> person = new ArrayList<>();

        Person iIvanova = new Person("Ирина Иванова", "1945", "Ж");
        person.add(iIvanova);
        Person iIvanov = new Person("Иван Иванов", "1940", "M");
        person.add(iIvanov);
        Person aPetrova = new Person("Анфиса Петрова", "1944", "Ж");
        person.add(aPetrova);
        Person sPetrov = new Person("Сергей Пертров", "1943", "M");
        person.add(sPetrov);
        Person oPetrova = new Person("Оксана Петрова", "1973", "Ж");
        person.add(oPetrova);
        Person nPetrov = new Person("Николай Петров", "1972", "M");
        person.add(nPetrov);
        Person yPetrova = new Person("Юлия Петрова", "1983", "Ж");
        person.add(yPetrova);
        Person vPupkin = new Person("Вася Пупкин", "1977", "M");
        person.add(vPupkin);
        Person iPupkina = new Person("Ирина Пупкина", "2003", "Ж");
        person.add(iPupkina);
        Person niPetrov = new Person("Никита Петров", "1998", "M");
        person.add(niPetrov);
        Person lPetrova = new Person("Людмила Петрова", "2002", "Ж");
        person.add(lPetrova);
        Person gPetrov = new Person("Георгий Петров", "2008", "M");
        person.add(gPetrov);

        connect.add(new Connection(iIvanova, Status.женой, iIvanov));
        connect.add(new Connection(iIvanova, Status.родителем, oPetrova));
        connect.add(new Connection(iIvanova, Status.бабушкой, niPetrov));
        connect.add(new Connection(iIvanova, Status.бабушкой, lPetrova));
        connect.add(new Connection(iIvanova, Status.бабушкой, gPetrov));
        connect.add(new Connection(iIvanov, Status.мужем, iIvanova));
        connect.add(new Connection(iIvanov, Status.родителем, oPetrova));
        connect.add(new Connection(iIvanov, Status.дедушкой, niPetrov));
        connect.add(new Connection(iIvanov, Status.дедушкой, lPetrova));
        connect.add(new Connection(iIvanov, Status.дедушкой, gPetrov));
        connect.add(new Connection(aPetrova, Status.женой, sPetrov));
        connect.add(new Connection(aPetrova, Status.родителем, nPetrov));
        connect.add(new Connection(aPetrova, Status.родителем, yPetrova));
        connect.add(new Connection(aPetrova, Status.бабушкой, iPupkina));
        connect.add(new Connection(aPetrova, Status.бабушкой, niPetrov));
        connect.add(new Connection(aPetrova, Status.бабушкой, lPetrova));
        connect.add(new Connection(aPetrova, Status.бабушкой, gPetrov));
        connect.add(new Connection(sPetrov, Status.мужем, aPetrova));
        connect.add(new Connection(sPetrov, Status.родителем, nPetrov));
        connect.add(new Connection(sPetrov, Status.родителем, yPetrova));
        connect.add(new Connection(sPetrov, Status.дедушкой, iPupkina));
        connect.add(new Connection(sPetrov, Status.дедушкой, niPetrov));
        connect.add(new Connection(sPetrov, Status.дедушкой, lPetrova));
        connect.add(new Connection(sPetrov, Status.дедушкой, gPetrov));
        connect.add(new Connection(oPetrova, Status.ребенком, iIvanova));
        connect.add(new Connection(oPetrova, Status.ребенком, iIvanov));
        connect.add(new Connection(oPetrova, Status.женой, nPetrov));
        connect.add(new Connection(oPetrova, Status.родителем, niPetrov));
        connect.add(new Connection(oPetrova, Status.родителем, lPetrova));
        connect.add(new Connection(oPetrova, Status.родителем, gPetrov));
        connect.add(new Connection(nPetrov, Status.ребенком, aPetrova));
        connect.add(new Connection(nPetrov, Status.ребенком, sPetrov));
        connect.add(new Connection(nPetrov, Status.мужем, oPetrova));
        connect.add(new Connection(nPetrov, Status.братом, yPetrova));
        connect.add(new Connection(nPetrov, Status.родителем, niPetrov));
        connect.add(new Connection(nPetrov, Status.родителем, lPetrova));
        connect.add(new Connection(nPetrov, Status.родителем, gPetrov));
        connect.add(new Connection(yPetrova, Status.ребенком, aPetrova));
        connect.add(new Connection(yPetrova, Status.ребенком, sPetrov));
        connect.add(new Connection(yPetrova, Status.женой, vPupkin));
        connect.add(new Connection(yPetrova, Status.сестрой, nPetrov));
        connect.add(new Connection(yPetrova, Status.родителем, iPupkina));
        connect.add(new Connection(vPupkin, Status.мужем, yPetrova));
        connect.add(new Connection(vPupkin, Status.родителем, iPupkina));
        connect.add(new Connection(iPupkina, Status.ребенком, yPetrova));
        connect.add(new Connection(iPupkina, Status.ребенком, vPupkin));
        connect.add(new Connection(iPupkina, Status.внуком, aPetrova));
        connect.add(new Connection(iPupkina, Status.внуком, sPetrov));
        connect.add(new Connection(niPetrov, Status.ребенком, oPetrova));
        connect.add(new Connection(niPetrov, Status.ребенком, nPetrov));
        connect.add(new Connection(niPetrov, Status.братом, lPetrova));
        connect.add(new Connection(niPetrov, Status.братом, gPetrov));
        connect.add(new Connection(niPetrov, Status.внуком, iIvanova));
        connect.add(new Connection(niPetrov, Status.внуком, iIvanov));
        connect.add(new Connection(niPetrov, Status.внуком, aPetrova));
        connect.add(new Connection(niPetrov, Status.внуком, sPetrov));
        connect.add(new Connection(lPetrova, Status.ребенком, oPetrova));
        connect.add(new Connection(lPetrova, Status.ребенком, nPetrov));
        connect.add(new Connection(lPetrova, Status.сестрой, niPetrov));
        connect.add(new Connection(lPetrova, Status.сестрой, gPetrov));
        connect.add(new Connection(lPetrova, Status.внуком, iIvanova));
        connect.add(new Connection(lPetrova, Status.внуком, iIvanov));
        connect.add(new Connection(lPetrova, Status.внуком, aPetrova));
        connect.add(new Connection(lPetrova, Status.внуком, sPetrov));
        connect.add(new Connection(gPetrov, Status.ребенком, oPetrova));
        connect.add(new Connection(gPetrov, Status.ребенком, nPetrov));
        connect.add(new Connection(gPetrov, Status.братом, lPetrova));
        connect.add(new Connection(gPetrov, Status.братом, niPetrov));
        connect.add(new Connection(gPetrov, Status.внуком, iIvanova));
        connect.add(new Connection(gPetrov, Status.внуком, iIvanov));
        connect.add(new Connection(gPetrov, Status.внуком, aPetrova));
        connect.add(new Connection(gPetrov, Status.внуком, sPetrov));

        System.out.println("Список имен, внесенных в семейное дерево: ");
        for (Person p : person) {
            System.out.println(p.getFull_name());
        }
        String userInput = userInputStr("Для получения полной информации о человеке " +
                "и его \nродственных связях введите имя и фамилию через пробел: ");
        for (Connection t : connect) {
            if (t.getP1().getFull_name().equalsIgnoreCase(userInput)) {
                t.printInfo();
                System.out.println();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Человек не ннайден!");
        }
    }

    public static String userInputStr(String msg) {
        Scanner sc = new Scanner(System.in);
        String inputStr;
        while (true) {
            System.out.println(msg);
            try {
                inputStr = sc.nextLine();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
        return inputStr;
    }

}
