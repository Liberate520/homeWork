import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;
import ru.gb.family_tree.writer.FIleHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {

        FamilyTree vishnyak = vishnyak();
        System.out.println(vishnyak.allInDetails());



        FIleHandler fh = new FIleHandler();
        if (fh.write(vishnyak, "output.data")) System.out.println("Данные успешно записаны");
        vishnyak = (FamilyTree) fh.read("output.data");
        System.out.println(vishnyak.allInDetails());
    }

    public static FamilyTree vishnyak() {
        FamilyTree vishnyak = new FamilyTree("Вишняк");

        Human danya = new Human(vishnyak,"Вишняк", "Даниил", Gender.Male);
        danya.setBirthday(LocalDate.of(2004, 1, 31));
        Human kate = new Human(vishnyak,"Лозовая", "Екатерина", Gender.Female);
        kate.setBirthday(LocalDate.of(2010, 10, 06));
        Human vika = new Human(vishnyak,"Козаева", "Виктория", Gender.Female);
        vika.setBirthday(LocalDate.of(2005, 9, 20));
        Human alena = new Human(vishnyak,"Дерека", "Алена", Gender.Female);
        alena.setBirthday(LocalDate.of(1994, 4, 06));
        Human dasha = new Human(vishnyak,"Дерека", "Дарья", Gender.Female);
        dasha.setBirthday(LocalDate.of(2000, 7, 28));
        Human jane = new Human(vishnyak,"Вишняк", "Евгения", Gender.Female);
        jane.setBirthday(LocalDate.of(1982, 10, 04));
        jane.setChild(danya);
        Human dima = new Human(vishnyak,"Вишняк", "Дмитрий", Gender.Male);
        dima.setBirthday(LocalDate.of(1979, 1, 12));
        dima.setChild(danya);
        Human sveta = new Human(vishnyak,"Лозовая", "Светлана", Gender.Female);
        sveta.setBirthday(LocalDate.of(1979, 10, 04));
        sveta.setChild(kate);
        sveta.setChild(vika);
        Human andrey = new Human(vishnyak,"Лозовой", "Андрей", Gender.Male);
        andrey.setBirthday(LocalDate.of(1979, 04, 13));
        andrey.setSpouse(sveta);
        andrey.setChild(kate);
        Human oksana = new Human(vishnyak,"Дерека", "Оксана", Gender.Female);
        oksana.setBirthday(LocalDate.of(1974, 7, 04));
        oksana.setChild(alena);
        oksana.setChild(dasha);
        Human grigory = new Human(vishnyak,"Цыбулевский", "Григорий", Gender.Male);
        Human valya = new Human(vishnyak,"Цыбулевская", "Валентина", Gender.Female);
        valya.setBirthday(LocalDate.of(1949, 10, 23));
        valya.setChild(jane);
        valya.setChild(sveta);
        Human ilya = new Human(vishnyak,"Цыбулевский", "Илья", Gender.Male);
        ilya.setBirthday(LocalDate.of(1949, 10, 10));
        ilya.setDeathday(LocalDate.of(2007, 5, 24));
        ilya.setSpouse(valya);
        ilya.setChild(jane);
        ilya.setChild(sveta);
        ilya.setChild(grigory);
        Human nina = new Human(vishnyak,"Вишняк", "Нина", Gender.Female);
        nina.setBirthday(LocalDate.of(1953, 11, 04));
        nina.setDeathday(LocalDate.of(2006, 4, 12));
        nina.setChild(dima);
        nina.setChild(oksana);
        Human grisha = new Human(vishnyak,"Вишняк", "Григорий", Gender.Male);
        grisha.setBirthday(LocalDate.of(1950, 12, 04));
        grisha.setDeathday(LocalDate.of(2022, 7, 22));
        grisha.setChild(dima);
        grisha.setChild(oksana);

        return vishnyak;
    }
}
