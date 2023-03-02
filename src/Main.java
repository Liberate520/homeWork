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
 *
 * HW_05
 * Изменить проект с деревом в соответствии с паттерном MVP.
 * Реализовать View составляющую и команды по примеру с урока.
 * В дерево должна быть возможность
 *          добавить нового человека,
 *          получить информацию по человеку(ближайшие родственники в том числе),
 *          вывод всего дерева
*/

import api.*;
import presenter.Presenter;
import ui.Console;
import ui.View;


import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new Console();
        DbProceed serviceModel = new DbProceed();
        new Presenter(view, serviceModel);

        view.start();
    }
}
