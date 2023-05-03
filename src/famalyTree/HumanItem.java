package famalyTree;

import human.Human;

public interface HumanItem {


    String getInfo();

    String getName();

    Human getFather();

    Human getMother();

    int getYearOfBirrth();
}
