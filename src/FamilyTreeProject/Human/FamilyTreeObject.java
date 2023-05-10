import java.util.Calendar;

public interface FamilyTreeObject<T>{
    String getFullName();
    Calendar getDateBirthday();
    public FamilyTreeObject<T> getMother();
    public FamilyTreeObject<T> getFather();
    public void addChild(T child);
}
