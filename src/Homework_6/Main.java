package Homework_6;

import Cache.CacheLimitations;
import OldClass.View;
import Serializator.Serializator;
import VIVI.ViewNew;

import java.io.InvalidObjectException;

public class Main {
    public static void main(String[] args) throws InvalidObjectException {
        /*
        Вызываем экземпляры класса
         */
        Designer_Human designer_human = new Designer_Human();  //Вызов  экземпляр класса

        Femily_Tree femily_tree = new Femily_Tree();//Вызов  экземпляр класса
        femily_tree.enumerationСollection(femily_tree); //метод перебора коллекции


        Serializator serializator = new Serializator();//Вызов  экземпляр класса
        serializator.serializatorMetod(designer_human); //вызываем серализотор

//        View view = new View(); //Вызов  экземпляр класса
//        view.Viewv(); // вызов окна работы с пользователем

        ViewNew viewNew = new ViewNew();
        viewNew.ViewvNEW();

        CacheLimitations cacheLimitations = new CacheLimitations(); //Вызов  экземпляр класса
        cacheLimitations.cacheMetod(femily_tree);//вызываем метод кэширования



    }


}
