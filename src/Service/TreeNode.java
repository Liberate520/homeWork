package Service;

import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> {

    String getInfo();


    LocalDate getBirth();
    int showAge();

    String getName();
    String getLastName();


}
