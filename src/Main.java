import family_tree.FamilyTree;
import family_tree.ServiceFamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.marriage.Marriage;
import saveload.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServiceFamilyTree service = new ServiceFamilyTree();

        Human anton = service.addHuman("Антон", LocalDate.of(1990, 10, 16), Gender.Male);
        Human helen = service.addHuman("Елена", LocalDate.of(1993, 04, 01), Gender.Female);
        Human andrew = service.addHuman("Андрей", LocalDate.of(2012, 12, 31), Gender.Male);
        System.out.println(String.format("test anton.getAge(): %d", anton.getAge()));

        //Добавляем связи "родители-дети"
        //!!! Допустимо ли, что это можно сделать вне сервиса ???
        anton.addChild(andrew);
        helen.addChild(andrew);

        // Регистрируем брак
        Marriage m = service.addMarriage(LocalDate.of(2011, 10, 16), helen, anton);

        //Андрей развелся с Еленой и женился на Маше
        //а) расторгаем брак
        service.stopMarriageById(m.getId(), LocalDate.of(2015, 1, 16));
        //б) добавляем персонаж
        Human masha = service.addHuman("Маша", LocalDate.of(1994, 11, 5), Gender.Female);
        //в) заключаем новый брак
        Marriage m2 = service.addMarriage(LocalDate.of(2016, 1, 1), masha, anton);

        service.sortHumansByAge();

        System.out.println(String.format("tree info: \n%s", service.getInfoAll()));

        //Выполняем запись в файл и последующее чтение
        FileHandler filehandler = new FileHandler();
        filehandler.saveTo(service.getTree(), "tree.txt");

        FamilyTree treeOut = (FamilyTree)filehandler.loadFrom("tree.txt");
        //Дублируем вывод:
        System.out.println(String.format("treeOut info: \n%s", treeOut.getInfoAll()));
    }
}