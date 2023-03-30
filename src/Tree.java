import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {
    static Human human1 = new Human("Иван", "Иванов", "Мужчина", "01.01.1900", "01.01.1960");
    static Human human2 = new Human("Василий", "Иванов", "Мужчина", "01.01.1920", "01.01.1980");
    static Human human3 = new Human("Петр", "Иванов", "Мужчина", "01.01.1940", "01.01.2000");
    static Human human4 = new Human("Георгий", "Иванов", "Мужчина", "01.01.1960", "01.01.2020");
    static Human human5 = new Human("Станислав", "Иванов", "Мужчина", "01.01.1980");
    static Human human6 = new Human("Алексей", "Иванов", "Мужчина", "01.01.2000");
    static Human human7 = new Human("Иван", "Петров", "Мужчина", "01.01.1900", "01.01.1960");
    static Human human8 = new Human("Василий", "Петров", "Мужчина", "01.01.1920", "01.01.1980");
    static Human human9 = new Human("Петр", "Петров", "Мужчина", "01.01.1940", "01.01.2000");
    static Human human10 = new Human("Георгий", "Петров", "Мужчина", "01.01.1960", "01.01.2020");
    static Human human11 = new Human("Станислав", "Петров", "Мужчина", "01.01.1980");
    static Human human12 = new Human("Алексей", "Петров", "Мужчина", "01.01.2000");
    static List<Human> listHuman = new ArrayList<>(Arrays.asList(human1, human2, human3, human4, human5, human6, human7, human8, human9, human10, human11, human12));

    public static void SearchChildren(String searchName, String searchSurname) {
        int value = 0;
        Human equals = null;
        int birthDay = 0;
        List<Human> children = new ArrayList<>();
        for (Human hum : listHuman) {
            if (searchName.equals(hum.getName()) && searchSurname.equals(hum.getSurname())) {
                equals = hum;
                String[] birListEquals = equals.getBirthday().split("\\.");
                birthDay = Integer.parseInt(birListEquals[2]);
            }
            String[] birList = hum.getBirthday().split("\\.");
            if (birthDay != 0 && searchSurname.equals(hum.getSurname()) && birthDay < Integer.parseInt(birList[2])) {
                children.add(hum);
                ++value;
            }
       }
        System.out.println("Отец: " +  "\n" + equals.toString());
        System.out.println("\n" + value + " человек" + " его потомки: ");
        for (Human ch : children){
            System.out.println(ch.toString());
        }
    }
}
