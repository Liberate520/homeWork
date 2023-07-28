import Tree.FamilyMember;

import java.util.Comparator;

//Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2)
//Несмотря на то, что на уроке все было показано, адаптировать к конкретному проекту было достаточно сложно
public class FamilyMemberComparatorByAge implements Comparator<FamilyMember> {
    @Override
    public int compare(FamilyMember o1, FamilyMember o2) {
        return Integer.compare(o2.getAgeFamilyMember(), o1.getAgeFamilyMember());
    }
}
