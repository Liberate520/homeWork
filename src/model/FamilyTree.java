package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FamilyTree<T extends Node> implements Serializable, Iterable<T>
{  
    private T t;
    private Human human;
    private ArrayList<T> familyTree = new ArrayList<>();

    public void addPerson(T t) {
        familyTree.add(t);

        if (t instanceof Human && t.getMother() != null)
            ((Human) t.getMother()).addChildren(t);

        if (t instanceof Human && t.getFather() != null)
            ((Human) t.getFather()).addChildren(t);
    }

    public FamilyTree getFamilyTree(FamilyTree familyTree) // НОВЫЙ МЕТОД!!!!
    {
        return familyTree;
    }

    @Override
    public String toString() {
        return familyTree.toString();
    }


    public <T extends Human> void findHuman()
    {
        System.out.println("Введите фамилию для поиска:");
        Scanner sc1 = new Scanner(System.in, "cp866");
        String findLastName = sc1.nextLine();

        System.out.println("Введите имя для поиска:");
        Scanner sc2 = new Scanner(System.in, "cp866");
        String findFirstName = sc2.nextLine();

        boolean find=false;
        for (int i = 0; i < ((Collection<FamilyTree>) familyTree).size(); i++) 
        {
            if (((Node) ((List<T>) familyTree).get(i)).getLastName().contains(findLastName) && (((Node) ((List<T>) familyTree).get(i)).getFirstName().contains(findFirstName))); 
            {
                System.out.println(((List<T>) familyTree).get(i));
                find=true;
            }    
        
            if (!find)
            {
                 System.out.println("Такой человек не найден.");
            }
        }
    } 


    @Override
    public Iterator<T> iterator(){
        return new HumanIterator((ArrayList) t);
    }
    public void sortById() {
        familyTree.sort(new IdComparator());
    }
    public void sortByLastName() {
        familyTree.sort(new NameComparator());
    }
}
