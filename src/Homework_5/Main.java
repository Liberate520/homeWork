package Homework_5;

import java.io.InvalidObjectException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws InvalidObjectException {
        /*
        Вызываем экземпляры класса
         */

        Femily_Tree femily_tree = new Femily_Tree();

        Designer_Human designer_human = new Designer_Human();
        /*
        параметризуем список
        */
        CacheLimitations<Designer_Human> cache = new CacheLimitations<>(10); //параметризуем список людей и устанавливаем размер кэша
        for (Designer_Human H1 : femily_tree) {
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

        Iterator<Designer_Human> iterator = femily_tree.iterator();
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
        System.out.println(serializator.serializaSave(designer_human)); //Проверка если true - значит запись прошла

//
//        try {
//            Designer_Human human11 = serializator.DesSerializa();
//            System.out.println(human11.getName());
//        } catch (InvalidObjectException e) {
//            throw new RuntimeException(e);
//        }


        WorkingFile fileworker = new WorkingFile();
        fileworker.serializaSave(designer_human); //записываем
        fileworker.DesSerializa(designer_human);// читаем
    }

}
