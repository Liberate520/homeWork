package model.creature.methods;

import model.creature.Interface.ParentsInfo;
import model.creature.Creature;
import model.creature.Gender;

public class Parents implements ParentsInfo<Creature> {
    private Creature mother;
    private Creature father;


      @Override
    public void addParent(Creature parent) {
        if (parent.getGender().equals(Gender.MALE)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.FEMALE)) {
            setMother(parent);
        }
    }

    public String getMotherInfo() {
        String res = "mother: ";
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "unknown";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "father: ";
        if (father != null) {
            res += father.getName();
        } else {
            res += "unknown";
        }
        return res;
    }

    @Override
    public Creature getMother() {
        return mother;
    }

    @Override
    public void setMother(Creature mather) {

    }

    @Override
    public Creature getFather() {
        return father;
    }

    @Override
    public void setFather(Creature father) {

    }

}
