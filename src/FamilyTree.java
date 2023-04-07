// import writeReadData.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FamilyTree implements Serializable, Iterable<Human>
{  
    private ArrayList<Human> famyliTree = new ArrayList<>();

    public void addPerson(Human human) {
        famyliTree.add(human);
        if (human.getMother() != null)
            human.getMother().addChildren(human);

        if (human.getFather() != null)
            human.getFather().addChildren(human);
    }

    @Override
    public String toString() {
        return famyliTree.toString();
    }

    public void findHuman()
    {
        System.out.println("Введите фамилию для поиска:");
        Scanner sc1 = new Scanner(System.in, "cp866");
        String findLastName = sc1.nextLine();

        System.out.println("Введите имя для поиска:");
        Scanner sc2 = new Scanner(System.in, "cp866");
        String findFirstName = sc2.nextLine();

        boolean find=false;
        for (int i = 0; i < famyliTree.size(); i++) 
        {
            if (famyliTree.get(i).getLastName().contains(findLastName) && famyliTree.get(i).getFirstName().contains(findFirstName)) 
            {
                System.out.println(famyliTree.get(i));
                find=true;
            }    
        }
        if (!find) System.out.println("Такой человек не найден.");
    } 

    @Override
    public Iterator<Human> iterator(){
        return new HumanIterator(famyliTree);
    }
    public void sortByAge() {
        famyliTree.sort(new AgeComparator());
    }
    public void sortByLastName() {
        famyliTree.sort(new NameComparator());
    }

}
