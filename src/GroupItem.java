import java.time.LocalDate;

public interface GroupItem {
    String getName();
    LocalDate getBirthday();

    String allInfo();

    Integer getId();
}
