import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Users implements Model, Iterable, Iterator<User> {

    private List<User> usersList;
    int i = 0;
    private String userData;

    public Users() {
        this.usersList = new ArrayList<User>();
    }

    public void addUser(String login, String password){
        this.usersList.add(new User( login,password));
    }
    public User get(int i){
        return usersList.get(i);
    }

    @Override
    public void setText(String s) {
        userData = s;
    }

    @Override
    public String execute() {
        while ()
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
