import com.sun.source.tree.IfTree;

import java.time.LocalDate;

public class TreeService {
    private int id;
    private String pathFH;
    private Tree<Person> tree;
    private Writable FH;

    public TreeService(){
        tree = new Tree<>();
        this.tree = tree;
    }

    public void SaveLoad(String pathFH, String methodFH){
        Writable FH = new FileHandler(pathFH);
        if (methodFH == "Save"){
            FH.saveFile(tree);
        }
        if (methodFH == "Load"){
            Tree tree = (Tree) FH.loadFile();
        }
    }

    public void addPerson(String surname, String firstName, String middleName, String sex, LocalDate date){
        tree.add(new Person(surname, firstName, middleName, sex, date, id++));
    }

    public void addPersonParents(int idPerson, int idParents, String typeOfParents){
        if (typeOfParents.equals("Mother")){
            tree.getById(idPerson).setMother(tree.getById(idParents));
        }
        if (typeOfParents.equals("Father")){
            tree.getById(idPerson).setFather(tree.getById(idParents));
        }
    }

    public String getTreeInfo(){
       return tree.getTreeInfo();
    }

    public Person getPersonById(int id) {
        return tree.getById(id);
    }

    public String getPersonsInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person: tree){
            stringBuilder.append(person).append("\n");
        }
        return stringBuilder.toString();
    }

    public void showChildrenById(int id){
        tree.getById(id).showChildren();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }
}
