package api;

import api.comparator.PersonComparatorByDateOfBirth;
import api.comparator.PersonComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Person> implements Serializable, Iterable<T>
{
    private List<T> familyTree = new ArrayList<>();
    private Writable writable;

    public FamilyTree()
    {
    }

//    public void add(api.Person person)
//    {
//        this.familyTree.add(
//        );
//    }
    public void add(T person)
    {
        this.familyTree.add(person);
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

    public T searchPersonByNameAndMiddleName(String name)
    {
        T result = null;
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

    public List<T> searchChildrenByPerson(Person person)
    {
        List<T> childrenList = new ArrayList<>();

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
    public String searchChildrenByFathersName(String name)
    {
        String result = "";
        T person = searchPersonByNameAndMiddleName(name);

        List<T> childrenList = new ArrayList<>();
        childrenList = searchChildrenByPerson(person);
        if (childrenList.isEmpty())
        {
            //System.out.printf("У '%s' нет детей\n",name);
            result = "У " + name + " нет детей\n";
        }
        else
        {
            if (childrenList.size() == 1)
            {
                //System.out.printf("У '%s' 1 ребенок:\n",name);
                result = "У " + name + " 1 ребенок:\n";
            }
            else
            {
                //System.out.printf("Список детей '%s' :\n",name);
                result = "Список детей " + name + " :\n";
            }

            for (int i=0; i<childrenList.size(); i++)
            {
                result += childrenList.get(i).printAll();
            }
        }
        return result;
    };

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

    public static FamilyTree initData()
    {
        /*person 01*/
        Person person01 = new Tsar(
                "Михаил",
                "Федорович",
                "Романов",
                Gender.Male,
                1596,
                1645,
                1,
                1613,
                1645);

        /*person 02*/
        Person person02 = new Tsar(
                "Алексей",
                "Михайлович",
                "Романов",
                Gender.Male,
                1629,
                1676,
                2,
                1645,
                1676);
        person02.setFather(person01);

        /*person 03*/
        Person person03 = new Person(
                "Мария",
                "Ильинишна",
                "Милославская",
                Gender.Female,
                1625,
                1669);
        person03.addSpouse(person02);

        /*person 04*/
        Person person04 = new Person(
                "Наталья",
                "Кирриловна",
                "Нарышкина",
                Gender.Female,
                1651,
                1694);
        person04.addSpouse(person02);

        /*person 05*/
        Person person05 = new Tsar(
                "Федор",
                "Алексеевич",
                "Романов",
                Gender.Male,
                1661,
                1682,
                3,
                1676,
                1682);
        person05.setFather(person02);
        person05.setMother(person03);

        /*person 06*/
        Person person06 = new Tsar(
                "Иоанн 5",
                "Алексеевич",
                "Романов",
                Gender.Male,
                1666,
                1696,
                4,
                1682,
                1696);
        person06.setFather(person02);
        person06.setMother(person03);

        /*person 07*/
        Person person07 = new Person(
                "Софья",
                "Алексеевна",
                "Романова",
                Gender.Female,
                1657,
                1704);
        person07.setFather(person02);
        person07.setMother(person03);

        /*person 08*/
        Person person08 = new Tsar(
                "Петр 1",
                "Алексеевич",
                "Романов",
                Gender.Male,
                1672,
                1725,
                5,
                1696,
                1725);
        person08.setFather(person02);
        person08.setMother(person04);

        /*person 09*/
        Person person09 = new Tsar(
                "Екатерина 1",
                "Алексеевна",
                "Михайлова",
                Gender.Female,
                1684,
                1727,
                6,
                1725,
                10727);
        person09.addSpouse(person08);

        FamilyTree familyTree = new FamilyTree();
        familyTree.add(person01);
        familyTree.add(person02);
        familyTree.add(person03);
        familyTree.add(person04);
        familyTree.add(person05);
        familyTree.add(person06);
        familyTree.add(person07);
        familyTree.add(person08);
        familyTree.add(person09);

        return familyTree;
    }
}

