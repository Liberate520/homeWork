//Основная программа
// Реализовать, с учетом ооп подхода, приложение.
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например:
// модель человека и дерева
// Под “проведением исследования” можно понимать например получение всех детей выбранного человека.

import Animal.Human.Human;
import FamalyTree.FamalyTree;

class Programma {
    public static void main (String[] args) {
        FamalyTree<Human> famalyTree = new FamalyTree<>();

        famalyTree.addT();
        System.out.println("hierge");
        //famalyTree.addHuman();
        //famalyTree.addHuman();
        //famalyTree.addHumanRelatives(famalyTree.addHuman(),famalyTree.addHuman());
        
        //Использование итерирования класса FamalyTree
        for (Human human : famalyTree) {
            System.out.println(human);
        }
    }
}
