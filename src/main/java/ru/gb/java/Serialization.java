package ru.gb.java;

import java.io.IOException;
import java.util.List;

public interface Serialization {
    void save(List<Person> personList, Tree tree) throws IOException;

    void load() throws IOException, ClassNotFoundException;

}

