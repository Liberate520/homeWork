package VIVI.AddHuman;

import Homework_6.Designer_Human;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class AddPeopleWithAnIdScanner implements IAddHuman{

    private List<Designer_Human> designer_human;
    private static int id;

    public void addHumanSimpleMetod(Designer_Human Human) {
        designer_human.add(Human);
    }
    @Override
    public void addHuman(Designer_Human human) {
        Scanner iScanner = new Scanner(in);
        String name = iScanner.nextLine();
        String sex = iScanner.nextLine();
        int date = iScanner.nextInt();
        human = new Designer_Human(id++, name, sex, date);
        addHumanSimpleMetod(human);
    }
}
