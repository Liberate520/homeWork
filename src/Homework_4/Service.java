package Homework_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Service {

    private Service(){
        this.humans = new ArrayList<>();
    }

    public List<Designer_Human> humans;

    public Service(List<Designer_Human> humans) {
        this.humans = humans;
    }

    private List<Designer_Human> humanList;


public Service(Femily_Tree humanList) {
    super();
        this.humanList = new ArrayList<>();
        this.humans = new ArrayList<>();
    }

    private static int id;

    public void AddHHUMAN(String name, String sex, int date) {
        Designer_Human humanList = new Designer_Human(id++, name, sex, date);
        Designer_Human.addHumanH(humanList);

    }

    /**
     * Метод сортировки
     *
     * @param
     */
    public void sort() {
        Collections.sort(humanList);}

    /**
     * Сортировка по имени
     * @return
     */
    public List<Designer_Human> sortByName() {
        this.humans.sort(Comparator.comparing(Designer_Human::getName));
        return humans;
    }

    /**
     * Сортировка по дате
     * @return
     */
    public List<Designer_Human> sortByDateOfBirth() {
        this.humans.sort(Comparator.comparing(Designer_Human::getDate));
        return humans;
    }
}



