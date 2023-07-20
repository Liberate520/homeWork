package GenerationTree.Model.Tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface GenTreeItem<T> extends Serializable {
    int getId();

    String getName();

    LocalDate getDateBirth();

    List<T> getParrents();

    List<T> getChildren();
}
