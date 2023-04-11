package member;

import java.util.Calendar;

public interface Member {

    String getLastName();

    int countChildren();

    ThreadLocal<Object> getChildren();

    String getFirstName();

    Calendar getBornDate();

    Boolean getGender();
}
