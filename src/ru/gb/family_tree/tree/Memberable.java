package ru.gb.family_tree.tree;

import java.time.LocalDate;
import java.util.Comparator;

public interface Memberable {
    public int id();
    public void setId(int id);
    public LocalDate birthDate();
    public String name();
}
