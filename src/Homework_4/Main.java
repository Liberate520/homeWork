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
//        Service service = new Service(humans);

        /*
        параметризуем список
        */
        Cache<Designer_Human> cache = new Cache<>(10); //параметризуем список людей и устанавливаем размер кэша
        for (Designer_Human H1 : humans) {
            cache.addEl(H1);
        }
        cache.getAllEL().forEach(System.out::println); //выводим кэш на экран

        /*
        класс общения с пользователем
         */
        CommunicationWithUsers jj = new CommunicationWithUsers();
        jj.selectTheProgramVersion();

        /*
         * Позволяет перебрать объекты коллекции
         */

        Iterator<Designer_Human> iterator = humans.iterator();
        while (iterator.hasNext()) {
            Designer_Human HHE = iterator.next();
            System.out.println(HHE);
        }

         /*
         Вариант вызова как в лекции
         */
        Serializator serializator = new Serializator() {
            //@Override
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

}
