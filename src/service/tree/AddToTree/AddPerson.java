package service.tree.AddToTree;

import service.Persons.Human;
import service.Persons.Person;
import service.tree.FamilyTree;

import java.util.List;

public class AddPerson<T extends Person>
{
    public FamilyTree addPerson(List<Person> person)

    {
        FamilyTree familyTree = new FamilyTree();
        Person human = new Human();

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
