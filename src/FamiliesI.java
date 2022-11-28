import java.util.List;

/*
то что всех объединяет
 */
public interface FamiliesI {
    // и животные и люди должны иметь своё место в дуреве
    public void addTree(FamiliesI person);

    public void addTree();

    public void printTree();

    public int getGender();

    public void addLink(Link link);

    public List<Link> getLink();
    public Link getLink(int i);

//    public void addLink();
}
