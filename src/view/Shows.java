/*
Этот интерфейс добавлен в качестве примера "Dependency Inversion (Принцип инверсии зависимостей)"
Ранее у нас был один конструктор для печати в консоль. Интерфейс же говорит что любой класс который имеет реализацию
    вывода потомков при получениии ссылки на его место в памяти, может быть использован как получатель данного запроса.
 */

package view;

import model.Human;

public interface Shows {
    public void viewHeirs(Human startPerson);
}
