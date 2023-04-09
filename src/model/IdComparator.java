package model;

import java.util.Comparator;

public class IdComparator<T extends Node> implements Comparator<T>
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