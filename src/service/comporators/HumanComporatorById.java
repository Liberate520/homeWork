package service.comporators;

import service.human.Human;
import java.util.Comparator;

public class HumanComporatorById implements Comparator<service.human.Human>{
    @Override
    public int compare(Human o1, Human o2) {
        if (o2.getId() == o1.getId()) {
            return 0;
        } else if (o1.getId() < o2.getId()) {
            return -1;
        } else {
            return 1;
        }
    }
}