import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Users implements Model, Iterable, Iterator<User> {

    private List<User> usersList;

    int i = 0;
    private String [] data;
    private String inputData;

    public Users() {
        this.usersList = new ArrayList<User>();
    }

    private void printUserList(){
        System.out.println(usersList);
    }
    private void addUser(){
        this.usersList.add(new User( data[1],data[2]));
    }
    public User get(int i){
        return usersList.get(i);
    }

    private String[] getDataFromText(){
        return data = inputData.split("\\s+");
    }
    private void Command(){
         switch (data[0]){
            case ("1"):
                addUser();
                break;
             case ("2"):
                printUserList();
                break;
             case ("0"):
                break;
        }
    }

    @Override
    public void setText(String s) {
        inputData = s;
    }

    @Override
    public void execute() {
        getDataFromText();
        Command();
    }
    @Override
    public Iterator iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return i < usersList.size();
    }

    @Override
    public User next() {
        return usersList.get(i++);
    }
}
