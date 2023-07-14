package GenerationTree.interfaces;

import java.time.LocalDate;

import GenerationTree.Structs.Gender;

public interface Service {
    void addTreeItem(String name, Gender gender, LocalDate dateBirth);
}
