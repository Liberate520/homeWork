package family_tree;
import family_tree.Human;

import java.util.Date;


public class Main {

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Human alex = new Human("Alex", new Date(1990, 0, 1));
        // Human linda = new Human("Linda", new Date(1992, 5, 15));
        //Date date = new Date(2000, 3, 13);
        Human petr = new Human("Пётр", "Касьянов", Gender.M ,  new Date(1960, 1, 16) );
        Human dima = new Human("Дмитрий", "Касьянов", Gender.M ,  new Date(1989, 3, 13) , petr, null);
        Human larisa = new Human("Лариса", "Павлова", Gender.F ,  new Date(1990, 4, 12),dima );
        dima.setSpouse(larisa);
        Human misha = new Human("Миша", "Касьянов", Gender.M ,  new Date(2000, 3, 13),dima , larisa);
        Human dasha = new Human("Даша", "Касьянова", Gender.F ,  new Date(2001, 12, 14),dima , larisa);

        System.out.println(misha);
        System.out.println(larisa);
        System.out.println(dima.getInfoFather());
        System.out.println(dasha.getInfoMother());
        System.out.println(misha.getInfoFather());

        familyTree.add(dima);
        familyTree.add(larisa);
        familyTree.add(dasha);
        familyTree.add(misha);
        System.out.println(familyTree.getInfo());



        //System.out.println(larisa);
        //familyTree.add(john);

        // Human emily = new Human("Emily", new Date(2013, 8, 10));

        // alex.addChild(john);
        // linda.addChild(john);
        // linda.addChild(emily);

        // john.setFather(alex);
        // john.setMother(linda);

        
        // familyTree.printFamilyTree();




    }
    
}
