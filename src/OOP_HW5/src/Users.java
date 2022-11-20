import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Users implements Model, Iterable, Iterator<User> {

    private List<User> usersList;
    int i = 0;

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
    }

    @Override
    public String execute() {
        return null;
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
