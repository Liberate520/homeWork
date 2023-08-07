package ru.gb.Tree;

import ru.gb.Tree.FamilyTree.Tree;
import ru.gb.Tree.Human.Gender;
import ru.gb.Tree.Human.Human;


public class Main {
    public static void main(String[] args) {
        
        Tree tree = familyTree();
        System.out.println(tree);
        
    }

    static Tree familyTree(){
        
        Tree familyTree = new Tree();
        
        
        Human ivan = new Human("Иван", Gender.male, Human.getBirthDate(1950, 10, 25), Human.getDeathDate(2015, 5, 10));
        Human natalya = new Human("Наталья", Gender.female, Human.getBirthDate(1955, 12, 31), Human.getDeathDate(2018, 4, 21));
        familyTree.addHuman(ivan);
        familyTree.addHuman(natalya);
        Tree.setWedding(ivan,natalya);

        Human sergey = new Human("Сергей", Gender.male, Human.getBirthDate(1975, 6, 21), natalya, ivan);
        Human alisa = new Human("Алиса", Gender.female, Human.getBirthDate(1976, 10, 10));
        familyTree.addHuman(sergey);
        familyTree.addHuman(alisa);
        ivan.addToChildren(sergey);
        natalya.addToChildren(sergey);
        Tree.setWedding(sergey, alisa);

        Human svetlana = new Human("Светлана", Gender.female, Human.getBirthDate(1998, 1, 24), alisa, sergey);
        familyTree.addHuman(svetlana);
        sergey.addToChildren(svetlana);
        alisa.addToChildren(svetlana);

        Human petr = new Human("Петр", Gender.male, Human.getBirthDate(2000, 7, 21), alisa, sergey);
        familyTree.addHuman(petr);
        sergey.addToChildren(petr);
        alisa.addToChildren(petr);

        return familyTree;
    }
    
}
