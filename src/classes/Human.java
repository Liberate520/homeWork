package classes;

public class Human {
    public enum state {
        MALE, FEMALE
    }

    public enum marige {
        YES, NO
    }

    protected String name;
    protected String familyname;
    protected state gender;
    protected marige marigeStatus;
    protected Parent[] parents = { null, null };

    public Parent[] getParents() {
        return parents;
    }

    public void setParents(Parent[] parents) {
        this.parents = parents;
    }

    public void showParents() {
        if (parents[0] == null) {
            return;
        } else {
            parents[0].getInfo();
            parents[1].getInfo();
        }
    }

    public marige getMarigeStatus() {
        return marigeStatus;
    }

    public void setMarigeStatus(marige marigeStatus) {
        this.marigeStatus = marigeStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public state getGender() {
        return gender;
    }

    public void setGender(int id) {
        if (id == 1) {
            this.gender = state.MALE;
        } else {
            this.gender = state.FEMALE;
        }
    }

    public Human(String name, String familyname, state gender) {
        this.name = name;
        this.familyname = familyname;
        this.gender = gender;
        this.marigeStatus = marige.NO;
    }

    public Human() {
        this("", "", state.MALE);
    }

    public void getInfo() {
        System.out.printf("Name: %12s, Family_name: %12s, Gender: %7s, Married: %5s\n", name, familyname, gender,
                marigeStatus);
    }
}
