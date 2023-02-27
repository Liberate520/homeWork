/**
 * HW_03
 * Продолжаем работать с проектом с семейным деревом.
 * Реализовать интерфейс Iterable для дерева.
 * Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения
 *
 * HW_04
 * Продолжаем грейдить наш проект с гениологическим древом.
 * Изменить древо, сделать класс параметизированным.
 * Продумать класс общения с пользователем, сделать набор команд, для операций над деревом
*/

import api.*;
import presenter.Presenter;
import ui.ConsoleUI;
import ui.View;


import java.io.IOException;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        Service service = new ServiceModel();
        Presenter presenter = new Presenter(view, service);

        view.start();
    }
}
