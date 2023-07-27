package genealogicalTree;

import java.time.LocalDate;

public interface GTgeneric {
    String getInfo();
    void addHuman();

    LocalDate getBirth();
    int showAge();


}
