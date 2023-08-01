package GenerationTree.Model.Tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface GenTreeItem extends Serializable {
    int getId();

    String getName();

    String getTreeName();

    LocalDate getDateBirth();

    List<GenTreeItem> getParrents();

    List<GenTreeItem> getChildren();

    boolean isAncestor(GenTreeItem potentialAncestor);

    boolean isDescendant(GenTreeItem potentialDescendant);

    boolean removeItem(GenTreeItem person);

}
