import java.util.*;


public class Communication implements Print {
    private Essence essense1;
    private Essence essense2;
    private Relation relation;

    List<Essence> communication = new ArrayList<>();

    public List<Essence> getCommunication() {
        return communication;
    }

    public Communication(Essence essense1, Essence essense2, Relation relation) {
        this.essense1 = essense1;
        this.essense2 = essense2;
        this.relation = relation;
    }

    public Communication(List<Essence> communication) {
        this.communication = communication;
    }

    public Essence getEssense1() {
        return essense1;
    }

    public void setEssense1(Essence essense1) {
        this.essense1 = essense1;
    }

    public Essence getEssense2() {
        return essense2;
    }

    public void setEssense2(Essence essense2) {
        this.essense2 = essense2;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return String.format("%s is %s for %s",
                this.essense1.getName(), 
                this.relation,
                this.essense2.getName());
    }
}
