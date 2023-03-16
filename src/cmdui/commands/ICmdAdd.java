package cmdui.commands;

import java.util.Date;

public interface ICmdAdd {
    String getName();

    String getSex();

    Date getBirthDay();

    int[] getParents();
}
