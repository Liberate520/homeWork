package members;

import java.time.LocalDate;

public interface Member {
    String getName();
    Gender getGender();
    int getChildrenAmount();
    LocalDate getBirthday();
    Member getFather();
    Member getMother();
    Boolean ContainsChild(Member child);
    Boolean addChild(Member child);
}
