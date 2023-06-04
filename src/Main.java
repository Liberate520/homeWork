import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

//https://github.com/Liberate520/homeWork/pull/559
public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Yuriy", "05.03.1991", new Human(), new Human(), new ArrayList<>(), Gender.male);
        Human human2 = new Human("Natalya","20.04.1959", new Human(), new Human(), new ArrayList<>(), Gender.female);
        Human human3 = new Human("Mikhail","15.12.1960", new Human(), new Human(), new ArrayList<>(), Gender.male);
        Human human4 = new Human("Vladimir", "06.06.1931", new Human(), new Human(), new ArrayList<>(), Gender.male);
        Human human5 = new Human("Galina", "15.12.1937", new Human(), new Human(), new ArrayList<>(), Gender.female);
        Human human6 = new Human("Victor", "15.02.1930", new Human(), new Human(), new ArrayList<>(), Gender.male);
        Human human7 = new Human("Vera", "09.08.1934", new Human(), new Human(), new ArrayList<>(), Gender.female);
        Human human8 = new Human("Daria", "08.08.1990", new Human(), new Human(), new ArrayList<>(), Gender.female);
        Human human9 = new Human("Evgeniy", "23.07.1987", new Human(), new Human(), new ArrayList<>(), Gender.male);
        Human human10 = new Human("Filippa", "10.09.2022", new Human(), new Human(), new ArrayList<>(), Gender.female);

        human1.setFather(human3);
        human1.setMother(human2);
        human2.setMother(human7);
        human2.setFather(human6);
        human3.setFather(human4);
        human3.setMother(human5);
        human9.setMother(human2);
        human9.setFather(human3);
        human9.setChild(human10);

        System.out.println("____________");
        System.out.println(human1);

        System.out.println("____________");
        System.out.println(human2);

        System.out.println("____________");
        System.out.println(human10);

        System.out.println("____________");
        System.out.println(human1.getMother());

        human1.getParents();

        System.out.println("____________");
        System.out.println(human2.getBirthday());
    }

}
