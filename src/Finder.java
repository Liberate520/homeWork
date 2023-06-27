import java.util.List;

public interface Finder {
    public List getParents();
    public List getChildren();
    public List getSubParents();
    public List getSubChildren();
}