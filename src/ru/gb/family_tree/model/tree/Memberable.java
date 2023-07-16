package ru.gb.family_tree.model.tree;

import java.time.LocalDate;

public interface Memberable {
    public int id();
    public void setId(int id);
    public LocalDate birthDate();
    public String name();
}
