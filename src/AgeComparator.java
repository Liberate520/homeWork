import java.util.Comparator;

public class AgeComparator implements Comparator<Human>{
        @Override
        public int compare(Human member1, Human member2) {
            return Integer.compare(member1.getAge(), member2.getAge());
        }

    }

