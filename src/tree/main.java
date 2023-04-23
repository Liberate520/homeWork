package tree;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class main { 
    public static void main (String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
 
        GregorianCalendar dateOfBirth1 = new GregorianCalendar(1984, Calendar.MAY, 6); 
        GregorianCalendar dateOfDeath1 = new GregorianCalendar(0,0,0);
        Human human1 = new Human("Колыверов", "Вячеславович", "Дмитрий", dateOfBirth1, dateOfDeath1);
        
        GregorianCalendar dateOfBirth2 = new GregorianCalendar(1986, Calendar.SEPTEMBER, 5); 
        GregorianCalendar dateOfDeath2 = new GregorianCalendar(0,0,0);
        Human human2 = new Human("Колыверов", "Вячеславович", "Юрий", dateOfBirth2, dateOfDeath2);

        GregorianCalendar dateOfBirth3 = new GregorianCalendar(1953, Calendar.NOVEMBER, 22); 
        GregorianCalendar dateOfDeath3 = new GregorianCalendar(0,0,0);
        Human human3 = new Human("Колыверов", "Александрович", "Вячеслав", dateOfBirth3, dateOfDeath3);

        GregorianCalendar dateOfBirth4 = new GregorianCalendar(1960, Calendar.DECEMBER, 19); 
        GregorianCalendar dateOfDeath4 = new GregorianCalendar(0,0,0);
        Human human4 = new Human("Колыверова", "Николаевна", "Татьяна", dateOfBirth4, dateOfDeath4);

        GregorianCalendar dateOfBirth5 = new GregorianCalendar(2018, Calendar.SEPTEMBER, 15); 
        GregorianCalendar dateOfDeath5 = new GregorianCalendar(0,0,0);
        Human human5 = new Human("Колыверова", "Юрьевна", "Александра", dateOfBirth5, dateOfDeath5);

        FamilyTree tree = new FamilyTree();

        tree.setHuman(human1);
        tree.setHuman(human2);
        tree.setHuman(human3);
        tree.setHuman(human4);
        tree.setHuman(human5);

        System.out.println(tree.toString());
        System.out.println(tree.getByFio("Колыверов", "Дмитрий", "Вячеславович"));

        ReadWrite rw = new ReadWrite();
        rw.write(tree);   
        System.out.println(rw.read().toString());

       
               
       
    }
    
}
