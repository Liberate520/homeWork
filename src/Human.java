import java.util.ArrayList;
import java.util.List;

public class Human implements FamiliesI {
    // человеку нужно имя
    private String fullName;
    // гендер 0=Ж 1=М
    int gender;
    // у человека будут связи
    private List<Link> links;

    public Human(String fullName, int gender) {

        this.fullName = fullName; // имя есть всегда и изначально
        this.gender = gender;
        links = new ArrayList<>();
//        this.addHumanList(this);
    }


    // прикрепляем человека к дереву
    public void addTree(Tree tree) {
        tree.addTree(this);
    }

    //добавляем связь через имя связи
    public void addLink(Link link) {
        this.links.add(link);
    }

    //добавляем связь через конструктор связей
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
