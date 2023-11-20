//Основная программа
// Реализовать, с учетом ооп подхода, приложение.
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например:
// модель человека и дерева
// Под “проведением исследования” можно понимать например получение всех детей выбранного человека.


//TTimport Human_tree.FamalyTree;

import FamalyTree.FamalyTree;

class Programma {
    public static void main (String[] args) {
        FamalyTree famalyTree = new FamalyTree();

        famalyTree.addHuman();
        System.out.println("hierge");
        //famalyTree.addHuman();
        //famalyTree.addHuman();
        //famalyTree.addHumanRelatives(famalyTree.addHuman(),famalyTree.addHuman());
    }
}
