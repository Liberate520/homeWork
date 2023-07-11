package family_tree.creatures.interfaces;

import java.io.Serializable;
import java.time.LocalDate;

public interface Creatures<E> extends Serializable {
LocalDate getDateOfBirth();
}
