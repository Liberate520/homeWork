package Tree.model;

import Tree.model.components.Gender;

// интерфейс указывает какие методы работы с деревом нужно реализовать
public interface Service {

    // методы для реализации
    String outputAList();

    void clearTree();

    String searchByName(String nextLine);

    void load();

    void save();

    void sortAlfab();

    void sortByAge();

    void addHuman(String fullName, int dateBirth, Gender sex, String mother, String father);

    boolean deletePerson(String nextLine);
}
