package model;

import java.util.Comparator;
public class NameComparator<T extends Node> implements Comparator<T> {
        @Override
        public int compare(T member1, T member2) 
        {
            
            if (member1 instanceof Human && member2 instanceof Human)
            {
                return member1.getLastName().compareTo(member2.getLastName());
            }
            
        return 1;
        }

    }