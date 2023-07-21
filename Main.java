package homeWork_Oop;

import homeWork_Oop.Human.Gender;
import homeWork_Oop.Human.Human;

import java.time.LocalDate;
import java.util.List;

import static java.util.List.of;
import static homeWork_Oop.Human.Gender.*;
import static homeWork_Oop.Human.Human.fioHumans;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = demoTree();
        System.out.println(tree);
        System.out.println();
    }
    static FamilyTree demoTree() {
        FamilyTree tree = new FamilyTree();

        List<String> fio = fioHumans("Иванов", "Алексей ", "Петрович");
        Human ivanov = new Human(fio, Gender.Male, LocalDate.of(1980, 12, 22));
        fio = fioHumans("Петрова", "Виолетта ", "Александровна");
        Human petrova = new Human(fio, Female, LocalDate.of(1980, 12, 22));
        fio = fioHumans("Достоевский", "Фёдор ", "Михайлович");
        Human dostoevsky = new Human(fio, Gender.Male, LocalDate.of(1980, 12, 22));


        tree.add(ivanov);
        tree.add(petrova);
        tree.add(dostoevsky);
        fio = fioHumans("Иванов", "Виталий ", "Алексеевич");
        Human ivanov2 = new Human(fio, Gender.Female, LocalDate.of(1988, 7,5),ivanov,petrova);
        fio = fioHumans("Петров", "Михаил  ", "Александрович");
        Human petrov2 = new Human(fio, Gender.Male, LocalDate.of(1991, 1,25),ivanov,petrova);
        tree.add(ivanov2);
        tree.add(petrov2);


    return tree;
    }



    }




