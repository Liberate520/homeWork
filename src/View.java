import java.util.ArrayList;
import java.util.List;

public class View {
    List<Option> comandlist = new ArrayList<>();

    public List<Option> getComandlist() {
        return comandlist;
    }

    public void setComandlist(List<Option> comandlist) {
        this.comandlist = comandlist;
    }

    public View(List<Option> comandlist) {
        this.comandlist = comandlist;
    }
    
    comandlist.add(new ComandSave());
    
}
