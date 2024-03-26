package writer;

import Tree.FamilyTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface Writable {

    boolean saveToFile(FamilyTree familyTree, String filePath);// сохранение данных в файл

    FamilyTree uploadFromFile (String filePath);// загрузка данных из файла

}
