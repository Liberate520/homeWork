import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree katsman = new FamilyTree("Katsman");

        Human vasya = new Human("Кацман", "Василий", Gender.Male);
        vasya.setBirthday(LocalDate.of(1901, 1, 12));
        vasya.setDeathday(LocalDate.of(1986, 9, 14));
        System.out.println(vasya);
        katsman.addMember(vasya);
        katsman.addMember(vasya); // 2 раза добавить того же самого не получится
        Human sara = new Human("Кацман", "Сара", Gender.Female);
        sara.setBirthday(LocalDate.of(1912, 6, 26));
        sara.setDeathday(LocalDate.of(1962, 12, 18));
        katsman.addMember(sara);

        sara.setSpouse(vasya); // Добавляем супруга Саре
        System.out.println(vasya.getSpouse()); // Васе Сара тоже добавилась супругой

        Human dushik = new Human("Кацман", "Андрей", Gender.Male);
        dushik.setBirthday(LocalDate.of(1931, 11, 6));
        dushik.setDeathday(LocalDate.of(2005, 5, 11));
        System.out.println(dushik.getAge());
        katsman.addMember(dushik);

        vasya.setChild(dushik);// Андрей - сын Сары и Васи
        sara.setChild(dushik);
        System.out.println(sara.getChildren());
        System.out.println(dushik.getParents()); // Андрею добавились оба родителя

        Human nastya = new Human("Петрова", "Анастасия", Gender.Female);
        nastya.setSpouse(dushik);

        Human mila = new Human("Кацман", "Людмила", Gender.Female);
        mila.setBirthday(LocalDate.of(1986, 8, 9));
        katsman.addMember(mila);
        nastya.setChild(mila);
        dushik.setChild(mila);
        mila.setLastname("Васильева"); // вышла замуж

        System.out.println(mila.getParents()); // выводятся оба родителя, хотя Настя не в семье

        System.out.println(mila.getId()); // должно быть 4, т.к. Настя не считается
        System.out.println(dushik.getChildren()); // Людмила уже Васильева
        nastya.setChild(mila); // пытаюсь добавить ребенка второй раз
        System.out.println(nastya.getChildren()); // не выходит...

        // Настю не добавляю в семью, она потом ушла от Андрея и в общем списке ее нет

        System.out.println(katsman.allMembers());
    }
}
