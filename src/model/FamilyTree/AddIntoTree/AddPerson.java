package model.FamilyTree.AddIntoTree;

import model.Persons.Person;
import java.util.ArrayList;

import model.FamilyTree.FamilyTree;
import model.Persons.Human;
import model.Persons.Person;
import model.Persons.InterfacePerson;
import model.Persons.Others;
import model.Persons.InterfaceHuman;
import model.Persons.InterfaceOthers;


public class AddPerson<T extends Person> 
{
    public <T extends FamilyTree> FamilyTree addPerson(Person person, FamilyTree familyTree) 
    {
            familyTree.add(person);

        if (person instanceof Human && person.getMother() != null)
           {
             ((Human) person.getMother()).addChildren(person);
           }
        if (person instanceof Human && person.getFather() != null)
        {
            ((Human) person.getFather()).addChildren(person);
        }   
        return familyTree; 
    }
    
}    


