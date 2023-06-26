package ru.gb.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tree implements Serializable {
    private List<Branch> branchOfKinship;
    private Person focusPerson;

    public Tree() {
        this.branchOfKinship = new ArrayList<>();
    }

    public void addBranch(Branch branch) {
        branchOfKinship.add(branch);
        System.out.println("Добавление ветви выполнено успешно");
    }

    public void printBranch(List<Person> personList) {
        SubMenu2 sm = new SubMenu2();
        int choice = sm.subMenu(personList);
        focusPerson = personList.get(choice);

        for (Branch br : branchOfKinship) {
            if (br.focusPerson.equals(focusPerson)) {
                System.out.println("Выбранный человек: " + focusPerson);
                System.out.println("Родители: " + br.branchOfParent);
                System.out.println("Дети: " + br.branchOfChild);

            }
        }
    }


}
