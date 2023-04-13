package model.FamilyTree.AddIntoTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.FamilyTree.FamilyTree;
import model.Persons.Others;
import model.Persons.Person;

public class AddOthers<T extends Person>
{
    public <T extends Person> FamilyTree FillByOthers()
    {
        FamilyTree familyTree = new FamilyTree();
        Others others1 = new Others(1, "иван", "инженер");
        Others others2 = new Others(2, "петр", "программист");
        
        List<Person> person = new ArrayList<>(Arrays.asList(others1, others2));

         for (Person value : person)  
         {
             familyTree.addPerson(person, familyTree); 
         }
        return familyTree;
        }    
}