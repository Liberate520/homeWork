package Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private final List<Communications> links=new ArrayList<>();

    public List<Communications> getLinks() {
        return links;
    }

    public void addLink(Person p1, Person p2, Relations r1, Relations r2) {
        this.links.add(new Communications(p1,p2,r1));
        this.links.add(new Communications(p2,p1,r2));
    }

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
