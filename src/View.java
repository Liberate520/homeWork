
import java.util.ArrayList;
import java.util.List;

public class View {
    List<Option> comandlist = new ArrayList<>();

    public View(List<Option> comandlist) {
        comandlist = this.comandlist;
    }
    public void addcomand(List<Option> comandList){
        comandlist.add(new ComandSave());
    }
    
    
}
