package Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private final List<Link> links=new ArrayList<>();

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links.addAll(links);
    }

    public void addLink(Human p1, Human p2, Relations r1, Relations r2) {
        this.links.add(new Link(p1,p2,r1));
        this.links.add(new Link(p2,p1,r2));
    }

    @Override
    public String toString() {
        StringBuilder result= new StringBuilder(new String());
        for (Link el :
                links) {
            result.append(el).append("\n");
        }
        return result.toString();
    }
}
