package ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.file_handler;

import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.FamilyTree;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Human;

import java.io.IOException;
import java.io.Serializable;

public interface Writable  {
     void save(Object o) throws IOException;
     // Метод для записи
     Object readable() throws IOException, ClassNotFoundException;
}
