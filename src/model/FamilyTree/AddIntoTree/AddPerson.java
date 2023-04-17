package model.FamilyTree.AddIntoTree;

import model.Persons.Person;
import java.util.List;
import model.FamilyTree.FamilyTree;
import model.Persons.Human;
import model.Persons.Others;


public class AddPerson<T extends Person> 
{
    public FamilyTree addPerson(List<Person> person) 

    {  
            FamilyTree familyTree = new FamilyTree();
            Person human = new Human();
            Person others = new Others();

            for (Person item :person)
            {
                familyTree.add(item);

                     if (item instanceof Human)
                        {  
                            if (item.getMother() != null)
                            {
                                ((Human) item.getMother()).addChildren(item);
                            }
                            if  (item.getFather() != null)
                            {
                                ((Human) item.getFather()).addChildren(item);
                            }  
                        } 
            }            
        return familyTree; 
    }    
}    
