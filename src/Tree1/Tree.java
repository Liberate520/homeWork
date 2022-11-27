package Tree1;

import java.util.ArrayList;
import java.util.List;

/**
 * Tree Класс хранящий в себе:
 * links - список всех родственных связей,
 * методы добавления связей по одному и списком разом,
 * Геттер для списка связей,
 * Переопределен toString для отображения данных об экземпляре определенным образом.
 */
public class Tree {
    private final List<Communications> links=new ArrayList<>();

    public List<Communications> getLinks() {
        return links;
    }

    public void addLink(Person p1, Person p2, Relations r1, Relations r2) {
        this.links.add(new Communications(p1,p2,r1));
        this.links.add(new Communications(p2,p1,r2));
    }
//    public void addLink(Person p1, Person p2) {
//        this.links.add(p1);
//        this.links.add(p2);
//    }

    @Override
    public String toString() {
        StringBuilder result= new StringBuilder();
        for (Communications el :
                links) {
            result.append(el).append("\n");
        }
        return result.toString();
    }
}
