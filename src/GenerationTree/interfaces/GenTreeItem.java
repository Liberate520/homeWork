package GenerationTree.interfaces;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface GenTreeItem<E extends GenTreeItem<E>> extends Serializable {
    int getId();

    String getName();

    LocalDate getDateBirth();

    List<E> getParrents();

    List<E> getChildren();
}
