package model.Comparator;

import java.util.Comparator;

import model.Persons.Human;
import model.Persons.Person;

public class IdComparator<T extends Person> implements Comparator<T>
{
        @Override
        public int compare(T member2, T member1) 
        {
            if (member1 instanceof Human && member2 instanceof Human)

           {
            return Integer.compare(member1.getId(), member2.getId());
           }
           return 1;
        }
    }