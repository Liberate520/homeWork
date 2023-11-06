package ru.gb.f_tree.f_mem;

import java.util.List;


public interface FamilyMember {
    String getName();

    String getFullName();
    List<FamilyMember> getParents();

    String getAge();
}

