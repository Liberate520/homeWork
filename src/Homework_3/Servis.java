package Homework_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Servis {
    private Servis(){
        this.humans = new ArrayList<>();
    }


//    private Designer_Human serviss;
    private List<Designer_Human> humans;

//    public Servis(List<Designer_Human> humans) {
//        this.humans = humans;
//    }

    private List<Designer_Human> humanList;

//    public Servis(Femily_Tree humans) {
//        humanList = new ArrayList<>();
//    }
public Servis(Femily_Tree humanList) {
    super();
        this.humanList = new ArrayList<>();
//        this.serviss = new Designer_Human();
    }

    private static int id;

//    public Servis(Designer_Human serviss) {
//        this.serviss = serviss;
//
//    }

    public void AddHHUMAN(String name, String sex, int date) {
        Designer_Human humanList = new Designer_Human(id++, name, sex, date);
        Designer_Human.addHumanH(humanList); //Ругается на то что this.serviss == null

    }

//    if (serviss == null){
//        this.serviss.addHumanH(humanList);
//    }
//

//
//    @Override
//    public Iterator<Designer_Human> iterator() {
//        return null;
//    }

    /**
     * Метод сортировки
     *
     * @param
     */
    public void sort() {
        Collections.sort(humanList);//не понимаю почему не работает
    }
    public void sortNAME() {
        Collections.sort(humans);//не понимаю почему не работает
    }

}
