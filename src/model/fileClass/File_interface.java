package model.fileClass;

import java.io.IOException;
import java.util.List;




import model.treeWork.ElementTree;




public interface File_interface {
    List<ElementTree> read_files() throws IOException, ClassNotFoundException;

    void write_files(List<ElementTree> homo) throws IOException;


}

