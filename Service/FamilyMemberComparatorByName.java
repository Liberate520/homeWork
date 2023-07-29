package Service;

import Tree.FamilyMember;

import java.util.Comparator;

//Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2)
//Несмотря на то, что на уроке все было показано, адаптировать к конкретному проекту было достаточно сложно

// Д.з. 4 сделать класс параметизированным

public class FamilyMemberComparatorByName<T extends FamilyMember> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getNameFamilyMember().compareTo(o2.getNameFamilyMember());
    }
}