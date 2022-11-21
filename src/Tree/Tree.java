package org.lesson01;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private List<Link> links=new ArrayList<>();

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links.addAll(links);
    }

    public void addLink(Person p1, Person p2, Relations r1, Relations r2) {
        this.links.add(new Link(p1,p2,r1));
        this.links.add(new Link(p2,p1,r2));
    }

    @Override
    public String toString() {
        String result=new String();
        for (Link el :
                links) {
            result+=el+"\n";
        }
        return result;
    }
}
