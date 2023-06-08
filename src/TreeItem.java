import java.time.LocalDate;
import java.util.List;

public interface TreeItem<T> {
    String getName();

    T getFather();

    LocalDate getDateOfBirth();

    T getMother();

    Gender getGender();

    List<T> getChildren();
}
