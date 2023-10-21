import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.service.Service;
import ru.gb.family_tree.tree.FamilyTree;
import ru.gb.family_tree.writer.FIleHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {

        Service service = new Service("Вишняк");

        Human danya = service.addNewToFamily("Вишняк", "Даниил", Gender.Male);
        danya.setBirthday(LocalDate.of(2004, 1, 31));
        Human kate = service.addNewToFamily("Лозовая", "Екатерина", Gender.Female);
        kate.setBirthday(LocalDate.of(2010, 10, 06));
        Human vika = service.addNewToFamily("Козаева", "Виктория", Gender.Female);
        vika.setBirthday(LocalDate.of(2005, 9, 20));
        Human alena = service.addNewToFamily("Дерека", "Алена", Gender.Female);
        alena.setBirthday(LocalDate.of(1994, 4, 06));
        Human dasha = service.addNewToFamily("Дерека", "Дарья", Gender.Female);
        dasha.setBirthday(LocalDate.of(2000, 7, 28));
        Human jane = service.addNewToFamily("Вишняк", "Евгения", Gender.Female);
        jane.setBirthday(LocalDate.of(1982, 10, 04));
        jane.setChild(danya);
        Human dima = service.addNewToFamily("Вишняк", "Дмитрий", Gender.Male);
        dima.setBirthday(LocalDate.of(1979, 1, 12));
        dima.setChild(danya);
        Human sveta = service.addNewToFamily("Лозовая", "Светлана", Gender.Female);
        sveta.setBirthday(LocalDate.of(1979, 10, 04));
        sveta.setChild(kate);
        sveta.setChild(vika);
        Human andrey = service.addNewToFamily("Лозовой", "Андрей", Gender.Male);
        andrey.setBirthday(LocalDate.of(1979, 04, 13));
        andrey.setSpouse(sveta);
        andrey.setChild(kate);
        Human oksana = service.addNewToFamily("Дерека", "Оксана", Gender.Female);
        oksana.setBirthday(LocalDate.of(1974, 7, 04));
        oksana.setChild(alena);
        oksana.setChild(dasha);
        Human grigory = service.addNewToFamily("Цыбулевский", "Григорий", Gender.Male);
        Human valya = service.addNewToFamily("Цыбулевская", "Валентина", Gender.Female);
        valya.setBirthday(LocalDate.of(1949, 10, 23));
        valya.setChild(jane);
        valya.setChild(sveta);
        Human ilya = service.addNewToFamily("Цыбулевский", "Илья", Gender.Male);
        ilya.setBirthday(LocalDate.of(1949, 10, 10));
        ilya.setDeathday(LocalDate.of(2007, 5, 24));
        ilya.setSpouse(valya);
        ilya.setChild(jane);
        ilya.setChild(sveta);
        ilya.setChild(grigory);
        Human nina = service.addNewToFamily("Вишняк", "Нина", Gender.Female);
        nina.setBirthday(LocalDate.of(1953, 11, 04));
        nina.setDeathday(LocalDate.of(2006, 4, 12));
        nina.setChild(dima);
        nina.setChild(oksana);
        Human grisha = service.addNewToFamily("Вишняк", "Григорий", Gender.Male);
        grisha.setBirthday(LocalDate.of(1950, 12, 04));
        grisha.setDeathday(LocalDate.of(2022, 7, 22));
        grisha.setChild(dima);
        grisha.setChild(oksana);

        System.out.println(service);

        service.sortById();
        System.out.println(service);
        service.sortByLastname();
        System.out.println(service);
        service.sortByName();
        System.out.println(service);
        service.sortByAge();
        System.out.println(service);


        //FamilyTree vishnyak = vishnyak();
        //System.out.println(vishnyak.allInDetails());



//        FIleHandler fh = new FIleHandler();
//        if (fh.write(vishnyak, "output.data")) System.out.println("Данные успешно записаны");
//        vishnyak = (FamilyTree) fh.read("output.data");
//        System.out.println(vishnyak.allInDetails());
    }

    public static FamilyTree vishnyak() {
        FamilyTree vishnyak = new FamilyTree("Вишняк");

        Human danya = new Human("Вишняк", "Даниил", Gender.Male);
        danya.setBirthday(LocalDate.of(2004, 1, 31));
        Human kate = new Human("Лозовая", "Екатерина", Gender.Female);
        kate.setBirthday(LocalDate.of(2010, 10, 06));
        Human vika = new Human("Козаева", "Виктория", Gender.Female);
        vika.setBirthday(LocalDate.of(2005, 9, 20));
        Human alena = new Human("Дерека", "Алена", Gender.Female);
        alena.setBirthday(LocalDate.of(1994, 4, 06));
        Human dasha = new Human("Дерека", "Дарья", Gender.Female);
        dasha.setBirthday(LocalDate.of(2000, 7, 28));
        Human jane = new Human("Вишняк", "Евгения", Gender.Female);
        jane.setBirthday(LocalDate.of(1982, 10, 04));
        jane.setChild(danya);
        Human dima = new Human("Вишняк", "Дмитрий", Gender.Male);
        dima.setBirthday(LocalDate.of(1979, 1, 12));
        dima.setChild(danya);
        Human sveta = new Human("Лозовая", "Светлана", Gender.Female);
        sveta.setBirthday(LocalDate.of(1979, 10, 04));
        sveta.setChild(kate);
        sveta.setChild(vika);
        Human andrey = new Human("Лозовой", "Андрей", Gender.Male);
        andrey.setBirthday(LocalDate.of(1979, 04, 13));
        andrey.setSpouse(sveta);
        andrey.setChild(kate);
        Human oksana = new Human("Дерека", "Оксана", Gender.Female);
        oksana.setBirthday(LocalDate.of(1974, 7, 04));
        oksana.setChild(alena);
        oksana.setChild(dasha);
        Human grigory = new Human("Цыбулевский", "Григорий", Gender.Male);
        Human valya = new Human("Цыбулевская", "Валентина", Gender.Female);
        valya.setBirthday(LocalDate.of(1949, 10, 23));
        valya.setChild(jane);
        valya.setChild(sveta);
        Human ilya = new Human("Цыбулевский", "Илья", Gender.Male);
        ilya.setBirthday(LocalDate.of(1949, 10, 10));
        ilya.setDeathday(LocalDate.of(2007, 5, 24));
        ilya.setSpouse(valya);
        ilya.setChild(jane);
        ilya.setChild(sveta);
        ilya.setChild(grigory);
        Human nina = new Human("Вишняк", "Нина", Gender.Female);
        nina.setBirthday(LocalDate.of(1953, 11, 04));
        nina.setDeathday(LocalDate.of(2006, 4, 12));
        nina.setChild(dima);
        nina.setChild(oksana);
        Human grisha = new Human("Вишняк", "Григорий", Gender.Male);
        grisha.setBirthday(LocalDate.of(1950, 12, 04));
        grisha.setDeathday(LocalDate.of(2022, 7, 22));
        grisha.setChild(dima);
        grisha.setChild(oksana);

        return vishnyak;
    }
}
