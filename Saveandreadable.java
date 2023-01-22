package Семинар1.homeWork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface SaveAndReadable {
    void read_info(Tree<Human> o)throws IOException;
    void  print_info(Tree<Human> o) throws IOException;

}
