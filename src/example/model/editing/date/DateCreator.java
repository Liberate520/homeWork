package org.example.model.editing.date;

import org.example.model.Human;
import org.example.model.Tree;

public interface DateCreator {
    void dateCreator(String date, Integer index, Tree<Human> tree);
}
