import java.util.ArrayList;
import java.util.List;

public class Trees {
    private List<Communication> communlist;

    public Trees(List<Communication> communlist) {
        this.communlist = communlist;
    }

    public Trees() {
        this(new ArrayList<>());
    }

    public List<Communication> getCommunlist() {
        return communlist;
    }

    public void setCommunlist(List<Communication> communlist) {
        this.communlist = communlist;
    }

    public void add_communication(Communication communication) {
        communlist.add(communication);
    }

 
}
