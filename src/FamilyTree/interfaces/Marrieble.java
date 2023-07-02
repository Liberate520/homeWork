package FamilyTree.interfaces;

import java.time.LocalDate;

import FamilyTree.Person;

public interface Marrieble {
    Boolean addChild(Person child);

    Boolean addSpouse(Marrieble spouse, LocalDate dateOfMarriage);

}