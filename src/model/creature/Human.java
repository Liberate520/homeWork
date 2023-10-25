package model.creature;

import model.FamilyTree.Interface.CreatureItem;
import model.creature.Interface.*;

import java.time.LocalDate;

public class Human extends Creature implements CreatureItem<Creature>, Spouse {
    private Human spouse;

    public Human(String name, Gender gender, LocalDate dataBirth, LocalDate dataDeath, Human mother, Human father, Human spouse) {
        super(name, gender, dataBirth, dataDeath, mother, father);
        this.spouse = spouse;
    }

    public Human(String name, Gender gender, LocalDate dataBirth) {
        super(name, gender, dataBirth);
    }

    public Human(String name, Gender gender, LocalDate dataBirth, Human father, Human mother) {
        super(name, gender, dataBirth, father, mother);
    }


    public String getSpouseInfo() {
        String res = "spouse: ";
        if (spouse == null) {
            res += "no";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }


    @Override
    public boolean addChildren(Creature child) {
        return false;
    }

    @Override
    public String getChildrenInfo() {
        return getChildrenInfo();
    }

    @Override
    public int getPeriod(LocalDate dataBirth, LocalDate dataDeath) {
        return 0;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public void addParent(Creature parent) {

    }
    @Override
    public String getMotherInfo() {
        return null;
    }

    @Override
    public String getFatherInfo() {
        return null;
    }
}



