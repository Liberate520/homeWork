package family_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FamilyTree {
    private List<Human> humanstList;

    public FamilyTree()
    {
        humanstList = new ArrayList<>();
    }
    public Human getPeopleByName(String name)
    {
        List<Human> humanstFaundList = new ArrayList<>();
        int find_people = 0;
        int index = 0;
        Scanner console_user = new Scanner(System.in);
        for(Human people: humanstList)
        {
            if(people.getName().equals(name))
            {
                find_people ++;
                humanstFaundList.add(people);
            }
        }
        if(find_people == 1)
        {
            return humanstFaundList.get(0);
        }
        else if(find_people > 1)
        {
            System.out.println("По вашему запросу нашлось несколько человек, выберите нужного:");
            for(Human people:humanstFaundList)
            {
                index ++;
                System.out.println(index + ") " + people);
            }
            int number_filt = console_user.nextInt();
            return humanstFaundList.get(number_filt - 1);
        }
        return null;
    }

    public void addHuman(Human people)
    {
        humanstList.add(people);
    }

    public String getHumansListInfo()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей: \n");
        for(Human people: humanstList)
        {
            stringBuilder.append(people);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}