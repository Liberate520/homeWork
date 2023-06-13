package homeWork.tree2.backend.familyTree;

import homeWork.tree2.backend.human.HumanObjectInterface;


public interface Family<E extends HumanObjectInterface> extends Iterable<E>{
    void addPeople(E person);
}

// Проблем не наблюдаю