package familytree;
import java.util.Date;

import familytree.family_tree.FamilyTree;
import familytree.file_hendler.FileHandler;
import familytree.human.Gender;
import familytree.human.Human;


public class Main {

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        FileHandler fileHandler = new FileHandler();
    
        Human petr = new Human("Пётр", "Касьянов", Gender.M ,  new Date(1960, 1, 16) );
        Human dima = new Human("Дмитрий", "Касьянов", Gender.M ,  new Date(1989, 3, 13) , petr, null);
        Human larisa = new Human("Лариса", "Павлова", Gender.F ,  new Date(1990, 4, 12),dima );
        dima.setSpouse(larisa);
        Human misha = new Human("Миша", "Касьянов", Gender.M ,  new Date(2000, 3, 13),dima , larisa);
        Human dasha = new Human("Даша", "Касьянова", Gender.F ,  new Date(2001, 12, 14),dima , larisa);
        Human  misha2 = new Human("Миша", "Плотников", Gender.M ,  new Date(2011, 4, 11));
        Human  man = new Human("Давид", "Абрамов", Gender.M ,  new Date(1990, 4, 11));
        larisa.getAge();
        System.out.println(larisa);
        System.out.println(dima.getInfoFather());
        System.out.println(dasha.getInfoMother());
        System.out.println(misha.getInfoFather());
        
        
    
        System.out.println();
        //System.out.println(larisa.getDateOfBirth().getYear());
        familyTree.getByName("Миша");
        familyTree.add(dima);
        familyTree.add(larisa);
        familyTree.add(dasha);
        familyTree.add(misha);
        familyTree.add(misha2);
        familyTree.add(man);
        System.out.println(familyTree.getInfo());
        //Запись
        fileHandler.write(familyTree, "HoweWorkJavaOOP\\familytree\\save\\family_tree.out");
        //Чтение
        FamilyTree loadTree = (FamilyTree)fileHandler.read("HoweWorkJavaOOP\\familytree\\save\\family_tree.out");
        System.out.println(loadTree.getInfo());
        //System.out.println(familyTree.getInfo());
        //System.out.println(larisa);
        //familyTree.add(john);
        loadTree.sortBySurname();
        System.out.println(loadTree.getInfo());
        loadTree.sortByBirthDate();
        System.out.println(loadTree.getInfo());
           




    }
    
}
