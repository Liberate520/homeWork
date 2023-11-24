//Основная программа
// Реализовать, с учетом ооп подхода, приложение.
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например:
// модель человека и дерева
// Под “проведением исследования” можно понимать например получение всех детей выбранного человека.

import Animal.Human.Gender;
import Animal.Human.Human;
import FamalyTree.FamalyTree;
import FileWork.Filehundler;

class Programma {
    public static void main (String[] args) {
        //FamalyTree<Human> famalyTree = new FamalyTree<>();

        // famalyTree.addT(new Human("Евгений",1997,10,24,Gender.Male));
        // famalyTree.addT(new Human("Диана",1998,9,16,Gender.Female));
        // famalyTree.addT(new Human("Настя",2025,11,24,Gender.Female));
        // famalyTree.PrintTree();
        // famalyTree.addTRelatives(0,1, 3);
        // famalyTree.PrintTree();
        // famalyTree.addTRelatives(0,2, 4);
        Filehundler filehundler = new Filehundler();
        filehundler.LoadInFile("save.txt");
        FamalyTree<Human> famalyTree = (FamalyTree<Human>)(filehundler.LoadInFile("save.txt"));
        famalyTree.PrintTree();
    }
}
