package model.file;

import model.Tree;
import model.person.Person;

public interface Files {
    public Tree<Person> readFile() throws ClassNotFoundException;
    public Boolean saveFile(Tree<Person> p);
    public String getFile_name();
    public void setFile_name(String file_name);
}
