import java.util.ArrayList;
import java.util.List;

public class Member extends Human{
    private Member father;
    private Member mother;
    private List<Member> children=new ArrayList<>();

    public Member(int yearBirth, int yearDeath, String fio, Gender gender, Member father, Member mother) {
        setFio(fio);
        setYearBirth(yearBirth);
        setYearDeath(yearDeath);
        this.father = father;
        this.mother = mother;
        if (!(father==null))
        {
            father.addChild(this);
        }
    }

    public Member getFather() {
        return father;
    }

    public void setFather(Member father) {
        this.father = father;
    }

    public Member getMother() {
        return mother;
    }

    public void setMother(Member mother) {
        this.mother = mother;
    }


    public List<Member> getChildren() {
        return children;
    }

    public void addChild(Member child) {
        this.children.add(child);
    }
    public void addChild(List<Member> children) {
        this.children.addAll(children);
    }

    public String toString() {
        return getFio()+" - годы жизни("+getYearBirth()+"-"+getYearDeath()+")";
    }
}
