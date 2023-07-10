package family_tree.human_family;

import java.time.LocalDate;
import java.util.List;

public interface HumanItem<T> {
    List<T> getParents();

    List<T> getAllChildren();

    String getName();

    LocalDate getbirthDate();
}
