import java.util.ArrayList;
import java.util.Collections;

public class Service {
    private MyTree myTree;
    private ArrayList<Persons> persons;
    
    public Service(MyTree myTree) {
        this.myTree = myTree;
    }

    public void sortByName(){
        Collections.sort(myTree.getTree());
    }
    
}
