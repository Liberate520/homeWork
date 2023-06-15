package tree.model.geneticTree;

import tree.model.human.Human;

import java.time.LocalDate;
import java.util.List;

public interface GroupItem<T> {
    String getName();
    String getInfo();
    boolean addChildren(T human);  //добавил метод для добавления ребенка
    LocalDate getBirthDate();
    GroupItem getFather(); // было Human getFather()
    GroupItem getMother(); // было Human getMother()
    List<T> getChildren();
}
