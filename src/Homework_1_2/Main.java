package Homework_1_2;

import java.io.InvalidObjectException;

public class Main {
    public static void main(String[] args) throws InvalidObjectException {


        Designer_Human human = new Designer_Human();
        Femily_Tree humans = new Femily_Tree();
        human.AddHuman("Alex", "man", 1993);
        human.AddChildren();
        humans.addparents(new Designer_Human("Alex", "man", 1999), null, null);

        humans.printDrevo(humans.getTree());
        humans.ShowALL(); //вывод всех людей
        humans.showName("Alex"); //вывод по имени

        humans.addHuman(new Designer_Human("Molly", "girl", 1999));

        Designer_Human human1 = new Designer_Human();
        human1.setName("sss");

        humans.searchHuman(humans.getTree()); //вызов поиска


//        Попытка добавления
//        List<interfaseSave> saves = new ArrayList<>();
//        saves.add((interfaseSave) human1);
//        serializa(saves);


/**
 * Вариант вызова как в лекции
 */
        Serializator serializator = new Serializator() {
//            @Override
            public void serializaSave() {

            }
        };
        System.out.println(serializator.serializaSave(human1)); //Проверка если true - значит записть прошла

//
//        try {
//            Designer_Human human11 = serializator.DesSerializa();
//            System.out.println(human11.getName());
//        } catch (InvalidObjectException e) {
//            throw new RuntimeException(e);
//        }


        Fileworker fileworker = new Fileworker();
        fileworker.serializaSave(human1); //записываем
        fileworker.DesSerializa(human1);// читаем
    }

}