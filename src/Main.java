import java.time.LocalDate;

import FamailyTree.FamilyTree;
import Human.Gender;
import Human.Human;

public class Main{
   public static void main(String[] args) {
        FamilyTree tree = treeFamily();
        System.out.println(tree);
    }
    
    public static FamilyTree treeFamily(){
        FamilyTree tree = new FamilyTree();
          
         Human grandMother1 = new Human("Нила", "Кожедуб",
                LocalDate.of(1947, 01,11) ,
                LocalDate.of(2015,05,10),Gender.Female);

        Human grandFather1 = new Human("Иван", "Кожедуб",
                LocalDate.of(1941,01,10),Gender.Male);

        Human grandMother2 = new Human("Людмила", "Кожедуб",
                LocalDate.of(1932,03,11),
                LocalDate.of(2012,06,20),Gender.Female);

        Human grandFather2 = new Human("Павел", "Кожедуб",
                LocalDate.of(1930,06,10),Gender.Male);

        tree.add(grandMother1);
        tree.add(grandFather1);
        tree.add(grandMother2);
        tree.add(grandFather2);

       Human mother = new Human("Татьяна","Кожедуб",
               LocalDate.of(1965,02,13),Gender.Female,grandMother1,grandFather1);

       Human father = new Human("Константин","Кожедуб",
               LocalDate.of(1963,01,15), Gender.Male,grandMother2,grandFather2);

      Human child1 = new Human("Владимир","Кожедуб",
               LocalDate.of(1988,02,11),Gender.Male,mother,father);

      Human child2 = new Human("Светлана","Кожедуб",
               LocalDate.of(1986,05,14),Gender.Female,mother,father);

        tree.add(mother);
        tree.add(father);
        tree.add(child1);
        tree.add(child2);

        return tree;
    }
}
   

