package homeWorkSem1.Option;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;

public class GetSisBro<T extends Human> implements Serializable, Option {
    Scanner iScanner = new Scanner(System.in);

    @Override
    public void execute(FamilyTree<Human> tree) {
        System.out.println("Enter Name of human: ");
        String getName = iScanner.nextLine();
        List<Human> res = tree.getHumanbyName(getName);
        List<Human> sisBro = new ArrayList<>();
        for (Human human : res) {
            sisBro = human.getSisBro();
        }
    System.out.printf("Sister/Brother of %s are: \n%s", getName, sisBro);
    }

    @Override
    public String description() {
        return String.format("Get Sisters/Brothers of Human");
    }

}
