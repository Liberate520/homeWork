package ru.gb.family_tree.Model.Family.Service.writer;

import java.io.Serializable;

public interface Saveble {
    boolean save(Serializable serializable);
    Object read();

}
