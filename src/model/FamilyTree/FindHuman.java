package model.FamilyTree;
import java.util.Scanner;

import model.Persons.Human;
import model.Persons.Person;
public class FindHuman<T extends Human> 
{
    public void findHuman(T t, FamilyTree familyTree)
    {
        System.out.println("Введите фамилию для поиска:");
        Scanner sc1 = new Scanner(System.in, "cp866");
        String findLastName = sc1.nextLine();

        System.out.println("Введите имя для поиска:");
        Scanner sc2 = new Scanner(System.in, "cp866");
        String findFirstName = sc2.nextLine();

        boolean find=false;
        for (int i = 0; i < familyTree.size(); i++) 
        {
            if (((T) familyTree.get(i)).getLastName().contains(findLastName) && (((T) familyTree.get(i)).getFirstName().contains(findFirstName))); 
            {
                System.out.println(familyTree.get(i));
                find=true;
            }    
        
            if (!find)
            {
                 System.out.println("Такой человек не найден.");
            }
        }
    }

    
}
