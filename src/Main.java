import Classes.FamilyTree;
import Classes.Human;

import java.time.LocalDate;

import static Classes.Gender.female;
import static Classes.Gender.male;

public class Main {
    public static void main(String[] args){

        FamilyTree tree =new FamilyTree();
        tree.add(new Human(1,"Пушкин","","Александр","Сергеевич",male,
                LocalDate.of(1799,06,06),LocalDate.of(1837,02,10),null,null));
        tree.add(new Human(2,"Пушкина","Гончарова","Наталья","Николаевна",female,
              LocalDate.of(1812,9,8),LocalDate.of(1863,12,8),null,null));


//       Human as=new Human(1,"Пушкин","","Александр","Сергеевич",male,
//              LocalDate.of(1799,06,06),LocalDate.of(1837,02,10),null,null);
//       Human nn=new Human(2,"Пушкина","Гончарова","Наталья","Николаевна",female,
//              LocalDate.of(1812,9,8),LocalDate.of(1863,12,8),null,null);

        System.out.println(tree.getInfo());
    }



}
