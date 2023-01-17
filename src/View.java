import java.util.ArrayList;
import java.util.List;

public class View {
    List<Option> comandlist = new ArrayList<>();
    FileHandler fileHandler = new FileHandler();
    comandlist.add(fileHandler.save());


}
