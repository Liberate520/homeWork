import family_tree.family_tree.Family_tree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.service.Service;
import family_tree.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ArrayList<String> snils = new ArrayList();
//
//        Family_tree myFamily = new Family_tree();
       /* FileHandler fh = new FileHandler();
        myFamily = fh.LoadFamily_tree();
        System.out.println(myFamily.getHumanListInfo());*/
       /* FileHandler fh = new FileHandler();

        Human human1 =  new Human("123-563-128 22", "Кулиев", "Рафик", LocalDate.of(1980, 3, 11), Gender.Male);
        Human human2 =  new Human("123-563-127 22", "Кулиев", "Анатолий", LocalDate.of(1999, 5, 11), Gender.Male);
        Human human3 =  new Human("123-563-126 22", "Кулиев", "Ренат", LocalDate.of(2001, 1, 25), Gender.Male);
        Human human4 =  new Human("123-563-125 22", "Кулиева", "Вера", LocalDate.of(1944, 9, 23), Gender.Female);
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println(human4);

        human1.AddMother(human4);
        System.out.println("----".repeat(5));
        System.out.println("Мама");
        System.out.println(human1.GetMother());

        System.out.println("----".repeat(5));
        human1.AddChildren(human2);
        human1.AddChildren(human3);
        System.out.println("Дети ");
        System.out.println(human1.GetChildren());


        System.out.println("----".repeat(5));
        System.out.println("Дерево ");
        myFamily.AddHuman(human1);
        myFamily.AddHuman(human2);
        myFamily.AddHuman(human4);
        System.out.println(myFamily.getHumanListInfo());

        //Все сохраняем

        //fh.SaveHuman(human2);
        myFamily.sortByName();
        System.out.println(myFamily.toString());*/
        Service MyFamily = new Service();
        MyFamily.AddHuman("123-563-128 22", "Кулиев", "Рафик", LocalDate.of(1980, 3, 11), Gender.Male);
        MyFamily.AddHuman("123-563-127 22", "Кулиев", "Анатолий", LocalDate.of(1999, 5, 11), Gender.Male);
        MyFamily.AddHuman("123-563-126 22", "Кулиев", "Ренат", LocalDate.of(2001, 1, 25), Gender.Male);
        MyFamily.AddHuman("123-563-125 22", "Кулиева", "Вера", LocalDate.of(1944, 9, 23), Gender.Female);
        MyFamily.AddHuman("123-563-125 28", "Петрова", "Мария", LocalDate.of(2005, 9, 24), Gender.Female);
        System.out.println(MyFamily);
        MyFamily.sortByName();
        System.out.println(MyFamily);
        MyFamily.sortByFam();
        System.out.println(MyFamily);
        MyFamily.sortByAge();
        System.out.println(MyFamily);


    }
}
