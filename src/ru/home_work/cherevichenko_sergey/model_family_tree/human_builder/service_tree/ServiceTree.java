package ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.service_tree;

import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Gender;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.FamilyTree;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Human;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.file_handler.FileHandler;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.file_handler.Writable;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Класс верхне уровнего программирования для создания человека и сразу добавления его в древо
public class ServiceTree implements Serializable, Writable {
    private FamilyTree<Human> tree;
    private HumanBuilder builder;
    private Writable writable;

    public ServiceTree(FamilyTree<Human> tree) {
        this.tree = tree;
    }

    public ServiceTree() {
        tree = new FamilyTree<>();
        builder = new HumanBuilder();
        writable = new  FileHandler(this.tree);

    }

    // Создание человека и добавление в древо
    public void addHuman(String name, String lastName, Gender gender,
                         LocalDate birthDay, LocalDate dateDeath) {
        Human human = builder.build(name, lastName, gender, birthDay, dateDeath, new ArrayList<Human>(0));
        tree.addHuman(human);

    }

    // Добавление ребенка родителям
    public String addChildForFamily(String motherName, String motherLastName, String fatherName,
                                    String fatherLastName, String nameChild, String lastNameChild) {

        return tree.addChildForFamily(motherName, motherLastName, fatherName,
                fatherLastName, nameChild, lastNameChild);
    }

    public String getHumanInfo() {
        return tree.getHumanInfo();
    }

    public String removeHuman(String name, String lastName) {
        return tree.removeHuman(name, lastName);
    }

    // Поиск ребенка по имени и фамилии
    public String findChildren(String name, String lastName) {
        return tree.findChildren(name, lastName);
    }

    // Сортировка по имени
    public void sortTreeByName() {
        tree.sortByName();
    }

    // Сортировка по возрасту
    public void sortTreeByAge() {
        tree.sortByAge();
    }

    // Сортировка по фамилии
    public void sortTreeByLastName() {
        tree.sortByLastName();

    }

    // Сортировка по количеству детей
    public void sortTreeByCountChildren() {
        tree.sortByCountChildren();
    }


    public String toString() {
        return getHumanInfo();
    }

    @Override
    public void save()  {
        writable.save();
    }

    @Override
    public Object readable()  {
        return tree = (FamilyTree<Human>) writable.readable();
    }
}
