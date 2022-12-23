//Реализовать, с учетом ооп подхода, приложение.
//        Для проведения исследований с генеалогическим древом.
//        Идея: описать некоторое количество компонент, например:
//        модель человека
//        компонента хранения связей и отношений между людьми: родитель, ребёнок - классика, но можно подумать и про отношение, брат, свекровь, сестра и т. д.
//        компонент для проведения исследований
//        дополнительные компоненты, например отвечающие за вывод данных в консоль, загрузку и сохранения в файл, получение\построение отдельных моделей человека
//        Под “проведением исследования” можно понимать получение всех детей выбранного человека.
//
//        Сделать PR к проекту: https://github.com/Liberate520/homeWork

import controller.TreeControl;
import model.Human;
import model.Tree;
import model.TreePerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> lis = new ArrayList<String>();
//        lis.get(1);

        // подгружаем контроллер
        TreeControl controller = new TreeControl();
        // создаём дерево
        Tree<TreePerson> tree = controller.createTree();
        // нужно создать человека
        //region Description
        Human IM = controller.createHuman("Мать", 0); // мать
        Human IF = controller.createHuman("Отец", 1); // отец
        Human B1 = controller.createHuman("Брат", 1); // Брат
        Human S1 = controller.createHuman("Сестра", 0); // сестра
        Human II = controller.createHuman("Я", 1); // я
        Human GmM = controller.createHuman("Бабушка матери", 0); // Бабушка матери
        Human GfM = controller.createHuman("Дедушка матери", 1); // дедушка матери
        Human GmF = controller.createHuman("Бабушка отца", 0); // Бабушка отца
        Human GfF = controller.createHuman("Дедушка отца", 1); // дедушка отца
        Human IS1 = controller.createHuman("Сын1", 1); // сын
        Human ID1 = controller.createHuman("Дочь1", 0); // дочь
        Human IS1D1 = controller.createHuman("Дочь1 сына1", 0); // дочь сына
        Human ID1D1 = controller.createHuman("Дочь1 дочери1", 0); // дочь дочери
        Human ID1D2 = controller.createHuman("Дочь2 дочери1", 0); // дочь дочери
        Human ID1S1 = controller.createHuman("Сын1 дочери1", 1); // сын дочери
        //endregion

        // человек находится в дереве
        //region Description
        controller.addToTree(IM, tree); // допустим мы не знаем кого добавляем, но знаем куда.
        controller.addToTree(IF, tree); // можно добавлять сразу создавая объект. Дерево запомнит всех
        controller.addToTree(new TreePerson[] {B1,S1,II,GmM,GfM,GmF,GfF,IS1,ID1,IS1D1,ID1D1,ID1D2,ID1S1}, tree);
        //endregion

        System.out.println(tree.getHumanList());

        // запрос на добавление связи
        // в перспективе гендер будет получен автоматом
        //region Description
        controller.createLink(new TreePerson[] {IM, GmM, GmF}, new TreePerson[] {IF, GfM, GfF}, 200); // все жёны к мужьям
        controller.createLink(new TreePerson[] {S1, S1, ID1D1, ID1D2}, new TreePerson[] {B1, II, ID1S1, ID1S1}, 100); // все сёстры к братьям
        controller.createLink(ID1D1, ID1D2, 100);
        controller.createLink(new TreePerson[] {IM,IM,IM, GmM, GmF, ID1,ID1,ID1}, new TreePerson[] {II, S1, B1, IM, IF, ID1D1, ID1D2, ID1S1}, 400); // все матери к детям
        controller.createLink(new TreePerson[] {IF, IF, IF, GfM, GfF, II, II, IS1}, new TreePerson[] {II, S1, B1, IM, IF, IS1, ID1, IS1D1}, 401); // все Отцы к детям
        //endregion

        System.out.println(ID1D1.getLink());

        //запрашиваем вывод дерева к потомкам
        controller.viewHeirs(II);
        System.out.printf("%n ---------- %n%n");
        controller.viewHeirs(GmM);

        controller.runMenu(); // запускаем меню
    }


}


/*
Попытаться отработать принципы SOLID

S – Single Responsibility (Принцип единственной ответственности)
    Не полностью уверен, но вроде нет ошибок.

O - Open closed Principle - принцип открытости-закрытости
    Вероятно примером можно выставить model.PersonMethods.getAllLink(Human person) (строка 20)
    Данный метод был расширен перегрузкой значительно позже после создания.
    Это можно было сделать и в новом классе, но в данном случае не целесообразно.

L - Liskov substitution Principle - принцип подстановки Барбары Лисков
    Наиболее частое использование здесь это наследование Human от TreePerson. Однако в методе Human нет переопределения
    методов способных вызвать подобную проблему

I -  Interface Segregation Principle - принцип разделения интерфейсов
    Интерфейсов реализовано мало. Ошибок нет.

D — Dependency Inversion (Принцип инверсии зависимостей):
    Добавлен интерфейс view.Shows. Пояснение в нулевой строке интерфейса.
    Вместе с тем в TreeControl добавлен сетер позволяющий установить другой визуализатор,
    однако изначально инициализируется по умолчанию ViewConstructor.


В целом тема освоена слабо, надо больше собственных практических применений.
 */