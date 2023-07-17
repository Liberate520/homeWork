package family_tree.model.human_family;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface HumanItem<T> extends Serializable {
    List<T> getParents();

    List<T> getAllHumans();

    List<T> getAllChildren();

    String getHumansInfo();

    String getName();

    LocalDate getbirthDate();
}
