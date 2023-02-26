package HomeWork3.comporator;

import java.util.Comparator;
import HomeWork3.Human;

public class HumanComporatorByAge implements Comparator<Human>
{

    @Override
    public int compare(Human o1, Human o2) 
    {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
    
}
