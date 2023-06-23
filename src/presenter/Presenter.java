package presenter;
import java.time.LocalDate;
import human.Gender;
import human.Human;
import tree.Service;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service)
    {
        this.service = service;
        this.view = view;
        view.setPresenter(this);
    }

    public void saveFile()
    {
        service.saveFile();
        view.print("Семейное древо сохранено !");
    }

    public void addHuman(String firstName, String lastname, Gender gender, LocalDate birthDate)
    {
        service.familyTree.add(new Human(firstName, lastname, gender, birthDate));
        view.print("Новый член семьи добавлен !");
    }

    public void loadFile(String filePath)
    {
        service.loadFile(filePath);
        view.print("Семейное древо загружено !");
    }

    public void getInfo() {
        view.print(service.getInfoHuman());
    }

    public void sortTree(String choice) {
        service.sortTree(choice);
    }

}
