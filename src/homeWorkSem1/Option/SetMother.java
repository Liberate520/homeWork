package homeWorkSem1.Option;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;

public class SetMother<T extends Human> implements Serializable, Option {

    Scanner iScanner = new Scanner(System.in);

    @Override
    public void execute(FamilyTree<Human> tree) {
        System.out.println("Enter Name of human: ");
        String getName = iScanner.nextLine();
        List<Human> res = tree.getHumanbyName(getName);
        System.out.println("Enter Mothers's name: ");
        String nameMother = iScanner.nextLine();
        List<Human> res2 = tree.getHumanbyName(nameMother);
        for (Human human : res) {
            for (Human hum : res2) {
                human.setMother(hum);
                hum.setChildren(res);// одновременно матери добавится ребенок
            }
        }
        for (Human element : res) {
            for (Human el : res2) {
                System.out.printf("%s добавились дети: \n%s", res2, el.getChildren());
                System.out.printf("\n%s добавилась мать: \n%s", res, element.getMother());
            }
        }
    }

    @Override
    public String description() {
        return String.format("Set Mother of Human");
    }

}
