package Model.FamTreeModel.Human;

public class Human extends Member  {

    private Human marriagePartner;

    public Human(int id, String firstName, String lastName, Gender sex, int age) {
        super(id, firstName, lastName, sex, age);

    }

    public Human() {
        super();
    }



    public Human getMarriagePartner() {
        return marriagePartner;
    }
    public boolean setMarriagePartner(Human marriagePartner) {
        if (isMan() != marriagePartner.isMan()) {
            this.marriagePartner = marriagePartner;
            marriagePartner.marriagePartner = this;
            if (isWom()) {
                setLastName(marriagePartner.getLastName());
            }
            else {
                marriagePartner.setLastName(this.getLastName());
            }
            return true;
        }
        return false;
    }


//    @Override
//    public void setAge(int age) {
//        super.setAge(age);
//    }
}

