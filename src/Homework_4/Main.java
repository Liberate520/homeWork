package Homework_4;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws InvalidObjectException {
        /*
        Вызываем экземпляры класса
         */
        Femily_Tree humans = new Femily_Tree();
        Designer_Human human = new Designer_Human();
        Service service = new Service(humans);

            /*
            параметризуем список
             */
        Cache<Designer_Human> cache = new Cache<>(10); //параметризуем список людей и устанавливаем размер кэша
        for (Designer_Human H1 : humans) {
            cache.addEl(H1);
        }
        cache.getAllEL().forEach(System.out::println); //выводим кэш на экран

        CommunicationWithUsers jj = new CommunicationWithUsers(); //Вызываем сканер
        jj.selectTheProgramVersion();


//Решение 3 домашнего задание

        service.AddHHUMAN("Vivi", "man", 1990);
        service.AddHHUMAN("Mia", "girl", 1988);
        service.AddHHUMAN("Franck", "man", 1991);
        service.AddHHUMAN("Luda", "girl", 1994);

        printFamilyTree(humans);

        service.sort(); //Сортировка

        service.sortByName(); //вариант сортировки по имени

        service.sortByDateOfBirth(); //Вариант сортировки по дате рождения

        Collections.sort(humans.getHumans());

//        service.sortNAME(); //&#x421;&#x43E;&#x440;&#x442;&#x438;&#x440;&#x43E;&#x432;&#x43A;&#x430; &#x43F;&#x43E; &#x438;&#x43C;&#x435;&#x43D;&#x438;

        printFamilyTree(humans);
        service.sort();
        for (Designer_Human HHE : humans) {
            System.out.println(HHE);
        }

        /**
         * Позволяет перебрать объекты коллекции
         */
        Iterator<Designer_Human> iterator = humans.iterator();
        while (iterator.hasNext()) {
            Designer_Human HHE = iterator.next();
            System.out.println(HHE);
        }


/**
 * Вариант вызова как в лекции
 */
        Serializator serializator = new Serializator() {
            //            @Override
            public void serializaSave() {

            }
        };
        System.out.println(serializator.serializaSave(human)); //Проверка если true - значит запись прошла

//
//        try {
//            Designer_Human human11 = serializator.DesSerializa();
//            System.out.println(human11.getName());
//        } catch (InvalidObjectException e) {
//            throw new RuntimeException(e);
//        }


        Fileworker fileworker = new Fileworker();
        fileworker.serializaSave(human); //записываем
        fileworker.DesSerializa(human);// читаем
    }

    private static void printFamilyTree(Femily_Tree humans) {
        for (Designer_Human HHE : humans) {
            System.out.println(HHE);
        }
        System.out.println();
    }


}
