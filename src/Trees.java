import java.util.ArrayList;
import java.util.List;

public class Trees {
    private List<Human> humanlist;

    public Trees(List<Human> humanlist){
        this.humanlist = humanlist;
    }
    public Trees(){
        this(new ArrayList<>());
    }
    
}
