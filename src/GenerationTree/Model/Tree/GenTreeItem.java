package GenerationTree.Model.Tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface GenTreeItem extends Serializable {
    int getId();

    String getName();

    LocalDate getDateBirth();

    List<GenTreeItem> getParrents();

    List<GenTreeItem> getChildren();

    boolean removeItem(GenTreeItem person);

}
