import java.time.LocalDate;

public class TreeService {
    private int id;
    private Tree tree;
    private Writable FH;

    public TreeService(String path){
        Writable FH = new FileHandler(path);
        this.tree = new Tree();
    }

    public void addPerson(String surname, String firstName, String middleName, String sex, LocalDate date){
        tree.add(new Person(surname, firstName, middleName, sex, date, id++));
    }

    public String getTreeInfo(){
       return tree.getTreeInfo();
    }

    public String getPersonsInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person: tree){
            stringBuilder.append(person).append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }
}
