import java.util.ArrayList;
import java.util.List;

public class FamilyTree
{
    private List<Person> familyTree = new ArrayList<>();

    public FamilyTree()
    {
    }

//    public void add(Person person)
//    {
//        this.familyTree.add(
//        );
//    }
    public void add(Person person)
    {
        this.familyTree.add(person);
    }

    public void printAll()
    {
        for (int i=0;i< familyTree.size();i++)
        {
            //familyTree.get(i).printAll();
            System.out.println(familyTree.get(i));
        }
    }

    public void setFamilyTree(List<Person> familyTree) {
        this.familyTree = familyTree;
    }

    public List<Person> getFamilyTree() {
        return familyTree;
    }

    public Person searchPersonByNameAndMiddleName(String name)
    {
        Person result = null;
        for (int i=0;i< familyTree.size();i++)
        {
            if (familyTree.get(i).getNameAndMiddleName().equals(name))
            {
                result = familyTree.get(i);
                break;
            }
        }
        return result;
    };

    public List<Person> searchChildrenByPerson(Person person)
    {
        List<Person> childrenList = new ArrayList<Person>();

        for (int i=0;i< familyTree.size();i++)
        {
            if (familyTree.get(i).getFather() != null)
            {
                if (familyTree.get(i).getFather().equals(person))
                {
                    childrenList.add(familyTree.get(i));
                }
            }
        }
        return childrenList;
    };
    public void searchChildrenByFathersName(String name)
    {
        Person person = searchPersonByNameAndMiddleName(name);

        List<Person> childrenList = new ArrayList<Person>();
        childrenList = searchChildrenByPerson(person);
        if (childrenList.isEmpty())
        {
            System.out.printf("У '%s' нет детей\n",name);
        }
        else
        {
            if (childrenList.size() == 1)
            {
                System.out.printf("У '%s' 1 ребенок:\n",name);
            }
            else
            {
                System.out.printf("Список детей '%s' :\n",name);
            }

            for (int i=0; i<childrenList.size(); i++)
            {
                childrenList.get(i).printAll();
            }
        }
    };
}
