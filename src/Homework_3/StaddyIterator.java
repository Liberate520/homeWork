package Homework_3;

import java.io.Serializable;
import java.util.*;

class StaddyIterator implements Iterator<Designer_Human> {

    private int index; //счетчик
    private final List<Designer_Human> humans;

    public StaddyIterator(List<Designer_Human> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return index < humans.size(); //достич конца коллекции
    }

    @Override
    public Designer_Human next() {
        return humans.get(index++); //0 1 2 3 ...
    }

}

