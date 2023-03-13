import model.*;
import presenter.Presenter;
import ui.*;

public class Main{  
    public static void main(String[] args) {
    View view = new Console();
    Service service = new FamilyTreeService();
    new Presenter(view, service);
    view.start();
    }
}