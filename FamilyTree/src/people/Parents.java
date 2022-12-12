package people;

public class Parents extends FamilyTree{
    private String name1;
    private String name2;
    private String kin;



    public Parents(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
        this.kin =getKinship();
    }


    public String getKin() {
        return kin;
    }

    public void setKin(String kin) {
        this.kin = kin;
    }

    @Override
    public String getKinship(){
        return "Супруги";
    }

    @Override
    public boolean startsWith(String java) {
        return false;
    }

    @Override
    public boolean matches(String s) {
        return false;
    }

    @Override
    public String toString() {
        return name1 + " "+ name2 + " -> " + kin;
    }
}
