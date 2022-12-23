package Семинар1.homeWork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Saveandreadable {
    void read_info(ArrayList<Human> o, String s)throws IOException;
    void  print_info(ArrayList<Human> o) throws IOException;

}
