package family_tree.model.human_family;

import java.time.LocalDate;
import java.util.List;

import family_tree.model.humans.Gender;

public interface HumanItem<T> {
    List<T> getParents();

    List<T> getAllHumans();

    List<T> getAllChildren();

    String getHumansInfo();

    String getName();

    int getBirthYear();

    Gender getGender();

    LocalDate getbirthDate();
}
