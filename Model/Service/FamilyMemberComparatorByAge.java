package Service;

import Model.Human;

import java.util.Comparator;

//Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2)
//Несмотря на то, что на уроке все было показано, адаптировать к конкретному проекту было достаточно сложно
public class FamilyMemberComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o2.getAge(), o1.getAge());
    }
}
