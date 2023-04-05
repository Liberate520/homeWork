public interface Files {
    Tree<Person> readFile();

    Boolean saveFile(Tree<Person> p);
}
