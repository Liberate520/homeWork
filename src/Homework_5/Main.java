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

        View view = new View();
        view.showAll();

        cacheMetod(femily_tree);
        enumerationСollection(femily_tree);
        serializatorMetod(designer_human);
    }

    private static void enumerationСollection(Femily_Tree femily_tree) {
        /*
         * Позволяет перебрать объекты коллекции
         */

        Iterator<Designer_Human> iterator = femily_tree.iterator();
        while (iterator.hasNext()) {
            Designer_Human HHE = iterator.next();
            System.out.println(HHE);
        }
    }

    private static void serializatorMetod(Designer_Human designer_human) throws InvalidObjectException {
        WorkingFile fileworker = new WorkingFile();
        fileworker.serializaSave(designer_human); //записываем
        fileworker.DesSerializa(designer_human);// читаем
    }

    private static void cacheMetod(Femily_Tree femily_tree) {
    /*
    параметризуем список
    */
        CacheLimitations<Designer_Human> cache = new CacheLimitations<>(10); //параметризуем список людей и устанавливаем размер кэша
        for (Designer_Human H1 : femily_tree) {
            cache.addEl(H1);
        }
        cache.getAllEL().forEach(System.out::println); //выводим кэш на экран

    }

}
