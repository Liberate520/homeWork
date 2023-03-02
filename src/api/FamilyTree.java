package api;

import api.comparator.PersonComparatorByDateOfBirth;
import api.comparator.PersonComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Person> implements Serializable, Iterable<T>
{
    private List<T> familyTree;// = new ArrayList<>();
    private Writable writable;

    public FamilyTree()
    {
        familyTree = new ArrayList<>();
    }

    public void add(T person)
    {
        familyTree.add(person);
    }

    public String printAll()
    {
        String result = "";
        for (int i=0;i< familyTree.size();i++)
        {
            result += familyTree.get(i).printAll();
            //System.out.println(familyTree.get(i));
        }
        result += "\n";
        return result;
    }

    public void setFamilyTree(List<T> familyTree) {
        this.familyTree = familyTree;
    }

    public List<T> getFamilyTree() {
        return familyTree;
    }

    public List<T> searchPersonByName(String name)
    {
        List<T> result = new ArrayList<>();
        for (int i=0;i< familyTree.size();i++)
        {
            if (
                    (familyTree.get(i).getNameAndMiddleName().equals(name)) |
                    (familyTree.get(i).getName().equals(name)) |
                    (familyTree.get(i).getMiddleName().equals(name))
               )
            {
                result.add(familyTree.get(i));
            }
        }
        return result;
    };

    public String searchChildrenByPerson(Person person)
    {
        String result = "";
        if (person.getChildren().isEmpty())
        {
            result = "У " + person.getName() + " " + person.getMiddleName() + " нет детей\n";
        }
        else
        {
            if (person.getChildren().size() == 1)
            {
                result = "У " + person.getName() + " " + person.getMiddleName() + " 1 ребенок:\n";
            }
            else
            {
                result = "Список детей " + person.getName() + " " + person.getMiddleName() + " :\n";
            }
            for (int i=0; i<person.getChildren().size(); i++)
            {
                result += person.getChildren().get(i).printAll();
            }
        }
        return result;
    }

    public void sortByName()
    {
        familyTree.sort(new PersonComparatorByName());
    }
    public void sortByDateOfBirth()
    {
        familyTree.sort(new PersonComparatorByDateOfBirth());
    }
    @Override
    public Iterator<T> iterator() {
        return new PersonIterator<T>(familyTree);
    }

}

