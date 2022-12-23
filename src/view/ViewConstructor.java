package view;

import controller.TreeControl; // допустим ли цикличный импорт? Python бы не разрешил
import model.Human;
import model.Link;

import java.util.List;

public class ViewConstructor implements Shows {
    TreeControl controller;

    public ViewConstructor(TreeControl controller) {
        this.controller = controller;
    }


    public void viewHeirs(Human startPerson){
        System.out.println(startPerson); // выводим первого
        String indent = "|";
        viewHeirs(startPerson, indent);// отправляем просчитываться всех потомков
    }

    public void viewHeirs(Human startPerson, String indent){
        // запрашиваем список всех потомков
        List<Link> childrens = controller.getAllLink(startPerson,'c');
        //перебираем потомков
        for (Link child : childrens) {
            System.out.printf("%s %s %n", indent, child.getSecond());
            viewHeirs((Human) child.getSecond(), indent + " |");
        }
    }
}
