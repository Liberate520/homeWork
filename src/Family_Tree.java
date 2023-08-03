//Реализовать,с учетом ооп подхода,приложение.
//Для проведения исследований с генеалогическим древом.
//Идея:описать некоторое количество компонент,например:
//модель человека и дерева
//Под “проведением исследования” можно понимать например получение всех детей выбранного человека.
//Более детальное описание проекта и как его реализовать обсуждали в конце семинара
//Сделать PR к проекту:https://github.com/Liberate520/homeWork
//В качестве ответа указать ссылку на PR
//Ссылка на то как сделать пулреквест смотри в материалах к уроку
//Если PR все таки не дается,то можно и ссылкой на гит репозиторий

import java.util.ArrayList;

public class Family_Tree {
    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    public void appendParentChild(Human parent, Human children) {
        tree.add(new Node(parent, Relationship.parent, children));
        tree.add(new Node(children, Relationship.children, parent));
    }

    public void appendWifeHusband(Human wife, Human husband) {
        tree.add(new Node(wife, Relationship.wife, husband));
        tree.add(new Node(husband, Relationship.husband, wife));
    }
}
