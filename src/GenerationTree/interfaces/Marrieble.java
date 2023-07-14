package GenerationTree.interfaces;

import java.time.LocalDate;

import GenerationTree.Person.Person;

public interface Marrieble {
    Boolean addChild(Person child);

    Boolean addSpouse(Marrieble spouse, LocalDate dateOfMarriage);

}