package GenerationTree.Person;

import java.time.LocalDate;

public interface Marrieble {
    Boolean addChild(Person child);

    Boolean addSpouse(Marrieble spouse, LocalDate dateOfMarriage);

}