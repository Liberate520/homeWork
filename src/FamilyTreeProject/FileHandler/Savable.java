import java.io.Serializable;

public interface Savable {
    public boolean save(Serializable serializable, String path);
    public FamilyTree load(String path);
}
