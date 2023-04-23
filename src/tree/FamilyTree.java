package tree;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FamilyTree implements Serializable{

    private List<Human> humanList;

    public FamilyTree(){
        this.humanList = new ArrayList<>();
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public void setHuman(Human human) {
        if (human != null){
            if (!humanList.contains(human)){
                humanList.add(human);
                if (human.getFather() != null){
                    human.getFather().setChildren(human);
                }
                if (human.getMother() != null){
                    human.getMother().setChildren(human);
                }
            }
               
        }        
    }

    public Human getByFio(String surname, String name, String patronymic){
        for (Human human: humanList){
            if(human.getName().equals(name) && human.getSurname().equals(surname) && human.getPatronymic().equals(patronymic)){
                return human;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        String str = null;
        DateFormat df = new SimpleDateFormat("dd MMM yyy");
        str = "В дереве " + humanList.size() + " человек: \n";
        for (Human human: humanList){
            str = str + human.getSurname() + " " + human.getName() + " " + human.getPatronymic()  + " (" 
            + df.format(human.getDateOfBirth().getTime());
            if (human.getDateOfDeath().get(Calendar.YEAR) != 2) {
                str = str + " - " + df.format(human.getDateOfDeath().getTime()) + ")\n";
            }
            else{
                str = str + ")\n";
            }
        }
        return str;
    }

    
}
