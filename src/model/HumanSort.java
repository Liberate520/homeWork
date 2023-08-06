package src.model;

import java.util.List;

public interface HumanSort<E extends Human>{
    void SortByName(List<E> al);

    void SortByAge(List <E> al);
}
