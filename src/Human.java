import java.util.ArrayList;
import java.util.List;

public class Human implements FamiliesI {
    // человеку нужно им€
    private String fullName;
    // гендер 0=∆ 1=ћ
    int gender;
    // у человека будут св€зи
    private List<Link> links;

    public Human(String fullName, int gender) {

        this.fullName = fullName; // им€ есть всегда и изначально
        this.gender = gender;
        links = new ArrayList<>();
//        this.addHumanList(this);
    }


    // прикрепл€ем человека к дереву
    public void addTree(Tree tree) {
        tree.addTree(this);
    }

    //добавл€ем св€зь через им€ св€зи
    public void addLink(Link link) {
        this.links.add(link);
    }

    //добавл€ем св€зь через конструктор св€зей
    public void addLink(Human second, byte tipeLink) {
        new Link(this, second, tipeLink);
    }

    public List<Link> getAllLinks() {
        return links;
    }
    public Link getLink(int i) {
        return links.get(i);
    }

    public int getGender() {
        return gender;
    }


}
