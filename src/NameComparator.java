import java.util.Comparator;
public class NameComparator implements Comparator<Human> {
        @Override
        public int compare(Human member1, Human member2) 
        {
            return member1.getLastName().compareTo(member2.getLastName());
        }

    }

