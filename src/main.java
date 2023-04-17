package oop_homework_1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class main { 
    public static void main (String[] args){

        
        List<Human> children1 = new ArrayList<>();
        List<Human> children2 = new ArrayList<>();
        List<Human> children3 = new ArrayList<>();
        List<Human> children4 = new ArrayList<>();
        List<Human> children5 = new ArrayList<>();


        List<Human> bro1 = new ArrayList<>();
        List<Human> bro2 = new ArrayList<>();
        List<Human> bro3 = new ArrayList<>();
        List<Human> bro4 = new ArrayList<>();
        List<Human> bro5 = new ArrayList<>();

        GregorianCalendar dateOfBirth3 = new GregorianCalendar(1953, Calendar.NOVEMBER, 22); 
        GregorianCalendar dateOfDeath3 = new GregorianCalendar(0,0,0);
        Human human3 = new Human("Колыверов", "Александрович", "Вячеслав", dateOfBirth3, dateOfDeath3, null, null, children3, bro3);

        GregorianCalendar dateOfBirth4 = new GregorianCalendar(1960, Calendar.DECEMBER, 19); 
        GregorianCalendar dateOfDeath4 = new GregorianCalendar(0,0,0);
        Human human4 = new Human("Колыверова", "Николаевна", "Татьяна", dateOfBirth4, dateOfDeath4, null, null, children4, bro4);
        
        GregorianCalendar dateOfBirth1 = new GregorianCalendar(1984, Calendar.MAY, 6); 
        GregorianCalendar dateOfDeath1 = new GregorianCalendar(0,0,0);
        Human human1 = new Human("Колыверов", "Вячеславович", "Дмитрий", dateOfBirth1, dateOfDeath1, human4, human3, children1, bro1);

        
        GregorianCalendar dateOfBirth2 = new GregorianCalendar(1986, Calendar.SEPTEMBER, 5); 
        GregorianCalendar dateOfDeath2 = new GregorianCalendar(0,0,0);
        Human human2 = new Human("Колыверов", "Вячеславович", "Юрий", dateOfBirth2, dateOfDeath2, human4, human3, children2, bro2);

        GregorianCalendar dateOfBirth5 = new GregorianCalendar(2018, Calendar.SEPTEMBER, 15); 
        GregorianCalendar dateOfDeath5 = new GregorianCalendar(0,0,0);
        Human human5 = new Human("Колыверова", "Юрьевна", "Александра", dateOfBirth5, dateOfDeath5, null, human2, children5, bro5);

        children3.add(human1);
        children3.add(human2); 

        children2.add(human5);

        children4.addAll(children3);
        
        bro1.add(human2);

        bro2.add(human1);
               
       FamilyTree familyTree1 = new FamilyTree(human2);
       System.out.println(familyTree1);
       FamilyTree familyTree2 = new FamilyTree(human1);
       System.out.println(familyTree2);      
       FamilyTree familyTree3 = new FamilyTree(human3);
       System.out.println(familyTree3);
    }
    
}
