import Model.Model;
import Model.home_work_class.Write.FileWriter;
import Presenter.Presenter;
import view.ConsoleUI;
import Model.home_work_class.Write.SingletonFileWrite;
public class MainNew {
    public static void main(String[] args) {
        ConsoleUI view = new ConsoleUI();
        SingletonFileWrite  writeData = SingletonFileWrite.getSingletonFileWrite(new FileWriter());
        Presenter presenter = new Presenter(new ConsoleUI(), new Model(writeData));
        view.setPresenter(presenter);
        view.startMenu();
    }
}
